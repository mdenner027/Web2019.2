package br.com.agenda.bd;

import java.sql.Connection;
import java.sql.SQLException;

public class TestaBd {
	public static void main(String[] args) {
		Connection con = new ConnectionFactory().getConnection();
		System.out.println("FUNFOU");
	}
}
