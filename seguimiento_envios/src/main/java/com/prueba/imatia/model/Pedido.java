package com.prueba.imatia.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pedido {

	public Pedido() {

	}

	public Pedido(Integer id, List<EstadoPedido> estadoPedidos) {
		this.id = id;
		this.estadoPedidos = estadoPedidos;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<EstadoPedido> estadoPedidos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<EstadoPedido> getEstadoPedidos() {
		return estadoPedidos;
	}

	public void setEstadoPedidos(List<EstadoPedido> estadoPedidos) {
		this.estadoPedidos = estadoPedidos;
	}

}