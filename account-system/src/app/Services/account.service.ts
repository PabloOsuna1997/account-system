import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { catchError, map, switchMap } from 'rxjs/operators';
import { ResponseApi } from '../models/ResponseApi';
import { Client } from '../models/Client';
import { Gender } from '../models/Gender';
import { PersonType } from '../models/PersonType';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  constructor(private http: HttpClient) {
  }


  public newUser(client: Client): Observable<any> {
    //this.loadingService.setLoading(true);
    return this.http.post<ResponseApi<Client>>(`http://localhost:8080/client/v1/save`, client).pipe(
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
    return this.http.get<ResponseApi<Client>>(`http://localhost:8080/client/v1/list`).pipe(
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
    return this.http.put<Client>(`http://localhost:8080/client/v1/update/${client.dbid}`, client).pipe(
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
    return this.http.put<Client>(`http://localhost:8080/client/v1/delete/${client.dbid}`, {}).pipe(
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
    return this.http.get<ResponseApi<Gender>>(`http://localhost:8080/gender/v1/list`).pipe(
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
    return this.http.get<ResponseApi<PersonType>>(`http://localhost:8080/person-type/v1/list`).pipe(
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