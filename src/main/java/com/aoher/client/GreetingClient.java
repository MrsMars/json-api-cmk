package com.aoher.client;

import com.aoher.domain.model.Greeting;
import io.crnk.client.CrnkClient;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryV2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class GreetingClient {

    private static final Logger log = LoggerFactory.getLogger(GreetingClient.class);

    private static final String NAMESPACE_URI = "http://localhost:9090/aoher/api";

    private CrnkClient crnkClient = new CrnkClient(NAMESPACE_URI);
    private ResourceRepositoryV2<Greeting, Long> resourceRepositoryV2;

    @PostConstruct
    public void init() {
        resourceRepositoryV2 = crnkClient.getRepositoryForType(Greeting.class);
    }

    public Greeting findOne(long id) {
        Greeting result = resourceRepositoryV2.findOne(id, new QuerySpec(Greeting.class));

        log.info("found {}", result.toString());
        return result;
    }
}
