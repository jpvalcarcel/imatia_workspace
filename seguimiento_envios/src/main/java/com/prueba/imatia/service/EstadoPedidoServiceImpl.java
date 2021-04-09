package com.prueba.imatia.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.imatia.dto.OrderTracking;
import com.prueba.imatia.model.Estado;
import com.prueba.imatia.model.EstadoPedido;
import com.prueba.imatia.model.Pedido;
import com.prueba.imatia.repositories.EstadoPedidoRepository;
import com.prueba.imatia.repositories.EstadoRepository;
import com.prueba.imatia.repositories.PedidoRepository;


@Service
public class EstadoPedidoServiceImpl implements EstadoPedidoService{

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private EstadoPedidoRepository estadoPedidoRepository;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void guardar(OrderTracking order) {
		Pedido pedido = pedidoRepository.getOne(order.getOrderId());
		Estado estado = estadoRepository.getOne(order.getTrackingStatusId());
		List<EstadoPedido> estados = new ArrayList<>();
		for (EstadoPedido estPed : pedido.getEstadoPedidos()) {
			estados.add(estPed);
		}
		if (pedido != null && estados.stream().noneMatch(ep -> ep.getEstado().getId() == 4)
				&& order.getTrackingStatusId() != 1) {
			estadoPedidoRepository.saveAndFlush(new EstadoPedido(null, pedido, estado, order.getChangeStatusDate()));
		}
	}
}
