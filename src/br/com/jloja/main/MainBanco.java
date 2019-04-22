package br.com.jloja.main;


import br.com.jloja.util.HibernateUtil;

public class MainBanco {

	public static void main(String[] args) {
		try {
			HibernateUtil.getSessionFactory();
			HibernateUtil.getSessionFactory().close();
			System.out.println("Conex�o realizada com sucesso");
		} catch (Exception e) {
			System.out.println("erro: " + e.getMessage());
			throw e;
		}

	}

}
