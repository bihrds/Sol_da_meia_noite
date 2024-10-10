public class Inversor {
    private String modelo;
    private double potencia;
    private double preco;
    private Fabricante fabricante;

    Inversor (String modelo, double potencia, double preco, Fabricante fabricante){
        this.modelo = modelo;
        this.potencia = potencia;
        this.preco = preco;
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public double getPotencia() {
        return potencia;
    }

    public double getPreco() {
        return preco;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    @Override
    public String toString() {
        return ": " + modelo + ", Potência: " + potencia + "W, Preço: " + preco + ", Fabricante: " + fabricante.getNome();
    }
}
