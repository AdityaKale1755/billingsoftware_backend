package in.Aditya.billingsoftware.service;

import com.razorpay.RazorpayException;
import in.Aditya.billingsoftware.io.RazorpayOrderResponse;

public interface RazorpayService {

    RazorpayOrderResponse createOrder(Double amount,String currency) throws RazorpayException;
}
