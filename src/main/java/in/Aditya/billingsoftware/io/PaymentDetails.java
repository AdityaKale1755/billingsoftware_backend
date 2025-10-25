package in.Aditya.billingsoftware.io;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDetails {

    private String razorpayOrderId;
    private String razorpayPaymentId;
    private String razorpaySignature;
    private PaymentStatus status;
    public enum PaymentStatus{
        PENDING,COMPLETED,FAILED
    }
}
