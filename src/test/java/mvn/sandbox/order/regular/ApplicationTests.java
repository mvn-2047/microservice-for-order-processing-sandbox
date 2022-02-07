package mvn.sandbox.order.regular;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@TestApp
class ApplicationTests {

    public static final String HELLO_WORLD_STATEMENT = "Hello World";

    @Test
    void contextLoads() {
        Assertions.assertThatNoException().isThrownBy(() -> {
            System.out.println(HELLO_WORLD_STATEMENT);
        });
    }
}
