package mvn.sandbox.order.regular.converter;

import mvn.sandbox.order.regular.dto.AddressDto;
import mvn.sandbox.order.regular.value.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressConverter {

    AddressConverter INSTANCE = Mappers.getMapper(AddressConverter.class);

    @Mapping(target = "id", ignore = true)
    Client fromDto(AddressDto addressDto);
}
