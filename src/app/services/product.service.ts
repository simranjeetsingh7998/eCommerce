import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from '../common/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private allProducts = 'http://localhost:8080/shopping/api/products';
  private searchByCategory = 'http://localhost:8080/shopping/api/category/';
  private searchByName = 'http://localhost:8080/shopping/api/products/';
  private getById = 'http://localhost:8080/shopping/api/products/productId/';

  constructor(private http: HttpClient) { }

  getProductList(): Observable<Product[]> {
    return this.http.get<Product[]>(this.allProducts);
  }

  getProductByCategory(id: number): Observable<Product[]> {
    return this.http.get<Product[]>(this.searchByCategory + id);
  }

  getProductByName(name: string): Observable<Product[]> {
    return this.http.get<Product[]>(this.searchByName + name);
  }

  getProductDetails(id: number): Observable<Product> {
    return this.http.get<Product>(this.getById + id);
  }
}
