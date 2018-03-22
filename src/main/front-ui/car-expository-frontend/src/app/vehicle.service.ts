import {Injectable} from '@angular/core';
import {Vehicle} from './Vehicle';
import {Observable} from 'rxjs/Observable';
import {of} from 'rxjs/observable/of';
import {MessageService} from './message.service';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {catchError, tap} from 'rxjs/operators';
import {Borrower} from './Borrower';
import {vehicleDto} from "./vehicleDto";
import {BorrowDto} from "./BorrowDto";

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};


@Injectable()
export class VehicleService {

  private carsUrl = 'api/showAll';
  private carDetailsUrl = 'api/details';
  private updateCarUrl = 'api/editCar';
  private deleteCarUlr = 'api/delete';
  private addCarUrl = 'api/addCar';
  private addBikeUrl = 'api/addBike';
  private borrowersUrl = 'api/getBorrowers'
  private borrowedVehiclesUrl = 'api/show'
  private borrowVehicleUrl = 'api/borrow';
  private borrowDate;

  constructor(private messageService: MessageService, private http: HttpClient) {
  }

  addVehicle(vehicle: Vehicle): Observable<Vehicle> {

    if (vehicle.vehicleType === 'Car') {
      return this.http.post<Vehicle>(this.addCarUrl, vehicle, httpOptions).pipe(
        tap((vehicle: Vehicle) => this.log(`added new car `)),
        catchError(this.handleError<Vehicle>('addCar')));
    } else if (vehicle.vehicleType === 'Bike') {
      return this.http.get<Vehicle>(this.addBikeUrl + '/' + vehicle.name, httpOptions).pipe(
        tap((vehicle: Vehicle) => this.log(`added new bike w/ `)),
        catchError(this.handleError<Vehicle>('addCar')));
    }
  }

  getCars(): Observable<Vehicle[]> {
    this.messageService.add('VehicleService: Cars fetched');

    return this.http.get<Vehicle[]>(this.carsUrl).pipe(
      tap(cars => this.log(`fetched cars`)), catchError(this.handleError('getCars', []))
    );
  }

  getVehicle(id: number): Observable<Vehicle> {
    /*this.messageService.add(`VehicleService fetched vehicle id=${id}`);*/
    const url = `${this.carDetailsUrl}/${id}`;
    return this.http.get<Vehicle>(url).pipe(tap(x => this.log(`fetched car id=${id}`)),
      catchError(this.handleError<Vehicle>(`getCar id=${id}`)));
  }

  updateVehicle(car: Vehicle): Observable<any> {
    return this.http.put(this.updateCarUrl, car, httpOptions).pipe(
      tap(x => this.log(`updated car id=${car.id}`)),
      catchError(this.handleError<any>('updatedCar'))
    );
  }

  getBorrowers(): Observable<any> {
    return this.http.get<Borrower[]>(this.borrowersUrl).pipe(
      tap(borrowers => this.log(`fetched borrowers`)),
      catchError(this.handleError('getBorrowers', [])));
  }

  getBorrowedVehicles(date: string): Observable<any> {
    const url = `${this.borrowedVehiclesUrl}/${date}`;
    return this.http.get<vehicleDto[]>(url).pipe(
      tap(borrowers => this.log(`get vehicles with borrow info`)),
      catchError(this.handleError('get vehicles with borrow info', [])));
  }

  deleteVehicle(id: number): Observable<Vehicle> {
    const url = `${this.deleteCarUlr}/${id}`;

    return this.http.delete<Vehicle>(url, httpOptions).pipe(
      tap(x => this.log(`deleted car id = ${id}`)), catchError(this.handleError<Vehicle>(`deleteCar`)));
  }

  borrowVehicle(borrow: BorrowDto): Observable<any> {
    const url = `${this.borrowVehicleUrl}`;
    return this.http.post<BorrowDto>(url, borrow, httpOptions).pipe(
      tap(x => this.log(`borrow vehicleId: ${borrow.vehicleId} borrowerId: ${borrow.borrowerId} date: ${borrow.date}`)),
      catchError(this.handleError<BorrowDto>(`borrow vehicle`)));
  }

  private log(message: string) {
    this.messageService.add('VehicleService: ' + message);
  }

  setBorrowDate(date: string) {
    this.borrowDate = date;
  }

  getBorrowDate(): string {
    return this.borrowDate;
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);

      this.log(`${operation} failed: ${error.message}`);

      return of(result as T);
    };
  }
}
