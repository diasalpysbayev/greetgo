import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StudentComponent } from './student/student.component';
import { HttpClientModule } from '@angular/common/http';
import { StudentService } from './student/student.service';
import { LoginComponent } from './login/login.component'
import { LoginService } from './login/login.service'
import { CommonModule } from '@angular/common'

@NgModule({
  declarations: [
    AppComponent, 
    StudentComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    CommonModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    StudentService,
    LoginService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
