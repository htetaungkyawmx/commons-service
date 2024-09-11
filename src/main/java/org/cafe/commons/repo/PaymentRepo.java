package org.cafe.commons.repo;

import org.cafe.commons.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PaymentRepo extends JpaRepository<PaymentEntity, UUID> {
}
