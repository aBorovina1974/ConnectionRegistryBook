import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs';
import { ReportService } from './report.service';


@Injectable({
  providedIn: 'root'
})
export class ReportResolverService implements Resolve<Blob>{

  constructor(private reportService: ReportService) { }

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Blob> {
      return this.reportService.getNewConnectionReportBlob(route.params['id']);
    }


}
