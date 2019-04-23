package br.com.jloja.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.jloja.DAO.UsuarioDAO;
import br.com.jloja.entity.UsuarioEntity;
import br.com.jloja.util.MsgUtil;

@ManagedBean(name = "usuarioMB")
@ViewScoped
public class UsuarioBean {
	
	private List<UsuarioEntity> listaU;
	private List<UsuarioEntity> listaUFiltrado;
	private UsuarioEntity usuario = new UsuarioEntity();
	
	public void listar() {
		try {
			listaU = new UsuarioDAO().listar();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void adicionar() {
		try {
			new UsuarioDAO().adicionar(usuario);
			usuario = new UsuarioEntity();
			MsgUtil.msgInfo("Usuario cadastrado com sucesso!");
		} catch (Exception e) {
			MsgUtil.msgErro("Erro ao cadastrar Usuario: " + e.getMessage());
		}
	}
	
	public void buscarCodigo(long id) {
		try {
			usuario = new UsuarioEntity();
			System.out.println(id);
			usuario = new UsuarioDAO().buscarPorId((int)id);
		} catch (Exception e) {
			MsgUtil.msgErro("Erro ao Buscar Usuario: " + e.getMessage());
		}
	}
	
	public void editar() {
		try {
			new UsuarioDAO().Editar(usuario);
			MsgUtil.msgInfo("Usuario editado com Sucesso!");
		} catch (Exception e) {
			MsgUtil.msgErro("Erro ao editar Usuario: " + e.getMessage());
		} finally {
			usuario = new UsuarioEntity();
		}
	}
	
	public void excluir() {
		try {
			new UsuarioDAO().excluir(usuario);
			MsgUtil.msgInfo("Usuario Excluido com Sucesso!");
		} catch (Exception e) {
			MsgUtil.msgErro("Erro ao editar Usuario: " + e.getMessage());
		} finally {
			usuario = new UsuarioEntity();
		}
	}
	
	
	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

	public List<UsuarioEntity> getListaU() {
		return listaU;
	}
	public void setListaU(List<UsuarioEntity> listaU) {
		this.listaU = listaU;
	}
	public List<UsuarioEntity> getListaUFiltrado() {
		return listaUFiltrado;
	}
	public void setListaUFiltrado(List<UsuarioEntity> listaUFiltrado) {
		this.listaUFiltrado = listaUFiltrado;
	}
	
}
