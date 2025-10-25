package in.Aditya.billingsoftware.repository;

import in.Aditya.billingsoftware.Entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity,Long> {

    Optional<ItemEntity> findByItemId(String id);

   // Integer countByCategory(Long id);
   Integer countByCategory_Id(Long id); // ✅ Correct



}
