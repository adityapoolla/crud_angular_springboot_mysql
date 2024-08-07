import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../common/models/user.model';

const BASE_URL = 'http://localhost:8080/users';

@Injectable({
  providedIn: 'root',
})
export class UsersService {
  constructor(private httpClient: HttpClient) {
    this.httpClient = httpClient;
  }

  getAllUsers(): Observable<User[]> {
    return this.httpClient.get<User[]>(BASE_URL);
  }

  getUser(userId: number): Observable<User> {
    return this.httpClient.get<User>(BASE_URL + userId);
  }

  saveUser(user: User): Observable<User> {
    return this.httpClient.post<User>(BASE_URL, user);
  }
}
