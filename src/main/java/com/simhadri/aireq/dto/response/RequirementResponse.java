package com.simhadri.aireq.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class RequirementResponse {

    private UUID id;
    private String projectName;
    private String summary;
    private String domain;
    private String primaryActor;

    private String functionalRequirements;
    private String nonFunctionalRequirements;
    private String userStories;
    private String constraints;
    private String assumptions;
    private String risks;
    private String acceptanceCriteria;
}
