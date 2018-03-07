import {Component, OnInit, Input} from '@angular/core';
import {Vehicle} from '../Vehicle';
import {Location} from '@angular/common';
import {ActivatedRoute, Params} from '@angular/router';
import {VehicleService} from '../vehicle.service';

@Component({
  selector: 'app-car-details',
  templateUrl: './car-details.component.html',
  styleUrls: ['./car-details.component.css']
})
export class CarDetailsComponent implements OnInit {

  isNameInputDisabled: boolean;
  isProductionDateInputDisabled: boolean;
  isModelInputDisabled: boolean;
  isColorInputDisabled: boolean;
  isIdInputDisabled: boolean;
  isVehicleTypeInputDisabled: boolean;
  isButtonSaveEnabled: boolean;
  action: string;

  @Input() vehicle: Vehicle;

  constructor(private route: ActivatedRoute, private vehicleService: VehicleService, private location: Location) {
  }

  ngOnInit() {
    this.route.params.subscribe((params: Params) => this.action = params['action'])
    console.log("current url: " + this.action);
    if (this.action === 'details') {
      this.getCar();
      this.createDetailsForm();
    } else if (this.action === 'editCar') {
      this.getCar();
      this.createEditForm();
    } else if (this.action === 'addCar') {
      this.vehicle = new Vehicle();
      this.createAddForm();
    }
  }

  getCar(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.vehicleService.getVehicle(id).subscribe(car => this.vehicle = car);
  }

  goBack(): void {
    this.location.back();
  }

  save(): void {
    if (this.action === 'editCar') {
      this.vehicleService.updateVehicle(this.vehicle).subscribe(() => this.goBack());
    }
    else if (this.action === 'addCar') {
      this.vehicleService.addVehicle(this.vehicle).subscribe(() => this.goBack());
    }
  }

  private createDetailsForm(): void {
    this.isProductionDateInputDisabled = true;
    this.isModelInputDisabled = true;
    this.isColorInputDisabled = true;
    this.isIdInputDisabled = true;
    this.isVehicleTypeInputDisabled = true;
    this.isNameInputDisabled = true;
    this.isButtonSaveEnabled = false;
  }

  private createEditForm(): void {
    this.isProductionDateInputDisabled = false;
    this.isModelInputDisabled = false;
    this.isColorInputDisabled = false;
    this.isIdInputDisabled = true;
    this.isVehicleTypeInputDisabled = true;
    this.isNameInputDisabled = false;
    this.isButtonSaveEnabled = true;
  }

  private createAddForm(): void {
    this.isProductionDateInputDisabled = false;
    this.isModelInputDisabled = false;
    this.isColorInputDisabled = false;
    this.isIdInputDisabled = true;
    this.isVehicleTypeInputDisabled = false;
    this.isNameInputDisabled = false;
    this.isButtonSaveEnabled = true;
  }
}
