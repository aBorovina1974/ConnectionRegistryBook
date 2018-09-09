import { Component, OnInit} from '@angular/core';
import { Connection } from '../../model/connection';
import { DataService } from '../../services/data.service';
import { LazyLoadEvent } from 'primeng/primeng';
import { Router } from '@angular/router';
import { ConnectionDetailsService } from '../../services/connection-details.service';


@Component({
  selector: 'rb-connections-review',
  templateUrl: './connections-review.component.html',
  styleUrls: ['./connections-review.component.css'],
})
export class ConnectionsReviewComponent implements OnInit {
  pageTitle = 'Pregled priključaka';
  tblColumns: any[];
  allConnections: Connection[];
  totalRecords: number;
  selectedConnection: Connection;

  constructor(private dataSeervice: DataService,
              private router: Router,
              private connectionDetails: ConnectionDetailsService) { }

  ngOnInit() {

    this.tblColumns = [
      { field: 'registryBookNo', header: 'Matični broj' },
      { field: 'requestForm.submitter.fullName', header: 'Ime i prezime vlasnika' },
      { field: 'requestForm.submitter.oib', header: 'Oib vlasnika' },
      { field: 'address', header: 'Adresa priključka' },
      { field: 'workOrder', header: 'Radni nalog' }
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

  loadConnectionLazy(event: LazyLoadEvent){
    this.dataSeervice.getConnectionsLazy(event).subscribe(
      (data) => {
        this.totalRecords = data.totalRecords;
        this.allConnections = data.data;
      },
    );
  }

  onRowSelect(event) {
    this.connectionDetails.setConnection(this.selectedConnection);
    this.router.navigate(['/connection/details']);
  }
}
