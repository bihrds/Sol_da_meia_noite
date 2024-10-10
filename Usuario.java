public class Usuario {
    protected String nomeUsuario;
    protected String senhaUsuario;
 
    public Usuario(String var1, String var2) {
       this.nomeUsuario = var1;
       this.senhaUsuario = var2;
    }
 
    public String getNome() {
       return this.nomeUsuario;
    }
 
    public String getSenha() {
       return this.senhaUsuario;
    }
 }
 