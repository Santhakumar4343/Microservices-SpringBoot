package com.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Set;

@Component
public class MyFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        ServerHttpRequest request=exchange.getRequest();
        HttpHeaders headers=request.getHeaders();
        Set<String> headerNames=headers.keySet();
        if(!headerNames.contains("Secret")){
            throw new RuntimeException("Secret header is missing");
        }
        List<String> secretHeader=headers.get("Secret");
        if(secretHeader==null || secretHeader.size()==0 || !secretHeader.get(0).equals("Santha@123")){
            throw new RuntimeException("Secret header is invalid");
        }
        return chain.filter(exchange);
    }
}
