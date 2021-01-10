package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Login;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public LoginServlet() {
        super();
   
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Login login = new Login();
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		
		if(login.validarLoginSenha(usuario, senha)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/paginas/acesso-permitido.jsp");
			dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/paginas/acesso-negado.jsp");
			dispatcher.forward(request, response);
		}
	
	}

}
