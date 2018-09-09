import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule  } from '@angular/router';
import { ReportComponent } from '../shared/report/report.component';
import { ReportResolverService } from '../services/report-resolver.service';



const routes: Routes = [
  { 
    path: 'report/:id', 
    component: ReportComponent,
    resolve: {reportData: ReportResolverService}
  }
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class RequestsRoutingModule { }
