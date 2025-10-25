package in.Aditya.billingsoftware.service;

import in.Aditya.billingsoftware.io.UserRequest;
import in.Aditya.billingsoftware.io.UserResponse;

import java.util.List;

public interface UserService {

   UserResponse createUser(UserRequest userRequest);

   String getUserRole(String email);

   List<UserResponse> readUser();

   void deleteUser(String id);
}
