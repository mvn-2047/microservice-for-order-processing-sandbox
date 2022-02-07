package mvn.sandbox.order.regular;

import org.springframework.boot.test.context.SpringBootTest;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@SpringBootTest
public @interface TestApp {
}
