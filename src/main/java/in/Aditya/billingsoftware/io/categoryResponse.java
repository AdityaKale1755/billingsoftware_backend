package in.Aditya.billingsoftware.io;


import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Builder
@Data
public class categoryResponse {


    private String categoryId;
    private String name;
    private String description;
    private String bgColor;
    private String imageUrl;
    private Timestamp createdAt;
    private Timestamp updateAt;
    private Integer items;
}
