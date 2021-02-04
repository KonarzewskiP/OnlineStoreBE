package com.app.repository;

import com.app.entity.PurchaseItem;
import com.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseItemRepository extends JpaRepository<PurchaseItem, Long> {
}
