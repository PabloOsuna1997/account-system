import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { catchError, map, switchMap } from 'rxjs/operators';
import { ResponseApi } from '../models/ResponseApi';
import { Client } from '../models/Client';
import { Gender } from '../models/Gender';
import { PersonType } from '../models/PersonType';
import { Account } from '../models/Account';
import { environment } from '../../enviroment/enviroment';
import { AccountType } from '../models/AccountType';
import { CurrencyType } from '../models/CurrencyType';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  account_api = environment.account_api;

  constructor(private http: HttpClient) {
  }


  public newUser(client: Client): Observable<any> {
    //this.loadingService.setLoading(true);
    return this.http.post<ResponseApi<Client>>(`${this.account_api}/client/v1/save`, client).pipe(
      map(response => {
        //this.loadingService.setLoading(false);
        return response
      }),
      catchError((error): any => {
        //this.loadingService.setLoading(false);
        console.log("error:", error);
        return of({ code: error.code })
      })
    );
  }

  public getUsers(): Observable<any> {
    //this.loadingService.setLoading(true);
    return this.http.get<ResponseApi<Client[]>>(`${this.account_api}/client/v1/list`).pipe(
      map(response => {
        //this.loadingService.setLoading(false);
        return response
      }),
      catchError((error): any => {
        //this.loadingService.setLoading(false);
        console.log("error:", error);
        return of({ code: error.code })
      })
    );
  }

  public getUser(id: number): Observable<any> {
    //this.loadingService.setLoading(true);
    return this.http.get<ResponseApi<Client>>(`${this.account_api}/client/v1/list?user=${id}`).pipe(
      map(response => {
        //this.loadingService.setLoading(false);
        return response
      }),
      catchError((error): any => {
        //this.loadingService.setLoading(false);
        console.log("error:", error);
        return of({ code: error.code })
      })
    );
  }

  public updateUser(client:  Client): Observable<any> {
    //this.loadingService.setLoading(true);
    return this.http.put<Client>(`${this.account_api}/client/v1/update/${client.dbid}`, client).pipe(
      map(response => {
        //this.loadingService.setLoading(false);
        return response
      }),
      catchError((error): any => {
        //this.loadingService.setLoading(false);
        console.log("error:", error);
        return of({ code: error.code })
      })
    );
  }


  public deleteUser(client:  Client): Observable<any> {
    //this.loadingService.setLoading(true);
    return this.http.put<Client>(`${this.account_api}/client/v1/delete/${client.dbid}`, {}).pipe(
      map(response => {
        //this.loadingService.setLoading(false);
        return response
      }),
      catchError((error): any => {
        //this.loadingService.setLoading(false);
        console.log("error:", error);
        return of({ code: error.code })
      })
    );
  }

  public getGenders(): Observable<any> {
    //this.loadingService.setLoading(true);
    return this.http.get<ResponseApi<Gender>>(`${this.account_api}/gender/v1/list`).pipe(
      map(response => {
        //this.loadingService.setLoading(false);
        return response
      }),
      catchError((error): any => {
        //this.loadingService.setLoading(false);
        console.log("error:", error);
        return of({ code: error.code })
      })
    );
  }

  public getPersonsType(): Observable<any> {
    //this.loadingService.setLoading(true);
    return this.http.get<ResponseApi<PersonType[]>>(`${this.account_api}/person-type/v1/list`).pipe(
      map(response => {
        //this.loadingService.setLoading(false);
        return response
      }),
      catchError((error): any => {
        //this.loadingService.setLoading(false);
        console.log("error:", error);
        return of({ code: error.code })
      })
    );
  }

  public newAccount(account: Account): Observable<any> {
    //this.loadingService.setLoading(true);
    return this.http.post<ResponseApi<Account>>(`${this.account_api}/account/v1/save`, account).pipe(
      map(response => {
        //this.loadingService.setLoading(false);
        return response
      }),
      catchError((error): any => {
        //this.loadingService.setLoading(false);
        console.log("error:", error);
        return of({ code: error.code })
      })
    );
  }

  public getAccountsById(userId: number): Observable<any> {
    //this.loadingService.setLoading(true);
    return this.http.get<ResponseApi<Account[]>>(`${this.account_api}/account/v1/user/${userId}`).pipe(
      map(response => {
        //this.loadingService.setLoading(false);
        return response
      }),
      catchError((error): any => {
        //this.loadingService.setLoading(false);
        console.log("error:", error);
        return of({ code: error.code })
      })
    );
  }

  public updateAccount(account:  Account): Observable<any> {
    //this.loadingService.setLoading(true);
    return this.http.put<Account>(`${this.account_api}/account/v1/update/${account.dbid}`, account).pipe(
      map(response => {
        //this.loadingService.setLoading(false);
        return response
      }),
      catchError((error): any => {
        //this.loadingService.setLoading(false);
        console.log("error:", error);
        return of({ code: error.code })
      })
    );
  }


  public deleteAccount(account:  Account): Observable<any> {
    //this.loadingService.setLoading(true);
    return this.http.put<Account>(`${this.account_api}/account/v1/delete/${account.dbid}`, {}).pipe(
      map(response => {
        //this.loadingService.setLoading(false);
        return response
      }),
      catchError((error): any => {
        //this.loadingService.setLoading(false);
        console.log("error:", error);
        return of({ code: error.code })
      })
    );
  }

  public getAccountTypes(): Observable<any> {
    //this.loadingService.setLoading(true);
    return this.http.get<ResponseApi<AccountType[]>>(`${this.account_api}/account/v1/type`).pipe(
      map(response => {
        //this.loadingService.setLoading(false);
        return response
      }),
      catchError((error): any => {
        //this.loadingService.setLoading(false);
        console.log("error:", error);
        return of({ code: error.code })
      })
    );
  }

  public getCurrencyTypes(): Observable<any> {
    //this.loadingService.setLoading(true);
    return this.http.get<ResponseApi<CurrencyType[]>>(`${this.account_api}/currency/v1/list`).pipe(
      map(response => {
        //this.loadingService.setLoading(false);
        return response
      }),
      catchError((error): any => {
        //this.loadingService.setLoading(false);
        console.log("error:", error);
        return of({ code: error.code })
      })
    );
  }

}