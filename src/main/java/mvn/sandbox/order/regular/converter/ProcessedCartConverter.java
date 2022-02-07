package mvn.sandbox.order.regular.converter;

import mvn.sandbox.order.regular.dto.CartProcessedDto;
import mvn.sandbox.order.regular.value.ProcessedCart;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {ShoppingCartConverter.class})
public interface ProcessedCartConverter {
    ProcessedCartConverter INSTANCE = Mappers.getMapper(ProcessedCartConverter.class);

    @Mapping(target = "cart", source = "items")
    CartProcessedDto toDto(ProcessedCart processedCart);
}
