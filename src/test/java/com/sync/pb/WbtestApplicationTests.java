package com.sync.pb;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.sync.pb.service.FourSquareFindRecommendedPlacesService;

/**
 * Integration test for {@link Application} starting on a random port.
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

public class WbtestApplicationTests {


	@Autowired
	private TestRestTemplate restTemplate;

	@MockBean
	private FourSquareFindRecommendedPlacesService findRecommendedPlacesService;

	@Before
	public void setup() {

	}

	@Test
	public void testLondon() {
		ResponseEntity<String> response = this.restTemplate
				.getForEntity("/venues/recommended/{poi}", String.class, "London");
		assertThat(response.getStatusCode().equals(HttpStatus.OK));

//		assertThat(response.getBody()).contains("London");
	}
	
	@Test
	public void testSF() {
		ResponseEntity<String> response = this.restTemplate
				.getForEntity("/venues/recommended/{poi}", String.class, "San Fransisco");
		assertThat(response.getStatusCode().equals(HttpStatus.OK));
//		assertThat(response.getBody()).contains("San Fransisco");
	}

}
