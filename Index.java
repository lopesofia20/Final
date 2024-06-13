import java.time.LocalDate;
import java.util.Scanner;

public class Index {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Receber Doação");
            System.out.println("2. Calcular Total de Doações");
            System.out.println("3. Listar Doações");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();
            scanner.nextLine(); 

            if (escolha == 1) {
                System.out.print("Tipo de Doação: ");
                String tipo = scanner.nextLine();
                System.out.print("Quantidade: ");
                double quantidade = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Data (AAAA-MM-DD): ");
                LocalDate data = LocalDate.parse(scanner.nextLine());
                sistema.adicionarDoacao(tipo, quantidade, data);
                System.out.println("Doação adicionada com sucesso!");
            } else if (escolha == 2) {
                double total = sistema.calcularTotalDoacoes();
                System.out.println("Total de Doações: " + total);
            } else if (escolha == 3) {
                for (Doacao doacao : sistema.getDoacoes()) {
                    System.out.println(doacao);
                }
            } else if (escolha == 4) {
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }
        scanner.close();
    }
}
