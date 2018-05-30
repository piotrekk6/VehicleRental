import {Component, Input, OnInit} from '@angular/core';
import {Vehicle} from '../models/Vehicle';
import {Location} from '@angular/common';
import {ActivatedRoute, Params} from '@angular/router';
import {VehicleService} from '../vehicles/vehicle.service';
import {Borrower} from "../models/Borrower";
import {BorrowDto} from "../models/BorrowDto";

@Component({
  selector: 'app-car-details',
  templateUrl: './vehicle-details.component.html',
  styleUrls: ['./vehicle-details.component.css']
})
export class CarDetailsComponent implements OnInit {

  isNameInputDisabled: boolean;
  isProductionDateInputDisabled: boolean;
  isModelInputDisabled: boolean;
  isColorInputDisabled: boolean;
  isIdInputDisabled: boolean;
  isVehicleTypeInputDisabled: boolean;
  isBorrowButtonVisible: boolean;
  isButtonSaveDisabled: boolean;
  isButtonSaveVisible: boolean;
  isSelectBorrowerVisible: boolean;
  isManufacturerInputDisabled: boolean;
  action: string;
  borrowers: Borrower[];
  selectedBorrower: Borrower;
  borrow: BorrowDto;

  @Input() vehicle: Vehicle;


  constructor(private route: ActivatedRoute, private vehicleService: VehicleService, private location: Location) {
  }

  ngOnInit() {
    this.route.params.subscribe((params: Params) => this.action = params['action'])
    console.log("current url: " + this.action);

    this.getBorrowers();
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

  getBorrowers(): void {
    this.vehicleService.getBorrowers().subscribe(borrowers => this.borrowers = borrowers);
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

  onBorrowerSelectChanged(borrowerId: number) {
    this.borrow = {
      borrowerId: borrowerId,
      vehicleId: this.vehicle.id,
      date: this.vehicleService.getBorrowDate()
    };
    console.log("this.vehicle.id " + this.vehicle.id);
    console.log("this.borrow.borrowerId " + this.borrow.borrowerId);
    console.log("BorrowDate " + this.vehicleService.getBorrowDate());
  }

  onBorrowButtonClicked()
  {
    this.borrowVehicle(this.borrow);
  }

  borrowVehicle(borrow: BorrowDto): void {
    this.vehicleService.borrowVehicle(borrow).subscribe(() => this.goBack());
  }

  onVehicleTypeChanged(vehicleType: string) {
    if (vehicleType === 'Bike') {
      this.setBikeOnlyInputsEnabled(true);
      if (this.action === 'addCar') this.isButtonSaveDisabled = false;
    }
    else if (vehicleType === 'Car') {
      this.setBikeOnlyInputsEnabled(false);
    }

  }

  private createDetailsForm(): void {
    this.isProductionDateInputDisabled = true;
    this.isModelInputDisabled = true;
    this.isColorInputDisabled = true;
    this.isIdInputDisabled = true;
    this.isVehicleTypeInputDisabled = true;
    this.isNameInputDisabled = true;
    this.isButtonSaveVisible = false;
    this.isSelectBorrowerVisible = true;
    this.isBorrowButtonVisible = true;
    this.isSelectBorrowerVisible = true;
    this.isManufacturerInputDisabled = true;
  }

  private createEditForm(): void {
    this.isProductionDateInputDisabled = false;
    this.isModelInputDisabled = false;
    this.isColorInputDisabled = false;
    this.isIdInputDisabled = true;
    this.isVehicleTypeInputDisabled = false;
    this.isNameInputDisabled = false;
    this.isButtonSaveVisible = true;
    this.isSelectBorrowerVisible = false;
    this.isBorrowButtonVisible = false;

  }

  private createAddForm(): void {
    this.isProductionDateInputDisabled = false;
    this.isModelInputDisabled = false;
    this.isColorInputDisabled = false;
    this.isIdInputDisabled = true;
    this.isVehicleTypeInputDisabled = false;
    this.isNameInputDisabled = false;
    this.isButtonSaveVisible = true;
    this.isSelectBorrowerVisible = false;
    this.isBorrowButtonVisible = false;
    this.isSelectBorrowerVisible = false;
  }

  setBikeOnlyInputsEnabled(status: boolean): void {
    this.isColorInputDisabled
      = this.isModelInputDisabled
      = this.isProductionDateInputDisabled
      = this.isButtonSaveDisabled
      = this.isManufacturerInputDisabled
      = status;
    this.isNameInputDisabled = !status;
  }
}
