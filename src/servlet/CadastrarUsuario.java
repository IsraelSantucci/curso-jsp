package servlet;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Usuario;
import dao.UsuarioDAO;

@WebServlet("/CadastrarUsuario")
public class CadastrarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UsuarioDAO dao;
  
    public CadastrarUsuario() {
    	super();
    	dao = new UsuarioDAO();
        
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String acao = request.getParameter("acao");
		String usuario = request.getParameter("usuario");
		
		if(acao.equals("delete")) {
			dao.deletar(usuario);
			
			try {
				List<Usuario> usuarios = dao.listar();
				RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastrar-usuario.jsp");
				request.setAttribute("usuarios", usuarios);
				dispatcher.forward(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		Usuario usuario = new Usuario();
		usuario.setLogin(login);
		usuario.setSenha(senha);
		
		dao.salvar(usuario);
		
		
		try {
			List<Usuario> usuarios =  dao.listar();
			request.setAttribute("usuarios", usuarios);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastrar-usuario.jsp");
			dispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
