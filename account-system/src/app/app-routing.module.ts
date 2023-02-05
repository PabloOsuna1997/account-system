import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccountDashboardComponent } from './pages/account-dashboard/account-dashboard.component';
import { MainDashboardComponent } from './pages/main-dashboard/main-dashboard.component';
import { UserManagementComponent } from './pages/user-management/user-management.component';
import { ChecksComponent } from './pages/checks/checks.component';

const routes: Routes = [
  { path: '', redirectTo: '/main', pathMatch: 'full' },
  { path: 'main', component: MainDashboardComponent },
  { path: 'management-users', component: UserManagementComponent },
  { path: 'management-account/:userId', component: AccountDashboardComponent },
  { path: 'management-checks/:userId/:accountId', component: ChecksComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
