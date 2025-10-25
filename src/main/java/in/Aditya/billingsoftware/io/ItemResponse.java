package in.Aditya.billingsoftware.io;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemResponse {

    private String itemId;
    private String name;
    private String price;
    private String categoryId;
    private String description;
    private String categoryName;
    private String imgUrl;
    private Timestamp createdAt;
    private Timestamp updateAt;
}
