package in.Aditya.billingsoftware.io;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class UserRequest {

    private String name;
    private String email;
    private String password;
    private String role;
}
