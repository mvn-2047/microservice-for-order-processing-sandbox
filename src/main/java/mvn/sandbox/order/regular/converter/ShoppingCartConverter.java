package mvn.sandbox.order.regular.converter;

import mvn.sandbox.order.regular.dto.PositionDto;
import mvn.sandbox.order.regular.value.ShoppingCartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ShoppingCartConverter {

    ShoppingCartConverter INSTANCE = Mappers.getMapper(ShoppingCartConverter.class);

    @Mapping(target = "positionSum", source = "sum")
    PositionDto toDto(ShoppingCartItem item);

    List<PositionDto> toDto(List<ShoppingCartItem> itemList);

    @Mapping(target = "sum", source = "positionSum")
    ShoppingCartItem fromDto(PositionDto positionDto);

    List<ShoppingCartItem> fromDto(List<PositionDto> positionDtoList);
}
