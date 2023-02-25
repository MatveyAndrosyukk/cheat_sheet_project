package project_structure.order_service.service;

import org.springframework.kafka.core.KafkaTemplate;
import project_structure.order_service.dto.InventoryResponse;
import project_structure.order_service.dto.OrderLineItemsDto;
import project_structure.order_service.dto.RequestOrder;
import project_structure.order_service.event.OrderPlacedEvent;
import project_structure.order_service.model.Order;
import project_structure.order_service.model.OrderLineItems;
import project_structure.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;
    private final WebClient.Builder webClientBuilder;
    private final KafkaTemplate<String, OrderPlacedEvent> kafkaTemplate; // after adding kafka

    public String placeOrder(RequestOrder requestOrder) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = requestOrder.getOrderLineItemsDto()
                .stream()
                .map(this::mapToDto)
                .toList();

        order.setOrderLineItems(orderLineItems);

        List<String> skuCodes = order.getOrderLineItems().stream()
                .map(OrderLineItems::getSkuCode)
                .toList();

        InventoryResponse[] inventoryResponses = webClientBuilder.build()
                .get()                                             // before discovery server: http://localhost:port/api/inventory
                .uri("http://inventory-service/api/inventory", // after discovery server
                        uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();

        boolean allProductsInStock = false;
        if (inventoryResponses != null){
            allProductsInStock = Arrays.stream(inventoryResponses).allMatch(InventoryResponse::isInStock);
        }

        if (Boolean.TRUE.equals(allProductsInStock)){
            orderRepository.save(order);
            OrderPlacedEvent orderPlacedEvent = OrderPlacedEvent // after adding kafka
                    .builder()
                    .orderNumber(order.getOrderNumber())
                    .build();

            kafkaTemplate.send("notificationTopic", orderPlacedEvent); // after adding kafka
            return "Order placed successfully";
        }else {
            throw new RuntimeException("Product is not in stock, please try again later!");
        }
    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;
    }
}
