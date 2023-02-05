import { Component } from '@angular/core';
import { MessageService, SelectItem } from 'primeng/api';
import { AccountService } from '../../Services/account.service';
import { ActivatedRoute, Router } from '@angular/router';
import { lastValueFrom } from 'rxjs';
import { Account } from '../../models/Account';
import { Crypto } from '../../Services/crypto';
import { Client } from '../../models/Client';
import { AccountType } from '../../models/AccountType';
import { CurrencyType } from '../../models/CurrencyType';

@Component({
	selector: 'app-account-dashboard',
	templateUrl: './account-dashboard.component.html',
	styleUrls: ['./account-dashboard.component.css']
})
export class AccountDashboardComponent {

	accountList: Account[] = [];
	msgs: any = [];
	userId!: number;
	user!: Client;
	accountDialog: boolean = false;
	newAccount!: Account;
	accountTypes: SelectItem[] = [];
	currencies: SelectItem[] = [];
	submitted!: boolean;

	constructor(private messageService: MessageService, private accountApi: AccountService, private router: Router, private crypto: Crypto,
		private _Activatedroute: ActivatedRoute) { }

	ngOnInit() {
		this._Activatedroute.params.subscribe(res => {
			const id = res['userId'];
			if (id != undefined) {
				(async () => {
					this.userId = Number(this.crypto.decrypt(id))   // des-encriptando el id de la certificacion
					await this.getUser();
					await this.getAccount();
				})();

			}
		});
	}

	async getAccountTypes() {
		let usersObs$ = this.accountApi.getAccountTypes();
		let response = await lastValueFrom(usersObs$);
		if (response.status == 200) {
			response.data.forEach((gr: AccountType) => {
				this.accountTypes.push({
					label: gr.name,
					value: gr.dbid
				})
			});
		}
		console.log("types: ", response)
	}

	async getCurrencies() {
		let usersObs$ = this.accountApi.getCurrencyTypes();
		let response = await lastValueFrom(usersObs$);
		if (response.status == 200) {
			response.data.forEach((gr: CurrencyType) => {
				this.currencies.push({
					label: gr.description,
					value: gr.dbid
				})
			});
		}
		console.log("types: ", response)
	}

	async getAccount() {
		let accountsObs$ = this.accountApi.getAccountsById(this.userId);
		let response = await lastValueFrom(accountsObs$);
		if (response.status != 200) {
			this.msgs.push({ severity: 'error', summary: 'Ups!!', detail: 'No se cargaron las cuentas' });
			return;
		}
		this.accountList = response.data.filter((account: Account) => account.status == 1);
		console.log("cuentas: ", response)
	}

	async getUser() {
		let usersObs$ = this.accountApi.getUser(this.userId);
		let response = await lastValueFrom(usersObs$);
		if (response.status != 200) {
			this.msgs.push({ severity: 'error', summary: 'Ups!!', detail: 'No se cargaron los usuarios' });
			return;
		}
		this.user = response.data;
		console.log("usuarios: ", this.user)

	}

	async openNew() {		
		await this.getAccountTypes();
		await this.getCurrencies();

		this.newAccount = {
			dbid:          0,
			clientId:     this.userId,
			amount:        1,
			init_vig:      new Date(),
			fin_vig:       new Date(),
			currency:      1,
			account_type:  1,
			status:        1,
			user_registry: "system",
			user_modified: "system"
		}
		this.submitted = false;
		console.log("new client", this.newAccount)
		this.accountDialog = true;
	}

	hideDialog() {
		this.accountDialog = false;
		this.submitted = false;
	}

	async saveAccount() {
		
		if(this.newAccount.dbid != 0){
			console.log("update account", this.newAccount)
			let result = await this.updateAccount();
			if (result) {
				this.msgs.push({ severity: 'success', summary: 'Exito', detail: 'Usuario actualizado correctamente' });
			} else {
				this.msgs.push({ severity: 'error', summary: 'Upss', detail: 'No se pudo actualizar el usuario, intentelo de nuevo' });
			}
			this.accountDialog = false;
			await this.getAccount();
		}else{
			console.log("new account", this.newAccount)
			if (this.newAccount.account_type && this.newAccount.currency) {
				this.submitted = true;
				let usersObs$ = this.accountApi.newAccount(this.newAccount);
				let response = await lastValueFrom(usersObs$);
				if (response.status == 200) {
					this.accountDialog = false;
					await this.getAccount();
					this.msgs.push({ severity: 'success', summary: 'Exito', detail: 'Cuenta registrado correctamente' });
				} else {
					this.msgs.push({ severity: 'error', summary: 'Ups!!', detail: 'No se pudo registrar el cuenta' });
				}
			} else {
				console.log("datos")
				this.msgs.push({ severity: 'error', summary: 'Upss', detail: 'Por favor complete todos los campos' });
			}
		}
	}

	async updateInfo(account: Account){
		this.newAccount = account
		this.submitted = false;
		this.accountDialog = true;
	}

	async updateAccount() {
		let usersObs$ = this.accountApi.updateAccount(this.newAccount);
		let response = await lastValueFrom(usersObs$);
		return response.status == 200
	}

	async deleteAccount(){
		let usersObs$ = this.accountApi.deleteAccount(this.newAccount);
		let response = await lastValueFrom(usersObs$);
		if (response.status == 200){
			this.accountDialog = false;
			await this.getAccount()
			this.newAccount = this.newAccount = {
				dbid:          0,
				clientId:     this.userId,
				amount:        1,
				init_vig:      new Date(),
				fin_vig:       new Date(),
				currency:      1,
				account_type:  1,
				status:        1,
				user_registry: "system",
				user_modified: "system"
			}
		}
	}
}
