package com.postcoder;

import java.util.Arrays;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.client.RestTemplate;

public class RemoteAddressManager implements AddressManager {

    private static final String BASE_URL = "http://ws.postcoder.com";

    private final RestTemplate restTemplate;

    public RemoteAddressManager(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    @Cacheable(value = "ieAddresses", key = "#eircode")
    public List<IeAddress> getIeAddresses(final String apiKey, final String eircode) {
        final String url = BASE_URL + "/pcw/" + apiKey + "/address/ie/" + eircode;
        final IeAddress[] addresses = restTemplate.getForObject(url, IeAddress[].class);

        return Arrays.asList(addresses);
    }

    @Override
    @Cacheable(value = "ukAddresses", key = "#postcode")
    public List<UkAddress> getUkAddresses(final String apiKey, final String postcode) {
        final String url = BASE_URL + "/pcw/" + apiKey + "/address/uk/" + postcode;
        final UkAddress[] addresses = restTemplate.getForObject(url, UkAddress[].class);

        return Arrays.asList(addresses);
    }
}
