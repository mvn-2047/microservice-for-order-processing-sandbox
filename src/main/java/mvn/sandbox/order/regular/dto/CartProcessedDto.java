package mvn.sandbox.order.regular.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CartProcessedDto {
    List<PositionDto> cart;
    BigDecimal totalSum;
}
