import { CartService } from './../../services/cart.service';
import { FormValidator } from './../../validators/form-validator';
import { State } from './../../common/state';
import { Country } from './../../common/country';
import { FormService } from './../../services/form.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {

  checkout!: FormGroup;

  totalPrice: number = 0.00; 
  totalQuantity: number = 0;

  creditCardYears: number[] = [];
  creditCardMonths: number[] = [];

  countries: Country[] = [];
  shippingAddressStates: State[] = [];
  billingAddressStates: State[] = [];

  constructor(private fb: FormBuilder, 
              private formService: FormService,
              private cartService: CartService) { }

  ngOnInit(): void {

    this.reviewCartDetails();

    this.checkout = this.fb.group({
      customer: this.fb.group({
        firstName: ['', [Validators.required, Validators.minLength(2), FormValidator.notOnlyWhitespace]],
        lastName: ['', [Validators.required, Validators.minLength(2), FormValidator.notOnlyWhitespace]],
        email: ['', [Validators.required, Validators.email]]
      }),
      shippingAddress: this.fb.group({
        street: ['', [Validators.required, Validators.minLength(2), FormValidator.notOnlyWhitespace]],
        city: ['', [Validators.required, Validators.minLength(2), FormValidator.notOnlyWhitespace]],
        state: ['', [Validators.required, FormValidator.notOnlyWhitespace]],
        country: ['', [Validators.required, FormValidator.notOnlyWhitespace]],
        zipCode: ['', [Validators.required, Validators.minLength(2), FormValidator.notOnlyWhitespace]]
      }),
      billingAddress: this.fb.group({
        street: ['', [Validators.required, Validators.minLength(2), FormValidator.notOnlyWhitespace]],
        city: ['', [Validators.required, Validators.minLength(2), FormValidator.notOnlyWhitespace]],
        state: ['', [Validators.required, FormValidator.notOnlyWhitespace]],
        country: ['', [Validators.required, FormValidator.notOnlyWhitespace]],
        zipCode: ['', [Validators.required, Validators.minLength(2), FormValidator.notOnlyWhitespace]]
      }),
      creditCard: this.fb.group({
        cardType: ['', [Validators.required]],
        nameOnCard: ['', [Validators.required, Validators.minLength(2), FormValidator.notOnlyWhitespace]],
        cardNumber: ['', [Validators.required, Validators.pattern('[0-9]{16}')]],
        securityCode: ['', [Validators.required, Validators.pattern('[0-9]{3}')]],
        expirationMonth: ['', [Validators.required, FormValidator.notOnlyWhitespace]],
        expirationYear: ['', [Validators.required, FormValidator.notOnlyWhitespace]]
      })   
    });

    // populate credit card months 
    const startMonth: number = new Date().getMonth() + 1;
    console.log("Start Month : " + startMonth);
    this.formService.getCreditCardMonths(startMonth).subscribe(
      months => this.creditCardMonths = months
    );

    // populate credit card years
    this.formService.getCreditCardYears().subscribe(
      years => this.creditCardYears = years
    ); 

    // populate countries
    this.formService.getCountries().subscribe(
      country => {
        this.countries = country;
      }
    );
  }

  onSubmit() {
    console.log("Handling Form Submission");

    if(this.checkout.invalid) {
      this.checkout.markAllAsTouched();
    }

    console.log(this.checkout.get('customer')?.value);
    const formGroup = this.checkout.get('shippingAddress');
    console.log("Shipping address details :- " + formGroup?.value.street + ", " + 
                formGroup?.value.city + ", " +  
                formGroup?.value.state + ", " + 
                formGroup?.value.country + ", " + 
                formGroup?.value.zipCode);
    const fg = this.checkout.get('billingAddress');
    console.log("Billing address details :- " + fg?.value.street + ", " + 
                fg?.value.city + ", " +  
                fg?.value.state + ", " + 
                fg?.value.country + ", " + 
                fg?.value.zipCode);
    console.log(this.checkout.get('creditCard')?.value);            
  }

  copyShippingAddressToBillingAddesss(event: any) {
    if(event.target.checked) {
      this.billingAddressStates = this.shippingAddressStates;
      this.checkout.controls.billingAddress.setValue(this.checkout.controls.shippingAddress.value);
      this.checkout.get('billingAddress.state')?.setValue(this.checkout.get('shippingAddress.state')?.value);
    }
    else {
      this.checkout.controls.billingAddress.reset();
      this.billingAddressStates = [];
    }
  }

  handleMonthsAndYears() {
    const creditCardFormGroup = this.checkout.get('creditCard');
    const currentYear: number = new Date().getFullYear();
    const selectedYear: number = Number(creditCardFormGroup?.value.expirationYear);
    let startMonth: number;

    if(currentYear == selectedYear) {
      startMonth = new Date().getMonth() + 1;
    }
    else {
      startMonth = 1;
    }
    this.formService.getCreditCardMonths(startMonth).subscribe(
      months => this.creditCardMonths = months
    );
  }

  getStates(formGroupName: string) {
    const formGroup = this.checkout.get(formGroupName);
    const countryName = formGroup?.value.country;

    this.formService.getStates(countryName).subscribe(
      data => {
        if(formGroupName == 'shippingAddress') {
          this.shippingAddressStates = data;
        }
        else {
          this.billingAddressStates = data;
        }
      }
    );
  }

  reviewCartDetails() {
    // subscribe to cartService.totalQuantity
    this.cartService.totalQuantity.subscribe(
      quantity => this.totalQuantity = quantity
    );

    // subscribe to cartService.totalPrice
    this.cartService.totalPrice.subscribe(
      price => this.totalPrice = price
    );
  }
}