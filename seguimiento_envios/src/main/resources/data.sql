DELETE FROM ESTADO_PEDIDO;
DELETE FROM ESTADO;
DELETE FROM PEDIDO;

INSERT INTO ESTADO(ID, NOMBRE) VALUES (1, "RECOGIDO EN ALMACÉN");
INSERT INTO ESTADO(ID, NOMBRE) VALUES (2, "EN REPARTO");
INSERT INTO ESTADO(ID, NOMBRE) VALUES (3, "INCIDENCIA EN ENTREGA");
INSERT INTO ESTADO(ID, NOMBRE) VALUES (4, "ENTREGADO");
INSERT INTO PEDIDO(ID) VALUES (230688716);
INSERT INTO PEDIDO(ID) VALUES (230688717);
INSERT INTO PEDIDO(ID) VALUES (230688718);
INSERT INTO ESTADO_PEDIDO(ID, FECHA_CAMBIO_ESTADO, ESTADO, PEDIDO) 
VALUES (1, CURRENT_TIMESTAMP, 1, 230688716);
INSERT INTO ESTADO_PEDIDO(ID, FECHA_CAMBIO_ESTADO, ESTADO, PEDIDO) 
VALUES (2, CURRENT_TIMESTAMP, 2, 230688717);
INSERT INTO ESTADO_PEDIDO(ID, FECHA_CAMBIO_ESTADO, ESTADO, PEDIDO) 
VALUES (3, CURRENT_TIMESTAMP, 4, 230688718);
INSERT INTO ESTADO_PEDIDO(ID, FECHA_CAMBIO_ESTADO, ESTADO, PEDIDO) 
VALUES (4, CURRENT_TIMESTAMP, 2, 230688716);
INSERT INTO ESTADO_PEDIDO(ID, FECHA_CAMBIO_ESTADO, ESTADO, PEDIDO) 
VALUES (5, CURRENT_TIMESTAMP, 3, 230688716);