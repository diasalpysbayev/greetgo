import {HttpClient, HttpResponse, HttpRequest, HttpHeaders, HttpErrorResponse} from '@angular/common/http'
import {Injectable} from '@angular/core'
import {Observable, throwError} from 'rxjs'
import {map} from 'rxjs/operators'
import {catchError} from 'rxjs/operators'

@Injectable()
export class StudentService{
    
    constructor(private _httpService: HttpClient){}

    getAllStudents(): Observable<Object>{
        const url = 'http://localhost:8080/api/students'
        return this._httpService.get(url)
        .pipe(
            map(res => {
                return res;
            },
            catchError(this.handleError)
        )
        )
    }
    
    addStudent(student: Object) {
        let body : {} = JSON.stringify(student)
        const url = 'http://localhost:8080/api/students'
        const options: {} = {headers: {'Content-Type' : 'application/json'}, responseType: 'text'}
        return this._httpService.post(url, body, options)
    }

    deleteStudent(studentId: string) {
        const url = "http://localhost:8080/api/students/" + studentId
        return this._httpService.delete(url, {responseType: 'text'})
        .pipe(
            map(
                res => {
                    console.log(res)
                },
                (err: any) => console.log(err) 
            )
        )
    }

    private handleError(error: Observable<Object>){
        return throwError(error);
    }
}