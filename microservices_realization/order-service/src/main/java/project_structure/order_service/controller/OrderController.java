package project_structure.order_service.controller;

import project_structure.order_service.dto.RequestOrder;
import project_structure.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody RequestOrder requestOrder){
        orderService.placeOrder(requestOrder);
        return "Order placed successfully";
    }
}
