package com.postcoder;

import java.util.Arrays;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;

public class AddressManagerStub implements AddressManager {

    @Override
    @Cacheable(value = "ieAddresses", key = "#eircode")
    public List<IeAddress> getIeAddresses(final String apiKey, final String eircode) {
        final IeAddress ieAddress1 = new IeAddress();
        ieAddress1.setSummaryline("Addressline1");
        final IeAddress ieAddress2 = new IeAddress();
        ieAddress2.setSummaryline("Addressline1");
        final IeAddress[] ieAdressess = new IeAddress[] { ieAddress1, ieAddress2 };
        return Arrays.asList(ieAdressess);
    }

    @Override
    @Cacheable(value = "ukAddresses", key = "#postcode")
    public List<UkAddress> getUkAddresses(final String apiKey, final String postcode) {
        final UkAddress ukAddress1 = new UkAddress();
        ukAddress1.setStreet("Street1");
        final UkAddress ukAddress2 = new UkAddress();
        ukAddress2.setStreet("Street2");
        final UkAddress[] ukAdressess = new UkAddress[] { ukAddress1, ukAddress2 };
        return Arrays.asList(ukAdressess);
    }

}
