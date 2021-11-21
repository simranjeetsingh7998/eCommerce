import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  keyword!: string;

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  searchProduct() {
    if(this.keyword) {
      this.router.navigateByUrl('/search/' + this.keyword);
    }
  }
}