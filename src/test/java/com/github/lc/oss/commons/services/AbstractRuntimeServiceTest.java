package com.github.lc.oss.commons.services;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.github.lc.oss.commons.testing.AbstractTest;

public class AbstractRuntimeServiceTest extends AbstractTest {
    private static class TestService extends AbstractRuntimeService {

    }

    @Test
    public void test_exec_java() {
        AbstractRuntimeService service = new TestService();

        boolean result = service.exec(null, "java", "-version");
        Assertions.assertTrue(result);
    }

    @Test
    public void test_exec_exception() {
        AbstractRuntimeService service = new TestService();

        Map<String, String> env = new HashMap<>();
        env.put("ARG", "value");
        boolean result = service.exec(env, "junk-boom!");
        Assertions.assertFalse(result);
    }
}
