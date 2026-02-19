package com.spring_cloud.eureka.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final ProductClient productClient;

    private String getProductInfo(String productId) {
        return productClient.getProduct(productId);
    }

    public String getOrder(String orderId) {
        if (orderId.equals("1")) {
            String productId = "2";
            String productInfo = getProductInfo(productId);
            return productInfo;
        }

        return "err";
    }
}
