package mvn.sandbox.order.regular.validation;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import mvn.sandbox.order.regular.constant.PaymentType;
import mvn.sandbox.order.regular.exception.InvalidClientException;
import mvn.sandbox.order.regular.value.Client;
import org.springframework.stereotype.Component;

@Component
@SuppressWarnings("java:S3008")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ClientValidation {

    static String INVALID_CLIENT_VALIDATION_ERROR = "This client is invalid";
    static String RESTRICTED_PAYMENT_TYPE = "cash_payment";

    public void validateClient(@NonNull Client client, @NonNull PaymentType paymentType) {
        if (client.getAddressId() == 0 || RESTRICTED_PAYMENT_TYPE.equals(paymentType.getCode())) {
            throw new InvalidClientException(INVALID_CLIENT_VALIDATION_ERROR);
        }
    }
}