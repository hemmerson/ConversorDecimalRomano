import static java.lang.String.join;
import static java.util.Collections.nCopies;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 26/11/2023
 */


public class DecimalToRomano {
    private int decimal;
    private static final int[] DECIMAL =
            {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] ROMANO =
            {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    public DecimalToRomano(){}

    public int getDecimal() {
        return decimal;
    }

    public void setDecimal(int decimal) throws Exception {
        if (decimal <= 0 ) {
            throw new Exception("Não pode ser inserido valor menor ou igual a 0.");
        } else if (decimal >= 4000) {
            throw new Exception("Não pode ser inserido valor maior ou igual a 4000.");
        }
        this.decimal = decimal;
    }

    public String converterEmRomanos() {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < DECIMAL.length; i++) {
            int parteInteira = decimal / DECIMAL[i];
            decimal -= DECIMAL[i] * parteInteira;
            resultado.append(join("", nCopies(parteInteira, ROMANO[i])));
        }
        return "O número decimal " + this.decimal + " em romano é: " + resultado;
    }
}
