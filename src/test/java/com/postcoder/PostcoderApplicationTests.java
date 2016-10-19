package com.postcoder;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PostcoderApplication.class, webEnvironment = WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
public class PostcoderApplicationTests {

    private static final String REMOTE_BASE_URL = "http://ws.postcoder.com";

    private static final String BASE_URL = "http://localhost:8080";

    private static final String API_KEY = "api-key";

    @MockBean
    private RestTemplate restTemplate;

    @Autowired
    private AddressManager addressManager;

    private final RestTemplate restTmp = new RestTemplate();

    @Test
    public void getAddressesTest() {
        final IeAddress ieAddress1 = new IeAddress();
        ieAddress1.setSummaryline("Address1");
        final IeAddress ieAddress2 = new IeAddress();
        ieAddress2.setSummaryline("Address2");
        final IeAddress[] ieAdressess = new IeAddress[] { ieAddress1, ieAddress2 };

        when(restTemplate.getForObject(REMOTE_BASE_URL + "/pcw/" + 1 + "/address/ie/" + "test", IeAddress[].class)).thenReturn(ieAdressess);
        final List<IeAddress> ieAddressesFromCache = addressManager.getIeAddresses("1", "test");
        assertNotNull(ieAddressesFromCache);
        assertTrue(Arrays.asList(ieAdressess).size() == ieAddressesFromCache.size());

        final UkAddress ukAddress1 = new UkAddress();
        ukAddress1.setStreet("Street1");
        final UkAddress ukAddress2 = new UkAddress();
        ukAddress2.setStreet("Street2");
        final UkAddress[] ukAdressess = new UkAddress[] { ukAddress1, ukAddress2 };

        when(restTemplate.getForObject(REMOTE_BASE_URL + "/pcw/" + 1 + "/address/uk/" + "test", UkAddress[].class)).thenReturn(ukAdressess);
        final List<UkAddress> ukAddressesFromCache = addressManager.getUkAddresses("1", "test");
        assertNotNull(ukAddressesFromCache);
        assertTrue(Arrays.asList(ukAdressess).size() == ukAddressesFromCache.size());
    }

    @Test
    public void getAddressesControllerTest() {
        final String eircode = "test";
        final String ieUrl = BASE_URL + "/pcw/{apiKey}/address/ie/{eircode}";

        final IeAddress[] ieAddresses = restTmp.getForObject(ieUrl, IeAddress[].class, API_KEY, eircode);
        assertNotNull(ieAddresses);

        final String postcode = "test";
        final String ukUrl = BASE_URL + "/pcw/{apiKey}/address/uk/{postcode}";

        final UkAddress[] ukAddresses = restTmp.getForObject(ukUrl, UkAddress[].class, API_KEY, postcode);
        assertNotNull(ukAddresses);
    }

}
