package com.sync.pb.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import com.sync.pb.domain.PlaceOfInterest;

/**
 * {@link FindRecommendedPlaces} backed by a remote REST service.
 *
 */
@Service
public class FourSquareFindRecommendedPlacesService implements FindRecommendedPlaces{

	private static final Logger logger = LoggerFactory
			.getLogger(FourSquareFindRecommendedPlacesService.class);

	private final ApplicationProperties properties;

	private final RestTemplate restTemplate;

	public FourSquareFindRecommendedPlacesService(ApplicationProperties properties,
			RestTemplateBuilder restTemplateBuilder) {
		this.properties = properties;
		this.restTemplate = restTemplateBuilder.build();
	}

	
	
	/**
	 * Get the Recommended places for a given {@link PlaceOfInterest}.
	 * @param poi the place name as in Town or City
	 * @return JSON Payload(String)
	 */
	public String findRecommendedPlaces(PlaceOfInterest poi)
	{
		Assert.notNull(poi, "Place must not be null");
		logger.debug("URL from property: " + this.properties.getRootUrl());
		String url = this.properties.getRootUrl()+
					this.properties.getServiceVersion()+
					this.properties.getApiEndpoint()+
					"?client_id="+this.properties.getClientId()+
					"&client_secret="+this.properties.getClientSecret()+
					"&v="+ this.properties.getVersionDate()+
					"&near={poi}";
		logger.debug("Retrieving Recommended places data for: " + poi + " from: " + url);

		return this.restTemplate.getForObject(url, String.class, poi.toString());

	}

}