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

@WebServlet(urlPatterns = "/CadastrarUsuario")
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

			try {
				dao.deletar(id);
				request.setAttribute("msg", "Usuario deletado com sussesso");

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
			String telefone = request.getParameter("telefone");

			Usuario usuario = new Usuario();
			usuario.setId(!id.isEmpty() ? Long.parseLong(id) : 0);
			usuario.setLogin(login);
			usuario.setNome(nome);
			usuario.setSenha(senha);
			usuario.setTelefone(telefone);

			try {
				boolean manterDados = false;

				if (login == null || login.isEmpty()) {
					request.setAttribute("msg", "O Login de usuario deve ser preenchido");
					manterDados = true;
				}else if (nome == null || nome.isEmpty()) {
					request.setAttribute("msg", "O Nome de usuario deve ser preenchida");
					manterDados = true;
				}else if (telefone == null || telefone.isEmpty()) {
					request.setAttribute("msg", "O Telefone de usuario deve ser preenchido");
					manterDados = true;
				}else if (senha == null || senha.isEmpty()) {
					request.setAttribute("msg", "O Senha de usuario deve ser preenchido");
					manterDados = true;
				}  else if (id == null || id.isEmpty() && dao.validarLogin(usuario.getLogin())) {
					if (dao.validarSenhaRepetida(usuario.getSenha())) {
						request.setAttribute("msg", "Ja existe outro usuário com essa senha");
						manterDados = true;
					} else {
						dao.salvar(usuario);
						request.setAttribute("msg", "Usuário Cadastrado com sussesso");
					}

				} else if (!(id == null) && !id.isEmpty()) {
					if (dao.validarLoginUpdate(usuario.getLogin(), usuario.getId())) {
						request.setAttribute("msg", "Já existe outro usuario com esse Login");
						manterDados = true;
					} else {
						if (dao.validarSenhaRepetidaUpdate(usuario.getSenha(), usuario.getId())) {
							request.setAttribute("msg", "Ja existe outro usuário com essa senha");
							manterDados = true;
						} else {
							dao.atualizar(usuario);
							request.setAttribute("msg", "Usuário atualizado com sussesso");
						}
					}
				} else {
					request.setAttribute("msg", "Ja existe outro usuario com esse login!");
					manterDados = true;
				}

				if (manterDados) {
					usuario.setId(null);
					request.setAttribute("usuario", usuario);
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
