import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ValidationMessagesComponent } from './validation-messages/validation-messages.component';
import { ReactiveFormsModule } from '@angular/forms';
import { ReportComponent } from './report/report.component';

@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule
  ],
  declarations: [
    ValidationMessagesComponent,
    ReportComponent
  ],
  exports: [
    ValidationMessagesComponent
  ]
})
export class SharedModule { }
