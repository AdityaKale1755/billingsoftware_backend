package in.Aditya.billingsoftware.repository;

import in.Aditya.billingsoftware.Entity.categoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface categoryRepository extends JpaRepository<categoryEntity,Long> {

    Optional<categoryEntity>findByCategoryId(String categoryId);

//    Optional<categoryEntity> findByCategory_id(String category_id);
//
//
//   Optional<categoryEntity> findByCategoryId(String categoryId);
}
