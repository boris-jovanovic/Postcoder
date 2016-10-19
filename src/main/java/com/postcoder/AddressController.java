package com.postcoder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

    private final AddressManager addressManager;

    @Autowired
    public AddressController(final AddressManager addressManager) {
        this.addressManager = addressManager;
    }

    @RequestMapping("/pcw/{apiKey}/address/ie/{eircode}")
    public @ResponseBody List<IeAddress> getIeAddresses(@PathVariable final String apiKey, @PathVariable final String eircode) {
        return addressManager.getIeAddresses(apiKey, eircode);
    }

    @RequestMapping("/pcw/{apiKey}/address/uk/{postcode}")
    public @ResponseBody List<UkAddress> getUkAddresses(@PathVariable final String apiKey, @PathVariable final String postcode) {
        return addressManager.getUkAddresses(apiKey, postcode);
    }
}
