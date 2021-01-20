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
		String login = request.getParameter("login");
		
		if(acao.equals("delete")) {
			dao.deletar(login);
			
			try {
				List<Usuario> usuarios = dao.listar();
				RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastrar-usuario.jsp");
				request.setAttribute("usuarios", usuarios);
				dispatcher.forward(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		} else if(acao.equals("editar")) {
			try {
				Usuario usuario = dao.consultar(login);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastrar-usuario.jsp");
				request.setAttribute("usuario", usuario);
				dispatcher.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		Usuario usuario = new Usuario();
		usuario.setId(!id.isEmpty()? Long.parseLong(id) : 0);
		usuario.setLogin(login);
		usuario.setSenha(senha);
		
		if(id == null || id.isEmpty()) {
			dao.salvar(usuario);
		}else {
			dao.atualizar(usuario);
		}
		
		
		
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
