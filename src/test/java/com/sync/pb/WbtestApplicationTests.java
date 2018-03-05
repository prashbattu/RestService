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
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.sync.pb.domain.PlaceOfInterest;
import com.sync.pb.service.FourSquareFindRecommendedPlacesService;

/**
 * Integration test for {@link Application} starting on a random port.
 *
 * @author Phillip Webb
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

public class WbtestApplicationTests {

	private static final PlaceOfInterest LONDON = new PlaceOfInterest("London");
	private static final PlaceOfInterest SANFRANSISCO = new PlaceOfInterest("San Fransisco");


	@Autowired
	private TestRestTemplate restTemplate;

	@MockBean
	private FourSquareFindRecommendedPlacesService findRecommendedPlacesService;

	@Before
	public void setup() {
//		given(this.findRecommendedPlacesService.getVehicleDetails(VIN))
//				.willReturn(new VehicleDetails("Honda", "Civic"));
	}

	@Test
	public void testLondon() {
		ResponseEntity<String> response = this.restTemplate
				.getForEntity("/venues/recommended/{poi}", String.class, "London");
		assertThat(response.getBody()).contains("London");
	}
	
	@Test
	public void testSF() {
		ResponseEntity<String> response = this.restTemplate
				.getForEntity("/venues/recommended/{poi}", String.class, "San Fransisco");
		assertThat(response.getBody()).contains("San Fransisco");
	}

}
