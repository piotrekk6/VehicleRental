import {Component, OnInit, Input} from '@angular/core';
import {Vehicle} from '../Vehicle';
import {Location} from '@angular/common';
import {ActivatedRoute} from '@angular/router';
import {VehicleService} from '../vehicle.service';

@Component({
  selector: 'app-car-details',
  templateUrl: './car-details.component.html',
  styleUrls: ['./car-details.component.css']
})
export class CarDetailsComponent implements OnInit {

  @Input() vehicle: Vehicle;

  constructor(private route: ActivatedRoute, private carService: VehicleService, private location: Location) {
  }
 //TODO add vehicle editing
  ngOnInit() {
    this.getCar();
  }

  getCar(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.carService.getCar(id).subscribe(car => this.vehicle = car);
  }

  goBack(): void {
    this.location.back();
  }

  save(): void {
    this.carService.updateCar(this.vehicle)
      .subscribe(() => this.goBack());
  }
}
