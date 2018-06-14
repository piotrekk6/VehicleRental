import { Component, OnInit } from '@angular/core';
import {authService} from "../auth/auth.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private authService: authService) { }

  ngOnInit() {
  }

  isLoggedIn(): boolean {
    return this.authService.isAuthenticated();
  }

  onLogout() {
    this.authService.logout();
  }
}
