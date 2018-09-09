import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'rb-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css']
})
export class ReportComponent implements OnInit {

  reportData: string;

  constructor(private route: ActivatedRoute) { }

  ngOnInit() {
    this.reportData = this.route.snapshot.data['reportData'];
    window.open(URL.createObjectURL(this.reportData), 'reportIframe');
  }
}
