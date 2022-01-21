package com.homework3;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class BaseIntegrationTest {
	
	@LocalServerPort
	protected int serverPort;
	
	@Autowired
	protected TestRestTemplate testRestTemplate;
	
	@Test
	public void contextLoads() {
		
	}
}
