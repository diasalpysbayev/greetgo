import {Component, OnInit} from '@angular/core'
import {Student} from './student'
import {StudentService} from './student.service'

@Component({
    selector: 'app-student',
    templateUrl: './student.component.html',
    styleUrls: ['./student.component.scss']
})

export class StudentComponent implements OnInit{
    students: Student[] = []
    student = new Student()
    
    showErrorMessage = false

    constructor(private _studentService: StudentService){
        this.students = [];
    }
    
    ngOnInit(): void{
        this.getStudents();
    }
 
    getStudents(): void{
        this._studentService.getAllStudents()
            .subscribe(result => {
                const me = Object.create(result)
                this.students = me;
                console.log(this.students);
            },(error) =>{
                console.log(error);
            }
        );
    }

    addStudent(): void{
        this._studentService.addStudent(this.student)
        .subscribe(
            (response) => {
                console.log(response)
                this.getStudents()
            },
            (error) => {
                console.log(error)
            }
        );
    }

    checkField(): void{
        if(this.student.isValid()) {
            this.addStudent()
            this.showErrorMessage = false
        }
        else {
            this.showErrorMessage = true
        }
    }

    clearField(): void {
        this.student.name = ''
        this.student.surname = ''
        this.student.subject = ''
        this.student.grade = ''
    }

    deleteStudent(studentId: string){
        
        let res = this._studentService.deleteStudent(studentId)
        res.subscribe(
            (next) => {
                this.getStudents();
                console.log("next")
                console.log(next)
            },
            (error) => {
                console.log("error")
                console.log(error)
            }
        )
    }
}