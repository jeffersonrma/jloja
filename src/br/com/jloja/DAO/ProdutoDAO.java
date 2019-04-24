package br.com.jloja.DAO;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import br.com.jloja.entity.ProdutoEntity;
import br.com.jloja.entity.UsuarioEntity;
import br.com.jloja.util.HibernateUtil;

public class ProdutoDAO {
	
	public static void main(String[] args) {	
		ProdutoEntity user = new ProdutoEntity();
		user.setNome("123");
		user.setDescricao("descriçao");
		user.setEstoque(5);
		user.setEstoqueIdeal(2);
		user.setValor(new BigDecimal(55.22));
		user.setUsuarioCadastro(new UsuarioDAO().buscarPorId(1));
		
		new ProdutoDAO().adicionar(user);
		
		
//		UsuarioEntity user = udao.buscarPorId(2);
//		user.setSenha("11111");
//		udao.Editar(user);
//		
	}
	public List<ProdutoEntity> listar(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<ProdutoEntity> pr = null;
		
		try {
			Query<ProdutoEntity> consulta = sessao.getNamedQuery("ProdutoEntity.listar");
			pr = (List<ProdutoEntity>)consulta.list();
			System.out.println("Usuarios emcontrados com sucesso " + pr.size());
			
		} catch (Exception e) {
			System.out.println("Erro listar usuario: " + e.getMessage());
			throw e;
		} finally {
			sessao.close();
		}
		
		return pr;
	}
	
	public ProdutoEntity buscarPorId(int id) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		ProdutoEntity p = null;
		try {
			Query<ProdutoEntity> consulta = sessao.getNamedQuery("ProdutoEntity.buscarPorId");
			consulta.setParameter("id", id);
			p = (ProdutoEntity)consulta.uniqueResult();
			System.out.println("Usuario emcontrado com sucesso " + p);
			
		} catch (Exception e) {
			System.out.println("erro produto/buscarPorId " + e.getMessage());
			throw e;
		} finally {
			sessao.close();
			System.out.println("sessao fecheda");
		}
		return p;
	}
	
	public void adicionar(ProdutoEntity p) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			sessao.save(p);
			transacao.commit();
			System.out.println("Produto adicionado com sucesso " +p.toString());
		} catch (Exception e) {
			if (transacao != null) transacao.rollback(); 
			System.out.println("Erro ProdutoDAO/adicionar: " + e.getMessage());
		} finally {
			sessao.close();
			System.out.println("sessao fechada");
		}
	}
	
	public void Editar(ProdutoEntity p) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			sessao.update(p);
			transacao.commit();
			System.out.println("Produto editado com sucesso " + p.toString());
		} catch (Exception e) {
			if (transacao != null) transacao.rollback(); 
			System.out.println("Erro ProdutoDAO/editar: " + e.getMessage());
		} finally {
			sessao.close();
			System.out.println("sessao fechada");
		}
	}
	
	public void excluir(ProdutoEntity p) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			sessao.delete(p);
			transacao.commit();
			System.out.println("Produto excluido com sucesso ");
		} catch (Exception e) {
			if (transacao != null) transacao.rollback(); 
			System.out.println("Erro ProdutoDAO/excluir: " + e.getMessage());
		} finally {
			sessao.close();
			System.out.println("sessao fechada");
		}
	}
	
	
	
}