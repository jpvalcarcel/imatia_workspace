package com.prueba.imatia.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.imatia.dto.OrderTracking;
import com.prueba.imatia.model.Estado;
import com.prueba.imatia.model.EstadoPedido;
import com.prueba.imatia.model.Pedido;


public interface EstadoPedidoService {

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void guardar(OrderTracking order);
	
}
