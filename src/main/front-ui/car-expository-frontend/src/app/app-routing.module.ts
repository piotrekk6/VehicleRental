import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {CarsComponent} from './cars/cars.component';
import {CarDetailsComponent} from './car-details/car-details.component';

const routes: Routes = [
  {path: 'showAll', component: CarsComponent},
  { path: '', redirectTo: '/showAll', pathMatch: 'full' },
  { path: 'details/:id', component: CarDetailsComponent }
];

@NgModule({
  exports: [
    RouterModule
  ],
  imports: [RouterModule.forRoot(routes)]
})

export class AppRoutingModule {
}
