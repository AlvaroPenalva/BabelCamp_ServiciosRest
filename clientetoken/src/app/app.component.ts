import { Component } from '@angular/core';
import { Student } from 'src/model/Student';
import { TokenServiceService } from './service/token-service.service';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(private service:TokenServiceService){}
  title='clientetoken';
  alumno!:Student;
  idAlumno!:number;
  buscarAlumno(){
    this.service.getStudentId(this.idAlumno).subscribe(s => this.alumno);
  }
}
