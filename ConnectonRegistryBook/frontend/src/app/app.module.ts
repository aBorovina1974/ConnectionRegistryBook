import { BrowserModule } from '@angular/platform-browser';
import { NgModule, ErrorHandler } from '@angular/core';
import { AppComponent } from './app.component';
import { RequestModule } from './requests/request.module';
import { HttpClientModule } from '@angular/common/http';
import { ReviewModule } from './review/review.module';
//import { GlobalErrorHandlerService } from './services/global-error-handler.service';
import { PanelMenuModule } from 'primeng/panelmenu';
import { MainMenuComponent } from './main-menu/main-menu.component';
import { PanelModule }  from 'primeng/panel';
import { WelcomeComponent } from './welcome/welcome.component';
import { AppRoutingModule } from './app-routing.module';


@NgModule({
  declarations: [
    AppComponent,
    MainMenuComponent,
    WelcomeComponent,
  ],
  imports: [
    BrowserModule,
    ReviewModule,
    RequestModule,
    AppRoutingModule,
    HttpClientModule,
    PanelMenuModule,
    PanelModule
  ],
  // providers: [{
  //   provide: ErrorHandler,
  //   useClass: GlobalErrorHandlerService
  // }],
  bootstrap: [AppComponent]
})
export class AppModule { }
