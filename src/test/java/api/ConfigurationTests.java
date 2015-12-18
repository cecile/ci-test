package api;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.jayway.jsonpath.JsonPath;
import java.util.ArrayList;

/**
 * Basic integration tests for service.
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port=0")
@DirtiesContext
public class ConfigurationTests {

	@Value("${local.server.port}")
	private int port;

	@Test
	public void testStatus() throws Exception {

		ResponseEntity<String> entity = new TestRestTemplate().getForEntity(
				"http://localhost:" + this.port + "/health", String.class);

		assertEquals(HttpStatus.OK, entity.getStatusCode());
		assertEquals("UP",JsonPath.read(entity.getBody(), "$.status"));
	}

	@Test
	public void testHome() throws Exception {

		ResponseEntity<String>  entity = new TestRestTemplate().getForEntity(
				"http://localhost:" + this.port + "/", String.class);

		assertEquals(HttpStatus.OK, entity.getStatusCode());
		assertEquals("home",JsonPath.read(entity.getBody(), "$.message"));

	}

	@Test
	public void testRANDOM() throws Exception {

		final int numbers = 5;

		ResponseEntity<String>  entity = new TestRestTemplate().getForEntity(
				"http://localhost:" + this.port + "/random/5", String.class);

		assertEquals(HttpStatus.OK, entity.getStatusCode());

		assertNotNull(JsonPath.read(entity.getBody(), "$.numbers"));

		for(int i=0;i<numbers;i++){
			assertNotNull(JsonPath.read(entity.getBody(), "$.numbers.["+Integer.toString(i)+"]"));
		}


	}

}
