import { Component } from '@angular/core';

import { BreadcrumbModule } from 'primeng/breadcrumb';
import { MenuItem } from 'primeng/api';
import { Router } from '@angular/router';


@Component({
  selector: 'app-main-dashboard',
  templateUrl: './main-dashboard.component.html',
  styleUrls: ['./main-dashboard.component.css']
})
export class MainDashboardComponent {

  sections: any[] = [
    {
      "name": "Administrador de usuarios",
      "Image": "url",
      "redirectTo": "management-users"
    }
  ];

  
	public items!: MenuItem[];

  constructor(private router: Router) { }

  ngOnInit() {
    this.items = [
			{ label: 'Home', url: '/' }
		]; 
  }


  moveToUser(section: any) {
    this.router.navigate([`/${section.redirectTo}`], { replaceUrl: true })
  }

}
