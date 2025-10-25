package in.Aditya.billingsoftware.implementation;

import in.Aditya.billingsoftware.Entity.UserEntity;
import in.Aditya.billingsoftware.io.UserRequest;
import in.Aditya.billingsoftware.io.UserResponse;
import in.Aditya.billingsoftware.repository.UserRepository;
import in.Aditya.billingsoftware.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        UserEntity newUser = convertToEntity(userRequest);
        newUser=userRepository.save(newUser);
        return convertTOResponse(newUser);
    }

    private UserResponse convertTOResponse(UserEntity newUser) {
       return UserResponse.builder()
                .name(newUser.getName())
                .email(newUser.getEmail())
                .userId(newUser.getUserId())
                .createdAt(newUser.getCreatedAt())
                .updateAt(newUser.getUpdateAt())
                .role(newUser.getRole())
                .build();
    }

    private UserEntity convertToEntity(UserRequest userRequest) {
        return UserEntity.builder()
                .userId(UUID.randomUUID().toString())
                .email(userRequest.getEmail())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .role(userRequest.getRole().toUpperCase())
                .name(userRequest.getName())
                .build();
    }


    @Override
    public String getUserRole(String email) {
      UserEntity existingUser= userRepository.findByEmail(email)
               .orElseThrow(()-> new UsernameNotFoundException("User not Found for the email:"+email));
      return existingUser.getRole();
    }

    @Override
    public List<UserResponse> readUser() {
       return userRepository.findAll()
               .stream()
               .map(user->convertTOResponse(user))
               .collect(Collectors.toList());
    }

    @Override
    public void deleteUser(String id) {
        UserEntity existingUser=userRepository.findByUserId(id)
                .orElseThrow(()->new UsernameNotFoundException("User not Found") );
        userRepository.delete(existingUser);
    }
}
