package com.app.service;


import com.app.dto.FinishPurchaseRequest;

public interface PurchaseService {

    Long finishPurchase(FinishPurchaseRequest request);
}
