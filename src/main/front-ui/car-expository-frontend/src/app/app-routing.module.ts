import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {CarsComponent} from './vehicles/vehicles.component';
import {CarDetailsComponent} from './vehicle-details/vehicle-details.component';
import {LoginComponent} from "./login/login.component";
import {RegisterComponent} from "./register/register.component";
import {NotFoundComponent} from "./not-found/not-found.component";

const routes: Routes = [
  { path: 'showAll', component: CarsComponent},
  { path: 'login', component: LoginComponent},
  { path: 'register', component: RegisterComponent},
  { path: '404', component: NotFoundComponent},

  { path: ':action', component: CarDetailsComponent },
  { path: ':action/:id', component: CarDetailsComponent },
  { path: '**', redirectTo: '404', pathMatch: 'full'}
];

@NgModule({
  exports: [
    RouterModule
  ],
  imports: [RouterModule.forRoot(routes)]
})

export class AppRoutingModule {
}
