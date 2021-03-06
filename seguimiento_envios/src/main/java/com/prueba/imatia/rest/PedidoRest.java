package com.prueba.imatia.rest;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.prueba.imatia.dto.OrderTrackings;
import com.prueba.imatia.dto.OrderTracking;
import com.prueba.imatia.model.Estado;
import com.prueba.imatia.model.EstadoPedido;
import com.prueba.imatia.model.Pedido;
import com.prueba.imatia.repositories.EstadoPedidoRepository;
import com.prueba.imatia.repositories.EstadoRepository;
import com.prueba.imatia.repositories.PedidoRepository;
import com.prueba.imatia.service.EstadoPedidoService;

@RestController
@RequestMapping(value = "order")
public class PedidoRest {

	@Autowired
	EstadoPedidoService estadoPedidoService;
	
	
	@PostMapping(value = "/tracking")
	public void guardarTracking(@RequestParam MultipartFile file) {
		try {

			DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

			List<OrderTracking> orderTrackings = new ArrayList<>();
			Integer temporalOrderId;
			Integer temporalTrackingStatusId;
			Date temporalChangeStatusDate;
			InputStream is = file.getInputStream();
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(is);
			NodeList orders = doc.getElementsByTagName("orderTracking");
			for (Integer i = 0; i < orders.getLength(); i++) {
				Element element = (Element) orders.item(i);
				temporalOrderId = Integer.parseInt(element.getElementsByTagName("orderId").item(0).getTextContent());
				temporalTrackingStatusId = Integer
						.parseInt(element.getElementsByTagName("trackingStatusId").item(0).getTextContent());
				temporalChangeStatusDate = java.sql.Date.valueOf(
						ZonedDateTime.parse(element.getElementsByTagName("changeStatusDate").item(0).getTextContent())
								.toLocalDate());
				orderTrackings
						.add(new OrderTracking(temporalOrderId, temporalTrackingStatusId, temporalChangeStatusDate));
			}
			for (OrderTracking order : orderTrackings) {
				estadoPedidoService.guardar(order);
			}
		} catch (SAXException | IOException | ParserConfigurationException ex) {
			ex.printStackTrace();
		}

	}


}
