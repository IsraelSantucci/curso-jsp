package beans;

public class Login {
	
	private String usuario;
	private String senha;
	
	public boolean validarLoginSenha(String usuario, String senha) {
		
		if(usuario.equalsIgnoreCase("admin")&& senha.equalsIgnoreCase("admin")) {
			return true;
		}
		return false;
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
