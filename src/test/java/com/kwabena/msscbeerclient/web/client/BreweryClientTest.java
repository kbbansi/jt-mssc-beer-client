package com.kwabena.msscbeerclient.web.client;

import com.kwabena.msscbeerclient.web.model.BeerDto;
import com.kwabena.msscbeerclient.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    @DisplayName("Should get beer by id")
    void getBeerById() {
        BeerDto dto = client.getBeerById(UUID.randomUUID());
        log.info("Got this Beer: [{}]", dto);
        assertNotNull(dto);
    }

    @Test
    @DisplayName("Should save new beer")
    void saveNewBeer() {
        BeerDto beerDto = BeerDto.builder().beerName("NewBeer").build();

        URI uri = client.saveNewBeer(beerDto);
        log.info("Resource Location: [{}]", uri);
        assertNotNull(uri);
    }

    @Test
    @DisplayName("Should update beer")
    void updateBeer() {
        BeerDto beerDto = BeerDto.builder().beerName("NewBeer").build();
        client.updateBeer(UUID.randomUUID(), beerDto);
    }

    @Test
    @DisplayName("Should delete beer")
    void deleteBeer() {
        client.deleteBeer(UUID.randomUUID());
    }

    @Test
    @DisplayName("Should save new customer")
    void saveNewCustomer() {
        CustomerDto customerDto = CustomerDto.builder().name("Knaomi").build();
        URI uri = client.saveNewCustomer(customerDto);
        log.info("Resource Location: [{}]", uri);
        assertNotNull(uri, "An Error Occurred");
    }

    @Test
    @DisplayName("Should update customer")
    void updateCustomer() {
        CustomerDto customerDto = CustomerDto.builder().name("Naomi").build();
        client.updateCustomer(UUID.randomUUID(), customerDto);
    }

    @Test
    @DisplayName("Should get customer by id")
    void getCustomerById() {
        CustomerDto customerDto = client.getCustomerById(UUID.randomUUID());
        assertNotNull(customerDto, "An Error Occurred");
    }

    @Test
    @DisplayName("Should delete customer")
    void deleteCustomer() {
        client.deleteCustomer(UUID.randomUUID());
    }
}