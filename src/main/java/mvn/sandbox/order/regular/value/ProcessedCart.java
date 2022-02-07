package mvn.sandbox.order.regular.value;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ProcessedCart {
    List<ShoppingCartItem> items;
    BigDecimal totalSum;
}
