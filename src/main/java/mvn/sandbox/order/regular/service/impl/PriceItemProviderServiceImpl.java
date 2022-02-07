package mvn.sandbox.order.regular.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import mvn.sandbox.order.regular.service.PriceItemProviderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PriceItemProviderServiceImpl implements PriceItemProviderService {

    RestTemplate restTemplate;

    @NonFinal
    @SuppressWarnings("java:S116")
    @Value("${price.item.service.provider:url}")
    String PRICE_ITEM_SERVICE_PROVIDER_URL;

    private static BigDecimal generateRandomBigDecimalFromRange(BigDecimal max) {
        return BigDecimal.ONE.add(BigDecimal.valueOf(Math.random()).multiply(max.subtract(BigDecimal.ONE)));
    }

    @Cacheable(value = "prices", cacheManager = "priceCachingManager", sync = true)
    public BigDecimal getPriceForItem(int itemId) {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
        return requestRestApi(itemId);
    }

    private BigDecimal requestRestApi(int itemId) {
        log.info("url: " + PRICE_ITEM_SERVICE_PROVIDER_URL);
        log.info("itemId: " + itemId);
        return generateRandomBigDecimalFromRange(BigDecimal.valueOf(1000000));
    }
}
