import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { PanelModule } from 'primeng/panel';
import { FieldsetModule } from 'primeng/fieldset';
import { CalendarModule } from 'primeng/calendar';
import { DropdownModule } from 'primeng/dropdown';
import { InputTextModule } from 'primeng/inputtext';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations'; 
import { AngularFontAwesomeModule } from 'angular-font-awesome';
import { NewConnectionComponent } from './new-connection/new-connection.component';
import { ReactiveFormsModule } from '@angular/forms';
import { ButtonModule } from 'primeng/button';
import { SharedModule } from '../shared/shared.module';
import { RequestsRoutingModule } from './requests-routing.module';
import {ToastModule} from 'primeng/toast';






@NgModule({
  imports: [
    CommonModule,
    BrowserModule,
    SharedModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    RequestsRoutingModule,
    AngularFontAwesomeModule,
    PanelModule,
    FieldsetModule,
    CalendarModule,
    DropdownModule,
    InputTextModule,
    ButtonModule,
    ToastModule
  ],
  declarations: [
    NewConnectionComponent
  ],
  exports:[
    
  ]
})
export class RequestModule { }
