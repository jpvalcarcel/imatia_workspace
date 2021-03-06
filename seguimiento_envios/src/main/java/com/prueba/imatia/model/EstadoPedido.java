package com.prueba.imatia.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EstadoPedido {
	
	

	public EstadoPedido() {
		super();
	}

	public EstadoPedido(Integer id, Pedido pedido, Estado estado, Date fechaCambioEstado) {
		super();
		this.id = id;
		this.pedido = pedido;
		this.estado = estado;
		this.fechaCambioEstado = fechaCambioEstado;
	}

	@SequenceGenerator(name = "seqEstadoPedido", sequenceName = "seqEstadoPedido", initialValue = 6, allocationSize = 1)
	@Id
	@GeneratedValue(generator = "seqEstadoPedido")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "pedido", referencedColumnName = "id", nullable = false)
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name = "estado", referencedColumnName = "id", nullable = false)
	private Estado estado;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCambioEstado;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Date getFechaCambioEstado() {
		return fechaCambioEstado;
	}

	public void setFechaCambioEstado(Date fechaCambioEstado) {
		this.fechaCambioEstado = fechaCambioEstado;
	}
	
}
