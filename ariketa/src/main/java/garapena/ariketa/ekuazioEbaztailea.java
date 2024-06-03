package garapena.ariketa;
import java.util.Scanner;

/**
 * Ekuazioak ebazteko programa.
 * Lehen mailakoak: ax+b = 0 eta bigarren mailakoak: ax^2+bx+c=0.
 */

public class ekuazioEbaztailea {
    /**
     * a0Exception salbuespena definitzen du. 'a' koefizientea 0 denean jaurtitzen da.
     */
    @SuppressWarnings("serial")
    public static class a0Exception extends Exception {
        /**
         * a0Exception konstruktorea.
         * @param s Salbuespen mezuaren deskribapena.
         */
        public a0Exception(String s) {
            super(s);
        }
    }

    /**
     * SoluzioGabea salbuespena definitzen du. Ekuazioak soluzio errealik ez duenean jaurtitzen da.
     */
    @SuppressWarnings("serial")
    public static class SoluzioGabea extends Exception {
        /**
         * SoluzioGabea konstruktorea.
         * @param s Salbuespen mezuaren deskribapena.
         */
        public SoluzioGabea(String s) {
            super(s);
        }
    }

    /**
     * Programa nagusia. Ekuazio mota aukeratu eta dagokion metodoa deitzen du.
     * @param args Programaren sarrera argumentuak.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Programa honek ekuazioak ebazten ditu. Lehen mailakoak: ax+b = 0 eta bigarren mailakoak: ax^2+bx+c=0");
        System.out.println("Zein ekuazio mota nahi duzu ebatzi (0->lehen mailakoa | 1-> bigarren mailakoa)");

        int m = scanner.nextInt();
        if (m == 0) {
            ebatziLehenMailakoa(scanner);
        } else {
            ebatziBigarrenMailakoa(scanner);
        }
        scanner.close();
    }

    /**
     * Lehen mailako ekuazioa ebazten du.
     * @param scanner Sarrera datuak eskaneatzen dituen Scanner objektua.
     */
    public static void ebatziLehenMailakoa(Scanner scanner) {
        System.out.println("a koefizientea sartu:");
        double a = scanner.nextDouble();
        System.out.println("b koefizientea sartu:");
        double b = scanner.nextDouble();
        try {
            double emaitza = kalkulatuLehenMailakoa(a, b);
            System.out.println("Emaitza da:");
            System.out.println(emaitza);
        } catch (a0Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Bigarren mailako ekuazioa ebazten du.
     * @param scanner Sarrera datuak eskaneatzen dituen Scanner objektua.
     */
    public static void ebatziBigarrenMailakoa(Scanner scanner) {
        System.out.println("a koefizientea sartu:");
        double a = scanner.nextDouble();
        System.out.println("b koefizientea sartu:");
        double b = scanner.nextDouble();
        System.out.println("c koefizientea sartu:");
        double c = scanner.nextDouble();
        if (a == 0) {
            System.out.println("Hori egiteko lehen mailako ekuazioa aukeratu");
        } else {
            try {
                double[] emaitza = kalkulatuBigarrenMailakoa(a, b, c);
                System.out.println("Emaitza(k) d(ir)a:");
                for (double v : emaitza) {
                    System.out.println(v);
                }
            } catch (SoluzioGabea e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Lehen mailako ekuazioa kalkulatzen du.
     * @param a 'a' koefizientea.
     * @param b 'b' koefizientea.
     * @return Ekuazioaren emaitza.
     * @throws a0Exception 'a' koefizientea 0 bada.
     */
    public static double kalkulatuLehenMailakoa(double a, double b) throws a0Exception {
        if (a == 0) {
            throw new a0Exception("a koefizientea ezin da 0 izan");
        } else {
            return -b / a;
        }
    }

    /**
     * Bigarren mailako ekuazioa kalkulatzen du.
     * @param a 'a' koefizientea.
     * @param b 'b' koefizientea.
     * @param c 'c' koefizientea.
     * @return Ekuazioaren emaitzak array batean.
     * @throws SoluzioGabea Ekuazioak soluzio errealik ez badu.
     */
    public static double[] kalkulatuBigarrenMailakoa(double a, double b, double c) throws SoluzioGabea {
        double diskriminatzailea = b * b - 4 * a * c;
        if (diskriminatzailea > 0) {
            double ema1 = (-b + Math.sqrt(diskriminatzailea)) / (2 * a);
            double ema2 = (-b - Math.sqrt(diskriminatzailea)) / (2 * a);
            return new double[]{ema1, ema2};
        } else if (diskriminatzailea == 0) {
            double ema = -b / (2 * a);
            return new double[]{ema};
        } else {
            throw new SoluzioGabea("Ekuazioak ez du soluzio errealik");
        }
    }
}
