import { CartService } from './../../services/cart.service';
import { CartItem } from './../../common/cart-item';
import { ProductService } from 'src/app/services/product.service';
import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/common/product';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent implements OnInit {

  product: Product = new Product();
  productId!: number;
  errorMessage!: string;

  constructor(
    private productService: ProductService, 
    private route: ActivatedRoute, 
    private cartService: CartService
    ) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(() => {
      this.handleProductDetails();
    });
  }

  handleProductDetails() {
    this.route.params.subscribe(param => {this.productId = param['id']})
    this.productService.getProductDetails(this.productId).subscribe(
      product => this.product = product,
      error => this.errorMessage = error
    );
  }

  addToCart() {
    const theCartItem = new CartItem(this.product);
    this.cartService.addToCart(theCartItem);
  }
}
