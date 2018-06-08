import {Component} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {authService} from "../auth/auth.service";
import {User} from "../models/User";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  form: FormGroup;
  user: User;
  token: string;
  isLoggedIn: boolean;


  constructor(private fb: FormBuilder,
              private authService: authService,
              private router: Router) {

    this.form = this.fb.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  ngOnInit() {
    this.user = new User();
    this.isLoggedIn = this.authService.isAuthenticated();
  }

  login() {
    const val = this.form.value;

    if (this.user.username && this.user.password) {
      this.authService.login(this.user)
        .subscribe(
          response => {
            this.token = response['token'];
            localStorage.setItem('token', this.token);
            console.log(this.token);
            const token2 = authService.getTokenFromLocalStorage();
            console.log(token2);
            this.router.navigateByUrl('/showAll');
          }
        );
    }
  }
}
