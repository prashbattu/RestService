package com.sync.pb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sync.pb.domain.PlaceOfInterest;
import com.sync.pb.service.FourSquareFindRecommendedPlacesService;

/**
 * Controller to return places information for a given {@link PlaceOfInterest}.
 *
 */
@RestController
public class SearchPlacesController extends BaseController{
	@Autowired
	private FourSquareFindRecommendedPlacesService findRecommendedPlaces;

	public FourSquareFindRecommendedPlacesService getFindRecommendedPlaces() {
		return findRecommendedPlaces;
	}


	public void setFindRecommendedPlaces(FourSquareFindRecommendedPlacesService findRecommendedPlaces) {
		this.findRecommendedPlaces = findRecommendedPlaces;
	}


	public SearchPlacesController(FourSquareFindRecommendedPlacesService findRecommendedPlaces) {
		this.findRecommendedPlaces = findRecommendedPlaces;
	}


	@GetMapping(path = "venues/recommended/{place}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String recommendedPlace(@PathVariable String place) {
		return this.findRecommendedPlaces.findRecommendedPlaces(new PlaceOfInterest(place));
	}

}
