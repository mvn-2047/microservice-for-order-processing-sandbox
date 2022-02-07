package mvn.sandbox.order.regular.service;

import mvn.sandbox.order.regular.TestApp;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Random;

@TestApp
class PriceItemProviderServiceTest {

    private static final BigDecimal MAX_ITEM_PRICE = BigDecimal.valueOf(1000000);
    private static final BigDecimal MIN_ITEM_PRICE = BigDecimal.valueOf(1);
    @Autowired
    PriceItemProviderService priceItemProviderService;

    @Test
    void shouldReturnItemPriceInSpecificRange() {
        //given
        var randomItemId = new Random().nextInt();

        //when
        var price = priceItemProviderService.getPriceForItem(randomItemId);

        //then
        Assertions.assertThat(price).isGreaterThanOrEqualTo(MIN_ITEM_PRICE).isLessThanOrEqualTo(MAX_ITEM_PRICE);
    }
}