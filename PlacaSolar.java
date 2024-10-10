public class PlacaSolar {
    private String modelo ;
    private double capacidade;
    private double preco;
    private Fabricante fabricante;

    PlacaSolar(String modelo, double capacidade, double preco, Fabricante fabricante){
        this.modelo = modelo;
        this.capacidade = capacidade;
        this.preco = preco;
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public double getCapacidade() {
        return capacidade;
    }

    public double getPreco() {
        return preco;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    @Override
    public String toString() {
        return "Solar: " + modelo + ", Capacidade: " + capacidade + "W, Preço: " + preco + ", Fabricante: " + fabricante.getNome();
    }
}