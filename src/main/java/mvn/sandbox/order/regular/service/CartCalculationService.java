package mvn.sandbox.order.regular.service;

import mvn.sandbox.order.regular.value.Client;
import mvn.sandbox.order.regular.value.ProcessedCart;
import mvn.sandbox.order.regular.value.ShoppingCartItem;

import java.util.List;

public interface CartCalculationService {
    ProcessedCart process(Client client, List<ShoppingCartItem> shoppingCart);
}
