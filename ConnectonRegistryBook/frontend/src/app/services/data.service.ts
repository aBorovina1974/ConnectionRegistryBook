import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { RequestPurpose } from '../model/request-purpose';
import { Municipality } from '../model/municipality';
import { ConnectionPurpose } from '../model/connection-purpose';
import { ConnectionCategory } from '../model/connection-category';
import { HttpClient, HttpParams, } from '@angular/common/http';
import { Connection } from '../model/connection';
import { LazyLoadEvent } from 'primeng/primeng';
import { CollectionResult } from '../helper/collection-result';
import { ConnectionRequestForm } from '../model/connection-request-form';
import { Person } from '../model/person';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(private http: HttpClient) { }

  getRequestPurposes(): Observable<RequestPurpose[]>{
    return this.http.get<RequestPurpose[]>(
    'http://localhost:8080/ConnectionRegistryBook/request/purpose/get');
  }

  getMunicipalities(): Observable<Municipality[]>{
    return this.http.get<Municipality[]>(
    'http://localhost:8080/ConnectionRegistryBook/municipality/get');
  }

  getConnectionPurposes(): Observable<ConnectionPurpose[]>{
    return this.http.get<ConnectionPurpose[]>(
    'http://localhost:8080/ConnectionRegistryBook/connection/purpose/get');
  }

  getConnectionCategories(): Observable<ConnectionCategory[]>{
    return this.http.get<ConnectionCategory[]>(
    'http://localhost:8080/ConnectionRegistryBook/connection/category/get');
  } 

  saveNewConnectionRequest(connection: Connection): Observable<Connection>{
    return this.http.post<Connection>(
    'http://localhost:8080/ConnectionRegistryBook/connection/save', connection);
  }

  getAllConnections(): Observable<Connection[]>{
    return this.http.get<Connection[]>(
      'http://localhost:8080/ConnectionRegistryBook/connection/get'
    );
  }

  getConnectionsLazy(event: LazyLoadEvent): Observable<CollectionResult<Connection>>{
    let httpParams: HttpParams = new HttpParams();
    httpParams = httpParams.set("global", "");
    httpParams = httpParams.set("registryBookNo", "");
    httpParams = httpParams.set("fullName", "");
    httpParams = httpParams.set("oib", "");
    httpParams = httpParams.set("address", "");

    for(let key in event.filters){
      httpParams = httpParams.set(key, event.filters[key].value);
    }

    let first: number = event.first;
    let rows: number = event.rows;
    return this.http.get<CollectionResult<Connection>>(
      `http://localhost:8080/ConnectionRegistryBook/connection/get/lazy/${first}/${rows}`,
      {params: httpParams}
    );
  }

  getRequestsLazy(event: LazyLoadEvent): Observable<CollectionResult<ConnectionRequestForm>>{
    let httpParams: HttpParams = new HttpParams();
    httpParams = httpParams.set("global", "");
    httpParams = httpParams.set("submissionDate", "");
    httpParams = httpParams.set("fullName", "");
    httpParams = httpParams.set("oib", "");
    httpParams = httpParams.set("name", "");

    for(let key in event.filters){
      httpParams = httpParams.set(key, event.filters[key].value);
    }

    let first: number = event.first;
    let rows: number = event.rows;
    return this.http.get<CollectionResult<ConnectionRequestForm>>(
      `http://localhost:8080/ConnectionRegistryBook/requests/get/lazy/${first}/${rows}`,
      {params: httpParams}
    );
  }

  getConnectionByRequestId(requestId: number): Observable<Connection> {
    return this.http.get<Connection>(
      `http://localhost:8080/ConnectionRegistryBook/connection/request/${requestId}`
    );
  }

  getPersonByOib(oib: string): Observable<Person> {
    return this.http.get<Person>(
      `http://localhost:8080/ConnectionRegistryBook/person/${oib}`
    );
  }
}

