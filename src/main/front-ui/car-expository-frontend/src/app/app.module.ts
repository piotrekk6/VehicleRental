import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {CarsComponent} from './vehicles/vehicles.component';
import {CarDetailsComponent} from './vehicle-details/vehicle-details.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {VehicleService} from './vehicles/vehicle.service';
import {MessagesComponent} from './messages/messages.component';
import {MessageService} from './messages/message.service';
import {AppRoutingModule} from './app-routing.module';
import {HttpClientModule} from '@angular/common/http';
import {LoginComponent} from './login/login.component';
import {authService} from "./auth/auth.service";
import { StorageServiceModule} from 'angular-webstorage-service';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { TokenInterceptor } from './auth/tokenInterceptor';
import { RegisterComponent } from './register/register.component';


@NgModule({
  declarations: [
    AppComponent,
    CarsComponent,
    CarDetailsComponent,
    MessagesComponent,
    LoginComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserModule,
    StorageServiceModule,
  ],
  providers: [
    VehicleService,
    MessageService,
    authService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
