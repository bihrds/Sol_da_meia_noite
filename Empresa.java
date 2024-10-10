public class Empresa extends Usuario {
    public Empresa(String nome, String senha) {
        super(nome, senha);
    }

    public void gerenciarSolicitacoes() {
        // Lógica para gerenciar solicitações
        System.out.println("Gerenciando solicitações.");
    }

    public void gerarRelatorioFinanceiro() {
        // Lógica para gerar relatórios
        System.out.println("Relatório financeiro gerado.");
    }
}