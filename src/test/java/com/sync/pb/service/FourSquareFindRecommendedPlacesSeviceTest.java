package com.sync.pb.service;

import java.util.Collection;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sync.pb.base.AbstractTest;
import com.sync.pb.domain.PlaceOfInterest;

/**
 * FourSquareFindRecommendedPlacesSevice Unit tests
 */

public class FourSquareFindRecommendedPlacesSeviceTest extends AbstractTest {

    @Autowired
    private FourSquareFindRecommendedPlacesService service;

    @Before
    public void setUp() {
        
    }

    @After
    public void tearDown() {
        // clean up after each test method
    }

    @Test
    public void testLondon() {

    	PlaceOfInterest poi = new PlaceOfInterest("London");
        String result = service.findRecommendedPlaces(poi);

        Assert.assertNotNull("failure - expected not null", result);
//        Assert.assertEquals("failure - expected list size", 2, list.size());

    }
    
    
    @Test
    public void testSF() {

    	PlaceOfInterest poi = new PlaceOfInterest("San Franscisco");
        String result = service.findRecommendedPlaces(poi);

        Assert.assertNotNull("failure - expected not null", result);
//        Assert.assertEquals("failure - expected list size", 2, list.size());

    }
    
    
    @Test
    public void testNotFound() {

    	PlaceOfInterest poi = new PlaceOfInterest("Blah");
        String result = service.findRecommendedPlaces(poi);

        Assert.assertNotNull("failure - expected not null", result);
//        Assert.assertEquals("failure - expected list size", 2, list.size());

    }



   


}
