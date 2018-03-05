package com.sync.pb.web;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.sync.pb.base.AbstractControllerTest;

/**
 * Unit tests for the SearchPlaceController using Spring MVC Mocks.
 * 
 */
public class SearchPlaceControllerTest extends AbstractControllerTest {


    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void testGetLondons() throws Exception {

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
    public void testGetSF() throws Exception {

        String uri = "/venues/recommended/San Fransisco";
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON)).andReturn();

        String content = result.getResponse().getContentAsString();
        int status = result.getResponse().getStatus();

        Assert.assertEquals("failure - expected HTTP status", 200, status);
        Assert.assertTrue(
                "failure - expected HTTP response body to have a value",
                content.trim().length() > 0);

    }

//    @Test
//    public void testGetNotFound() throws Exception {
//
//        String uri = "/venues/recommended/BlahBlah";
//
//        MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri)
//                .accept(MediaType.APPLICATION_JSON)).andReturn();
//
//        String content = result.getResponse().getContentAsString();
//        int status = result.getResponse().getStatus();
//
//        Assert.assertEquals("failure - expected HTTP status 400", 400, status);
////        Assert.assertTrue("failure - expected HTTP response body to be empty",
////                content.trim().length() == 0);
//
//    }



}

