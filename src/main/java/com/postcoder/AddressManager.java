package com.postcoder;

import java.util.List;

public interface AddressManager {

    List<IeAddress> getIeAddresses(String apiKey, String eircode);

    List<UkAddress> getUkAddresses(String apiKey, String postcode);
}
