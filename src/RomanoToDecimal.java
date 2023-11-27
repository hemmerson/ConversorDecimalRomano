import java.util.HashMap;
import java.util.Map;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 26/11/2023
 */
public class RomanoToDecimal {

    private String romano;
    private Map<Character, Integer> romanoToDecimal = new HashMap<>();

    public RomanoToDecimal(){
        this.romanoToDecimal.put('I', 1);
        this.romanoToDecimal.put('V', 5);
        this.romanoToDecimal.put('X', 10);
        this.romanoToDecimal.put('L', 50);
        this.romanoToDecimal.put('C', 100);
        this.romanoToDecimal.put('D', 500);
        this.romanoToDecimal.put('M', 1000);
    }

    public String getRomano() {
        return romano;
    }

    public void setRomano(String romano) throws Exception {
        String rMaiusc = romano.toUpperCase();

        if (!isValidRomanNumeral(rMaiusc)) {
            // Caso o número romano não seja válido, você pode tratar isso de alguma forma.
            // Neste exemplo, estou apenas imprimindo uma mensagem e mantendo o valor anterior.
            throw new Exception("Número romano inválido. Verifique as regras.");
        }

        this.romano = rMaiusc;
    }

    private boolean isValidRomanNumeral(String romano) {
        // Adicione aqui as verificações necessárias para as regras do sistema de numeração romano.

        // Regra: Símbolos iguais juntos não podem ter repetições maiores que 3.
        // Regra: Dois símbolos diferentes juntos (com o maior antes do menor) significam soma de valores.
        // Regra: Dois símbolos diferentes juntos (com o menor antes do maior) significam subtração de valores.
        // Adicione mais verificações conforme necessário.

        // Exemplo de verificação para repetições maiores que 3:
        char prevSymbol = ' '; // Símbolo fictício inicial para comparação
        int repeatCount = 0;

        for (char currentSymbol : romano.toCharArray()) {
            if (currentSymbol == prevSymbol) {
                repeatCount++;
                if (repeatCount > 3) {
                    return false; // Repetição maior que 3, número inválido.
                }
            } else {
                repeatCount = 1; // Reinicia a contagem para um novo símbolo
            }

            // Adicione mais verificações conforme necessário.
            // Por exemplo, para garantir que as regras de subtração sejam seguidas.
            // Ou para verificar a ordem correta dos símbolos.

            prevSymbol = currentSymbol;
        }

        return true; // Se chegou até aqui, o número romano é válido.
    }

    public String converterEmDecimal() {
        int decimal = 0;
        int prevValue = 0;

        for (int i = this.romano.length() - 1; i >= 0; i--) {
            char currentSymbol = this.romano.charAt(i);
            int currentValue = this.romanoToDecimal.get(currentSymbol);

            if (currentValue < prevValue) {
                decimal -= currentValue;
            } else {
                decimal += currentValue;
            }
            prevValue = currentValue;
        }
        return ("O número romano " + this.romano + " em decimal é: " + decimal);
    }
}
