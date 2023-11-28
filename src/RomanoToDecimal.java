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

        if (repeteMaisQueTres(rMaiusc))
            throw new Exception("Número romano inválido. Algum Caracter se repete mais que três vezes.");

        if (caracteresInvalidos(rMaiusc))
            throw new Exception("Número romano inválido. O valor possui caracteres Inválidos.");

        if (regraDoI(rMaiusc))
            throw new Exception("Número romano inválido. O caracter 'I' está em um local proibido.");

        if (regraDoX(rMaiusc))
            throw new Exception("Número romano inválido. O caracter 'X' está em um local proibido.");

        if (regraDoL(rMaiusc))
            throw new Exception("Número romano inválido. O caracter 'L' está em um local proibido.");

        if (repeteMenor(rMaiusc))
            throw new Exception("Número romano inválido. Contém caracteres repetidos antes de um valor maior.");

        this.romano = rMaiusc;
    }

    private boolean repeteMaisQueTres(String romano) {
        // Regra: Símbolos iguais juntos não podem ter repetições maiores que 3.
        // Verificação para repetições maiores que 3:

        char prevSymbol = ' '; // Símbolo fictício inicial para comparação
        int repeatCount = 0;

        for (char currentSymbol : romano.toCharArray()) {
            if (currentSymbol == prevSymbol) {
                repeatCount++;
                if (repeatCount > 3) {
                    return true; // Repetição maior que 3, número inválido.
                }
            } else {
                repeatCount = 1; // Reinicia a contagem para um novo símbolo
            }
            prevSymbol = currentSymbol;
        }
        return false; // Se chegou até aqui, o número romano é válido.
    }

    private boolean caracteresInvalidos(String romano){
        for (char letra: romano.toCharArray()) {
            if (letra != 'M' && letra != 'D' && letra != 'C' &&
                    letra != 'L' && letra != 'X' && letra != 'V' && letra != 'I'){
                return true;
            }
        }
        return false;
    }

    private boolean regraDoI(String romano){
        char laux = ' ';
        for (char letra: romano.toCharArray()) {
            if (letra == 'I'){
                laux = letra;
            }
            if (laux == 'I' && (letra == 'M' || letra == 'D' || letra == 'C' || letra == 'L' )){
                return true;
            }
        }
        return false;
    }

    private boolean regraDoX(String romano){
        char laux = ' ';
        for (char letra: romano.toCharArray()) {
            if (letra == 'X'){
                laux = letra;
            }
            if (laux == 'X' && (letra == 'M' || letra == 'D' )){
                return true;
            }
        }
        return false;
    }

    private boolean regraDoL(String romano){
        char laux = ' ';
        for (char letra: romano.toCharArray()) {
            if (letra == 'L'){
                laux = letra;
            }
            if (laux == 'L' && (letra == 'M' || letra == 'D' || letra == 'C' )){
                return true;
            }
        }
        return false;
    }

    private boolean repeteMenor(String romano){
        int tam = romano.length();
        int repete = 0;

        for (int i = 1; i < tam; i++){
            char anterior = romano.charAt(i - 1);
            char atual = romano.charAt(i);
            if (repete > 0 && (this.romanoToDecimal.get(anterior) < this.romanoToDecimal.get(atual))){
                return true;
            }
            if (anterior == atual) {
                repete++;
            }
            else {
                repete = 0;
            }
        }
        return false;
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
