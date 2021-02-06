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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");
		String parametroId = request.getParameter("id");
		Long id = !parametroId.isEmpty() ? Long.parseLong(parametroId) : 0;

		if (acao.equals("delete")) {
			dao.deletar(id);

			try {
				List<Usuario> usuarios = dao.listar();
				RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastrar-usuario.jsp");
				request.setAttribute("usuarios", usuarios);
				dispatcher.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (acao.equals("editar")) {
			try {
				Usuario usuario = dao.consultar(id);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastrar-usuario.jsp");
				request.setAttribute("usuario", usuario);
				dispatcher.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (acao.equals("listartodos")) {
			try {
				List<Usuario> usuarios = dao.listar();
				RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastrar-usuario.jsp");
				request.setAttribute("usuarios", usuarios);
				dispatcher.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");

		if (acao != null && acao.equalsIgnoreCase("reset")) {
			try {
				List<Usuario> usuarios = dao.listar();
				request.setAttribute("usuarios", usuarios);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastrar-usuario.jsp");
				dispatcher.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			String id = request.getParameter("id");
			String login = request.getParameter("login");
			String nome = request.getParameter("nome");
			String senha = request.getParameter("senha");

			Usuario usuario = new Usuario();
			usuario.setId(!id.isEmpty() ? Long.parseLong(id) : 0);
			usuario.setLogin(login);
			usuario.setNome(nome);
			usuario.setSenha(senha);

			try {
				if (id == null || id.isEmpty() && dao.validarLogin(login)) {
					dao.salvar(usuario);
					System.out.println("cadastrado com susseso:");
				} else if(!(id == null) && !id.isEmpty()){
					dao.atualizar(usuario);
					System.out.println("cadastro atualizado");
				}else {
					System.out.println("login repetido");
				}

				List<Usuario> usuarios = dao.listar();
				request.setAttribute("usuarios", usuarios);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastrar-usuario.jsp");
				dispatcher.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

}
