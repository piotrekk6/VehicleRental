import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';


import {AppComponent} from './app.component';
import {CarsComponent} from './cars/cars.component';
import {CarDetailsComponent} from './car-details/car-details.component';
import {FormsModule} from '@angular/forms';
import {VehicleService} from './vehicle.service';
import {MessagesComponent} from './messages/messages.component';
import {MessageService} from './message.service';
import {AppRoutingModule} from './/app-routing.module';
import {RouterModule} from '@angular/router';
import {HttpClientModule} from '@angular/common/http';


@NgModule({
  declarations: [
    AppComponent,
    CarsComponent,
    CarDetailsComponent,
    MessagesComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [
    VehicleService,
    MessageService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
