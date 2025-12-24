package com.simhadri.aireq.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class IdeaRequest {

    @NotBlank
    private String projectName;

    @NotBlank
    private String highLevelIdea;

    private String targetUsers;
    private String coreFeatures;
    private String constraints;
}
