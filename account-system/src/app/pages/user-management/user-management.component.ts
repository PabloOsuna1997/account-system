import { Component } from '@angular/core';
import { SelectItem } from 'primeng/api';
import { MessageService } from 'primeng/api';
import { AccountService } from '../../Services/account.service';
import { lastValueFrom } from 'rxjs';
import { Client } from '../../models/Client';
import { Gender } from '../../models/Gender';
import { PersonType } from '../../models/PersonType';
import { Router } from '@angular/router';
import { Crypto } from '../../Services/crypto';

@Component({
	selector: 'app-user-management',
	templateUrl: './user-management.component.html',
	styleUrls: ['./user-management.component.css'],
	styles: [`
        :host ::ng-deep .p-cell-editing {
            padding-top: 0 !important;
            padding-bottom: 0 !important;
        }
    `]
})
export class UserManagementComponent {

	usersList!: Client[];
	clonedClients: { [s: string]: Client; } = {};
	newClient!: Client;
	clientDialog: boolean = false;
	genders: SelectItem[] = [];
	personsType: SelectItem[] = [];
	msgs: any = [];
	submitted!: boolean;

	constructor(private messageService: MessageService, private accountApi: AccountService, private router: Router,
		private crypto: Crypto) {
	}

	ngOnInit() {
		//this.messageService.add({severity:'success', summary:'Service Message', detail:'Via MessageService'});
		//this.msgs.push({ severity: 'error', summary: 'Ups!!', detail: 'No se cargaron los usuarios' });
		(async () => {
			await this.getUsers();
			await this.getGenders();
			await this.getPersonsType();
		})();
	}

	show() {
		this.msgs.push({ severity: 'info', summary: 'Info Message', detail: 'PrimeNG rocks' });
	}

	hide() {
		this.msgs = [];
	}

	async getUsers() {
		let usersObs$ = this.accountApi.getUsers();
		let response = await lastValueFrom(usersObs$);
		if (response.status != 200) {
			this.msgs.push({ severity: 'error', summary: 'Ups!!', detail: 'No se cargaron los usuarios' });
			return;
		}
		this.usersList = response.data.filter((user: Client) => user.status == 1);
		console.log("usuarios: ", this.usersList)

	}

	async updateUser(client: Client) {
		let usersObs$ = this.accountApi.updateUser(client);
		let response = await lastValueFrom(usersObs$);
		return response.status == 200
	}

	async deleteUser(client: Client) {
		let usersObs$ = this.accountApi.deleteUser(client);
		let response = await lastValueFrom(usersObs$);
		return response.status == 200
	}

	async getGenders() {
		let usersObs$ = this.accountApi.getGenders();
		let response = await lastValueFrom(usersObs$);

		if (response.status == 200) {
			response.data.forEach((gr: Gender) => {
				this.genders.push({
					label: gr.gender,
					value: gr.dbid
				})

			});

		}
		console.log("genders: ", response)
	}

	async getPersonsType() {
		let usersObs$ = this.accountApi.getPersonsType();
		let response = await lastValueFrom(usersObs$);

		if (response.status == 200) {
			response.data.forEach((gr: PersonType) => {
				this.personsType.push({
					label: gr.description,
					value: gr.dbid
				})

			});

		}
		console.log("persons: ", response)
	}


	openNew() {
		this.newClient = {
			"dbid": 0,
			"first_name": "",
			"last_name": "",
			"cui": 0,
			"nit": "",
			"phone_number": 0,
			"email_address": "",
			"birthay": new Date(),
			"marial_status": 1,
			"status": 1,
			"person_type": 1,
			"gender": 2,
			"user_modified": "system",
			"user_registry": "system"
		}
		this.submitted = false;
		console.log("new client", this.newClient)
		this.clientDialog = true;
	}

	hideDialog() {
		this.clientDialog = false;
		this.submitted = false;
	}

	async saveClient() {
		if (this.newClient.cui) {
			this.submitted = true;
			let usersObs$ = this.accountApi.newUser(this.newClient);
			let response = await lastValueFrom(usersObs$);
			if (response.status == 200) {
				this.clientDialog = false;
				await this.getUsers();
				this.msgs.push({ severity: 'success', summary: 'Exito', detail: 'Usuario registrado correctamente' });
			} else {
				this.msgs.push({ severity: 'error', summary: 'Ups!!', detail: 'No se pudo registrar el usuario' });
			}
		} else {
			console.log("datos")
			this.msgs.push({ severity: 'error', summary: 'Upss', detail: 'Por favor complete todos los campos' });
		}
	}

	onRowEditInit(client: Client) {
		this.clonedClients[client.dbid] = { ...client };
	}

	async onRowEditSave(client: Client) {
		if (client.cui > 0) {
			delete this.clonedClients[client.dbid];
			let result = await this.updateUser(client);
			if (result) {
				this.msgs.push({ severity: 'success', summary: 'Exito', detail: 'Usuario actualizado correctamente' });
			} else {
				this.msgs.push({ severity: 'error', summary: 'Upss', detail: 'No se pudo actualizar el usuario, intentelo de nuevo' });
			}
		}
		else {
			this.msgs.push({ severity: 'error', summary: 'Upss', detail: 'Por favor complete todos los campos' });
		}
	}

	onRowEditCancel(client: Client, index: number) {
		this.usersList[index] = this.clonedClients[client.dbid];
		delete this.clonedClients[client.dbid];
	}

	async onDeleteUser(client: Client, index: number) {
		if (client.dbid > 0) {
			delete this.clonedClients[client.dbid];
			let result = await this.deleteUser(client);
			if (result) {
				console.log("usuario eliminadoooo")
				await this.getUsers();
				this.msgs.push({ severity: 'success', summary: 'Exito', detail: 'Usuario eliminado correctamente' });
			} else {
				this.msgs.push({ severity: 'error', summary: 'Upss', detail: 'No se pudo eliminar el usuario, intentelo de nuevo' });
			}
		}
		else {
			this.msgs.push({ severity: 'error', summary: 'Upss', detail: 'Por favor complete todos los campos' });
		}
	}

	openAccounts(client: Client) {
		const ecr = this.crypto.encrypt(client.dbid.toString());
		this.router.navigate([`/management-account/${ecr}`], { replaceUrl: true })
	}
}
