package com.app.service;

import com.app.dto.FinishPurchaseRequest;
import com.app.entity.Order;
import com.app.entity.Product;
import com.app.entity.PurchaseItem;
import com.app.repository.OrderRepository;
import com.app.repository.PurchaseItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class PurchaseServiceImpl implements PurchaseService {

    private final ProductService productService;
    private final UserService userService;
    private final OrderRepository orderRepository;
    private final PurchaseItemRepository purchaseItemRepository;

    @Override
    public Long finishPurchase(FinishPurchaseRequest request) {
        log.info("creating order entity from requestL: {}", request);
        Order order = new Order();
        order.setUser(userService.findOrCreateUser(
                request.getName(),
                request.getSurname(),
                request.getPhone(),
                request.getEmail(),
                request.getAddress()
        ));
        order.setComment(request.getComment());
        order = orderRepository.save(order);

        for (Map.Entry<Long, Integer> entry : request.getProductIdProductCount().entrySet()) {
            Long k = entry.getKey();
            Integer v = entry.getValue();
            Product product = productService.findById(k);
            PurchaseItem purchaseItem = new PurchaseItem();
            purchaseItem.setProduct(product);
            purchaseItem.setCount(v);
            purchaseItem.setOrderEntity(order);
            purchaseItemRepository.save(purchaseItem);
        }

        return order.getId();
    }
}
