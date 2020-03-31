package com.aoher.server;

import com.aoher.client.GreetingClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CrnkControllerTest {

    @Autowired
    private GreetingClient greetingClient;

    @Test
    public void testFindOne() {
        assertEquals("Hello World!", greetingClient.findOne(1L).getContent());
    }
}