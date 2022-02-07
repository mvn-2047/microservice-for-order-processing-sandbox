package mvn.sandbox.order.regular.service;

import mvn.sandbox.order.regular.value.Client;

public interface ClientPriceLevelMatcherService {
    Float getClientRatio(Client client);
}
