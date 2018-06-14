import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {authService} from "../auth/auth.service";
import {User} from "../models/User";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user: User;

  constructor(private router: Router, private authService: authService) {
  }

  ngOnInit() {
    this.user = new User();
  }

  register() {
    if (this.user.username && this.user.password) {
      this.authService.register(this.user).subscribe();
    }
  }
}
