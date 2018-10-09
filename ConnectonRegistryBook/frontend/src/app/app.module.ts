import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { RequestModule } from './requests/request.module';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { ReviewModule } from './review/review.module';
import { PanelMenuModule } from 'primeng/panelmenu';
import { MainMenuComponent } from './main-menu/main-menu.component';
import { PanelModule } from 'primeng/panel';
import { WelcomeComponent } from './welcome/welcome.component';
import { AppRoutingModule } from './app-routing.module';
import { HttpErrorInterceptor } from './services/http-error-interceptor';
import { MessageService } from 'primeng/api';




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
  providers: [
    {
      provide: HTTP_INTERCEPTORS, 
      useClass: HttpErrorInterceptor,
      multi: true
    },
    MessageService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
