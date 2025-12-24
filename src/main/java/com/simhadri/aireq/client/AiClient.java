package com.simhadri.aireq.client;

import com.simhadri.aireq.dto.request.IdeaRequest;
import com.simhadri.aireq.entity.RequirementDocument;

public interface AiClient {
    RequirementDocument generate(IdeaRequest request);
}
