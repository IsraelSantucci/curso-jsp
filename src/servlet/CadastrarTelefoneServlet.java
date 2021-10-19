package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Usuario;

@WebServlet(urlPatterns="/cadastrarTelefones")
public class CadastrarTelefoneServlet extends HttpServlet{
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
		
		RequestDispatcher dispather = req.getRequestDispatcher("WEB-INF/paginas/telefones.jsp");
		dispather.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException{
		
	}
}
