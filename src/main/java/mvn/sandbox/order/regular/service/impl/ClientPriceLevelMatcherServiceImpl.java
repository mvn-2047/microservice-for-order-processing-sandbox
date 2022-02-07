package mvn.sandbox.order.regular.service.impl;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import mvn.sandbox.order.regular.service.ClientPriceLevelMatcherService;
import mvn.sandbox.order.regular.value.Client;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@SuppressWarnings("java:S3008")
public class ClientPriceLevelMatcherServiceImpl implements ClientPriceLevelMatcherService {

    static Float BASIC_CLIENT_RATIO = 1.0f;
    static Float SPECIFIC_CLIENT_RATIO = 1.2f;
    static int ADDRESS_OF_SPECIFIC_CLIENT_ID = 1212121212;

    public Float getClientRatio(@NonNull Client client) {
        Objects.requireNonNull(client);
        if (client.getAddressId() == ADDRESS_OF_SPECIFIC_CLIENT_ID) {
            return SPECIFIC_CLIENT_RATIO;
        }
        return BASIC_CLIENT_RATIO;
    }
}
