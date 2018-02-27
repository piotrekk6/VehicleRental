import {Component, OnInit} from '@angular/core';
import {VehicleService} from '../vehicle.service';
import {Vehicle} from '../Vehicle';
import {MessageService} from '../message.service';


@Component({
  selector: 'app-cars',
  templateUrl: './cars.component.html',
  styleUrls: ['./cars.component.css']
})
export class CarsComponent implements OnInit {
  vehicles: Vehicle[];

  // selectedCar: Vehicle;

  constructor(private vehicleService: VehicleService) {
  }

  ngOnInit() {
    this.getVehicles();
  }

  /*  onSelect(vehicle: Vehicle): void {
      this.selectedCar = vehicle;
      this.messageService.add('Clicked: ' + vehicle.model);

    }*/

  getVehicles(): void {
    this.vehicleService.getCars().subscribe(cars => this.vehicles = cars);
  }

  add(name: string): void {
    name = name.trim();
    if (!name) {
      return;
    }
    this.vehicleService.addCar({model: name} as Vehicle).subscribe(car => {
      this.vehicles.push(car);
    });
  }

  delete(vehicle: Vehicle): void {
    this.vehicles = this.vehicles.filter(c => c !== vehicle);
    this.vehicleService.deleteCar(vehicle).subscribe();
  }
}
