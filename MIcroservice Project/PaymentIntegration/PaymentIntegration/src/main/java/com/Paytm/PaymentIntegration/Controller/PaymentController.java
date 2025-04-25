package com.Paytm.PaymentIntegration.Controller;


import com.Paytm.PaymentIntegration.Config.AppConfig;
import com.paytm.pg.merchant.PaytmChecksum;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URL;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    Random random = new Random();
    String orderID = "Order:"+random.nextInt(1000000);

    @PostMapping("/start")
    public Map<String, Object> startPayment(@RequestBody Map<String, Object> data) {
        JSONObject paytmParams = new JSONObject();

        JSONObject body = new JSONObject();
        body.put("requestType","Payment");
        body.put("mid",AppConfig.MID);
        body.put("websiteName",AppConfig.WEBSITE);
        body.put("orderId",orderID);
        body.put("callbackUrl","https://localhost:8086/payment-success");

        JSONObject txnAmount = new JSONObject();
        txnAmount.put("value", data.get("amount"));
        txnAmount.put("currency", "INR");

        JSONObject userInfo = new JSONObject();
        userInfo.put("custId", "CUST_001");

        body.put("txnAmount", txnAmount);
        body.put("userInfo", userInfo);

        ResponseEntity<Map> response=null;

        try {
            String checksum = PaytmChecksum.generateSignature(body.toString(), AppConfig.MKEY);

            JSONObject head = new JSONObject();
            head.put("signature", checksum);

            paytmParams.put("body", body);
            paytmParams.put("head", head);

            String post_data = paytmParams.toString();

            /* for Staging */
            URL url = new URL("https://securegw-stage.paytm.in/theia/api/v1/initiateTransaction?mid="+AppConfig.MID+"&orderId="+orderID+"");

            HttpHeaders headers=new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Map<String,Object>> httpEntity=new HttpEntity<>(paytmParams.toMap(),headers);
            RestTemplate restTemplate=new RestTemplate();
            response=restTemplate.postForEntity(url.toString(),httpEntity,Map.class);
        } catch (Exception exception) {
             exception.printStackTrace();
        }
        Map<String,Object> responseBody=response.getBody();
        responseBody.put("OrderID",orderID);
        responseBody.put("Amount",txnAmount.get("value"));
        return responseBody;
    }

}
