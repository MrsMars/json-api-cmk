package com.aoher.domain.repository;

import com.aoher.domain.model.Greeting;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.resource.list.ResourceList;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class GreetingRepositoryImpl extends ResourceRepositoryBase<Greeting, Long> {

    private Map<Long, Greeting> greetings = new HashMap<>();

    public GreetingRepositoryImpl() {
        super(Greeting.class);

        greetings.put(1L, new Greeting(1L, "Hello World!"));
    }

    @Override
    public ResourceList<Greeting> findAll(QuerySpec querySpec) {
        return querySpec.apply(greetings.values());
    }
}
