package org.cafe.commons.repo;

import org.cafe.commons.entity.LineItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LineItemRepo extends JpaRepository<LineItemEntity, UUID> {
}
