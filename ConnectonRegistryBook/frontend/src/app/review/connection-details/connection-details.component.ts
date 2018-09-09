import { Component, OnInit } from '@angular/core';
import { ConnectionDetailsService } from '../../services/connection-details.service';
import { Connection } from '../../model/connection';

@Component({
  selector: 'rb-connection-details',
  templateUrl: './connection-details.component.html',
  styleUrls: ['./connection-details.component.css']
})
export class ConnectionDetailsComponent implements OnInit {

  connectionDetails: Connection;

  constructor(private connectionDetailsService: ConnectionDetailsService) { }

  ngOnInit() {
    this.connectionDetails = this.connectionDetailsService.getConnection();
  }

}
