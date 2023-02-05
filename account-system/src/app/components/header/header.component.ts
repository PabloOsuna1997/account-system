import { Component } from '@angular/core';
import { MenuItem } from 'primeng/api';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {

  public items!: MenuItem[];

  ngOnInit() {
      this.items = [
          {label:'Home', url: '/'}
        ];
  }
  
}
