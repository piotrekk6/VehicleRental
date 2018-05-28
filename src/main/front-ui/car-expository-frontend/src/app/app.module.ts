import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';


import {AppComponent} from './app.component';
import {CarsComponent} from './vehicles/vehicles.component';
import {CarDetailsComponent} from './vehicle-details/vehicle-details.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {VehicleService} from './vehicle.service';
import {MessagesComponent} from './messages/messages.component';
import {MessageService} from './message.service';
import {AppRoutingModule} from './app-routing.module';
import {HttpClientModule} from '@angular/common/http';
import {MyDatePickerModule} from 'mydatepicker';
import {LoginComponent} from './login/login.component';
import {AuthService} from "./AuthService";


@NgModule({
  declarations: [
    AppComponent,
    CarsComponent,
    CarDetailsComponent,
    MessagesComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserModule,
    MyDatePickerModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [
    VehicleService,
    MessageService,
    AuthService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
