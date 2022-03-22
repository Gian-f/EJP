package br.com.example.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.example.model.Cliente;

@Named
@SessionScoped
public class clienteBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Cliente cliente;
	
	private List<Cliente> clientes = new ArrayList<Cliente>();
	
	@PostConstruct
	public void inicializar() {
		clientes.clear();
	}
	
	public String salvar() {
		clientes.add(cliente);
		System.out.println("cliente " + cliente.getNome() + " cadastrado com sucesso!");
		limpar();
		return "";
	}
	
	public String excluir() {
		clientes.remove(cliente);
		System.out.println("cliente " + cliente.getNome() + " deletado com sucesso!");
		limpar();
		return "";
	}
	
	
	public void limpar() {
		cliente = new Cliente();
	}
	
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
}
