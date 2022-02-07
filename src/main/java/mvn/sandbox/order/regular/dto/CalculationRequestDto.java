package mvn.sandbox.order.regular.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import mvn.sandbox.order.regular.constant.PaymentType;

import java.util.List;

@Builder
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CalculationRequestDto {
    List<PositionDto> cart;
    PaymentType payment;
    AddressDto address;
}
