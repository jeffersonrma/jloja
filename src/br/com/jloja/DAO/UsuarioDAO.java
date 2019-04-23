package br.com.jloja.DAO;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import br.com.jloja.entity.UsuarioEntity;
import br.com.jloja.util.HibernateUtil;

public class UsuarioDAO {
	
	public static void main(String[] args) {
		UsuarioDAO udao = new UsuarioDAO();
		UsuarioEntity user = new UsuarioEntity();
		user.setNome("nome4");
		user.setSenha("123");
		udao.adicionar(user);
		
		
//		UsuarioEntity user = udao.buscarPorId(2);
//		user.setSenha("11111");
//		udao.Editar(user);
//		
	}
	
	public UsuarioEntity autenticar(String login, String senha) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		UsuarioEntity u = null;
		try {
			Query<UsuarioEntity> consulta = sessao.getNamedQuery("UsuarioEntity.login");
			consulta.setParameter("login", login);
			consulta.setParameter("senha", senha);
			u = (UsuarioEntity)consulta.uniqueResult();
			System.out.println("Usuario emcontrado com sucesso " + u);
			
		} catch (Exception e) {
			System.out.println("erro usuario/buscarPorId " + e.getMessage());
			throw e;
		} finally {
			sessao.close();
			System.out.println("sessao fecheda");
		}
		return u;
	}
	
	public List<UsuarioEntity> listar(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<UsuarioEntity> us = null;
		
		try {
			Query<UsuarioEntity> consulta = sessao.getNamedQuery("UsuarioEntity.listar");
			us = (List<UsuarioEntity>)consulta.list();
			System.out.println("Usuarios emcontrados com sucesso " + us.size());
			
		} catch (Exception e) {
			System.out.println("Erro listar usuario: " + e.getMessage());
			throw e;
		} finally {
			sessao.close();
		}
		
		return us;
	}
	
	public UsuarioEntity buscarPorId(int id) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		UsuarioEntity u = null;
		try {
			Query<UsuarioEntity> consulta = sessao.getNamedQuery("UsuarioEntity.buscarPorId");
			consulta.setParameter("id", id);
			u = (UsuarioEntity)consulta.uniqueResult();
			System.out.println("Usuario emcontrado com sucesso " + u);
			
		} catch (Exception e) {
			System.out.println("erro usuario/buscarPorId " + e.getMessage());
			throw e;
		} finally {
			sessao.close();
			System.out.println("sessao fecheda");
		}
		return u;
	}
	
	public void adicionar(UsuarioEntity u) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			sessao.save(u);
			transacao.commit();
			System.out.println("Usuario adicionado com sucesso " + u.toString());
		} catch (Exception e) {
			if (transacao != null) transacao.rollback(); 
			System.out.println("Erro UsuariDAO/adicionar: " + e.getMessage());
		} finally {
			sessao.close();
			System.out.println("sessao fechada");
		}
	}
	
	public void Editar(UsuarioEntity u) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			sessao.update(u);
			transacao.commit();
			System.out.println("Usuario editado com sucesso " + u.toString());
		} catch (Exception e) {
			if (transacao != null) transacao.rollback(); 
			System.out.println("Erro UsuarioDAO/editar: " + e.getMessage());
		} finally {
			sessao.close();
			System.out.println("sessao fechada");
		}
	}
	
	public void excluir(UsuarioEntity u) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			sessao.delete(u);
			transacao.commit();
			System.out.println("Usuario ecluido com sucesso ");
		} catch (Exception e) {
			if (transacao != null) transacao.rollback(); 
			System.out.println("Erro UsuarioDAO/ecluir: " + e.getMessage());
		} finally {
			sessao.close();
			System.out.println("sessao fechada");
		}
	}

}
