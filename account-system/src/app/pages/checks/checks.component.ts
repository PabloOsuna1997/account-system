import { Component } from '@angular/core';
import { Client } from '../../models/Client';
import { Account } from '../../models/Account';
import { SelectItem, MessageService, MenuItem } from 'primeng/api';
import { ActivatedRoute, Router } from '@angular/router';
import { AccountService } from '../../Services/account.service';
import { lastValueFrom } from 'rxjs';
import { Crypto } from '../../Services/crypto';
import { CheckBook } from '../../models/CheckBook';

@Component({
  selector: 'app-checks',
  templateUrl: './checks.component.html',
  styleUrls: ['./checks.component.css']
})
export class ChecksComponent {

  checkBooks: CheckBook[] = [];
  msgs: any = [];
  userId!: number;
  accountId!: number;
  user!: Client;
  accountDialog: boolean = false;
  newAccount!: Account;
  accountTypes: SelectItem[] = [];
  quantityList: SelectItem[] = [];
  submitted!: boolean;
  newCheckbook!: CheckBook;
  CheckBookDialog: boolean = false;
  public items!: MenuItem[];

  constructor(private messageService: MessageService, private accountApi: AccountService, private router: Router, private crypto: Crypto,
    private _Activatedroute: ActivatedRoute) { }

  ngOnInit() {
    this._Activatedroute.params.subscribe(res => {
      const usId = res['userId'];
      const accId = res['accountId'];
      if (usId && accId) {
        (async () => {
          this.userId = Number(this.crypto.decrypt(usId))   // des-encriptando el id de la certificacion
          this.accountId = Number(this.crypto.decrypt(accId))   // des-encriptando el id de la certificacion
          await this.getUser();
          await this.getChecks();
          await this.getAccount();
        })();

      }

      this.items = [
				{ label: 'Home', url: '/' },
				{ label: 'Users', url: 'management-users/' },
				{ label: 'Accounts', url: `management-account/${usId}` },
        { label: 'CheckBooks', url: `management-checks/${usId}/${accId}` }
			];
    });

    this.quantityList.push({ label: "20", value: "20" })
    this.quantityList.push({ label: "50", value: "50" })
    this.quantityList.push({ label: "100", value: "100" })

  }

  async getChecks() {
    let accountsObs$ = this.accountApi.getCheckBookByAccountId(this.accountId);
    let response = await lastValueFrom(accountsObs$);
    if (response.status != 200) {
      this.msgs.push({ severity: 'error', summary: 'Ups!!', detail: 'No se cargaron las cuentas' });
      return;
    }
    this.checkBooks = response.data.filter((account: Account) => account.status == 1);
    console.log("chequeras: ", response)
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

  async getAccount() {
    let usersObs$ = this.accountApi.getAccountsById(this.accountId);
    let response = await lastValueFrom(usersObs$);
    if (response.status != 200) {
      this.msgs.push({ severity: 'error', summary: 'Ups!!', detail: 'No se cargaron los usuarios' });
      return;
    }
    this.newAccount = response.data;
    console.log("usuarios: ", this.user)

  }

  async openUpdate(checkBook: CheckBook) {
    this.newCheckbook = checkBook;
    this.submitted = false;
    this.CheckBookDialog = true;
  }

  async openNew() {
    this.newCheckbook = {
      dbid: 0,
      accountId: 1,
      start_correlative: 1,
      fin_correlative: 1,
      quantity_checks: 1,
      status: 1,
      user_registry: "",
      user_modified: "",
      registry_date: new Date()
    }
    this.submitted = false;
    this.CheckBookDialog = true;
  }

  async deleteCheckBook() {
    let usersObs$ = this.accountApi.deleteCheckBook(this.newCheckbook);
    let response = await lastValueFrom(usersObs$);
    if (response.status == 200) {
      this.CheckBookDialog = false;
      await this.getChecks()
      this.newCheckbook = {
        dbid: 0,
        accountId: 1,
        start_correlative: 1,
        fin_correlative: 1,
        quantity_checks: 1,
        status: 1,
        user_registry: "",
        user_modified: "",
        registry_date: new Date()
      }
    }
  }

  async saveCheckBook() {
    if (this.newCheckbook.dbid == 0) {
      this.newCheckbook = {
        dbid: 0,
        accountId: this.accountId,
        fin_correlative: 1,
        start_correlative: 1,
        registry_date: new Date(),
        status: 1,
        quantity_checks: this.newCheckbook.quantity_checks,
        user_registry: "system",
        user_modified: "system"
      }

      if (this.newCheckbook.quantity_checks > 0) {
        this.submitted = true;
        let usersObs$ = this.accountApi.newCheckBook(this.newCheckbook);
        let response = await lastValueFrom(usersObs$);
        if (response.status == 200) {
          this.CheckBookDialog = false;
          await this.getChecks();
          this.msgs.push({ severity: 'success', summary: 'Exito', detail: 'Chequera registrada correctamente' });
        } else {
          this.msgs.push({ severity: 'error', summary: 'Ups!!', detail: 'No se pudo registrar la chequera' });
        }
      } else {
        console.log("datos")
        this.msgs.push({ severity: 'error', summary: 'Upss', detail: 'Por favor complete todos los campos' });
      }
    } else {
      console.log("update account", this.newAccount)
      let result = await this.updateCheckBook();
      if (result) {
        this.msgs.push({ severity: 'success', summary: 'Exito', detail: 'Usuario actualizado correctamente' });
      } else {
        this.msgs.push({ severity: 'error', summary: 'Upss', detail: 'No se pudo actualizar el usuario, intentelo de nuevo' });
      }
      this.CheckBookDialog = false;
      await this.getChecks();
    }
  }

  async updateCheckBook() {
    let usersObs$ = this.accountApi.updateCheckBook(this.newCheckbook);
    let response = await lastValueFrom(usersObs$);
    return response.status == 200
  }

  hideDialog() {
    this.CheckBookDialog = false;
    this.submitted = false;
  }
}
