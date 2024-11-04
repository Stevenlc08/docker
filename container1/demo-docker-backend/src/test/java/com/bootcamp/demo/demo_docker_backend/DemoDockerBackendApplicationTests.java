package com.bootcamp.demo.demo_docker_backend;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@EnabledIfEnvironmentVariable(named = "env", matches = "production")
class DemoDockerBackendApplicationTests {

	@Test
	void contextLoads() {
	}

}
