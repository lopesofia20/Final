import java.time.LocalDate;

public class Doacao {
    private String tipo;
    private double quantidade;
    private LocalDate data;

    public Doacao(String tipo, double quantidade, LocalDate data) {
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public LocalDate getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Doacao{" +
                "tipo='" + tipo + '\'' +
                ", quantidade=" + quantidade +
                ", data=" + data +
                '}';
    }
}
