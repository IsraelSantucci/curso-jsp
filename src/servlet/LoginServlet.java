package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Usuario;
import dao.LoginDAO;
import dao.UsuarioDAO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDAO loginDAO = new LoginDAO();
	private HttpSession session = null;
	public LoginServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String deslogar = request.getParameter("acao");
		if(deslogar == null) {
			deslogar = "";
		};
		
		if(deslogar.equalsIgnoreCase("deslogar")) {
			request.getSession().removeAttribute("usuarioLogado");
			RequestDispatcher dispatcher = request.getRequestDispatcher("sisteminha.jsp");
			dispatcher.forward(request, response);
		}else{
			doPost(request, response);
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Usuario login = new Usuario();
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		Usuario atributo = (Usuario) request.getSession().getAttribute("usuarioLogado");
		boolean estaLogado = false;
		if(atributo != null) {
			estaLogado = true ;
		}
		try {
			if(!estaLogado) {
				if (loginDAO.validarLogin(usuario, senha)) {
					UsuarioDAO dao = new UsuarioDAO();
					session = request.getSession();
					session.setAttribute("usuarioLogado", dao.consultarUsuario(usuario));
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/paginas/acesso-permitido.jsp");
					dispatcher.forward(request, response);
				} else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/paginas/acesso-negado.jsp");
					dispatcher.forward(request, response);
				}
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/paginas/acesso-permitido.jsp");
				dispatcher.forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
