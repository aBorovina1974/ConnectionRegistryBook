import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/primeng';

@Component({
  selector: 'rb-main-menu',
  templateUrl: './main-menu.component.html',
  styleUrls: ['./main-menu.component.css']
})
export class MainMenuComponent implements OnInit {

  items: MenuItem[];

  constructor() { }

  ngOnInit() {
    this.items = [
      {
        label: 'Pregled',
        items: [
          { label: 'Priključci', routerLink: ['/review/connections'] },
          { label: 'Zahtjevi' , routerLink: ['/review/requests'] },
          { label: 'Rješenja' },
        ]
      },
      {
        label: 'Zahtjev',
        items: [
          { label: 'Novi priključak',  routerLink: ['/new'] },
          { label: 'Promjena vlasništva' },
          { label: 'Izmještaj' },
        ]
      },
      {
        label: 'Rješenje',
        items: [
          { label: 'Novi priključak' },
          { label: 'Promjena vlasništva' },
          { label: 'Izmještaj' },
        ]
      },
      { label: 'Ugovor' }
    ];
  }
}
