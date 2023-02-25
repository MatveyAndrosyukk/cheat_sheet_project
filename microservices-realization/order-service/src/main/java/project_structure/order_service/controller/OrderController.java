package project_structure.order_service.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import project_structure.order_service.dto.RequestOrder;
import project_structure.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CircuitBreaker(name = "inventory", fallbackMethod = "fallBackHandleSaveOrderMethod")
    @TimeLimiter(name = "inventory")
    @Retry(name = "inventory")
    public CompletableFuture<String> handleSaveOrder(@RequestBody RequestOrder requestOrder){
        String response = orderService.placeOrder(requestOrder);
        return CompletableFuture.supplyAsync(() -> response);
    }

    public CompletableFuture<String> fallBackHandleSaveOrderMethod(RequestOrder requestOrder, RuntimeException exception){
        String response = "Ooops! Something went wrong, please order after some time!";
        return CompletableFuture.supplyAsync(() -> response);
    }
}
