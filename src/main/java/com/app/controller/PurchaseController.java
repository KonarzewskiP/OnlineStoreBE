package com.app.controller;


import com.app.dto.FinishPurchaseRequest;
import com.app.dto.FinishPurchaseResponse;
import com.app.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/purchases")
public class PurchaseController {

    private final PurchaseService purchaseService;

    @PostMapping("/finishPurchase")
    public ResponseEntity finishedPurchase(@Validated @RequestBody FinishPurchaseRequest request) {
        log.info("Handling finish purchase request: {}", request);
        Long orderId = purchaseService.finishPurchase(request);
        return ResponseEntity.ok(new FinishPurchaseResponse(orderId));
    }

}
