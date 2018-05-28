import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {CarsComponent} from './vehicles/vehicles.component';
import {CarDetailsComponent} from './vehicle-details/vehicle-details.component';
import {LoginComponent} from "./login/login.component";

const routes: Routes = [
  { path: 'showAll', component: CarsComponent},
  { path: 'login', component: LoginComponent},
  { path: '', redirectTo: 'showAll', pathMatch: 'full' },
  { path: ':action/:id', component: CarDetailsComponent },
  { path: ':action', component: CarDetailsComponent },

];

@NgModule({
  exports: [
    RouterModule
  ],
  imports: [RouterModule.forRoot(routes)]
})

export class AppRoutingModule {
}
