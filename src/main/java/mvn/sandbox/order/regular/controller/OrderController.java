package mvn.sandbox.order.regular.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import mvn.sandbox.order.regular.converter.AddressConverter;
import mvn.sandbox.order.regular.converter.ProcessedCartConverter;
import mvn.sandbox.order.regular.converter.ShoppingCartConverter;
import mvn.sandbox.order.regular.dto.CalculationRequestDto;
import mvn.sandbox.order.regular.dto.CartProcessedDto;
import mvn.sandbox.order.regular.service.CartCalculationService;
import mvn.sandbox.order.regular.validation.ClientValidation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/order")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class OrderController {

    ShoppingCartConverter shoppingCartConverter = ShoppingCartConverter.INSTANCE;
    ProcessedCartConverter processedCartConverter = ProcessedCartConverter.INSTANCE;
    AddressConverter clientConverter = AddressConverter.INSTANCE;
    CartCalculationService cartCalculationService;
    ClientValidation clientValidation;

    @PostMapping("/calculate")
    public CartProcessedDto calculateShoppingCart(@RequestBody CalculationRequestDto request) {
        var client = clientConverter.fromDto(request.getAddress());
        var shoppingCart = shoppingCartConverter.fromDto(request.getCart());

        clientValidation.validateClient(client, request.getPayment());

        var processedCart = cartCalculationService.process(client, shoppingCart);
        return processedCartConverter.toDto(processedCart);
    }
}