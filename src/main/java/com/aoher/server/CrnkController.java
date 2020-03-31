package com.aoher.server;

import io.crnk.core.engine.registry.ResourceRegistry;
import io.crnk.spring.boot.v3.CrnkConfigV3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.stream.Collectors;

@RestController
@Import({CrnkConfigV3.class})
public class CrnkController {

    @Autowired
    private ResourceRegistry resourceRegistry;

    @GetMapping("/resources-info")
    public Map<String, String> getResources() {
        return resourceRegistry.getResources().stream()
                .collect(Collectors.toMap(
                        r -> r.getRepositoryInformation().getResource().getResourceType(),
                        r -> resourceRegistry.getResourceUrl(r.getResourceInformation()),
                        (a, b) -> b));
    }
}
