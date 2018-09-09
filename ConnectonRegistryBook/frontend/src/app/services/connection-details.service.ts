import { Injectable } from '@angular/core';
import { Connection } from '../model/connection';

@Injectable({
  providedIn: 'root'
})
export class ConnectionDetailsService {

  private connection: Connection;

  getConnection() {
    return this.connection;
  }

  setConnection(connection: Connection) {
    this.connection = connection;
  }
  
  constructor() { }
}
