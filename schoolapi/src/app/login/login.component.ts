import {Component, OnInit} from '@angular/core'
import {User} from './login'
import {Router} from '@angular/router'
import {LoginService} from './login.service'

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.scss']
})

export class LoginComponent implements OnInit{

    constructor(
        private _loginService: LoginService,
        private router: Router,
    ) { }

    login = new User()

    username = this.login.username
    password = this.login.password

    showErrorMessage = false
    
    ngOnInit(): void {}

    checkLogin(login: User): void{
        this._loginService.checkLogin(this.login)
        .subscribe(
            (response) => {
                this.router.navigate(['/students'])
                console.log(response)
            },
            (error) => {
                this.showErrorMessage = true
                console.log('error')
                console.log(error)
            }
        );
    }

    clearField(): void {
        this.login.username = ''
        this.login.password = ''
    }
}