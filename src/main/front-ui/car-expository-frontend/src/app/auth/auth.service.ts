import {HttpClient} from "@angular/common/http";
import {User} from "../models/User";
import {Injectable} from "@angular/core";
import 'rxjs/Rx';
import {tokenNotExpired} from "angular2-jwt";

@Injectable()
export class authService {

  private loginUrl = "/api/users/login/generate-token";
  private registerUrl = "/api/users/register";
  public isLoggedIn: boolean;

  constructor(private http: HttpClient) {
  }

  login(user: User) {
    return this.http.post<User>(this.loginUrl, user).shareReplay();
  }

  logout()
  {
    localStorage.removeItem('token');
    this.isLoggedIn = this.isAuthenticated();
    location.reload();
  }

  static getTokenFromLocalStorage(): string {
    return localStorage.getItem('token');
  }

  public isAuthenticated(): boolean {
    // get the token
    const token = authService.getTokenFromLocalStorage();
    // return a boolean reflecting
    // whether or not the token is expired
    return tokenNotExpired(null, token);
  }

  register(user: User)
  {
    return this.http.post<User>(this.registerUrl, user).shareReplay();
  }
}
