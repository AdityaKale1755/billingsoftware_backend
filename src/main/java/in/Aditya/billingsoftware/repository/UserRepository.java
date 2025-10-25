package in.Aditya.billingsoftware.repository;

import in.Aditya.billingsoftware.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {

    Optional<UserEntity>findByEmail(String email);

    Optional<UserEntity>findByUserId(String userId);
}
