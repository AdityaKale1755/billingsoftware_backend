package in.Aditya.billingsoftware.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import java.sql.Timestamp;

@Entity
@Table(name = "category_table")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class categoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "categoryId", unique = true)
    private String categoryId;

    @Column(unique = true)
    private String name;
    private String description;
    private String bgColor;
    private String imageUrl;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updateAt;
}
