import {Component, OnInit} from '@angular/core';
import {VehicleService} from '../vehicle.service';
import {Vehicle} from '../Vehicle';
import {MessageService} from '../message.service';
import {logger} from "codelyzer/util/logger";
import {isBoolean} from "util";


@Component({
  selector: 'app-cars',
  templateUrl: './cars.component.html',
  styleUrls: ['./cars.component.css']
})
export class CarsComponent implements OnInit {
  vehicles: Vehicle[];
  selectedVehicle: Vehicle;
  selectedId: number;

  isEditButtonDisabled: boolean;
  isDeleteButtonDisabled: boolean;
  isDetailsButtonDisabled: boolean;

  constructor(private vehicleService: VehicleService, private messageService: MessageService) {
  }

  ngOnInit() {
    this.getVehicles();
    this.enableButtonsIfVehicleSelected();
  }

  onSelect(vehicle: Vehicle): void {
    this.selectedVehicle = vehicle;
    this.selectedId = vehicle.id;
    this.enableButtonsIfVehicleSelected();

    console.log('Clicked: ' + this.selectedVehicle.id);
  }

  getVehicles(): void {
    this.vehicleService.getCars().subscribe(cars => this.vehicles = cars);
  }

  add(name: string): void {
    name = name.trim();
    if (!name) {
      return;
    }
    this.vehicleService.addVehicle({model: name} as Vehicle).subscribe(car => {
      this.vehicles.push(car);
    });
  }

  delete(vehicle: Vehicle): void {
    this.vehicles = this.vehicles.filter(c => c !== vehicle);
    this.vehicleService.deleteVehicle(vehicle).subscribe();
  }

  private enableButtonsIfVehicleSelected() {
    if (this.isVehicleSelected()) {
      this.enableEditButton(this.selectedVehicle);
      this.enableDeleteDetailsButtons()
    }
    else {
      this.disableEditDeleteDetailsButtons();
    }
  }

  private disableEditDeleteDetailsButtons() {
    this.isDeleteButtonDisabled = true;
    this.isDetailsButtonDisabled = true;
    this.isEditButtonDisabled = true;
  }

  private isVehicleSelected(): boolean {
    return this.selectedVehicle != null;
  }

  private enableEditButton(vehicle: Vehicle): void {
    if(vehicle.vehicleType === 'Car') this.isEditButtonDisabled=false;
    else this.isEditButtonDisabled=true;
  }

  private enableDeleteDetailsButtons(): void {
    this.isDeleteButtonDisabled = false;
    this.isDetailsButtonDisabled = false;
  }
}
