import { Component } from '@angular/core';
import { MessageService, SelectItem } from 'primeng/api';
import { AccountService } from '../../Services/account.service';
import { ActivatedRoute, Router } from '@angular/router';
import { lastValueFrom } from 'rxjs';
import { Account } from '../../models/Account';
import { Crypto } from '../../Services/crypto';
import { Client } from '../../models/Client';
import { AccountType } from '../../models/AccountType';

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

  async getAccountTypes(){
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

  async getCurrencies(){
    let usersObs$ = this.accountApi.getCurrencyTypes();
		let response = await lastValueFrom(usersObs$);
		if (response.status == 200) {
			response.data.forEach((gr: AccountType) => {
				this.currencies.push({
					label: gr.name,
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
		this.accountList = response.data.filter( (account: Account) => account.status == 1);
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

    addAccount(){
		console.log("cuenta")
		this.msgs.push({ severity: 'error', summary: 'Ups!!', detail: 'No se cargaron los usuarios' });
    }
}
