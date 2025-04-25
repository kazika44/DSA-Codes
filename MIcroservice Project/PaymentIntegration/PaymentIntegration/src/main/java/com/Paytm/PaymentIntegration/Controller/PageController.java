package com.Paytm.PaymentIntegration.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
@RequestMapping("/")
    public String homepage()
    {
        System.out.println("HomePage Running");
        return "Home";
    }
}
