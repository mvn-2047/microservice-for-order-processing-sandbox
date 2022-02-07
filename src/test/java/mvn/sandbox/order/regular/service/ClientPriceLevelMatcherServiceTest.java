package mvn.sandbox.order.regular.service;

import mvn.sandbox.order.regular.TestApp;
import mvn.sandbox.order.regular.constant.PaymentType;
import mvn.sandbox.order.regular.value.Client;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@TestApp
class ClientPriceLevelMatcherServiceTest {

    private static final Float BASIC_CLIENT_RATIO = 1.0f;
    private static final Float SPECIFIC_CLIENT_RATIO = 1.2f;
    private static final int ADDRESS_OF_SPECIFIC_CLIENT_ID = 1212121212;
    @Autowired
    ClientPriceLevelMatcherService clientPriceLevelMatcherService;

    @Test
    void shouldProvideCorrectBasicPriceLevelMatching() {
        //given
        var client = Client.builder().id(1).addressId(123).paymentType(PaymentType.CARD).build();

        //when
        var ratio = clientPriceLevelMatcherService.getClientRatio(client);

        //then
        Assertions.assertThat(ratio).isEqualTo(BASIC_CLIENT_RATIO);
    }

    @Test
    void shouldProvideCorrectSpecificPriceLevelMatching() {
        //given
        var client =
                Client.builder().id(1).addressId(ADDRESS_OF_SPECIFIC_CLIENT_ID).paymentType(PaymentType.CARD).build();

        //when
        var ratio = clientPriceLevelMatcherService.getClientRatio(client);

        //then
        Assertions.assertThat(ratio).isEqualTo(SPECIFIC_CLIENT_RATIO);
    }
}
