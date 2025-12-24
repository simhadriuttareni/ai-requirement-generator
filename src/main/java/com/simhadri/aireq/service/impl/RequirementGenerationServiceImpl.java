package com.simhadri.aireq.service.impl;

import com.simhadri.aireq.client.AiClient;
import com.simhadri.aireq.dto.request.IdeaRequest;
import com.simhadri.aireq.dto.response.PagedResponse;
import com.simhadri.aireq.dto.response.RequirementResponse;
import com.simhadri.aireq.entity.RequirementDocument;
import com.simhadri.aireq.exception.NotFoundException;
import com.simhadri.aireq.repository.RequirementDocumentRepository;
import com.simhadri.aireq.service.RequirementGenerationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RequirementGenerationServiceImpl
        implements RequirementGenerationService {

    private final AiClient aiClient;
    private final RequirementDocumentRepository repository;

    @Override
    public RequirementResponse generate(IdeaRequest request) {
        RequirementDocument doc = aiClient.generate(request);
        RequirementDocument saved = repository.save(doc);
        return map(saved);
    }

    @Override
    public RequirementResponse getById(UUID id) {
        RequirementDocument doc = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Requirement not found"));
        return map(doc);
    }

    @Override
    public PagedResponse<RequirementResponse> getAll(int page, int size) {
        Page<RequirementDocument> result =
                repository.findAll(PageRequest.of(page, size));

        return PagedResponse.<RequirementResponse>builder()
                .content(result.map(this::map).getContent())
                .page(page)
                .size(size)
                .totalElements(result.getTotalElements())
                .totalPages(result.getTotalPages())
                .build();
    }

    private RequirementResponse map(RequirementDocument d) {
        return RequirementResponse.builder()
                .id(d.getId())
                .projectName(d.getProjectName())
                .summary(d.getSummary())
                .domain(d.getDomain())
                .primaryActor(d.getPrimaryActor())
                .functionalRequirements(d.getFunctionalRequirements())
                .nonFunctionalRequirements(d.getNonFunctionalRequirements())
                .userStories(d.getUserStories())
                .constraints(d.getConstraints())
                .assumptions(d.getAssumptions())
                .risks(d.getRisks())
                .acceptanceCriteria(d.getAcceptanceCriteria())
                .build();
    }
}
