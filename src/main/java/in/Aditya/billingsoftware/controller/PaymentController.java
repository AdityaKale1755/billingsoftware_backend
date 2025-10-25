package in.Aditya.billingsoftware.controller;

import com.razorpay.RazorpayException;
import in.Aditya.billingsoftware.io.OrderResponse;
import in.Aditya.billingsoftware.io.PaymentRequest;
import in.Aditya.billingsoftware.io.PaymentVerificationRequest;
import in.Aditya.billingsoftware.io.RazorpayOrderResponse;
import in.Aditya.billingsoftware.service.OrderService;
import in.Aditya.billingsoftware.service.RazorpayService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payments")
public class PaymentController {

    private final RazorpayService razorpayService;
    private final OrderService orderService;

    @PostMapping("/create-order")
    @ResponseStatus(HttpStatus.CREATED)
    public RazorpayOrderResponse createRazorpayOrder(@RequestBody PaymentRequest request) throws RazorpayException {
        return razorpayService.createOrder(request.getAmount(),request.getCurrency());
    }

    @PostMapping("/verify")
    public OrderResponse verifyPayment(@RequestBody PaymentVerificationRequest request){

        return orderService.verifyPayment(request);
    }

}
