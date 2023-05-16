import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-logo-argentina',
  templateUrl: './logo-argentina.component.html',
  styleUrls: ['./logo-argentina.component.css']
})
export class LogoArgentinaComponent implements OnInit{
constructor(private router:Router){ }

    ngOnInit(): void {
      
    }

    login(){
      this.router.navigate(['/login'])
    }


}
