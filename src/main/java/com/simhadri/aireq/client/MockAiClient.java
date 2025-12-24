package com.simhadri.aireq.client;

import com.simhadri.aireq.dto.request.IdeaRequest;
import com.simhadri.aireq.entity.RequirementDocument;
import org.springframework.stereotype.Component;

@Component
public class MockAiClient implements AiClient {

    @Override
    public RequirementDocument generate(IdeaRequest request) {
        return RequirementDocument.builder()
                .projectName(request.getProjectName())
                .summary("AI generated summary for " + request.getProjectName())
                .domain("Software")
                .primaryActor("End User")
                .functionalRequirements("User can submit idea\nSystem generates requirements")
                .nonFunctionalRequirements("Scalable, Secure")
                .userStories("As a user, I want requirements generated")
                .constraints(request.getConstraints())
                .assumptions("User provides clear idea")
                .risks("Ambiguous requirements")
                .acceptanceCriteria("Requirements generated successfully")
                .build();
    }
}
