package mvn.sandbox.order.regular.service.impl;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import mvn.sandbox.order.regular.service.CartCalculationService;
import mvn.sandbox.order.regular.service.ClientPriceLevelMatcherService;
import mvn.sandbox.order.regular.service.PriceItemProviderService;
import mvn.sandbox.order.regular.value.Client;
import mvn.sandbox.order.regular.value.ProcessedCart;
import mvn.sandbox.order.regular.value.ShoppingCartItem;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CartCalculationServiceImpl implements CartCalculationService {

    PriceItemProviderService priceItemProvidingService;
    ClientPriceLevelMatcherService clientPriceLevelMatcherService;

    @NonNull
    public ProcessedCart process(@NonNull Client client, @NonNull List<ShoppingCartItem> shoppingCart) {
        var clientPriceRatio = clientPriceLevelMatcherService.getClientRatio(client);
        var shoppingCartItemList = getShoppingCartItems(shoppingCart, clientPriceRatio);
        var cartCheckoutSum = cartTotalSum(shoppingCartItemList).setScale(2, RoundingMode.UP);
        return ProcessedCart.builder().items(shoppingCartItemList).totalSum(cartCheckoutSum).build();
    }

    @NonNull
    private BigDecimal cartTotalSum(@NonNull List<ShoppingCartItem> shoppingCartItemList) {
        return shoppingCartItemList.stream().map(ShoppingCartItem::getSum).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @NonNull
    private List<ShoppingCartItem> getShoppingCartItems(@NonNull List<ShoppingCartItem> shoppingCart,
                                                        @NonNull Float clientPriceRatio) {
        return shoppingCart.stream().map(i -> {
            var price =
                    priceItemProvidingService.getPriceForItem(i.getId()).multiply(BigDecimal.valueOf(clientPriceRatio));
            var totalSum = price.multiply(BigDecimal.valueOf(i.getQuantity()));
            return ShoppingCartItem.builder().id(i.getId()).quantity(i.getQuantity())
                    .sum(totalSum.setScale(2, RoundingMode.UP)).build();
        }).filter(i -> i.getSum().compareTo(BigDecimal.ZERO) > 0).collect(Collectors.toList());
    }
}
