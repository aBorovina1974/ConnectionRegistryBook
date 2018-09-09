import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { WelcomeComponent } from './welcome/welcome.component';
import { NewConnectionComponent } from './requests/new-connection/new-connection.component';
import { ConnectionsReviewComponent } from './review/connections-review/connections-review.component';
import { RequestsReviewComponent } from './review/requests-review/requests-review.component';


const routes: Routes = [
  { path: 'review/connections', component: ConnectionsReviewComponent},
  { path: 'review/requests', component: RequestsReviewComponent},
  { path: 'new', component: NewConnectionComponent},
  { path: 'welcome', component: WelcomeComponent},
  { path: '', redirectTo: 'welcome', pathMatch: 'full' },
  { path: '**', redirectTo: 'welcome', pathMatch: 'full' }
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  declarations: [],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }
