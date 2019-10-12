package br.com.agenda.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class AddContatoServlet
 */
public class AddContatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddContatoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String nome = "";
		String endereco = "";
		String email = "";
		String dataTexto = "";
		try {
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

		ContatoDAO dao = new ContatoDAO();
		dao.adicionaContato(contato);
		out.println("<html>");
		out.println("<body>");
		out.println("Contato cadastrado com sucesso!");
		out.println("</body>");
		out.println("</html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
