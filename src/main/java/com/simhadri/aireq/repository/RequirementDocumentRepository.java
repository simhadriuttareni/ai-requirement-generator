package com.simhadri.aireq.repository;

import com.simhadri.aireq.entity.RequirementDocument;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RequirementDocumentRepository
        extends JpaRepository<RequirementDocument, UUID> {
}
