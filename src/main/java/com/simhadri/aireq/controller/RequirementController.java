package com.simhadri.aireq.controller;

import com.simhadri.aireq.dto.request.IdeaRequest;
import com.simhadri.aireq.dto.response.PagedResponse;
import com.simhadri.aireq.dto.response.RequirementResponse;
import com.simhadri.aireq.service.RequirementGenerationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/requirements")
@RequiredArgsConstructor
public class RequirementController {

    private final RequirementGenerationService service;

    @PostMapping("/generate")
    public ResponseEntity<RequirementResponse> generate(
            @Valid @RequestBody IdeaRequest request) {
        return ResponseEntity.ok(service.generate(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RequirementResponse> get(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<PagedResponse<RequirementResponse>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        return ResponseEntity.ok(service.getAll(page, size));
    }
}
