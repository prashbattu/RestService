package com.sync.pb.service;

import com.sync.pb.domain.PlaceOfInterest;

/**
 * A service to obtain JSON payload for a given {@link PlaceOfInterest}.
 * 
 */
public interface FindRecommendedPlaces {

	/**
	 * Get the Recommended places for a given {@link PlaceOfInterest}.
	 * @param poi the place name as in Town or City
	 * @return JSON Payload(String)
	 */
	String findRecommendedPlaces(PlaceOfInterest poi);
			

}