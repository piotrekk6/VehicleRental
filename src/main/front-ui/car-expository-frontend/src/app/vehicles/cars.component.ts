import {Component, OnInit} from '@angular/core';
import {VehicleService} from '../vehicle.service';
import {Vehicle} from '../Vehicle';
import {MessageService} from '../message.service';
import {logger} from "codelyzer/util/logger";
import {isBoolean} from "util";
import {Borrow} from "../Borrow";

@Component({
  selector: 'app-cars',
  templateUrl: './cars.component.html',
  styleUrls: ['./cars.component.css']
})
export class CarsComponent implements OnInit {
  vehicles: Vehicle[];
  selectedBorrow: Borrow;
  selectedId: number;
  borrowDate: string;
  borrows: Borrow[];

  isEditButtonDisabled: boolean;
  isDeleteButtonDisabled: boolean;
  isDetailsButtonDisabled: boolean;

  constructor(private vehicleService: VehicleService, private messageService: MessageService) {
  }

  ngOnInit() {
    this.enableButtonsIfVehicleSelected();
    this.borrowDate = new Date().toISOString().slice(0,10);
    this.borrowDate = new Date("2018-08-10").toISOString().slice(0,10);
    this.getBorrowedVehicles(this.borrowDate);

    console.log(this.borrowDate);
  }

  onSelect(borrow: Borrow): void {
    this.selectedBorrow = borrow;
    this.selectedId = borrow.vehicleDto.id;
    this.enableButtonsIfVehicleSelected();

    console.log('Clicked: ' + this.selectedBorrow.id);
  }

  getVehicles(): void {
    this.vehicleService.getCars().subscribe(cars => this.vehicles = cars);
  }

  getBorrowedVehicles(date: string) {
    this.vehicleService.getBorrowedVehicles(date).subscribe(borrows => this.borrows = borrows);
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
    this.vehicleService.deleteVehicle(this.selectedId).subscribe();
  }

  private enableButtonsIfVehicleSelected() {
    if (this.isVehicleSelected()) {
      this.enableEditButton(this.selectedBorrow);
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
    return this.selectedBorrow != null;
  }

  private enableEditButton(borrow: Borrow): void {
    if (borrow.vehicleDto.vehicleType === 'Car') this.isEditButtonDisabled = false;
    else this.isEditButtonDisabled = true;
  }

  private enableDeleteDetailsButtons(): void {
    this.isDeleteButtonDisabled = false;
    this.isDetailsButtonDisabled = false;
  }
}
