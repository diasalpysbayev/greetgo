import {HttpClient, HttpResponse, HttpRequest, HttpHeaders, HttpErrorResponse} from '@angular/common/http'
import {Injectable} from '@angular/core'
import {Observable, throwError} from 'rxjs'
import { User } from './login'

@Injectable()
export class LoginService{
    constructor(private _httpService: HttpClient){}

    checkLogin(login: User){  
        console.log(login.password)       
        let body: {} = JSON.stringify(login);  
        const url = 'http://localhost:8080/login'
        const options: {} = {headers: {'Content-Type' : 'application/json'}, responseType: 'text'}
        return this._httpService.post(url, body, options)
    }
}