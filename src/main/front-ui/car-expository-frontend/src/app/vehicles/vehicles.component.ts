import {Component, OnInit} from '@angular/core';
import {VehicleService} from '../vehicle.service';
import {Vehicle} from '../Vehicle';
import {MessageService} from '../message.service';
import {vehicleDto} from "../vehicleDto";
import {BehaviorSubject} from "rxjs/BehaviorSubject";

@Component({
  selector: 'app-cars',
  templateUrl: './vehicles.component.html',
  styleUrls: ['./vehicles.component.css']
})
export class CarsComponent implements OnInit {
  vehicles: Vehicle[];
  selectedVehicle: vehicleDto;
  selectedId: number;
  borrowDate: string;
  inputDate: Date;
  vehiclesRent: vehicleDto[];
  todayDate: Date;

  isEditButtonDisabled: boolean;
  isDeleteButtonDisabled: boolean;
  isDetailsButtonDisabled: boolean;

  constructor(private vehicleService: VehicleService, private messageService: MessageService) {
  }

  ngOnInit() {
    this.enableButtonsIfVehicleSelected();
    this.borrowDate = new Date().toISOString().slice(0,10);
    this.getBorrowedVehicles(this.borrowDate);
    this.vehicleService.setBorrowDate(this.borrowDate);

    console.log(this.borrowDate);
  }

  onSelect(vehicle: vehicleDto): void {
    this.selectedVehicle = vehicle;
    this.selectedId = vehicle.id;
    this.enableButtonsIfVehicleSelected();

    console.log('Clicked: ' + this.selectedVehicle.id);
  }

  getVehicles(): void {
    this.vehicleService.getCars().subscribe(cars => this.vehicles = cars);
  }

  onDateChanged(date: string) {
    this.getBorrowedVehicles(date);
    this.selectedVehicle = null;
    this.vehicleService.setBorrowDate(date);
    this.enableButtonsIfVehicleSelected();
    if(this.isDateInputLaterOrEqualToToday()) this.setDetailsButtonDisabled(false);
  }

  getBorrowedVehicles(date: string) {
    this.vehicleService.getBorrowedVehicles(date).subscribe(borrows => this.vehiclesRent = borrows);
  }


  delete(vehicle: vehicleDto): void {
    this.vehiclesRent = this.vehiclesRent.filter(c => c !== vehicle);
    this.vehicleService.deleteVehicle(this.selectedId).subscribe();
  }

  private enableButtonsIfVehicleSelected() {
    if (this.isVehicleSelected()) {
      this.enableEditButtonIfCarSelected(this.selectedVehicle);
      this.setEditButtonDisabled(false);
      if(this.isDateInputLaterOrEqualToToday())
      {
        this.setDetailsButtonDisabled(false);
      }
    }
    else {
      this.disableEditDeleteDetailsButtons();
    }
  }

  isDateInputLaterOrEqualToToday(): boolean
  {
    this.todayDate = new Date();
    console.log("todayDate: " + this.todayDate);
    this.inputDate = new Date(this.borrowDate);
    console.log("input date: " + this.inputDate);
    if (this.inputDate >= this.todayDate) {
      return true
    }
    else return false;
  }

  private disableEditDeleteDetailsButtons() {
    this.isDeleteButtonDisabled = true;
    this.isDetailsButtonDisabled = true;
    this.isEditButtonDisabled = true;
  }

  private isVehicleSelected(): boolean {
    return this.selectedVehicle != null;
  }

  private enableEditButtonIfCarSelected(vehicle: vehicleDto): void {
    if (vehicle.vehicleType === 'Car') this.isEditButtonDisabled = false;
    else this.isEditButtonDisabled = true;
  }

  private setEditButtonDisabled(val: boolean): void {
    this.isDeleteButtonDisabled = val;
  }

  private setDetailsButtonDisabled( val: boolean): void {
    this.isDetailsButtonDisabled = val;
  }



}
