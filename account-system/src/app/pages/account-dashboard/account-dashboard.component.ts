import { Component } from '@angular/core';
import { MessageService } from 'primeng/api';
import { AccountService } from '../../Services/account.service';
import { ActivatedRoute, Router } from '@angular/router';
import { lastValueFrom } from 'rxjs';
import { Account } from '../../models/Account';
import { Crypto } from '../../Services/crypto';
import { Client } from '../../models/Client';

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

  async getAccount() {
		let accountsObs$ = this.accountApi.getAccountsById(this.userId);
		let response = await lastValueFrom(accountsObs$);
		if (response.status != 200) {
			this.msgs.push({ severity: 'error', summary: 'Ups!!', detail: 'No se cargaron las cuentas' });
			return;
		}
		this.accountList = response.data.filter( (user: Account) => user.status == 1);
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
}
