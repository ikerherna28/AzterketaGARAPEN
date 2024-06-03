package garapena.ariketa;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EkuazioEbaztaileaTest {

    @Test
    public void testKalkulatuLehenMailakoa() throws ekuazioEbaztailea.a0Exception {
        double a = 2.0;
        double b = 4.0;
        double expected = -2.0;
        double actual = ekuazioEbaztailea.kalkulatuLehenMailakoa(a, b);
        assertEquals(expected, actual, "Lehen mailako ekuazioaren emaitza ez da zuzena");
    }

    @Test
    public void testKalkulatuBigarrenMailakoa() throws ekuazioEbaztailea.SoluzioGabea {
        double a = 1.0;
        double b = -3.0;
        double c = 2.0;
        double[] expected = {2.0, 1.0};
        double[] actual = ekuazioEbaztailea.kalkulatuBigarrenMailakoa(a, b, c);
        assertArrayEquals(expected, actual, "Bigarren mailako ekuazioaren emaitza ez da zuzena");
    }

    @Test
    public void testKalkulatuLehenMailakoaThrowsException() {
        double a = 0.0;
        double b = 4.0;
        assertThrows(ekuazioEbaztailea.a0Exception.class, () -> ekuazioEbaztailea.kalkulatuLehenMailakoa(a, b));
    }

    @Test
    public void testKalkulatuBigarrenMailakoaThrowsException() {
        double a = 1.0;
        double b = 1.0;
        double c = 1.0;
        assertThrows(ekuazioEbaztailea.SoluzioGabea.class, () -> ekuazioEbaztailea.kalkulatuBigarrenMailakoa(a, b, c));
    }
}
