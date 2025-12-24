package com.simhadri.aireq.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "requirement_documents")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequirementDocument {

    @Id
    @GeneratedValue
    private UUID id;

    private String projectName;
    private String summary;
    private String domain;
    private String primaryActor;

    @Lob
    private String functionalRequirements;

    @Lob
    private String nonFunctionalRequirements;

    @Lob
    private String userStories;

    @Lob
    private String constraints;

    @Lob
    private String assumptions;

    @Lob
    private String risks;

    @Lob
    private String acceptanceCriteria;
}
