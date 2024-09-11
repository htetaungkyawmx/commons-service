package org.cafe.commons.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cafe.commons.shared.Location;
import org.cafe.commons.shared.Status;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Enumerated(EnumType.STRING)
    private Location location;
    @Enumerated(EnumType.STRING)
    private Status status;
    @CreationTimestamp
    private LocalDateTime processedAt;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<LineItemEntity> lineItems = new ArrayList<>();

    public OrderEntity(Location location, Status status, LocalDateTime processedAt) {
        this.location = location;
        this.status = status;
        this.processedAt = processedAt;
    }

    //Helper Method to add line items
    public void addLineItem(LineItemEntity lineItem) {
        lineItems.add(lineItem);
        lineItem.setOrder(this);
    }
}
