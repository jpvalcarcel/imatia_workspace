package com.prueba.imatia.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estado {

	public Estado() {
		super();
	}

	public Estado(Integer id, String nombre, Set<EstadoPedido> estadoPedidos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.estadoPedidos = estadoPedidos;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column
	private String nombre;

	@OneToMany(mappedBy = "estado", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<EstadoPedido> estadoPedidos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<EstadoPedido> getEstadoPedidos() {
		return estadoPedidos;
	}

	public void setEstadoPedidos(Set<EstadoPedido> estadoPedidos) {
		this.estadoPedidos = estadoPedidos;
	}

}
