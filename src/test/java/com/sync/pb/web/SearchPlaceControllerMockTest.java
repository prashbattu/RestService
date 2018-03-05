package com.sync.pb.web;


import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.sync.pb.base.AbstractControllerTest;
import com.sync.pb.domain.PlaceOfInterest;
import com.sync.pb.service.FourSquareFindRecommendedPlacesService;

/**
 * Unit tests for the GreetingController using Mockito mocks and spies.
 * 
 */
public class SearchPlaceControllerMockTest extends AbstractControllerTest {

    /**
     * A mocked GreetingService
     */
    @Mock
    private FourSquareFindRecommendedPlacesService findRecommendedPlacesService;


    /**
     * A GreetingController instance with <code>@Mock</code> components injected
     * into it.
     */
    @InjectMocks
    private SearchPlacesController searchPlacesController;

    /**
     * Setup each test method. Initialize Mockito mock and spy objects. Scan for
     * Mockito annotations.
     */
    @Before
    public void setUp() {
        // Initialize Mockito annotated components
        MockitoAnnotations.initMocks(this);
        // Prepare the Spring MVC Mock components for standalone testing
        setUp(searchPlacesController);
    }

    @Test
    public void testGetSF() throws Exception {

        // Create some test data
        String sfResponse = getTwyfordStubData();
        PlaceOfInterest poi = new PlaceOfInterest("San Fransisco");

        // Stub the GreetingService.findAll method return value
        when(findRecommendedPlacesService.findRecommendedPlaces(poi)).thenReturn(sfResponse);

        // Perform the behavior being tested
        String uri = "/venues/recommended/San Fransisco";

        MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON)).andReturn();

        // Extract the response status and body
        String content = result.getResponse().getContentAsString();
        int status = result.getResponse().getStatus();

        // Verify the GreetingService.findAll method was invoked once
        verify(findRecommendedPlacesService, times(1)).findRecommendedPlaces(poi);

        // Perform standard JUnit assertions on the response
        Assert.assertEquals("failure - expected HTTP status 200", 200, status);
        Assert.assertTrue(
                "failure - expected HTTP response body to have a value",
                content.trim().length() > 0);

    }

  private String getTwyfordStubData()
  {
	 return "\"{\n" + 
	 		"    \\\"meta\\\": {\n" + 
	 		"        \\\"code\\\": 200,\n" + 
	 		"        \\\"requestId\\\": \\\"5a9c97ad351e3d52f8c38615\\\"\n" + 
	 		"    },\n" + 
	 		"    \\\"response\\\": {\n" + 
	 		"        \\\"geocode\\\": {\n" + 
	 		"            \\\"what\\\": \\\"\\\",\n" + 
	 		"            \\\"where\\\": \\\"twyford\\\",\n" + 
	 		"            \\\"center\\\": {\n" + 
	 		"                \\\"lat\\\": 51.47518,\n" + 
	 		"                \\\"lng\\\": -0.86037\n" + 
	 		"            },\n" + 
	 		"            \\\"displayString\\\": \\\"Twyford, Wokingham, United Kingdom\\\",\n" + 
	 		"            \\\"cc\\\": \\\"GB\\\",\n" + 
	 		"            \\\"geometry\\\": {\n" + 
	 		"                \\\"bounds\\\": {\n" + 
	 		"                    \\\"ne\\\": {\n" + 
	 		"                        \\\"lat\\\": 51.482418,\n" + 
	 		"                        \\\"lng\\\": -0.849981\n" + 
	 		"                    },\n" + 
	 		"                    \\\"sw\\\": {\n" + 
	 		"                        \\\"lat\\\": 51.468231,\n" + 
	 		"                        \\\"lng\\\": -0.872683\n" + 
	 		"                    }\n" + 
	 		"                }\n" + 
	 		"            },\n" + 
	 		"            \\\"slug\\\": \\\"twyford-united-kingdom\\\",\n" + 
	 		"            \\\"longId\\\": \\\"72057594040563230\\\"\n" + 
	 		"        },\n" + 
	 		"        \\\"headerLocation\\\": \\\"Twyford\\\",\n" + 
	 		"        \\\"headerFullLocation\\\": \\\"Twyford\\\",\n" + 
	 		"        \\\"headerLocationGranularity\\\": \\\"city\\\",\n" + 
	 		"        \\\"totalResults\\\": 22,\n" + 
	 		"        \\\"suggestedBounds\\\": {\n" + 
	 		"            \\\"ne\\\": {\n" + 
	 		"                \\\"lat\\\": 51.49623234313675,\n" + 
	 		"                \\\"lng\\\": -0.845815124910221\n" + 
	 		"            },\n" + 
	 		"            \\\"sw\\\": {\n" + 
	 		"                \\\"lat\\\": 51.47434277661696,\n" + 
	 		"                \\\"lng\\\": -0.8691419059844507\n" + 
	 		"            }\n" + 
	 		"        },\n" + 
	 		"        \\\"groups\\\": [\n" + 
	 		"            {\n" + 
	 		"                \\\"type\\\": \\\"Recommended Places\\\",\n" + 
	 		"                \\\"name\\\": \\\"recommended\\\",\n" + 
	 		"                \\\"items\\\": [\n" + 
	 		"                    {\n" + 
	 		"                        \\\"reasons\\\": {\n" + 
	 		"                            \\\"count\\\": 0,\n" + 
	 		"                            \\\"items\\\": [\n" + 
	 		"                                {\n" + 
	 		"                                    \\\"summary\\\": \\\"This spot is popular\\\",\n" + 
	 		"                                    \\\"type\\\": \\\"general\\\",\n" + 
	 		"                                    \\\"reasonName\\\": \\\"globalInteractionReason\\\"\n" + 
	 		"                                }\n" + 
	 		"                            ]\n" + 
	 		"                        },\n" + 
	 		"                        \\\"venue\\\": {\n" + 
	 		"                            \\\"id\\\": \\\"4bdafe732a3a0f471fd8acb6\\\",\n" + 
	 		"                            \\\"name\\\": \\\"Waitrose\\\",\n" + 
	 		"                            \\\"contact\\\": {\n" + 
	 		"                                \\\"phone\\\": \\\"+441189344646\\\",\n" + 
	 		"                                \\\"formattedPhone\\\": \\\"+44 118 934 4646\\\",\n" + 
	 		"                                \\\"twitter\\\": \\\"waitrose\\\",\n" + 
	 		"                                \\\"instagram\\\": \\\"waitrose\\\",\n" + 
	 		"                                \\\"facebook\\\": \\\"81027643206\\\",\n" + 
	 		"                                \\\"facebookUsername\\\": \\\"Waitrose\\\",\n" + 
	 		"                                \\\"facebookName\\\": \\\"Waitrose\\\"\n" + 
	 		"                            },\n" + 
	 		"                            \\\"location\\\": {\n" + 
	 		"                                \\\"address\\\": \\\"London Rd\\\",\n" + 
	 		"                                \\\"lat\\\": 51.478139491149754,\n" + 
	 		"                                \\\"lng\\\": -0.866105135330712,\n" + 
	 		"                                \\\"labeledLatLngs\\\": [\n" + 
	 		"                                    {\n" + 
	 		"                                        \\\"label\\\": \\\"display\\\",\n" + 
	 		"                                        \\\"lat\\\": 51.478139491149754,\n" + 
	 		"                                        \\\"lng\\\": -0.866105135330712\n" + 
	 		"                                    }\n" + 
	 		"                                ],\n" + 
	 		"                                \\\"postalCode\\\": \\\"RG10 9EH\\\",\n" + 
	 		"                                \\\"cc\\\": \\\"GB\\\",\n" + 
	 		"                                \\\"city\\\": \\\"Twyford\\\",\n" + 
	 		"                                \\\"state\\\": \\\"Berkshire\\\",\n" + 
	 		"                                \\\"country\\\": \\\"United Kingdom\\\",\n" + 
	 		"                                \\\"formattedAddress\\\": [\n" + 
	 		"                                    \\\"London Rd\\\",\n" + 
	 		"                                    \\\"Twyford\\\",\n" + 
	 		"                                    \\\"Berkshire\\\",\n" + 
	 		"                                    \\\"RG10 9EH\\\",\n" + 
	 		"                                    \\\"United Kingdom\\\"\n" + 
	 		"                                ]\n" + 
	 		"                            },\n" + 
	 		"                            \\\"categories\\\": [\n" + 
	 		"                                {\n" + 
	 		"                                    \\\"id\\\": \\\"52f2ab2ebcbc57f1066b8b46\\\",\n" + 
	 		"                                    \\\"name\\\": \\\"Supermarket\\\",\n" + 
	 		"                                    \\\"pluralName\\\": \\\"Supermarkets\\\",\n" + 
	 		"                                    \\\"shortName\\\": \\\"Supermarket\\\",\n" + 
	 		"                                    \\\"icon\\\": {\n" + 
	 		"                                        \\\"prefix\\\": \\\"https://ss3.4sqi.net/img/categories_v2/shops/food_grocery_\\\",\n" + 
	 		"                                        \\\"suffix\\\": \\\".png\\\"\n" + 
	 		"                                    },\n" + 
	 		"                                    \\\"primary\\\": true\n" + 
	 		"                                }\n" + 
	 		"                            ],\n" + 
	 		"                            \\\"verified\\\": false,\n" + 
	 		"                            \\\"stats\\\": {\n" + 
	 		"                                \\\"tipCount\\\": 5,\n" + 
	 		"                                \\\"usersCount\\\": 203,\n" + 
	 		"                                \\\"checkinsCount\\\": 876\n" + 
	 		"                            },\n" + 
	 		"                            \\\"url\\\": \\\"http://www.waitrose.com\\\",\n" + 
	 		"                            \\\"rating\\\": 7.9,\n" + 
	 		"                            \\\"ratingColor\\\": \\\"C5DE35\\\",\n" + 
	 		"                            \\\"ratingSignals\\\": 31,\n" + 
	 		"                            \\\"allowMenuUrlEdit\\\": true,\n" + 
	 		"                            \\\"beenHere\\\": {\n" + 
	 		"                                \\\"count\\\": 0,\n" + 
	 		"                                \\\"marked\\\": false,\n" + 
	 		"                                \\\"lastCheckinExpiredAt\\\": 0\n" + 
	 		"                            },\n" + 
	 		"                            \\\"hours\\\": {\n" + 
	 		"                                \\\"status\\\": \\\"Closed until 8:00 AM\\\",\n" + 
	 		"                                \\\"richStatus\\\": {\n" + 
	 		"                                    \\\"entities\\\": [],\n" + 
	 		"                                    \\\"text\\\": \\\"Closed until 8:00 AM\\\"\n" + 
	 		"                                },\n" + 
	 		"                                \\\"isOpen\\\": false,\n" + 
	 		"                                \\\"isLocalHoliday\\\": false\n" + 
	 		"                            },\n" + 
	 		"                            \\\"photos\\\": {\n" + 
	 		"                                \\\"count\\\": 0,\n" + 
	 		"                                \\\"groups\\\": []\n" + 
	 		"                            },\n" + 
	 		"                            \\\"hereNow\\\": {\n" + 
	 		"                                \\\"count\\\": 0,\n" + 
	 		"                                \\\"summary\\\": \\\"Nobody here\\\",\n" + 
	 		"                                \\\"groups\\\": []\n" + 
	 		"                            }\n" + 
	 		"                        },\n" + 
	 		"                        \\\"tips\\\": [\n" + 
	 		"                            {\n" + 
	 		"                                \\\"id\\\": \\\"519524bc498e9efad7b6070a\\\",\n" + 
	 		"                                \\\"createdAt\\\": 1368728764,\n" + 
	 		"                                \\\"text\\\": \\\"You can shop here for things.\\\",\n" + 
	 		"                                \\\"type\\\": \\\"user\\\",\n" + 
	 		"                                \\\"canonicalUrl\\\": \\\"https://foursquare.com/item/519524bc498e9efad7b6070a\\\",\n" + 
	 		"                                \\\"likes\\\": {\n" + 
	 		"                                    \\\"count\\\": 2,\n" + 
	 		"                                    \\\"groups\\\": [],\n" + 
	 		"                                    \\\"summary\\\": \\\"2 likes\\\"\n" + 
	 		"                                },\n" + 
	 		"                                \\\"logView\\\": true,\n" + 
	 		"                                \\\"agreeCount\\\": 2,\n" + 
	 		"                                \\\"disagreeCount\\\": 0,\n" + 
	 		"                                \\\"todo\\\": {\n" + 
	 		"                                    \\\"count\\\": 0\n" + 
	 		"                                },\n" + 
	 		"                                \\\"user\\\": {\n" + 
	 		"                                    \\\"id\\\": \\\"20434645\\\",\n" + 
	 		"                                    \\\"firstName\\\": \\\"Myles\\\",\n" + 
	 		"                                    \\\"lastName\\\": \\\"Dyer\\\",\n" + 
	 		"                                    \\\"gender\\\": \\\"male\\\",\n" + 
	 		"                                    \\\"photo\\\": {\n" + 
	 		"                                        \\\"prefix\\\": \\\"https://igx.4sqi.net/img/user/\\\",\n" + 
	 		"                                        \\\"suffix\\\": \\\"/3Q0P5P3Y3EIRP4IB.jpg\\\"\n" + 
	 		"                                    }\n" + 
	 		"                                }\n" + 
	 		"                            }\n" + 
	 		"                        ],\n" + 
	 		"                        \\\"referralId\\\": \\\"e-0-4bdafe732a3a0f471fd8acb6-0\\\"\n" + 
	 		"                    },\n" + 
	 		"                    {\n" + 
	 		"                        \\\"reasons\\\": {\n" + 
	 		"                            \\\"count\\\": 0,\n" + 
	 		"                            \\\"items\\\": [\n" + 
	 		"                                {\n" + 
	 		"                                    \\\"summary\\\": \\\"This spot is popular\\\",\n" + 
	 		"                                    \\\"type\\\": \\\"general\\\",\n" + 
	 		"                                    \\\"reasonName\\\": \\\"globalInteractionReason\\\"\n" + 
	 		"                                }\n" + 
	 		"                            ]\n" + 
	 		"                        },\n" + 
	 		"                        \\\"venue\\\": {\n" + 
	 		"                            \\\"id\\\": \\\"4d814082dbc5f04d625107b7\\\",\n" + 
	 		"                            \\\"name\\\": \\\"Sebastian's Cafe\\\",\n" + 
	 		"                            \\\"contact\\\": {},\n" + 
	 		"                            \\\"location\\\": {\n" + 
	 		"                                \\\"address\\\": \\\"22-42 Station Rd\\\",\n" + 
	 		"                                \\\"lat\\\": 51.477464,\n" + 
	 		"                                \\\"lng\\\": -0.8665801,\n" + 
	 		"                                \\\"labeledLatLngs\\\": [\n" + 
	 		"                                    {\n" + 
	 		"                                        \\\"label\\\": \\\"display\\\",\n" + 
	 		"                                        \\\"lat\\\": 51.477464,\n" + 
	 		"                                        \\\"lng\\\": -0.8665801\n" + 
	 		"                                    }\n" + 
	 		"                                ],\n" + 
	 		"                                \\\"cc\\\": \\\"GB\\\",\n" + 
	 		"                                \\\"country\\\": \\\"United Kingdom\\\",\n" + 
	 		"                                \\\"formattedAddress\\\": [\n" + 
	 		"                                    \\\"22-42 Station Rd\\\",\n" + 
	 		"                                    \\\"United Kingdom\\\"\n" + 
	 		"                                ]\n" + 
	 		"                            },\n" + 
	 		"                            \\\"categories\\\": [\n" + 
	 		"                                {\n" + 
	 		"                                    \\\"id\\\": \\\"4bf58dd8d48988d16d941735\\\",\n" + 
	 		"                                    \\\"name\\\": \\\"Café\\\",\n" + 
	 		"                                    \\\"pluralName\\\": \\\"Cafés\\\",\n" + 
	 		"                                    \\\"shortName\\\": \\\"Café\\\",\n" + 
	 		"                                    \\\"icon\\\": {\n" + 
	 		"                                        \\\"prefix\\\": \\\"https://ss3.4sqi.net/img/categories_v2/food/cafe_\\\",\n" + 
	 		"                                        \\\"suffix\\\": \\\".png\\\"\n" + 
	 		"                                    },\n" + 
	 		"                                    \\\"primary\\\": true\n" + 
	 		"                                }\n" + 
	 		"                            ],\n" + 
	 		"                            \\\"verified\\\": false,\n" + 
	 		"                            \\\"stats\\\": {\n" + 
	 		"                                \\\"tipCount\\\": 3,\n" + 
	 		"                                \\\"usersCount\\\": 46,\n" + 
	 		"                                \\\"checkinsCount\\\": 92\n" + 
	 		"                            },\n" + 
	 		"                            \\\"price\\\": {\n" + 
	 		"                                \\\"tier\\\": 1,\n" + 
	 		"                                \\\"message\\\": \\\"Cheap\\\",\n" + 
	 		"                                \\\"currency\\\": \\\"£\\\"\n" + 
	 		"                            },\n" + 
	 		"                            \\\"rating\\\": 7.3,\n" + 
	 		"                            \\\"ratingColor\\\": \\\"C5DE35\\\",\n" + 
	 		"                            \\\"ratingSignals\\\": 8,\n" + 
	 		"                            \\\"allowMenuUrlEdit\\\": true,\n" + 
	 		"                            \\\"beenHere\\\": {\n" + 
	 		"                                \\\"count\\\": 0,\n" + 
	 		"                                \\\"marked\\\": false,\n" + 
	 		"                                \\\"lastCheckinExpiredAt\\\": 0\n" + 
	 		"                            },\n" + 
	 		"                            \\\"photos\\\": {\n" + 
	 		"                                \\\"count\\\": 0,\n" + 
	 		"                                \\\"groups\\\": []\n" + 
	 		"                            },\n" + 
	 		"                            \\\"hereNow\\\": {\n" + 
	 		"                                \\\"count\\\": 0,\n" + 
	 		"                                \\\"summary\\\": \\\"Nobody here\\\",\n" + 
	 		"                                \\\"groups\\\": []\n" + 
	 		"                            }\n" + 
	 		"                        },\n" + 
	 		"                        \\\"tips\\\": [\n" + 
	 		"                            {\n" + 
	 		"                                \\\"id\\\": \\\"4fb357b6e4b02908319e506f\\\",\n" + 
	 		"                                \\\"createdAt\\\": 1337153462,\n" + 
	 		"                                \\\"text\\\": \\\"It opens at 8 so get in for a good hearty English Breakfast start to the day. Or cake, sarnie etc\\\",\n" + 
	 		"                                \\\"type\\\": \\\"user\\\",\n" + 
	 		"                                \\\"canonicalUrl\\\": \\\"https://foursquare.com/item/4fb357b6e4b02908319e506f\\\",\n" + 
	 		"                                \\\"likes\\\": {\n" + 
	 		"                                    \\\"count\\\": 2,\n" + 
	 		"                                    \\\"groups\\\": [],\n" + 
	 		"                                    \\\"summary\\\": \\\"2 likes\\\"\n" + 
	 		"                                },\n" + 
	 		"                                \\\"logView\\\": true,\n" + 
	 		"                                \\\"agreeCount\\\": 0,\n" + 
	 		"                                \\\"disagreeCount\\\": 0,\n" + 
	 		"                                \\\"todo\\\": {\n" + 
	 		"                                    \\\"count\\\": 0\n" + 
	 		"                                },\n" + 
	 		"                                \\\"user\\\": {\n" + 
	 		"                                    \\\"id\\\": \\\"21144593\\\",\n" + 
	 		"                                    \\\"firstName\\\": \\\"Mark\\\",\n" + 
	 		"                                    \\\"lastName\\\": \\\"Hammond\\\",\n" + 
	 		"                                    \\\"gender\\\": \\\"male\\\",\n" + 
	 		"                                    \\\"photo\\\": {\n" + 
	 		"                                        \\\"prefix\\\": \\\"https://igx.4sqi.net/img/user/\\\",\n" + 
	 		"                                        \\\"suffix\\\": \\\"/LXLFKAWOK13UJKWF.jpg\\\"\n" + 
	 		"                                    }\n" + 
	 		"                                }\n" + 
	 		"                            }\n" + 
	 		"                        ],\n" + 
	 		"                        \\\"referralId\\\": \\\"e-0-4d814082dbc5f04d625107b7-1\\\"\n" + 
	 		"                    },\n" + 
	 		"                    {\n" + 
	 		"                        \\\"reasons\\\": {\n" + 
	 		"                            \\\"count\\\": 0,\n" + 
	 		"                            \\\"items\\\": [\n" + 
	 		"                                {\n" + 
	 		"                                    \\\"summary\\\": \\\"This spot is popular\\\",\n" + 
	 		"                                    \\\"type\\\": \\\"general\\\",\n" + 
	 		"                                    \\\"reasonName\\\": \\\"globalInteractionReason\\\"\n" + 
	 		"                                }\n" + 
	 		"                            ]\n" + 
	 		"                        },\n" + 
	 		"                        \\\"venue\\\": {\n" + 
	 		"                            \\\"id\\\": \\\"4d0a20a582aaa093c92fd4c2\\\",\n" + 
	 		"                            \\\"name\\\": \\\"La Fontana\\\",\n" + 
	 		"                            \\\"contact\\\": {\n" + 
	 		"                                \\\"phone\\\": \\\"+441189342698\\\",\n" + 
	 		"                                \\\"formattedPhone\\\": \\\"+44 118 934 2698\\\"\n" + 
	 		"                            },\n" + 
	 		"                            \\\"location\\\": {\n" + 
	 		"                                \\\"address\\\": \\\"12 Wargrave Rd\\\",\n" + 
	 		"                                \\\"lat\\\": 51.47893224796384,\n" + 
	 		"                                \\\"lng\\\": -0.8662681563334645,\n" + 
	 		"                                \\\"labeledLatLngs\\\": [\n" + 
	 		"                                    {\n" + 
	 		"                                        \\\"label\\\": \\\"display\\\",\n" + 
	 		"                                        \\\"lat\\\": 51.47893224796384,\n" + 
	 		"                                        \\\"lng\\\": -0.8662681563334645\n" + 
	 		"                                    }\n" + 
	 		"                                ],\n" + 
	 		"                                \\\"postalCode\\\": \\\"RG10 9PG\\\",\n" + 
	 		"                                \\\"cc\\\": \\\"GB\\\",\n" + 
	 		"                                \\\"city\\\": \\\"Berkshire\\\",\n" + 
	 		"                                \\\"state\\\": \\\"Berkshire\\\",\n" + 
	 		"                                \\\"country\\\": \\\"United Kingdom\\\",\n" + 
	 		"                                \\\"formattedAddress\\\": [\n" + 
	 		"                                    \\\"12 Wargrave Rd\\\",\n" + 
	 		"                                    \\\"Berkshire\\\",\n" + 
	 		"                                    \\\"RG10 9PG\\\",\n" + 
	 		"                                    \\\"United Kingdom\\\"\n" + 
	 		"                                ]\n" + 
	 		"                            },\n" + 
	 		"                            \\\"categories\\\": [\n" + 
	 		"                                {\n" + 
	 		"                                    \\\"id\\\": \\\"4bf58dd8d48988d110941735\\\",\n" + 
	 		"                                    \\\"name\\\": \\\"Italian Restaurant\\\",\n" + 
	 		"                                    \\\"pluralName\\\": \\\"Italian Restaurants\\\",\n" + 
	 		"                                    \\\"shortName\\\": \\\"Italian\\\",\n" + 
	 		"                                    \\\"icon\\\": {\n" + 
	 		"                                        \\\"prefix\\\": \\\"https://ss3.4sqi.net/img/categories_v2/food/italian_\\\",\n" + 
	 		"                                        \\\"suffix\\\": \\\".png\\\"\n" + 
	 		"                                    },\n" + 
	 		"                                    \\\"primary\\\": true\n" + 
	 		"                                }\n" + 
	 		"                            ],\n" + 
	 		"                            \\\"verified\\\": false,\n" + 
	 		"                            \\\"stats\\\": {\n" + 
	 		"                                \\\"tipCount\\\": 3,\n" + 
	 		"                                \\\"usersCount\\\": 37,\n" + 
	 		"                                \\\"checkinsCount\\\": 218\n" + 
	 		"                            },\n" + 
	 		"                            \\\"url\\\": \\\"http://www.lafontanatwyford.com/\\\",\n" + 
	 		"                            \\\"price\\\": {\n" + 
	 		"                                \\\"tier\\\": 2,\n" + 
	 		"                                \\\"message\\\": \\\"Moderate\\\",\n" + 
	 		"                                \\\"currency\\\": \\\"£\\\"\n" + 
	 		"                            },\n" + 
	 		"                            \\\"hasMenu\\\": true,\n" + 
	 		"                            \\\"rating\\\": 7.3,\n" + 
	 		"                            \\\"ratingColor\\\": \\\"C5DE35\\\",\n" + 
	 		"                            \\\"ratingSignals\\\": 8,\n" + 
	 		"                            \\\"menu\\\": {\n" + 
	 		"                                \\\"type\\\": \\\"Menu\\\",\n" + 
	 		"                                \\\"label\\\": \\\"Menu\\\",\n" + 
	 		"                                \\\"anchor\\\": \\\"View Menu\\\",\n" + 
	 		"                                \\\"url\\\": \\\"https://foursquare.com/v/la-fontana/4d0a20a582aaa093c92fd4c2/menu\\\",\n" + 
	 		"                                \\\"mobileUrl\\\": \\\"https://foursquare.com/v/4d0a20a582aaa093c92fd4c2/device_menu\\\"\n" + 
	 		"                            },\n" + 
	 		"                            \\\"allowMenuUrlEdit\\\": true,\n" + 
	 		"                            \\\"beenHere\\\": {\n" + 
	 		"                                \\\"count\\\": 0,\n" + 
	 		"                                \\\"marked\\\": false,\n" + 
	 		"                                \\\"lastCheckinExpiredAt\\\": 0\n" + 
	 		"                            },\n" + 
	 		"                            \\\"photos\\\": {\n" + 
	 		"                                \\\"count\\\": 0,\n" + 
	 		"                                \\\"groups\\\": []\n" + 
	 		"                            },\n" + 
	 		"                            \\\"hereNow\\\": {\n" + 
	 		"                                \\\"count\\\": 0,\n" + 
	 		"                                \\\"summary\\\": \\\"Nobody here\\\",\n" + 
	 		"                                \\\"groups\\\": []\n" + 
	 		"                            }\n" + 
	 		"                        },\n" + 
	 		"                        \\\"tips\\\": [\n" + 
	 		"                            {\n" + 
	 		"                                \\\"id\\\": \\\"58b2c480ecb67e34d7c43887\\\",\n" + 
	 		"                                \\\"createdAt\\\": 1488110720,\n" + 
	 		"                                \\\"text\\\": \\\"Really friendly, great coffee!\\\",\n" + 
	 		"                                \\\"type\\\": \\\"user\\\",\n" + 
	 		"                                \\\"canonicalUrl\\\": \\\"https://foursquare.com/item/58b2c480ecb67e34d7c43887\\\",\n" + 
	 		"                                \\\"logView\\\": true,\n" + 
	 		"                                \\\"agreeCount\\\": 0,\n" + 
	 		"                                \\\"disagreeCount\\\": 0,\n" + 
	 		"                                \\\"todo\\\": {\n" + 
	 		"                                    \\\"count\\\": 0\n" + 
	 		"                                },\n" + 
	 		"                                \\\"user\\\": {\n" + 
	 		"                                    \\\"id\\\": \\\"89106621\\\",\n" + 
	 		"                                    \\\"firstName\\\": \\\"Rachel\\\",\n" + 
	 		"                                    \\\"lastName\\\": \\\"Hanson\\\",\n" + 
	 		"                                    \\\"gender\\\": \\\"female\\\",\n" + 
	 		"                                    \\\"photo\\\": {\n" + 
	 		"                                        \\\"prefix\\\": \\\"https://igx.4sqi.net/img/user/\\\",\n" + 
	 		"                                        \\\"suffix\\\": \\\"/blank_girl.png\\\",\n" + 
	 		"                                        \\\"default\\\": true\n" + 
	 		"                                    }\n" + 
	 		"                                }\n" + 
	 		"                            }\n" + 
	 		"                        ],\n" + 
	 		"                        \\\"referralId\\\": \\\"e-0-4d0a20a582aaa093c92fd4c2-2\\\"\n" + 
	 		"                    },\n" + 
	 		"                    {\n" + 
	 		"                        \\\"reasons\\\": {\n" + 
	 		"                            \\\"count\\\": 0,\n" + 
	 		"                            \\\"items\\\": [\n" + 
	 		"                                {\n" + 
	 		"                                    \\\"summary\\\": \\\"This spot is popular\\\",\n" + 
	 		"                                    \\\"type\\\": \\\"general\\\",\n" + 
	 		"                                    \\\"reasonName\\\": \\\"globalInteractionReason\\\"\n" + 
	 		"                                }\n" + 
	 		"                            ]\n" + 
	 		"                        },\n" + 
	 		"                        \\\"venue\\\": {\n" + 
	 		"                            \\\"id\\\": \\\"4bfc0c62e05e0f478519cfa8\\\",\n" + 
	 		"                            \\\"name\\\": \\\"Haweli\\\",\n" + 
	 		"                            \\\"contact\\\": {\n" + 
	 		"                                \\\"phone\\\": \\\"+441189320939\\\",\n" + 
	 		"                                \\\"formattedPhone\\\": \\\"+44 118 932 0939\\\"\n" + 
	 		"                            },\n" + 
	 		"                            \\\"location\\\": {\n" + 
	 		"                                \\\"address\\\": \\\"15 Church St\\\",\n" + 
	 		"                                \\\"lat\\\": 51.477282691587156,\n" + 
	 		"                                \\\"lng\\\": -0.8662595214816516,\n" + 
	 		"                                \\\"labeledLatLngs\\\": [\n" + 
	 		"                                    {\n" + 
	 		"                                        \\\"label\\\": \\\"display\\\",\n" + 
	 		"                                        \\\"lat\\\": 51.477282691587156,\n" + 
	 		"                                        \\\"lng\\\": -0.8662595214816516\n" + 
	 		"                                    }\n" + 
	 		"                                ],\n" + 
	 		"                                \\\"postalCode\\\": \\\"RG10 9DN\\\",\n" + 
	 		"                                \\\"cc\\\": \\\"GB\\\",\n" + 
	 		"                                \\\"city\\\": \\\"Twyford\\\",\n" + 
	 		"                                \\\"state\\\": \\\"Berkshire\\\",\n" + 
	 		"                                \\\"country\\\": \\\"United Kingdom\\\",\n" + 
	 		"                                \\\"formattedAddress\\\": [\n" + 
	 		"                                    \\\"15 Church St\\\",\n" + 
	 		"                                    \\\"Twyford\\\",\n" + 
	 		"                                    \\\"Berkshire\\\",\n" + 
	 		"                                    \\\"RG10 9DN\\\",\n" + 
	 		"                                    \\\"United Kingdom\\\"\n" + 
	 		"                                ]\n" + 
	 		"                            },\n" + 
	 		"                            \\\"categories\\\": [\n" + 
	 		"                                {\n" + 
	 		"                                    \\\"id\\\": \\\"4bf58dd8d48988d10f941735\\\",\n" + 
	 		"                                    \\\"name\\\": \\\"Indian Restaurant\\\",\n" + 
	 		"                                    \\\"pluralName\\\": \\\"Indian Restaurants\\\",\n" + 
	 		"                                    \\\"shortName\\\": \\\"Indian\\\",\n" + 
	 		"                                    \\\"icon\\\": {\n" + 
	 		"                                        \\\"prefix\\\": \\\"https://ss3.4sqi.net/img/categories_v2/food/indian_\\\",\n" + 
	 		"                                        \\\"suffix\\\": \\\".png\\\"\n" + 
	 		"                                    },\n" + 
	 		"                                    \\\"primary\\\": true\n" + 
	 		"                                }\n" + 
	 		"                            ],\n" + 
	 		"                            \\\"verified\\\": false,\n" + 
	 		"                            \\\"stats\\\": {\n" + 
	 		"                                \\\"tipCount\\\": 9,\n" + 
	 		"                                \\\"usersCount\\\": 96,\n" + 
	 		"                                \\\"checkinsCount\\\": 341\n" + 
	 		"                            },\n" + 
	 		"                            \\\"url\\\": \\\"http://www.hawelitwyford.co.uk\\\",\n" + 
	 		"                            \\\"price\\\": {\n" + 
	 		"                                \\\"tier\\\": 2,\n" + 
	 		"                                \\\"message\\\": \\\"Moderate\\\",\n" + 
	 		"                                \\\"currency\\\": \\\"£\\\"\n" + 
	 		"                            },\n" + 
	 		"                            \\\"rating\\\": 6.9,\n" + 
	 		"                            \\\"ratingColor\\\": \\\"FFC800\\\",\n" + 
	 		"                            \\\"ratingSignals\\\": 21,\n" + 
	 		"                            \\\"allowMenuUrlEdit\\\": true,\n" + 
	 		"                            \\\"beenHere\\\": {\n" + 
	 		"                                \\\"count\\\": 0,\n" + 
	 		"                                \\\"marked\\\": false,\n" + 
	 		"                                \\\"lastCheckinExpiredAt\\\": 0\n" + 
	 		"                            },\n" + 
	 		"                            \\\"hours\\\": {\n" + 
	 		"                                \\\"status\\\": \\\"Closed until Noon\\\",\n" + 
	 		"                                \\\"richStatus\\\": {\n" + 
	 		"                                    \\\"entities\\\": [],\n" + 
	 		"                                    \\\"text\\\": \\\"Closed until Noon\\\"\n" + 
	 		"                                },\n" + 
	 		"                                \\\"isOpen\\\": false,\n" + 
	 		"                                \\\"isLocalHoliday\\\": false\n" + 
	 		"                            },\n" + 
	 		"                            \\\"photos\\\": {\n" + 
	 		"                                \\\"count\\\": 0,\n" + 
	 		"                                \\\"groups\\\": []\n" + 
	 		"                            },\n" + 
	 		"                            \\\"hereNow\\\": {\n" + 
	 		"                                \\\"count\\\": 0,\n" + 
	 		"                                \\\"summary\\\": \\\"Nobody here\\\",\n" + 
	 		"                                \\\"groups\\\": []\n" + 
	 		"                            }\n" + 
	 		"                        },\n" + 
	 		"                        \\\"tips\\\": [\n" + 
	 		"                            {\n" + 
	 		"                                \\\"id\\\": \\\"4fbfd741e4b032785104e003\\\",\n" + 
	 		"                                \\\"createdAt\\\": 1337972545,\n" + 
	 		"                                \\\"text\\\": \\\"Adequate food, but not great service, waited for ages last time we were there!\\\",\n" + 
	 		"                                \\\"type\\\": \\\"user\\\",\n" + 
	 		"                                \\\"canonicalUrl\\\": \\\"https://foursquare.com/item/4fbfd741e4b032785104e003\\\",\n" + 
	 		"                                \\\"likes\\\": {\n" + 
	 		"                                    \\\"count\\\": 3,\n" + 
	 		"                                    \\\"groups\\\": [],\n" + 
	 		"                                    \\\"summary\\\": \\\"3 likes\\\"\n" + 
	 		"                                },\n" + 
	 		"                                \\\"logView\\\": true,\n" + 
	 		"                                \\\"agreeCount\\\": 0,\n" + 
	 		"                                \\\"disagreeCount\\\": 0,\n" + 
	 		"                                \\\"todo\\\": {\n" + 
	 		"                                    \\\"count\\\": 0\n" + 
	 		"                                },\n" + 
	 		"                                \\\"user\\\": {\n" + 
	 		"                                    \\\"id\\\": \\\"25656771\\\",\n" + 
	 		"                                    \\\"firstName\\\": \\\"Carla\\\",\n" + 
	 		"                                    \\\"lastName\\\": \\\"Hammond\\\",\n" + 
	 		"                                    \\\"gender\\\": \\\"female\\\",\n" + 
	 		"                                    \\\"photo\\\": {\n" + 
	 		"                                        \\\"prefix\\\": \\\"https://igx.4sqi.net/img/user/\\\",\n" + 
	 		"                                        \\\"suffix\\\": \\\"/3ECNWNHJJYNV4HL2.jpg\\\"\n" + 
	 		"                                    }\n" + 
	 		"                                }\n" + 
	 		"                            }\n" + 
	 		"                        ],\n" + 
	 		"                        \\\"referralId\\\": \\\"e-0-4bfc0c62e05e0f478519cfa8-3\\\"\n" + 
	 		"                    },\n" + 
	 		"                    {\n" + 
	 		"                        \\\"reasons\\\": {\n" + 
	 		"                            \\\"count\\\": 0,\n" + 
	 		"                            \\\"items\\\": [\n" + 
	 		"                                {\n" + 
	 		"                                    \\\"summary\\\": \\\"This spot is popular\\\",\n" + 
	 		"                                    \\\"type\\\": \\\"general\\\",\n" + 
	 		"                                    \\\"reasonName\\\": \\\"globalInteractionReason\\\"\n" + 
	 		"                                }\n" + 
	 		"                            ]\n" + 
	 		"                        },\n" + 
	 		"                        \\\"venue\\\": {\n" + 
	 		"                            \\\"id\\\": \\\"55d74ec9498e0afc9f28e2d8\\\",\n" + 
	 		"                            \\\"name\\\": \\\"Costa Coffee\\\",\n" + 
	 		"                            \\\"contact\\\": {},\n" + 
	 		"                            \\\"location\\\": {\n" + 
	 		"                                \\\"address\\\": \\\"3 High Street\\\",\n" + 
	 		"                                \\\"lat\\\": 51.477585,\n" + 
	 		"                                \\\"lng\\\": -0.866732,\n" + 
	 		"                                \\\"labeledLatLngs\\\": [\n" + 
	 		"                                    {\n" + 
	 		"                                        \\\"label\\\": \\\"display\\\",\n" + 
	 		"                                        \\\"lat\\\": 51.477585,\n" + 
	 		"                                        \\\"lng\\\": -0.866732\n" + 
	 		"                                    }\n" + 
	 		"                                ],\n" + 
	 		"                                \\\"postalCode\\\": \\\"RG10 9AB\\\",\n" + 
	 		"                                \\\"cc\\\": \\\"GB\\\",\n" + 
	 		"                                \\\"city\\\": \\\"Twyford\\\",\n" + 
	 		"                                \\\"state\\\": \\\"Berkshire\\\",\n" + 
	 		"                                \\\"country\\\": \\\"United Kingdom\\\",\n" + 
	 		"                                \\\"formattedAddress\\\": [\n" + 
	 		"                                    \\\"3 High Street\\\",\n" + 
	 		"                                    \\\"Twyford\\\",\n" + 
	 		"                                    \\\"Berkshire\\\",\n" + 
	 		"                                    \\\"RG10 9AB\\\",\n" + 
	 		"                                    \\\"United Kingdom\\\"\n" + 
	 		"                                ]\n" + 
	 		"                            },\n" + 
	 		"                            \\\"categories\\\": [\n" + 
	 		"                                {\n" + 
	 		"                                    \\\"id\\\": \\\"4bf58dd8d48988d1e0931735\\\",\n" + 
	 		"                                    \\\"name\\\": \\\"Coffee Shop\\\",\n" + 
	 		"                                    \\\"pluralName\\\": \\\"Coffee Shops\\\",\n" + 
	 		"                                    \\\"shortName\\\": \\\"Coffee Shop\\\",\n" + 
	 		"                                    \\\"icon\\\": {\n" + 
	 		"                                        \\\"prefix\\\": \\\"https://ss3.4sqi.net/img/categories_v2/food/coffeeshop_\\\",\n" + 
	 		"                                        \\\"suffix\\\": \\\".png\\\"\n" + 
	 		"                                    },\n" + 
	 		"                                    \\\"primary\\\": true\n" + 
	 		"                                }\n" + 
	 		"                            ],\n" + 
	 		"                            \\\"verified\\\": false,\n" + 
	 		"                            \\\"stats\\\": {\n" + 
	 		"                                \\\"tipCount\\\": 1,\n" + 
	 		"                                \\\"usersCount\\\": 23,\n" + 
	 		"                                \\\"checkinsCount\\\": 82\n" + 
	 		"                            },\n" + 
	 		"                            \\\"price\\\": {\n" + 
	 		"                                \\\"tier\\\": 1,\n" + 
	 		"                                \\\"message\\\": \\\"Cheap\\\",\n" + 
	 		"                                \\\"currency\\\": \\\"£\\\"\n" + 
	 		"                            },\n" + 
	 		"                            \\\"rating\\\": 6.7,\n" + 
	 		"                            \\\"ratingColor\\\": \\\"FFC800\\\",\n" + 
	 		"                            \\\"ratingSignals\\\": 8,\n" + 
	 		"                            \\\"allowMenuUrlEdit\\\": true,\n" + 
	 		"                            \\\"beenHere\\\": {\n" + 
	 		"                                \\\"count\\\": 0,\n" + 
	 		"                                \\\"marked\\\": false,\n" + 
	 		"                                \\\"lastCheckinExpiredAt\\\": 0\n" + 
	 		"                            },\n" + 
	 		"                            \\\"photos\\\": {\n" + 
	 		"                                \\\"count\\\": 0,\n" + 
	 		"                                \\\"groups\\\": []\n" + 
	 		"                            },\n" + 
	 		"                            \\\"hereNow\\\": {\n" + 
	 		"                                \\\"count\\\": 0,\n" + 
	 		"                                \\\"summary\\\": \\\"Nobody here\\\",\n" + 
	 		"                                \\\"groups\\\": []\n" + 
	 		"                            }\n" + 
	 		"                        },\n" + 
	 		"                        \\\"tips\\\": [\n" + 
	 		"                            {\n" + 
	 		"                                \\\"id\\\": \\\"55d7687c498e2452380a6de9\\\",\n" + 
	 		"                                \\\"createdAt\\\": 1440180348,\n" + 
	 		"                                \\\"text\\\": \\\"It has only just opened but the service is very friendly and the location good. Noisy if you're planning to work and no wifi currently.\\\",\n" + 
	 		"                                \\\"type\\\": \\\"user\\\",\n" + 
	 		"                                \\\"canonicalUrl\\\": \\\"https://foursquare.com/item/55d7687c498e2452380a6de9\\\",\n" + 
	 		"                                \\\"logView\\\": true,\n" + 
	 		"                                \\\"agreeCount\\\": 0,\n" + 
	 		"                                \\\"disagreeCount\\\": 0,\n" + 
	 		"                                \\\"todo\\\": {\n" + 
	 		"                                    \\\"count\\\": 0\n" + 
	 		"                                },\n" + 
	 		"                                \\\"user\\\": {\n" + 
	 		"                                    \\\"id\\\": \\\"27495679\\\",\n" + 
	 		"                                    \\\"firstName\\\": \\\"Douglas\\\",\n" + 
	 		"                                    \\\"lastName\\\": \\\"Maitland\\\",\n" + 
	 		"                                    \\\"gender\\\": \\\"male\\\",\n" + 
	 		"                                    \\\"photo\\\": {\n" + 
	 		"                                        \\\"prefix\\\": \\\"https://igx.4sqi.net/img/user/\\\",\n" + 
	 		"                                        \\\"suffix\\\": \\\"/27495679-4R42AWIWPIFVOK50.jpg\\\"\n" + 
	 		"                                    }\n" + 
	 		"                                }\n" + 
	 		"                            }\n" + 
	 		"                        ],\n" + 
	 		"                        \\\"referralId\\\": \\\"e-0-55d74ec9498e0afc9f28e2d8-4\\\"\n" + 
	 		"                    },\n" + 
	 		"                    {\n" + 
	 		"                        \\\"reasons\\\": {\n" + 
	 		"                            \\\"count\\\": 0,\n" + 
	 		"                            \\\"items\\\": [\n" + 
	 		"                                {\n" + 
	 		"                                    \\\"summary\\\": \\\"This spot is popular\\\",\n" + 
	 		"                                    \\\"type\\\": \\\"general\\\",\n" + 
	 		"                                    \\\"reasonName\\\": \\\"globalInteractionReason\\\"\n" + 
	 		"                                }\n" + 
	 		"                            ]\n" + 
	 		"                        },\n" + 
	 		"                        \\\"venue\\\": {\n" + 
	 		"                            \\\"id\\\": \\\"4c1d3c3eb306c928bd3c65b7\\\",\n" + 
	 		"                            \\\"name\\\": \\\"Duke of Wellington\\\",\n" + 
	 		"                            \\\"contact\\\": {\n" + 
	 		"                                \\\"phone\\\": \\\"+441189340456\\\",\n" + 
	 		"                                \\\"formattedPhone\\\": \\\"+44 118 934 0456\\\",\n" + 
	 		"                                \\\"twitter\\\": \\\"brakspearpubs\\\"\n" + 
	 		"                            },\n" + 
	 		"                            \\\"location\\\": {\n" + 
	 		"                                \\\"address\\\": \\\"27 High St\\\",\n" + 
	 		"                                \\\"lat\\\": 51.477411020760805,\n" + 
	 		"                                \\\"lng\\\": -0.868081597753804,\n" + 
	 		"                                \\\"labeledLatLngs\\\": [\n" + 
	 		"                                    {\n" + 
	 		"                                        \\\"label\\\": \\\"display\\\",\n" + 
	 		"                                        \\\"lat\\\": 51.477411020760805,\n" + 
	 		"                                        \\\"lng\\\": -0.868081597753804\n" + 
	 		"                                    }\n" + 
	 		"                                ],\n" + 
	 		"                                \\\"postalCode\\\": \\\"RG10 9AG\\\",\n" + 
	 		"                                \\\"cc\\\": \\\"GB\\\",\n" + 
	 		"                                \\\"city\\\": \\\"Twyford\\\",\n" + 
	 		"                                \\\"country\\\": \\\"United Kingdom\\\",\n" + 
	 		"                                \\\"formattedAddress\\\": [\n" + 
	 		"                                    \\\"27 High St\\\",\n" + 
	 		"                                    \\\"Twyford\\\",\n" + 
	 		"                                    \\\"RG10 9AG\\\",\n" + 
	 		"                                    \\\"United Kingdom\\\"\n" + 
	 		"                                ]\n" + 
	 		"                            },\n" + 
	 		"                            \\\"categories\\\": [\n" + 
	 		"                                {\n" + 
	 		"                                    \\\"id\\\": \\\"4bf58dd8d48988d11b941735\\\",\n" + 
	 		"                                    \\\"name\\\": \\\"Pub\\\",\n" + 
	 		"                                    \\\"pluralName\\\": \\\"Pubs\\\",\n" + 
	 		"                                    \\\"shortName\\\": \\\"Pub\\\",\n" + 
	 		"                                    \\\"icon\\\": {\n" + 
	 		"                                        \\\"prefix\\\": \\\"https://ss3.4sqi.net/img/categories_v2/nightlife/pub_\\\",\n" + 
	 		"                                        \\\"suffix\\\": \\\".png\\\"\n" + 
	 		"                                    },\n" + 
	 		"                                    \\\"primary\\\": true\n" + 
	 		"                                }\n" + 
	 		"                            ],\n" + 
	 		"                            \\\"verified\\\": false,\n" + 
	 		"                            \\\"stats\\\": {\n" + 
	 		"                                \\\"tipCount\\\": 5,\n" + 
	 		"                                \\\"usersCount\\\": 94,\n" + 
	 		"                                \\\"checkinsCount\\\": 631\n" + 
	 		"                            },\n" + 
	 		"                            \\\"price\\\": {\n" + 
	 		"                                \\\"tier\\\": 1,\n" + 
	 		"                                \\\"message\\\": \\\"Cheap\\\",\n" + 
	 		"                                \\\"currency\\\": \\\"£\\\"\n" + 
	 		"                            },\n" + 
	 		"                            \\\"rating\\\": 6.3,\n" + 
	 		"                            \\\"ratingColor\\\": \\\"FFC800\\\",\n" + 
	 		"                            \\\"ratingSignals\\\": 20,\n" + 
	 		"                            \\\"allowMenuUrlEdit\\\": true,\n" + 
	 		"                            \\\"beenHere\\\": {\n" + 
	 		"                                \\\"count\\\": 0,\n" + 
	 		"                                \\\"marked\\\": false,\n" + 
	 		"                                \\\"lastCheckinExpiredAt\\\": 0\n" + 
	 		"                            },\n" + 
	 		"                            \\\"hours\\\": {\n" + 
	 		"                                \\\"isOpen\\\": false,\n" + 
	 		"                                \\\"isLocalHoliday\\\": false\n" + 
	 		"                            },\n" + 
	 		"                            \\\"photos\\\": {\n" + 
	 		"                                \\\"count\\\": 0,\n" + 
	 		"                                \\\"groups\\\": []\n" + 
	 		"                            },\n" + 
	 		"                            \\\"hereNow\\\": {\n" + 
	 		"                                \\\"count\\\": 0,\n" + 
	 		"                                \\\"summary\\\": \\\"Nobody here\\\",\n" + 
	 		"                                \\\"groups\\\": []\n" + 
	 		"                            }\n" + 
	 		"                        },\n" + 
	 		"                        \\\"tips\\\": [\n" + 
	 		"                            {\n" + 
	 		"                                \\\"id\\\": \\\"51fa526f498ed113121823ea\\\",\n" + 
	 		"                                \\\"createdAt\\\": 1375359599,\n" + 
	 		"                                \\\"text\\\": \\\"Lovely beer garden out the back and good pub food!\\\",\n" + 
	 		"                                \\\"type\\\": \\\"user\\\",\n" + 
	 		"                                \\\"canonicalUrl\\\": \\\"https://foursquare.com/item/51fa526f498ed113121823ea\\\",\n" + 
	 		"                                \\\"likes\\\": {\n" + 
	 		"                                    \\\"count\\\": 2,\n" + 
	 		"                                    \\\"groups\\\": [],\n" + 
	 		"                                    \\\"summary\\\": \\\"2 likes\\\"\n" + 
	 		"                                },\n" + 
	 		"                                \\\"logView\\\": true,\n" + 
	 		"                                \\\"agreeCount\\\": 2,\n" + 
	 		"                                \\\"disagreeCount\\\": 0,\n" + 
	 		"                                \\\"todo\\\": {\n" + 
	 		"                                    \\\"count\\\": 0\n" + 
	 		"                                },\n" + 
	 		"                                \\\"user\\\": {\n" + 
	 		"                                    \\\"id\\\": \\\"60905919\\\",\n" + 
	 		"                                    \\\"firstName\\\": \\\"Natalie\\\",\n" + 
	 		"                                    \\\"lastName\\\": \\\"Richardson\\\",\n" + 
	 		"                                    \\\"gender\\\": \\\"female\\\",\n" + 
	 		"                                    \\\"photo\\\": {\n" + 
	 		"                                        \\\"prefix\\\": \\\"https://igx.4sqi.net/img/user/\\\",\n" + 
	 		"                                        \\\"suffix\\\": \\\"/4NBPTXII4EBYLVG5.jpg\\\"\n" + 
	 		"                                    }\n" + 
	 		"                                }\n" + 
	 		"                            }\n" + 
	 		"                        ],\n" + 
	 		"                        \\\"referralId\\\": \\\"e-0-4c1d3c3eb306c928bd3c65b7-5\\\"\n" + 
	 		"                    },\n" + 
	 		"                    {\n" + 
	 		"                        \\\"reasons\\\": {\n" + 
	 		"                            \\\"count\\\": 0,\n" + 
	 		"                            \\\"items\\\": [\n" + 
	 		"                                {\n" + 
	 		"                                    \\\"summary\\\": \\\"This spot is popular\\\",\n" + 
	 		"                                    \\\"type\\\": \\\"general\\\",\n" + 
	 		"                                    \\\"reasonName\\\": \\\"globalInteractionReason\\\"\n" + 
	 		"                                }\n" + 
	 		"                            ]\n" + 
	 		"                        },\n" + 
	 		"                        \\\"venue\\\": {\n" + 
	 		"                            \\\"id\\\": \\\"4f40c419e4b005b534fd322e\\\",\n" + 
	 		"                            \\\"name\\\": \\\"Tesco\\\",\n" + 
	 		"                            \\\"contact\\\": {\n" + 
	 		"                                \\\"twitter\\\": \\\"tesco\\\",\n" + 
	 		"                                \\\"facebook\\\": \\\"112463368812803\\\",\n" + 
	 		"                                \\\"facebookUsername\\\": \\\"tesco\\\",\n" + 
	 		"                                \\\"facebookName\\\": \\\"Tesco\\\"\n" + 
	 		"                            },\n" + 
	 		"                            \\\"location\\\": {\n" + 
	 		"                                \\\"address\\\": \\\"25 London Road\\\",\n" + 
	 		"                                \\\"lat\\\": 51.478764832034024,\n" + 
	 		"                                \\\"lng\\\": -0.8660928292574221,\n" + 
	 		"                                \\\"labeledLatLngs\\\": [\n" + 
	 		"                                    {\n" + 
	 		"                                        \\\"label\\\": \\\"display\\\",\n" + 
	 		"                                        \\\"lat\\\": 51.478764832034024,\n" + 
	 		"                                        \\\"lng\\\": -0.8660928292574221\n" + 
	 		"                                    }\n" + 
	 		"                                ],\n" + 
	 		"                                \\\"postalCode\\\": \\\"RG10 9EH\\\",\n" + 
	 		"                                \\\"cc\\\": \\\"GB\\\",\n" + 
	 		"                                \\\"city\\\": \\\"Twyford\\\",\n" + 
	 		"                                \\\"state\\\": \\\"Berkshire\\\",\n" + 
	 		"                                \\\"country\\\": \\\"United Kingdom\\\",\n" + 
	 		"                                \\\"formattedAddress\\\": [\n" + 
	 		"                                    \\\"25 London Road\\\",\n" + 
	 		"                                    \\\"Twyford\\\",\n" + 
	 		"                                    \\\"Berkshire\\\",\n" + 
	 		"                                    \\\"RG10 9EH\\\",\n" + 
	 		"                                    \\\"United Kingdom\\\"\n" + 
	 		"                                ]\n" + 
	 		"                            },\n" + 
	 		"                            \\\"categories\\\": [\n" + 
	 		"                                {\n" + 
	 		"                                    \\\"id\\\": \\\"4bf58dd8d48988d118951735\\\",\n" + 
	 		"                                    \\\"name\\\": \\\"Grocery Store\\\",\n" + 
	 		"                                    \\\"pluralName\\\": \\\"Grocery Stores\\\",\n" + 
	 		"                                    \\\"shortName\\\": \\\"Grocery Store\\\",\n" + 
	 		"                                    \\\"icon\\\": {\n" + 
	 		"                                        \\\"prefix\\\": \\\"https://ss3.4sqi.net/img/categories_v2/shops/food_grocery_\\\",\n" + 
	 		"                                        \\\"suffix\\\": \\\".png\\\"\n" + 
	 		"                                    },\n" + 
	 		"                                    \\\"primary\\\": true\n" + 
	 		"                                }\n" + 
	 		"                            ],\n" + 
	 		"                            \\\"verified\\\": true,\n" + 
	 		"                            \\\"stats\\\": {\n" + 
	 		"                                \\\"tipCount\\\": 0,\n" + 
	 		"                                \\\"usersCount\\\": 18,\n" + 
	 		"                                \\\"checkinsCount\\\": 172\n" + 
	 		"                            },\n" + 
	 		"                            \\\"url\\\": \\\"http://www.tesco.com\\\",\n" + 
	 		"                            \\\"rating\\\": 5.7,\n" + 
	 		"                            \\\"ratingColor\\\": \\\"FF9600\\\",\n" + 
	 		"                            \\\"ratingSignals\\\": 2,\n" + 
	 		"                            \\\"allowMenuUrlEdit\\\": true,\n" + 
	 		"                            \\\"beenHere\\\": {\n" + 
	 		"                                \\\"count\\\": 0,\n" + 
	 		"                                \\\"marked\\\": false,\n" + 
	 		"                                \\\"lastCheckinExpiredAt\\\": 0\n" + 
	 		"                            },\n" + 
	 		"                            \\\"photos\\\": {\n" + 
	 		"                                \\\"count\\\": 0,\n" + 
	 		"                                \\\"groups\\\": []\n" + 
	 		"                            },\n" + 
	 		"                            \\\"storeId\\\": \\\"5509\\\",\n" + 
	 		"                            \\\"hereNow\\\": {\n" + 
	 		"                                \\\"count\\\": 0,\n" + 
	 		"                                \\\"summary\\\": \\\"Nobody here\\\",\n" + 
	 		"                                \\\"groups\\\": []\n" + 
	 		"                            }\n" + 
	 		"                        },\n" + 
	 		"                        \\\"referralId\\\": \\\"e-0-4f40c419e4b005b534fd322e-6\\\"\n" + 
	 		"                    },\n" + 
	 		"                    {\n" + 
	 		"                        \\\"reasons\\\": {\n" + 
	 		"                            \\\"count\\\": 0,\n" + 
	 		"                            \\\"items\\\": [\n" + 
	 		"                                {\n" + 
	 		"                                    \\\"summary\\\": \\\"This spot is popular\\\",\n" + 
	 		"                                    \\\"type\\\": \\\"general\\\",\n" + 
	 		"                                    \\\"reasonName\\\": \\\"globalInteractionReason\\\"\n" + 
	 		"                                }\n" + 
	 		"                            ]\n" + 
	 		"                        },\n" + 
	 		"                        \\\"venue\\\": {\n" + 
	 		"                            \\\"id\\\": \\\"4c0a04a2bbc676b0293a49d5\\\",\n" + 
	 		"                            \\\"name\\\": \\\"Wyevale Garden Centre\\\",\n" + 
	 		"                            \\\"contact\\\": {\n" + 
	 		"                                \\\"phone\\\": \\\"+441189403933\\\",\n" + 
	 		"                                \\\"formattedPhone\\\": \\\"+44 118 940 3933\\\",\n" + 
	 		"                                \\\"twitter\\\": \\\"gardencentregrp\\\"\n" + 
	 		"                            },\n" + 
	 		"                            \\\"location\\\": {\n" + 
	 		"                                \\\"address\\\": \\\"Floral Mile, Hare Hatch\\\",\n" + 
	 		"                                \\\"lat\\\": 51.49523736284039,\n" + 
	 		"                                \\\"lng\\\": -0.8468754331408679,\n" + 
	 		"                                \\\"labeledLatLngs\\\": [\n" + 
	 		"                                    {\n" + 
	 		"                                        \\\"label\\\": \\\"display\\\",\n" + 
	 		"                                        \\\"lat\\\": 51.49523736284039,\n" + 
	 		"                                        \\\"lng\\\": -0.8468754331408679\n" + 
	 		"                                    }\n" + 
	 		"                                ],\n" + 
	 		"                                \\\"postalCode\\\": \\\"RG10 9SW\\\",\n" + 
	 		"                                \\\"cc\\\": \\\"GB\\\",\n" + 
	 		"                                \\\"city\\\": \\\"Twyford\\\",\n" + 
	 		"                                \\\"state\\\": \\\"Berkshire\\\",\n" + 
	 		"                                \\\"country\\\": \\\"United Kingdom\\\",\n" + 
	 		"                                \\\"formattedAddress\\\": [\n" + 
	 		"                                    \\\"Floral Mile, Hare Hatch\\\",\n" + 
	 		"                                    \\\"Twyford\\\",\n" + 
	 		"                                    \\\"Berkshire\\\",\n" + 
	 		"                                    \\\"RG10 9SW\\\",\n" + 
	 		"                                    \\\"United Kingdom\\\"\n" + 
	 		"                                ]\n" + 
	 		"                            },\n" + 
	 		"                            \\\"categories\\\": [\n" + 
	 		"                                {\n" + 
	 		"                                    \\\"id\\\": \\\"4eb1c0253b7b52c0e1adc2e9\\\",\n" + 
	 		"                                    \\\"name\\\": \\\"Garden Center\\\",\n" + 
	 		"                                    \\\"pluralName\\\": \\\"Garden Centers\\\",\n" + 
	 		"                                    \\\"shortName\\\": \\\"Garden Center\\\",\n" + 
	 		"                                    \\\"icon\\\": {\n" + 
	 		"                                        \\\"prefix\\\": \\\"https://ss3.4sqi.net/img/categories_v2/parks_outdoors/gardencenter_\\\",\n" + 
	 		"                                        \\\"suffix\\\": \\\".png\\\"\n" + 
	 		"                                    },\n" + 
	 		"                                    \\\"primary\\\": true\n" + 
	 		"                                }\n" + 
	 		"                            ],\n" + 
	 		"                            \\\"verified\\\": false,\n" + 
	 		"                            \\\"stats\\\": {\n" + 
	 		"                                \\\"tipCount\\\": 3,\n" + 
	 		"                                \\\"usersCount\\\": 177,\n" + 
	 		"                                \\\"checkinsCount\\\": 388\n" + 
	 		"                            },\n" + 
	 		"                            \\\"url\\\": \\\"http://www.thegardencentregroup.co.uk/garden-centres/wyevale/Wyevale-Hare-Hatch-Garden-Centre/S\\\",\n" + 
	 		"                            \\\"hasMenu\\\": true,\n" + 
	 		"                            \\\"rating\\\": 5.6,\n" + 
	 		"                            \\\"ratingColor\\\": \\\"FF9600\\\",\n" + 
	 		"                            \\\"ratingSignals\\\": 25,\n" + 
	 		"                            \\\"menu\\\": {\n" + 
	 		"                                \\\"type\\\": \\\"Products\\\",\n" + 
	 		"                                \\\"label\\\": \\\"Products\\\",\n" + 
	 		"                                \\\"anchor\\\": \\\"View Products\\\",\n" + 
	 		"                                \\\"url\\\": \\\"https://foursquare.com/v/wyevale-garden-centre/4c0a04a2bbc676b0293a49d5/menu\\\",\n" + 
	 		"                                \\\"mobileUrl\\\": \\\"https://foursquare.com/v/4c0a04a2bbc676b0293a49d5/device_menu\\\"\n" + 
	 		"                            },\n" + 
	 		"                            \\\"allowMenuUrlEdit\\\": true,\n" + 
	 		"                            \\\"beenHere\\\": {\n" + 
	 		"                                \\\"count\\\": 0,\n" + 
	 		"                                \\\"marked\\\": false,\n" + 
	 		"                                \\\"lastCheckinExpiredAt\\\": 0\n" + 
	 		"                            },\n" + 
	 		"                            \\\"hours\\\": {\n" + 
	 		"                                \\\"isOpen\\\": false,\n" + 
	 		"                                \\\"isLocalHoliday\\\": false\n" + 
	 		"                            },\n" + 
	 		"                            \\\"photos\\\": {\n" + 
	 		"                                \\\"count\\\": 0,\n" + 
	 		"                                \\\"groups\\\": []\n" + 
	 		"                            },\n" + 
	 		"                            \\\"hereNow\\\": {\n" + 
	 		"                                \\\"count\\\": 0,\n" + 
	 		"                                \\\"summary\\\": \\\"Nobody here\\\",\n" + 
	 		"                                \\\"groups\\\": []\n" + 
	 		"                            }\n" + 
	 		"                        },\n" + 
	 		"                        \\\"flags\\\": {\n" + 
	 		"                            \\\"outsideRadius\\\": true\n" + 
	 		"                        },\n" + 
	 		"                        \\\"tips\\\": [\n" + 
	 		"                            {\n" + 
	 		"                                \\\"id\\\": \\\"4f8e8663e4b040530aff2586\\\",\n" + 
	 		"                                \\\"createdAt\\\": 1334740579,\n" + 
	 		"                                \\\"text\\\": \\\"Great aquatic centre here\\\",\n" + 
	 		"                                \\\"type\\\": \\\"user\\\",\n" + 
	 		"                                \\\"canonicalUrl\\\": \\\"https://foursquare.com/item/4f8e8663e4b040530aff2586\\\",\n" + 
	 		"                                \\\"logView\\\": true,\n" + 
	 		"                                \\\"agreeCount\\\": 0,\n" + 
	 		"                                \\\"disagreeCount\\\": 0,\n" + 
	 		"                                \\\"todo\\\": {\n" + 
	 		"                                    \\\"count\\\": 0\n" + 
	 		"                                },\n" + 
	 		"                                \\\"user\\\": {\n" + 
	 		"                                    \\\"id\\\": \\\"2115642\\\",\n" + 
	 		"                                    \\\"firstName\\\": \\\"Danny\\\",\n" + 
	 		"                                    \\\"lastName\\\": \\\"Crone\\\",\n" + 
	 		"                                    \\\"gender\\\": \\\"male\\\",\n" + 
	 		"                                    \\\"photo\\\": {\n" + 
	 		"                                        \\\"prefix\\\": \\\"https://igx.4sqi.net/img/user/\\\",\n" + 
	 		"                                        \\\"suffix\\\": \\\"/R0GLC4W21WFVONAQ.jpg\\\"\n" + 
	 		"                                    }\n" + 
	 		"                                }\n" + 
	 		"                            }\n" + 
	 		"                        ],\n" + 
	 		"                        \\\"referralId\\\": \\\"e-0-4c0a04a2bbc676b0293a49d5-7\\\"\n" + 
	 		"                    },\n" + 
	 		"                    {\n" + 
	 		"                        \\\"reasons\\\": {\n" + 
	 		"                            \\\"count\\\": 0,\n" + 
	 		"                            \\\"items\\\": [\n" + 
	 		"                                {\n" + 
	 		"                                    \\\"summary\\\": \\\"This spot is popular\\\",\n" + 
	 		"                                    \\\"type\\\": \\\"general\\\",\n" + 
	 		"                                    \\\"reasonName\\\": \\\"globalInteractionReason\\\"\n" + 
	 		"                                }\n" + 
	 		"                            ]\n" + 
	 		"                        },\n" + 
	 		"                        \\\"venue\\\": {\n" + 
	 		"                            \\\"id\\\": \\\"4edcc8614901c8be2059ec54\\\",\n" + 
	 		"                            \\\"name\\\": \\\"Platform 5\\\",\n" + 
	 		"                            \\\"contact\\\": {},\n" + 
	 		"                            \\\"location\\\": {\n" + 
	 		"                                \\\"address\\\": \\\"Twyford Railway Station\\\",\n" + 
	 		"                                \\\"crossStreet\\\": \\\"Station Rd\\\",\n" + 
	 		"                                \\\"lat\\\": 51.47543490703757,\n" + 
	 		"                                \\\"lng\\\": -0.8637672361650554,\n" + 
	 		"                                \\\"labeledLatLngs\\\": [\n" + 
	 		"                                    {\n" + 
	 		"                                        \\\"label\\\": \\\"display\\\",\n" + 
	 		"                                        \\\"lat\\\": 51.47543490703757,\n" + 
	 		"                                        \\\"lng\\\": -0.8637672361650554\n" + 
	 		"                                    }\n" + 
	 		"                                ],\n" + 
	 		"                                \\\"postalCode\\\": \\\"RG10 9NA\\\",\n" + 
	 		"                                \\\"cc\\\": \\\"GB\\\",\n" + 
	 		"                                \\\"city\\\": \\\"Twyford\\\",\n" + 
	 		"                                \\\"state\\\": \\\"Berkshire\\\",\n" + 
	 		"                                \\\"country\\\": \\\"United Kingdom\\\",\n" + 
	 		"                                \\\"formattedAddress\\\": [\n" + 
	 		"                                    \\\"Twyford Railway Station (Station Rd)\\\",\n" + 
	 		"                                    \\\"Twyford\\\",\n" + 
	 		"                                    \\\"Berkshire\\\",\n" + 
	 		"                                    \\\"RG10 9NA\\\",\n" + 
	 		"                                    \\\"United Kingdom\\\"\n" + 
	 		"                                ]\n" + 
	 		"                            },\n" + 
	 		"                            \\\"categories\\\": [\n" + 
	 		"                                {\n" + 
	 		"                                    \\\"id\\\": \\\"4f4531504b9074f6e4fb0102\\\",\n" + 
	 		"                                    \\\"name\\\": \\\"Platform\\\",\n" + 
	 		"                                    \\\"pluralName\\\": \\\"Platforms\\\",\n" + 
	 		"                                    \\\"shortName\\\": \\\"Platform\\\",\n" + 
	 		"                                    \\\"icon\\\": {\n" + 
	 		"                                        \\\"prefix\\\": \\\"https://ss3.4sqi.net/img/categories_v2/travel/trainstation_\\\",\n" + 
	 		"                                        \\\"suffix\\\": \\\".png\\\"\n" + 
	 		"                                    },\n" + 
	 		"                                    \\\"primary\\\": true\n" + 
	 		"                                }\n" + 
	 		"                            ],\n" + 
	 		"                            \\\"verified\\\": false,\n" + 
	 		"                            \\\"stats\\\": {\n" + 
	 		"                                \\\"tipCount\\\": 2,\n" + 
	 		"                                \\\"usersCount\\\": 33,\n" + 
	 		"                                \\\"checkinsCount\\\": 202\n" + 
	 		"                            },\n" + 
	 		"                            \\\"venueRatingBlacklisted\\\": true,\n" + 
	 		"                            \\\"beenHere\\\": {\n" + 
	 		"                                \\\"count\\\": 0,\n" + 
	 		"                                \\\"marked\\\": false,\n" + 
	 		"                                \\\"lastCheckinExpiredAt\\\": 0\n" + 
	 		"                            },\n" + 
	 		"                            \\\"photos\\\": {\n" + 
	 		"                                \\\"count\\\": 0,\n" + 
	 		"                                \\\"groups\\\": []\n" + 
	 		"                            },\n" + 
	 		"                            \\\"hereNow\\\": {\n" + 
	 		"                                \\\"count\\\": 0,\n" + 
	 		"                                \\\"summary\\\": \\\"Nobody here\\\",\n" + 
	 		"                                \\\"groups\\\": []\n" + 
	 		"                            }\n" + 
	 		"                        },\n" + 
	 		"                        \\\"tips\\\": [\n" + 
	 		"                            {\n" + 
	 		"                                \\\"id\\\": \\\"51363a2ee4b04ed669e10d53\\\",\n" + 
	 		"                                \\\"createdAt\\\": 1362508334,\n" + 
	 		"                                \\\"text\\\": \\\"Don't pick a fight with and of the locals.\\\",\n" + 
	 		"                                \\\"type\\\": \\\"user\\\",\n" + 
	 		"                                \\\"canonicalUrl\\\": \\\"https://foursquare.com/item/51363a2ee4b04ed669e10d53\\\",\n" + 
	 		"                                \\\"logView\\\": true,\n" + 
	 		"                                \\\"agreeCount\\\": 0,\n" + 
	 		"                                \\\"disagreeCount\\\": 0,\n" + 
	 		"                                \\\"todo\\\": {\n" + 
	 		"                                    \\\"count\\\": 0\n" + 
	 		"                                },\n" + 
	 		"                                \\\"user\\\": {\n" + 
	 		"                                    \\\"id\\\": \\\"1896\\\",\n" + 
	 		"                                    \\\"firstName\\\": \\\"Roger\\\",\n" + 
	 		"                                    \\\"lastName\\\": \\\"Nolan\\\",\n" + 
	 		"                                    \\\"gender\\\": \\\"male\\\",\n" + 
	 		"                                    \\\"photo\\\": {\n" + 
	 		"                                        \\\"prefix\\\": \\\"https://igx.4sqi.net/img/user/\\\",\n" + 
	 		"                                        \\\"suffix\\\": \\\"/1896_1245070434.jpg\\\"\n" + 
	 		"                                    }\n" + 
	 		"                                }\n" + 
	 		"                            }\n" + 
	 		"                        ],\n" + 
	 		"                        \\\"referralId\\\": \\\"e-0-4edcc8614901c8be2059ec54-8\\\"\n" + 
	 		"                    },\n" + 
	 		"                    {\n" + 
	 		"                        \\\"reasons\\\": {\n" + 
	 		"                            \\\"count\\\": 0,\n" + 
	 		"                            \\\"items\\\": [\n" + 
	 		"                                {\n" + 
	 		"                                    \\\"summary\\\": \\\"This spot is popular\\\",\n" + 
	 		"                                    \\\"type\\\": \\\"general\\\",\n" + 
	 		"                                    \\\"reasonName\\\": \\\"globalInteractionReason\\\"\n" + 
	 		"                                }\n" + 
	 		"                            ]\n" + 
	 		"                        },\n" + 
	 		"                        \\\"venue\\\": {\n" + 
	 		"                            \\\"id\\\": \\\"4edcc8e15c5c96a20110fa1e\\\",\n" + 
	 		"                            \\\"name\\\": \\\"Platform 2\\\",\n" + 
	 		"                            \\\"contact\\\": {},\n" + 
	 		"                            \\\"location\\\": {\n" + 
	 		"                                \\\"address\\\": \\\"Twyford Railway Station\\\",\n" + 
	 		"                                \\\"crossStreet\\\": \\\"Station Rd\\\",\n" + 
	 		"                                \\\"lat\\\": 51.475337756913305,\n" + 
	 		"                                \\\"lng\\\": -0.8633730284556641,\n" + 
	 		"                                \\\"labeledLatLngs\\\": [\n" + 
	 		"                                    {\n" + 
	 		"                                        \\\"label\\\": \\\"display\\\",\n" + 
	 		"                                        \\\"lat\\\": 51.475337756913305,\n" + 
	 		"                                        \\\"lng\\\": -0.8633730284556641\n" + 
	 		"                                    }\n" + 
	 		"                                ],\n" + 
	 		"                                \\\"postalCode\\\": \\\"RG10 9NA\\\",\n" + 
	 		"                                \\\"cc\\\": \\\"GB\\\",\n" + 
	 		"                                \\\"city\\\": \\\"Twyford\\\",\n" + 
	 		"                                \\\"state\\\": \\\"Berkshire\\\",\n" + 
	 		"                                \\\"country\\\": \\\"United Kingdom\\\",\n" + 
	 		"                                \\\"formattedAddress\\\": [\n" + 
	 		"                                    \\\"Twyford Railway Station (Station Rd)\\\",\n" + 
	 		"                                    \\\"Twyford\\\",\n" + 
	 		"                                    \\\"Berkshire\\\",\n" + 
	 		"                                    \\\"RG10 9NA\\\",\n" + 
	 		"                                    \\\"United Kingdom\\\"\n" + 
	 		"                                ]\n" + 
	 		"                            },\n" + 
	 		"                            \\\"categories\\\": [\n" + 
	 		"                                {\n" + 
	 		"                                    \\\"id\\\": \\\"4f4531504b9074f6e4fb0102\\\",\n" + 
	 		"                                    \\\"name\\\": \\\"Platform\\\",\n" + 
	 		"                                    \\\"pluralName\\\": \\\"Platforms\\\",\n" + 
	 		"                                    \\\"shortName\\\": \\\"Platform\\\",\n" + 
	 		"                                    \\\"icon\\\": {\n" + 
	 		"                                        \\\"prefix\\\": \\\"https://ss3.4sqi.net/img/categories_v2/travel/trainstation_\\\",\n" + 
	 		"                                        \\\"suffix\\\": \\\".png\\\"\n" + 
	 		"                                    },\n" + 
	 		"                                    \\\"primary\\\": true\n" + 
	 		"                                }\n" + 
	 		"                            ],\n" + 
	 		"                            \\\"verified\\\": false,\n" + 
	 		"                            \\\"stats\\\": {\n" + 
	 		"                                \\\"tipCount\\\": 0,\n" + 
	 		"                                \\\"usersCount\\\": 20,\n" + 
	 		"                                \\\"checkinsCount\\\": 95\n" + 
	 		"                            },\n" + 
	 		"                            \\\"venueRatingBlacklisted\\\": true,\n" + 
	 		"                            \\\"beenHere\\\": {\n" + 
	 		"                                \\\"count\\\": 0,\n" + 
	 		"                                \\\"marked\\\": false,\n" + 
	 		"                                \\\"lastCheckinExpiredAt\\\": 0\n" + 
	 		"                            },\n" + 
	 		"                            \\\"photos\\\": {\n" + 
	 		"                                \\\"count\\\": 0,\n" + 
	 		"                                \\\"groups\\\": []\n" + 
	 		"                            },\n" + 
	 		"                            \\\"hereNow\\\": {\n" + 
	 		"                                \\\"count\\\": 0,\n" + 
	 		"                                \\\"summary\\\": \\\"Nobody here\\\",\n" + 
	 		"                                \\\"groups\\\": []\n" + 
	 		"                            }\n" + 
	 		"                        },\n" + 
	 		"                        \\\"referralId\\\": \\\"e-0-4edcc8e15c5c96a20110fa1e-9\\\"\n" + 
	 		"                    }\n" + 
	 		"                ]\n" + 
	 		"            }\n" + 
	 		"        ]\n" + 
	 		"    }\n" + 
	 		"}\"";
  }
}