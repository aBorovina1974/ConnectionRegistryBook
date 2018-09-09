import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { DataService } from '../../services/data.service';
import { RequestPurpose } from '../../model/request-purpose';
import { Municipality } from '../../model/municipality';
import { ConnectionPurpose } from '../../model/connection-purpose';
import { ConnectionCategory } from '../../model/connection-category';
import { Person } from '../../model/person';
import { Connection } from '../../model/connection';
import { ConnectionRequestForm } from '../../model/connection-request-form';
import { Status } from '../../model/status';
import { RequestType } from '../../model/request-type';
import { Router, ActivatedRoute } from '@angular/router';


@Component({
  selector: 'rb-new-connection',
  templateUrl: './new-connection.component.html',
  styleUrls: ['./new-connection.component.css'],
})
export class NewConnectionComponent implements OnInit {

  pageTitle: string = 'Novi priključak';
  saveBtnLabel: string = 'Spremi';
  newConnectionForm: FormGroup;
  requestPurposes: RequestPurpose[];
  municipalities: Municipality[];
  connectionPurposes: ConnectionPurpose[];
  connectionCategories: ConnectionCategory[];
  retreivedConnection: Connection;

  constructor(private fb: FormBuilder,
    private dataService: DataService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
    this.newConnectionForm = this.fb.group({
      requestDate: [new Date(), Validators.required],
      requestPurpose: ['', Validators.required],
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      oib: ['', [Validators.required, Validators.pattern("[0-9]{11}")]],
      phone: ['', Validators.required],
      email: ['', Validators.required],
      submitterAddress: ['', Validators.required],
      cadastralMunicipality: ['', Validators.required],
      settlementArea: ['', Validators.required],
      cadastralParcelNo: ['', Validators.required],
      connectionAddress: ['', Validators.required],
      connectionPurpose: ['', Validators.required],
      connectionCategory: ['', Validators.required],
      registryBookNo: ['', Validators.required]
    });
    if(this.route.snapshot.data['requestData'] != null){
      this.getExistingRequestData(this.route.snapshot.data['requestData']);
      this.retreivedConnection = this.route.snapshot.data['requestData'];
    }
    this.getUiData();
  }

  private getUiData() {

    this.dataService.getRequestPurposes()
      .subscribe(
        (data: RequestPurpose[]) => this.requestPurposes = data,
        (err: Error) => console.log(err)
      );

    this.dataService.getMunicipalities()
      .subscribe(
        (data: Municipality[]) => this.municipalities = data,
        (err: Error) => console.log(err)
      );

    this.dataService.getConnectionPurposes()
      .subscribe(
        (data: ConnectionPurpose[]) => this.connectionPurposes = data,
        (err: Error) => console.log(err)
      );

    this.dataService.getConnectionCategories()
      .subscribe(
        (data: ConnectionCategory[]) => this.connectionCategories = data,
        (err: Error) => console.log(err)
      );
  }

  private getUserData(): Connection {

    let submitter: Person = new Person();
    submitter.name = this.newConnectionForm.get('firstName').value;
    submitter.surnameNickname = this.newConnectionForm.get('lastName').value;
    submitter.oib = this.newConnectionForm.get('oib').value;
    submitter.phone = this.newConnectionForm.get('phone').value;
    submitter.email = this.newConnectionForm.get('email').value;
    submitter.address = this.newConnectionForm.get('submitterAddress').value;

    let requestDate = this.newConnectionForm.get('requestDate').value;
    let requestPurpose = this.newConnectionForm.get('requestPurpose').value;

    let requestType = new RequestType();
    requestType.id = 1;
    requestType.name = 'novi priključak';
    requestType.description = null;

    let connectionRequestForm: ConnectionRequestForm = new ConnectionRequestForm();
    connectionRequestForm.submissionDate = requestDate;
    connectionRequestForm.requestPurpose = requestPurpose;
    connectionRequestForm.requestType = requestType;
    connectionRequestForm.submitter = submitter;

    let status = new Status();
    status.id = 1;
    status.name = 'zahtjev';
    status.description = null;

    let connection: Connection = new Connection();
    connection.requestForm = connectionRequestForm;
    connection.cadastralMunicipality = this.newConnectionForm.get('cadastralMunicipality').value;
    connection.settlementArea = this.newConnectionForm.get('settlementArea').value;
    connection.cadastralParcelNo = this.newConnectionForm.get('cadastralParcelNo').value;
    connection.address = this.newConnectionForm.get('connectionAddress').value;
    connection.registryBookNo = this.newConnectionForm.get('registryBookNo').value;
    connection.connectionPurpose = this.newConnectionForm.get('connectionPurpose').value;
    connection.connectionCategory = this.newConnectionForm.get('connectionCategory').value;
    connection.status = status;

    if (this.newConnectionForm.get('requestPurpose').value.name === 'vodoopskrba i odvodnja' ||
      this.newConnectionForm.get('requestPurpose').value.name === 'odvodnja') {
      connection.hasDrainage = true;
    }
    else {
      connection.hasDrainage = false;
    }
    return connection;
  }

  saveNewConnectionRequest() {
    if(this.retreivedConnection) {
      this.updateNewConnectionRequest(this.retreivedConnection);
    }
    else{
      this.dataService.saveNewConnectionRequest(this.getUserData())
      .subscribe(
        (data: Connection) => {
          if (data) {
            console.log(data);
            alert(`Zahtjev za novi priključak podnositelja
                  ${data.requestForm.submitter.fullName}
                  uspješno je spremljen`);
          }
        },
        (err: Error) => console.log(err),
        () => this.resetForm()
      );
    }
  }

  getNewConnectionRequestDocument(): void {
    if(this.retreivedConnection) {
      this.router.navigate(['/report', this.retreivedConnection.id])
    }
    else
    {
      this.dataService.saveNewConnectionRequest(this.getUserData())
      .subscribe(
        (data: Connection) => this.router.navigate(['/report', data.id]),
        (err: Error) => console.log(err)
      );
    }
  }

  getExistingRequestData(connection: Connection) {
    this.newConnectionForm.setValue({
      requestDate: new Date(connection.requestForm.submissionDate),    
      requestPurpose: connection.requestForm.requestPurpose,
      firstName: connection.requestForm.submitter.name,
      lastName: connection.requestForm.submitter.surnameNickname,
      oib: connection.requestForm.submitter.oib,
      phone: connection.requestForm.submitter.phone,
      email: connection.requestForm.submitter.email,
      submitterAddress: connection.requestForm.submitter.address,
      cadastralMunicipality: connection.cadastralMunicipality,
      settlementArea: connection.settlementArea,
      cadastralParcelNo: connection.cadastralParcelNo,
      connectionAddress: connection.address,
      connectionPurpose: connection.connectionPurpose,
      connectionCategory: connection.connectionCategory,
      registryBookNo: connection.registryBookNo
    });
    this.pageTitle = 'Izmjeni zahtjev';
  }

  updateNewConnectionRequest(connection: Connection) {
    connection.requestForm.submissionDate = this.newConnectionForm.get('requestDate').value;
    connection.requestForm.requestPurpose = this.newConnectionForm.get('requestPurpose').value;
    connection.requestForm.submitter.name = this.newConnectionForm.get('firstName').value;
    connection.requestForm.submitter.surnameNickname = this.newConnectionForm.get('lastName').value;
    connection.requestForm.submitter.oib  = this.newConnectionForm.get('oib').value;
    connection.requestForm.submitter.phone = this.newConnectionForm.get('phone').value;
    connection.requestForm.submitter.email = this.newConnectionForm.get('email').value;
    connection.requestForm.submitter.address = this.newConnectionForm.get('submitterAddress').value;
    connection.cadastralMunicipality = this.newConnectionForm.get('cadastralMunicipality').value;
    connection.settlementArea = this.newConnectionForm.get('settlementArea').value;
    connection.cadastralParcelNo = this.newConnectionForm.get('cadastralParcelNo').value;
    connection.address = this.newConnectionForm.get('connectionAddress').value;
    connection.registryBookNo = this.newConnectionForm.get('registryBookNo').value;
    connection.connectionPurpose = this.newConnectionForm.get('connectionPurpose').value;
    connection.connectionCategory = this.newConnectionForm.get('connectionCategory').value;
    
    if (this.newConnectionForm.get('requestPurpose').value.name === 'vodoopskrba i odvodnja' ||
    this.newConnectionForm.get('requestPurpose').value.name === 'odvodnja')
    {
      connection.hasDrainage = true;
    }
    else {
      connection.hasDrainage = false;
    }
    this.dataService.saveNewConnectionRequest(connection)
    .subscribe(
      (data: Connection) => {
        if(data) {
          alert(`Zahtjev za novi priključak podnositelja 
                ${data.requestForm.submitter.fullName}
                uspješno izmjenjen.`);
        }
      },
      (err: Error) => console.log(err),
      () => this.router.navigate(['/review/requests'])
    );
  }

  isFormInvalid(): boolean {
    return !this.newConnectionForm.valid;
  }

  resetForm(): void {
    this.newConnectionForm.reset();
    this.newConnectionForm.patchValue({ requestDate: new Date() });
  }
}
