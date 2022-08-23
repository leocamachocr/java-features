package ac.ucr.if3000.concurrency.volatileze;

import dev.leocamacho.volatilize.VolatilePrint;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VolatileTest {

    @Test
    public void testTaskRunner() {

        new VolatilePrint.Reader(new OutputTest()).start();
        VolatilePrint.number = 38;
        VolatilePrint.ready = true;
    }

    static class OutputTest extends VolatilePrint.Output {

        @Override
        public void print(int number) {
            Assertions.assertSame(number, 38);
        }
    }
}
