export class Student {
    id!: string
    name!: string
    surname!: string
    subject!: string
    grade!: string

    constructor(){}

    isValid(): boolean {
        return this.surname != '' &&
               this.name != '' &&
               this.subject != '' &&
               this.grade != ''
    }

}