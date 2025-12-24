package com.simhadri.aireq.service;

import com.simhadri.aireq.dto.request.IdeaRequest;
import com.simhadri.aireq.dto.response.PagedResponse;
import com.simhadri.aireq.dto.response.RequirementResponse;

import java.util.UUID;

public interface RequirementGenerationService {

    RequirementResponse generate(IdeaRequest request);

    RequirementResponse getById(UUID id);

    PagedResponse<RequirementResponse> getAll(int page, int size);
}
