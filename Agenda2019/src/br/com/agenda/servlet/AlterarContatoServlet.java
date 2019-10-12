package br.com.agenda.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.agenda.bd.ContatoDAO;
import br.com.agenda.modelo.Contato;

/**
 * Servlet implementation class AlterarContatoServlet
 */
public class AlterarContatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AlterarContatoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Long id = null;
		String nome = "";
		String endereco = "";
		String email = "";
		String dataTexto = "";
		try {
			id = Long.parseLong(request.getParameter("id"));
			nome = request.getParameter("nome");
			endereco = request.getParameter("endereco");
			email = request.getParameter("email");
			dataTexto = request.getParameter("dataNascimento");
		} catch (NullPointerException e) {
			e.printStackTrace();
			// RequestDispatcher rd =
			// request.getRequestDispatcher("/adiciona-contato.html");
			// rd.forward(request, response);
		}
		Calendar dataNascimento = Calendar.getInstance();

		try {
			Date data = new SimpleDateFormat("yyyy-MM-dd").parse(dataTexto);
			dataNascimento.setTime(data);
		} catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		Contato contato = new Contato();
		contato.setDataNascimento(dataNascimento);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setNome(nome);
		contato.setId(id);
		ContatoDAO dao = new ContatoDAO();
		dao.alterarContato(contato);
		RequestDispatcher rd = request
				.getRequestDispatcher("/lista-contatos.jsp");
		rd.forward(request, response);
	}

}
