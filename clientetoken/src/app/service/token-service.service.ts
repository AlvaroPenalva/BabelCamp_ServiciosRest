import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CredentialDto } from 'src/model/CredentialDto';
import { Student } from 'src/model/Student';
@Injectable({
  providedIn: 'root'
})
export class TokenServiceService {

  urlBase:string="http://localhost:8000/crud";
  token:string ="";
  user:string="admin";
  pwd:string="admin";
  constructor(private http: HttpClient) { }

  getToken(){
    let dto:CredentialDto = new CredentialDto();
    dto.pwd=this.pwd;
    dto.user=this.user;
    this.http.post<string>(this.urlBase +"/login", dto).subscribe(tk=>this.token = tk);
  }

  getStudentId(idAlumno:number){
    if(this.token == null || this.token == "") this.getToken;

    let heads:HttpHeaders = new HttpHeaders();
    heads.append("Authorization", "Bearer " + this.token);
    return this.http.get<Student[]>(this.urlBase+ "Alumno" + idAlumno, {headers:heads});
  }

  getStudents(){
    if(this.token == null || this.token == "") this.getToken;
    let heads:HttpHeaders = new HttpHeaders();
    heads.append("Authorization", "Bearer " + this.token);
    return this.http.get<Student[]>(this.urlBase+ "Alumnos", {headers:heads});
  }

}
