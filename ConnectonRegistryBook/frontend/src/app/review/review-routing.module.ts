import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { ConnectionDetailsComponent } from './connection-details/connection-details.component';
import { ReportComponent } from '../shared/report/report.component';
import { ReportResolverService } from '../services/report-resolver.service';
import { NewConnectionComponent } from '../requests/new-connection/new-connection.component';
import { EditRequestResolverService } from '../services/edit-request-resolver.service';


const routes: Routes = [
   { path: 'connection/details', component: ConnectionDetailsComponent},
   
   { 
    path: 'report/:id', 
    component: ReportComponent,
    resolve: {reportData: ReportResolverService }
   },
   
  { 
    path: 'new/:id', 
    component: NewConnectionComponent,
    resolve: {requestData: EditRequestResolverService }
  }
]

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(routes)
  ],
  declarations: []
})
export class ReviewRoutingModule { }
