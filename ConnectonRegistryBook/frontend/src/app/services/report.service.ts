import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ReportService {
  
  constructor(private http: HttpClient) { }

  getNewConnectionReportBlob(resourceId: number): Observable<Blob> {
    return this.http.get(      
    `http://localhost:8080/ConnectionRegistryBook/report/new/connection/${resourceId}`,
    { responseType: 'blob' });
  }
}
