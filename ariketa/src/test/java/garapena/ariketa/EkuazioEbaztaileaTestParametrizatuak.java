package garapena.ariketa;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

public class EkuazioEbaztaileaTestParametrizatuak {

    @ParameterizedTest
    @MethodSource("lehenMailakoEkuazioData")
    public void testKalkulatuLehenMailakoa(double a, double b, double expected) throws ekuazioEbaztailea.a0Exception {
        double actual = ekuazioEbaztailea.kalkulatuLehenMailakoa(a, b);
        assertEquals(expected, actual, "Lehen mailako ekuazioaren emaitza ez da zuzena");
    }

    @ParameterizedTest
    @MethodSource("bigarrenMailakoEkuazioData")
    public void testKalkulatuBigarrenMailakoa(double a, double b, double c, double[] expected) throws ekuazioEbaztailea.SoluzioGabea {
        double[] actual = ekuazioEbaztailea.kalkulatuBigarrenMailakoa(a, b, c);
        assertArrayEquals(expected, actual, "Bigarren mailako ekuazioaren emaitza ez da zuzena");
    }

    private static Stream<Arguments> lehenMailakoEkuazioData() {
        return Stream.of(
            Arguments.of(2.0, 4.0, -2.0),
            Arguments.of(-3.0, 9.0, 3.0),
            Arguments.of(5.0, 0.0, 0.0)
        );
    }

    private static Stream<Arguments> bigarrenMailakoEkuazioData() {
        return Stream.of(
            Arguments.of(1.0, -3.0, 2.0, new double[]{2.0, 1.0}),
            Arguments.of(1.0, -5.0, 6.0, new double[]{3.0, 2.0}),
            Arguments.of(1.0, -2.0, 1.0, new double[]{1.0})
        );
    }
}
