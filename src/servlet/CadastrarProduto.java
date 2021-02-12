package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Produto;
import dao.ProdutoDAO;

/**
 * Servlet implementation class CadastrarProduto
 */
@WebServlet(urlPatterns = "/CadastrarProdutos")
public class CadastrarProduto extends HttpServlet {
	


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		String parametroCodigo = request.getParameter("codigo");
		 
		Long codigo = parametroCodigo.isEmpty() ? null : Long.valueOf(parametroCodigo);
		
		ProdutoDAO dao = new ProdutoDAO();
		if(acao.equalsIgnoreCase("excluir")){
			dao.excluirProduto(codigo);
			
		}
		if(acao.equalsIgnoreCase("editar")) {
			
			Produto produto = dao.buscarProduto(codigo);
			request.setAttribute("produto", produto);
			
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrar-produtos.jsp");
		List<Produto> produtos = dao.listar();
		request.setAttribute("produtos", produtos);
		
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String codigo = request.getParameter("codigo");
		String nome = request.getParameter("nome");
		String quantidade = request.getParameter("quantidade");
		String valor = request.getParameter("valor");
		
		Produto produto = new Produto();
		produto.setCodigo(codigo.isEmpty() ? null : Long.valueOf(codigo));
		produto.setNome(nome);
		produto.setQuantidade(quantidade.isEmpty() ? 0 : Integer.valueOf(quantidade));
		produto.setValor(valor.isEmpty() ? 0 : Double.valueOf(valor));
		
		ProdutoDAO dao = new ProdutoDAO();
		
		if(produto.getCodigo() != null ) {
			dao.editarProduto(produto);
		}else {
			dao.cadastraProduto(produto);
		}
		
		
		List<Produto> produtos = dao.listar();
		request.setAttribute("produtos", produtos);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrar-produtos.jsp");
		dispatcher.forward(request, response);
		
	}

}
