package org.cafe.commons.entity;

import jakarta.persistence.*;
import lombok.*;
import org.cafe.commons.shared.Status;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Enumerated(EnumType.STRING)
    private Status status;
    private BigDecimal amount;
    @CreationTimestamp
    private LocalDateTime processedAt;
    @OneToOne
    private OrderEntity order;

    public PaymentEntity(Status status, BigDecimal amount, LocalDateTime processedAt) {
        this.status = status;
        this.amount = amount;
        this.processedAt = processedAt;
    }
}
