package br.com.jloja.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.jloja.DAO.UsuarioDAO;
import br.com.jloja.entity.UsuarioEntity;

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
		} catch (Exception e) {
			throw e;
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
