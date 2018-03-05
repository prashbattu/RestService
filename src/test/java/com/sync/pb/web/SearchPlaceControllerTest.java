package com.sync.pb.web;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.sync.pb.base.AbstractControllerTest;

/**
 * Unit tests for the GreetingController using Spring MVC Mocks.
 * 
 */
public class SearchPlaceControllerTest extends AbstractControllerTest {


//    @Autowired
//    private SearchPlacesController searchPlacesController;

    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void testGetGreetings() throws Exception {

        String uri = "/venues/recommended/London";

        MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON)).andReturn();

        String content = result.getResponse().getContentAsString();
        int status = result.getResponse().getStatus();

        Assert.assertEquals("failure - expected HTTP status", 200, status);
        Assert.assertTrue(
                "failure - expected HTTP response body to have a value",
                content.trim().length() > 0);

    }

    @Test
    public void testGetGreeting() throws Exception {

        String uri = "/venues/recommended/San Fransisco";
        Long id = new Long(1);

        MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri, id)
                .accept(MediaType.APPLICATION_JSON)).andReturn();

        String content = result.getResponse().getContentAsString();
        int status = result.getResponse().getStatus();

        Assert.assertEquals("failure - expected HTTP status 200", 200, status);
        Assert.assertTrue(
                "failure - expected HTTP response body to have a value",
                content.trim().length() > 0);

    }

    @Test
    public void testGetGreetingNotFound() throws Exception {

        String uri = "/venues/recommended/Blah blah";
        Long id = Long.MAX_VALUE;

        MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri, id)
                .accept(MediaType.APPLICATION_JSON)).andReturn();

        String content = result.getResponse().getContentAsString();
        int status = result.getResponse().getStatus();

        Assert.assertEquals("failure - expected HTTP status 500", 500, status);
//        Assert.assertTrue("failure - expected HTTP response body to be empty",
//                content.trim().length() == 0);

    }



}

