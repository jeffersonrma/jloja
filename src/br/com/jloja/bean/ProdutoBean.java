package br.com.jloja.bean;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.com.jloja.DAO.ProdutoDAO;
import br.com.jloja.DAO.UsuarioDAO;
import br.com.jloja.entity.ProdutoEntity;
import br.com.jloja.entity.UsuarioEntity;
import br.com.jloja.util.MsgUtil;

@ManagedBean(name = "produtoMB")
@SessionScoped
public class ProdutoBean {
	
	private List<ProdutoEntity> listaU;
	private List<ProdutoEntity> listaUFiltrado;
	private ProdutoEntity produto = new ProdutoEntity();
	private int codigo;
	
	public ProdutoBean() {
		System.out.println("OOOOOOOOOOOOOOOO   CRIADO");
	}
	
	
	public void listar() {
		try {
			listaU = new ProdutoDAO().listar();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void adicionar(UsuarioEntity u) {
		try {
			produto.setUsuarioCadastro(u);
			new ProdutoDAO().adicionar(produto);
			produto = new ProdutoEntity();
			MsgUtil.msgInfo("Produto cadastrado com sucesso!");
		} catch (Exception e) {
			MsgUtil.msgErro("Erro ao cadastrar Produto: " + e.getMessage());
		}
	}
	
	public void buscarCodigo(long id) {
		try {
			produto = new ProdutoEntity();
			System.out.println(id);
			produto = new ProdutoDAO().buscarPorId((int)id);
		} catch (Exception e) {
			MsgUtil.msgErro("Erro ao Buscar Produto: " + e.getMessage());
		}
	}
	
	public void editar() {
		try {
			new ProdutoDAO().Editar(produto);
			MsgUtil.msgInfo("Produto editado com Sucesso!");
		} catch (Exception e) {
			MsgUtil.msgErro("Erro ao editar Produto: " + e.getMessage());
		} finally {
			produto = new ProdutoEntity();
		}
	}
	
	public void excluir() {
		try {
			new ProdutoDAO().excluir(produto);
			MsgUtil.msgInfo("Produto Excluido com Sucesso!");
		} catch (Exception e) {
			MsgUtil.msgErro("Erro ao editar Produto: " + e.getMessage());
		} finally {
			produto = new ProdutoEntity();
		}
	}
	
	
	public ProdutoEntity getProduto() {
		return produto;
	}

	public void setProduto(ProdutoEntity produto) {
		this.produto = produto;
	}

	public List<ProdutoEntity> getListaU() {
		return listaU;
	}
	public void setListaU(List<ProdutoEntity> listaU) {
		this.listaU = listaU;
	}
	public List<ProdutoEntity> getListaUFiltrado() {
		return listaUFiltrado;
	}
	public void setListaUFiltrado(List<ProdutoEntity> listaUFiltrado) {
		this.listaUFiltrado = listaUFiltrado;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	

}
