INSERT INTO almacen ( nombre)
SELECT 'Almacen Centro'
    WHERE NOT EXISTS (SELECT 1 FROM almacen WHERE nombre = 'Almacen Centro');

INSERT INTO almacen ( nombre)
SELECT 'Almacen Zona Sur'
    WHERE NOT EXISTS (SELECT 1 FROM almacen WHERE nombre = 'Almacen Zona Sur');

INSERT INTO almacen ( nombre)
SELECT 'Almacen Zona Norte'
    WHERE NOT EXISTS (SELECT 1 FROM almacen WHERE nombre = 'Almacen Zona Norte');

INSERT INTO grupo_cliente ( descuento, nombre)
SELECT 10, 'Especial'
    WHERE NOT EXISTS (SELECT 1 FROM grupo_cliente WHERE nombre = 'Especial');

INSERT INTO grupo_cliente ( descuento, nombre)
SELECT 50, 'Mayorista'
    WHERE NOT EXISTS (SELECT 1 FROM grupo_cliente WHERE nombre = 'Mayorista');

INSERT INTO grupo_cliente ( descuento, nombre)
SELECT 60, 'VIP'
    WHERE NOT EXISTS (SELECT 1 FROM grupo_cliente WHERE nombre = 'VIP');

INSERT INTO cliente ( apellidos, cod_cliente, direccion, email, nombre, num_documento, telefono, tipo_documento, grupo_cliente_id)
SELECT 'Soliz', 'C001', 'Los lotes', 'soliz@cliente.com', 'Fernando', '123456', '70045123', 'CI', 1
    WHERE NOT EXISTS (SELECT 1 FROM cliente WHERE cod_cliente = 'C001');

INSERT INTO cliente ( apellidos, cod_cliente, direccion, email, nombre, num_documento, telefono, tipo_documento, grupo_cliente_id)
SELECT 'Flores', 'C002', 'B/Olivos', 'ftorrez@gmai.com', 'Angelica', '789456', '6094511', 'CI', 2
    WHERE NOT EXISTS (SELECT 1 FROM cliente WHERE cod_cliente = 'C002');

INSERT INTO cliente ( apellidos, cod_cliente, direccion, email, nombre, num_documento, telefono, tipo_documento, grupo_cliente_id)
SELECT 'Espada Salazar', 'C003', 'Santos Dumount 5 anillo', 'espada@gmail.com', 'Angelica', '95175', '785612148', 'NIT', 3
    WHERE NOT EXISTS (SELECT 1 FROM cliente WHERE cod_cliente = 'C003');

INSERT INTO grupo_producto ( nombre)
SELECT 'Grupo 1'
    WHERE NOT EXISTS (SELECT 1 FROM grupo_producto WHERE nombre = 'Grupo 1');

INSERT INTO grupo_producto ( nombre)
SELECT 'Grupo 2'
    WHERE NOT EXISTS (SELECT 1 FROM grupo_producto WHERE nombre = 'Grupo 2');

INSERT INTO forma_entrega ( nombre)
SELECT 'Delivery'
    WHERE NOT EXISTS (SELECT 1 FROM forma_entrega WHERE nombre = 'Delivery');

INSERT INTO forma_entrega ( nombre)
SELECT 'Correo'
    WHERE NOT EXISTS (SELECT 1 FROM forma_entrega WHERE nombre = 'Correo');

INSERT INTO fabricante ( nombre)
SELECT 'EMAPA'
    WHERE NOT EXISTS (SELECT 1 FROM fabricante WHERE nombre = 'EMAPA');

INSERT INTO fabricante ( nombre)
SELECT 'HP'
    WHERE NOT EXISTS (SELECT 1 FROM fabricante WHERE nombre = 'HP');

INSERT INTO fabricante ( nombre)
SELECT 'AZUS'
    WHERE NOT EXISTS (SELECT 1 FROM fabricante WHERE nombre = 'AZUS');

INSERT INTO forma_pago ( nombre)
SELECT 'Efectivo'
    WHERE NOT EXISTS (SELECT 1 FROM forma_pago WHERE nombre = 'Efectivo');

INSERT INTO forma_pago ( nombre)
SELECT 'Tarjeta'
    WHERE NOT EXISTS (SELECT 1 FROM forma_pago WHERE nombre = 'Tarjeta');

INSERT INTO forma_pago ( nombre)
SELECT 'Qr'
    WHERE NOT EXISTS (SELECT 1 FROM forma_pago WHERE nombre = 'Qr');

INSERT INTO proveedor ( nombre)
SELECT 'Los Andes'
    WHERE NOT EXISTS (SELECT 1 FROM proveedor WHERE nombre = 'Los Andes');

INSERT INTO proveedor ( nombre)
SELECT 'Grupo Venado'
    WHERE NOT EXISTS (SELECT 1 FROM proveedor WHERE nombre = 'Grupo Venado');

INSERT INTO producto ( fabricante_id, precio_lista, nombre, sku)
SELECT 1, 100, 'Teclado Corsair', 'TC'
    WHERE NOT EXISTS (SELECT 1 FROM producto WHERE sku = 'TC');

INSERT INTO producto ( fabricante_id, precio_lista, nombre, sku)
SELECT 1, 50, 'Mouse Corsair', 'MC'
    WHERE NOT EXISTS (SELECT 1 FROM producto WHERE sku = 'MC');

INSERT INTO producto ( fabricante_id, precio_lista, nombre, sku)
SELECT 2, 500, 'Portatil HP', 'PHP'
    WHERE NOT EXISTS (SELECT 1 FROM producto WHERE sku = 'PHP');
