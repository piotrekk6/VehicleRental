import {Injectable} from '@angular/core';
import {Vehicle} from './Vehicle';
import {Observable} from 'rxjs/Observable';
import {of} from 'rxjs/observable/of';
import {MessageService} from './message.service';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {catchError, map, tap} from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};


@Injectable()
export class VehicleService {

  private carsUrl = 'api/showAll';
  private carDetailsUrl = 'api/details';

  constructor(private messageService: MessageService, private http: HttpClient) {
  }

  addCar(car: Vehicle): Observable<Vehicle> {

    return this.http.post<Vehicle>(this.carsUrl, car, httpOptions).pipe(
      tap((car: Vehicle) => this.log(`added new car w/ id=${car.id}`)),
      catchError(this.handleError<Vehicle>('addCar'))
    );
  }

  getCars(): Observable<Vehicle[]> {
    this.messageService.add('VehicleService: Cars fetched');

    return this.http.get<Vehicle[]>(this.carsUrl).pipe(
      tap(cars => this.log(`fetched cars (tap)`)), catchError(this.handleError('getCars', []))
    );
  }

  getCar(id: number): Observable<Vehicle> {
    /*this.messageService.add(`VehicleService fetched vehicle id=${id}`);*/
    const url = `${this.carDetailsUrl}/${id}`;
    return this.http.get<Vehicle>(url).pipe(tap(x => this.log(`fetched car id=${id}`)),
      catchError(this.handleError<Vehicle>(`getCar id=${id}`)));
  }

  updateCar(car: Vehicle): Observable<any> {
    return this.http.put(this.carsUrl, car, httpOptions).pipe(
      tap(x => this.log(`updated car id=${car.id}`)),
      catchError(this.handleError<any>('updatedCar'))
    );
  }

  searchCars(term: string): Observable<Vehicle[]> {
    if (!term.trim()) {
      // if not search term, return empty hero array.
      return of([]);
    }
    return this.http.get<Vehicle[]>(`api/cars/?name=${term}`).pipe(
      tap(_ => this.log(`found cars matching "${term}"`)),
      catchError(this.handleError<Vehicle[]>('searchCars', []))
    );
  }

  deleteCar(car: Vehicle): Observable<Vehicle> {
    const id = typeof car === 'number' ? car : car.id;
    const url = `${this.carsUrl}/${id}`;

    return this.http.delete<Vehicle>(url, httpOptions).pipe(
      tap(x => this.log(`deleted car id = ${id}`)), catchError(this.handleError<Vehicle>(`deleteCar`))
    );

  }

  private log(message: string) {
    this.messageService.add('VehicleService: ' + message);
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);

      this.log(`${operation} failed: ${error.message}`);

      return of(result as T);
    };
  }
}
