import java.util.Scanner;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 26/11/2023
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        menu();
        int opc = scanner.nextInt();
        while(opc != 0) {
            if (opc == 1) {
                DecimalToRomano dtr = new DecimalToRomano();
                System.out.println("Digite o valor em decimal para ser convertido: ");
                int decimal = scanner.nextInt();
                dtr.setDecimal(decimal);
                System.out.println(dtr.converterEmRomanos());
            }
            else if (opc == 2){
                RomanoToDecimal rtd = new RomanoToDecimal();
                System.out.println("Digite o valor em romano para ser convertido: ");
                String romano = scanner.next();
                rtd.setRomano(romano);
                System.out.println(rtd.converterEmDecimal());
            }
            else{
                System.out.println("Opção Inválida!");
            }
            menu();
            opc = scanner.nextInt();
        }
    }

    public static void menu(){
        System.out.println("========================================");
        System.out.println("== 1 - Converter Decimal para Romano  ==");
        System.out.println("== 2 - Converter Romano para Decimal  ==");
        System.out.println("== 0 - Sair                           ==");
        System.out.println("========================================");
    }
}