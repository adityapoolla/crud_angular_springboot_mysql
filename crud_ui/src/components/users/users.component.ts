import { Component } from '@angular/core';
import { User } from '../../app/common/models/user.model';
import { UsersService } from '../../app/service/user.service';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-users',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './users.component.html',
  styleUrl: './users.component.css',
})
export class UsersComponent {
  users: User[] | undefined;
  constructor(private userService: UsersService) {
    this.userService = userService;
  }
  ngOnInit(): void {
    this.userService.getAllUsers().subscribe((users) => (this.users = users));
  }
}
