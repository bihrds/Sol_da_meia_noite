public class Fabricante {
    private String nomeFabricante;

    Fabricante(String nomeFabricante){
        this.nomeFabricante = nomeFabricante;
    }

    @Override
    public String toString(){
        return "Fabricante: " + nomeFabricante;
    }

    public String getNome() {
        return nomeFabricante;
    }
    
}