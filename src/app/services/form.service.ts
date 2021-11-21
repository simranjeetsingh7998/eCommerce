import { State } from './../common/state';
import { Country } from './../common/country';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class FormService {

  private countryUrl: string = "http://localhost:8080/shopping/api/countries";
  private stateUrl: string = "http://localhost:8080/shopping/api/state/";

  constructor(private http: HttpClient) { }

  getCountries(): Observable<Country[]> {
    return this.http.get<Country[]>(this.countryUrl);
  }

  getStates(countryName: string): Observable<State[]> {
    return this.http.get<State[]>(this.stateUrl + countryName);
  }

  getCreditCardMonths(startMonth: number): Observable<number[]> {
    let data: number[] = [];

    // build an array for months dropdown
    for(let month = startMonth; month <= 12; month++) {
      data.push(month);
    }

    // of operator wraps the object as an observable
    return of(data);
  }

  getCreditCardYears(): Observable<number[]> {
    let data: number[] = [];
    const startYear: number = new Date().getFullYear();
    const endYear : number = startYear + 10;

    for(let year = startYear; year <= endYear; year++) {
      data.push(year);
    }
    return of(data);
  }
}
