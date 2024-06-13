import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private List<Doacao> doacoes;
    private final String filePath = "doacoes.txt";

    public Sistema() {
        this.doacoes = new ArrayList<>();
        carregarDoacoes();
    }

    public void adicionarDoacao(String tipo, double quantidade, LocalDate data) {
        Doacao doacao = new Doacao(tipo, quantidade, data);
        doacoes.add(doacao);
        salvarDoacoes();
    }

    public double calcularTotalDoacoes() {
        return doacoes.stream().mapToDouble(Doacao::getQuantidade).sum();
    }

    public void salvarDoacoes() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Doacao doacao : doacoes) {
                writer.write(doacao.getTipo() + "," + doacao.getQuantidade() + "," + doacao.getData() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar doações: " + e.getMessage());
        }
    }

    public void carregarDoacoes() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                String tipo = partes[0];
                double quantidade = Double.parseDouble(partes[1]);
                LocalDate data = LocalDate.parse(partes[2]);
                doacoes.add(new Doacao(tipo, quantidade, data));
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar doações: " + e.getMessage());
        }
    }

    public List<Doacao> getDoacoes() {
        return doacoes;
    }
}
