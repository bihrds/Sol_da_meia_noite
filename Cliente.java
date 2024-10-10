public class Cliente extends Usuario {
    private String endereco;
    private String telefone;
    private String cpf;

    public Cliente(String nome, String senha, String endereco, String telefone, String cpf) {
        super(nome, senha);
        this.endereco = endereco;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCpf(){
        return cpf;
    }

    public void solicitarProjeto() {
        // Lógica para solicitar projeto
        System.out.println("Projeto solicitado.");
    }

    @Override
    public String toString() {
        return "Cliente: " + getNome() + ", Endereço: " + endereco + ", Telefone: " + telefone;
    }
}