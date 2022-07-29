import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private apiServerUrl = "http://localhost:8080";
  
  constructor(private http: HttpClient) { }
  
  getEmployees(): Observable<Employee[]>{
    return this.http.get<Employee[]>(this.apiServerUrl + "/employee/all")
  }

  getEmployeeByid(id:number): Observable<Employee>{
    return this.http.get<Employee>(this.apiServerUrl + "/employee/find/"+id)
  }

  addEmployee(employee: Employee): Observable<Employee>{
  
    return this.http.post<Employee>(this.apiServerUrl + "/employee/add",employee)
  }

  updateEmployee(employee: Employee): Observable<Employee>{
    return this.http.put<Employee>(this.apiServerUrl + "/employee/update", employee)
  }
  deleteEmployeeById(id:number): Observable<void>{
    return this.http.delete<void>(this.apiServerUrl + "/employee/delete/"+ id)
  }
}


