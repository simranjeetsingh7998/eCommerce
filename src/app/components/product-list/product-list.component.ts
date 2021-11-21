import { CartService } from './../../services/cart.service';
import { CartItem } from './../../common/cart-item';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from 'src/app/common/product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products: Product[] = [];
  errorMessage!: string;
  currentCategoryId!: number;
  searchedProduct!: string;
  page: number = 1;

  constructor(
    private productService: ProductService,
    private cartService: CartService,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(() => {
      this.page = 1;
      this.allProducts();
    });
  }

  allProducts() {
    this.route.params.subscribe(param => this.searchedProduct = param['keyword']);
    if(this.searchedProduct) {
      this.searchProducts();
    }
    else {
      this.getProducts();
    }
  }

  searchProducts() {
    this.productService.getProductByName(this.searchedProduct).subscribe(
      (product) => { this.products = product },
      (error) => { this.errorMessage = error }
    );
  }

  getProducts() {
    this.route.params.subscribe(param => this.currentCategoryId = param['id']);
    if (this.currentCategoryId) {
      this.productService.getProductByCategory(this.currentCategoryId).subscribe(
        (product) => { this.products = product },
        (error) => { this.errorMessage = error }
      );
    }
    else {
      this.productService.getProductList().subscribe(
        (product) => { this.products = product },
        (error) => { this.errorMessage = error }
      );
    }
  }

  addToCart(product: Product) {
    console.log("Added To Cart : ", product.name, " ", product.unitPrice);
    const theCartItem = new CartItem(product);
    this.cartService.addToCart(theCartItem);
  }
}
