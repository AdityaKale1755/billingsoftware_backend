package in.Aditya.billingsoftware.repository;

import in.Aditya.billingsoftware.Entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemEntityRepository extends JpaRepository<OrderItemEntity,Long> {

}
