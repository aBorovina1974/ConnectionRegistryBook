import { Component, OnInit } from '@angular/core';
import { ConnectionRequestForm } from '../../model/connection-request-form';
import { DataService } from '../../services/data.service';
import { LazyLoadEvent } from 'primeng/primeng';
import {MenuItem} from 'primeng/api';
import { Connection } from '../../model/connection';
import { Router } from '@angular/router';

@Component({
  selector: 'rb-requests-review',
  templateUrl: './requests-review.component.html',
  styleUrls: ['./requests-review.component.css']
})
export class RequestsReviewComponent implements OnInit {

  pageTitle = "Pregled zahtjeva";
  tblColumns: any[];
  allRequests: ConnectionRequestForm[];
  totalRecords: number;
  selectedRequest: ConnectionRequestForm;
  contextMenuItems: MenuItem[];

  constructor(private dataService: DataService,
              private router: Router) { }

  ngOnInit() {

    this.tblColumns = [
      { field: 'submissionDate', header: 'Datum podnošenja' },
      { field: 'submitter.fullName', header: 'Ime i prezime podnositelja' },
      { field: 'submitter.oib', header: 'Oib podnositelja' },
      { field: 'requestType.name', header: 'Vrsta zahtjeva' }
    ];

    this.contextMenuItems = [
      { label: 'Generiraj dokument', command: (event) => this.getNewConnectionRequestDocument() },
      { label: 'Uredi', command: (event) => this.editSelestedRequest() }
    ];
  }

  private getCellData(rowData: any, col: any): any {
    const nestedProperties: string[] = col.field.split('.');
    let value: any = rowData;
    for (const prop of nestedProperties) {
      value = value[prop];
    }
    return value;
  }

  loadRequestsLazy(event: LazyLoadEvent){
    this.dataService.getRequestsLazy(event).subscribe(
      (data) => {
        this.totalRecords = data.totalRecords;
        this.allRequests = data.data;
      },
    );
  }

  getNewConnectionRequestDocument(): void {
    this.dataService.getConnectionByRequestId(this.selectedRequest.id).subscribe(
      (data: Connection) => this.router.navigate(['/report', data.id]),
      (err: Error) => console.log(err)
    );
  }

  editSelestedRequest(): void {
    this.router.navigate(['/new', this.selectedRequest.id]);
  }

}
