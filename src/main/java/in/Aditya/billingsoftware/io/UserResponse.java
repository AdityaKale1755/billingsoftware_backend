package in.Aditya.billingsoftware.io;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class UserResponse {

    private String userId;
    private String name;
    private String email;
//    private String password;
    private Timestamp createdAt;
    private Timestamp updateAt;
    private String role;
}
