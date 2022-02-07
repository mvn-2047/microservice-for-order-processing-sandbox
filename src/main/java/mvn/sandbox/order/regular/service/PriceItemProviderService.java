package mvn.sandbox.order.regular.service;

import java.math.BigDecimal;

public interface PriceItemProviderService {
    BigDecimal getPriceForItem(int itemId);
}
