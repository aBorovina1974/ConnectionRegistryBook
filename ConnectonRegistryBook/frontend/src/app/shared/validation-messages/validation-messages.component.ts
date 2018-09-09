import { Component, OnInit, Input } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'rb-validation-messages',
  templateUrl: './validation-messages.component.html',
  styleUrls: ['./validation-messages.component.css']
})
export class ValidationMessagesComponent implements OnInit {

  @Input('form') form: FormGroup;
  @Input('control') controlName: string;

  constructor() { }

  ngOnInit() {
  }

  controlValidationErrors(control: string){
    let controlState = this.form.controls[control];
    return (controlState.dirty && controlState.errors) ? controlState.errors : null;
  }
}
