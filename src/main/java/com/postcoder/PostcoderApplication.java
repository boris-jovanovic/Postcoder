package com.postcoder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

@EnableCaching
@SpringBootApplication
public class PostcoderApplication {

    public static void main(final String[] args) {
        SpringApplication.run(PostcoderApplication.class, args);
    }

    @Bean("restTemplate")
    @Profile("prod")
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean("addressManager")
    @Profile({ "test", "prod" })
    public AddressManager postcoderManager(final RestTemplate restTemplate) {
        return new RemoteAddressManager(restTemplate);
    }

    @Bean("addressManager")
    @Profile("dev")
    public AddressManager postcoderManagerStub() {
        return new AddressManagerStub();
    }

}
