import {HttpClient} from "@angular/common/http";
import {User} from "./User";
import {Injectable} from "@angular/core";
import 'rxjs/Rx';

@Injectable()
export class AuthService{

  private loginUrl = "/api/users/login/generate-token"

  constructor(private http: HttpClient){
  }

  login(user:User){
    return this.http.post<User>(this.loginUrl, user).shareReplay();
  }
}
