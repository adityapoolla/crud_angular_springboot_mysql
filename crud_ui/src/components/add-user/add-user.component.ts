import { Component } from '@angular/core';
import { ReactiveFormsModule, FormGroup, FormControl } from '@angular/forms';
import { UsersService } from '../../app/service/user.service';

@Component({
  selector: 'app-add-user',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './add-user.component.html',
  styleUrl: './add-user.component.css',
})
export class AddUserComponent {
  userForm = new FormGroup({
    firstName: new FormControl(''),
    lastName: new FormControl(''),
    emailId: new FormControl(''),
    phoneNumber: new FormControl(''),
  });

  constructor(private usersService: UsersService) {}

  handleSubmit(): void {
    this.usersService
      .saveUser({
        firstName: this.userForm.value.firstName!,
        lastName: this.userForm.value.lastName!,
        emailId: this.userForm.value.emailId!,
        id: 0,
      })
      .subscribe((data) => {
        console.log(data);
      });
  }
}
