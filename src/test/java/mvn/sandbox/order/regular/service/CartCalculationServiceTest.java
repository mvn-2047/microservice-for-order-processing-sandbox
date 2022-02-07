package mvn.sandbox.order.regular.service;

import mvn.sandbox.order.regular.TestApp;
import mvn.sandbox.order.regular.constant.PaymentType;
import mvn.sandbox.order.regular.value.Client;
import mvn.sandbox.order.regular.value.ProcessedCart;
import mvn.sandbox.order.regular.value.ShoppingCartItem;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@TestApp
class CartCalculationServiceTest {

    @Autowired
    CartCalculationService cartCalculationService;

    @Test
    void shouldReturnCorrectShoppingCartSum() {
        //given
        var shoppingCart = getBasicCart();
        var client = Client.builder().id(1).addressId(123).paymentType(PaymentType.CARD).build();

        //when
        var sum = cartCalculationService.process(client, shoppingCart);
        var shoppingCartSum = getShoppingCartSum(sum);

        //then
        Assertions.assertThat(sum.getTotalSum()).isEqualByComparingTo(shoppingCartSum);
    }

    private BigDecimal getShoppingCartSum(ProcessedCart sum) {
        return sum.getItems().stream().map(ShoppingCartItem::getSum).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private List<ShoppingCartItem> getBasicCart() {
        List<ShoppingCartItem> list = new ArrayList<>();
        var cart1 = ShoppingCartItem.builder().id(1).quantity(12).sum(BigDecimal.valueOf(1200)).build();
        var cart2 = ShoppingCartItem.builder().id(2).quantity(24).sum(BigDecimal.valueOf(3600)).build();
        list.add(cart1);
        list.add(cart2);
        return list;
    }
}
