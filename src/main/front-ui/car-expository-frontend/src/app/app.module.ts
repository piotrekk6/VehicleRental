import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';


import {AppComponent} from './app.component';
import {CarsComponent} from './vehicles/cars.component';
import {CarDetailsComponent} from './vehicle-details/car-details.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {VehicleService} from './vehicle.service';
import {MessagesComponent} from './messages/messages.component';
import {MessageService} from './message.service';
import {AppRoutingModule} from './/app-routing.module';
import {RouterModule} from '@angular/router';
import {HttpClientModule} from '@angular/common/http';
import { MyDatePickerModule } from 'mydatepicker';



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
    HttpClientModule,
    BrowserModule,
    MyDatePickerModule
  ],
  providers: [
    VehicleService,
    MessageService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
