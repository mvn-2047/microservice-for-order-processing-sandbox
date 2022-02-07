package mvn.sandbox.order.regular.value;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Builder
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ShoppingCartItem {
    int id;
    int quantity;
    BigDecimal sum;
}
