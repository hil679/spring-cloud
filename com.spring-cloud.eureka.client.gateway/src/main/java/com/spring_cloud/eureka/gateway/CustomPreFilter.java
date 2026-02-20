package com.spring_cloud.eureka.gateway;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.logging.Logger;

@Component // 주의 등록안하면 사용 불가
public class CustomPreFilter implements GlobalFilter, Ordered {
    private final Logger logger = Logger.getLogger(CustomPreFilter.class.getName());


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest httpRequest = exchange.getRequest();
        logger.info("PRE FILTER: "+httpRequest.getURI());
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE; // pre -> 우선순위 최상위로 둘 예정
    }
}
