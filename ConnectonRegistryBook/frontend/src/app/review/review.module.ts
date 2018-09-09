import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TableModule } from 'primeng/table';
import { ConnectionsReviewComponent } from './connections-review/connections-review.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations'; 
import { PanelModule } from 'primeng/panel';
import {TabViewModule} from 'primeng/tabview';
import {CardModule} from 'primeng/card';
import { InputTextModule } from 'primeng/inputtext';
import { FormsModule } from '@angular/forms';
import { ReviewRoutingModule } from './review-routing.module';
import { ConnectionDetailsComponent } from './connection-details/connection-details.component';
import { RequestsReviewComponent } from './requests-review/requests-review.component';
import {ContextMenuModule} from 'primeng/contextmenu';






@NgModule({
  imports: [
    BrowserAnimationsModule,
    CommonModule,
    ReviewRoutingModule,
    TableModule,
    PanelModule,
    TabViewModule,
    CardModule,
    InputTextModule,
    ContextMenuModule,
    FormsModule
  ],
  declarations: [
    ConnectionsReviewComponent,
    ConnectionDetailsComponent,
    RequestsReviewComponent
  ],
  exports: [
  ]
})
export class ReviewModule { }
