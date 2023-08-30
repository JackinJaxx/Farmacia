CREATE TABLE estados(
    id_estado serial NOT NULL PRIMARY KEY,
    nombre_estado VARCHAR (20) NOT NULL
);

CREATE TABLE municipios(
    id_municipio serial NOT NULL PRIMARY KEY,
    nombre_municipio VARCHAR (50) NOT NULL,
    id_estado INTEGER references estados not null
);

CREATE TABLE sucursales(
    id_sucursal serial PRIMARY KEY,
    nombre_sucursal VARCHAR (50),
    direccion_sucursal VARCHAR (50) NOT NULL,
    id_municipio INTEGER references municipios not null
);

CREATE TABLE status(
	id_status serial PRIMARY KEY,
	descripcion_status VARCHAR (10) NOT NULL
);

CREATE TABLE tipo_dispositivos(
	id_tipo_dispositivo serial PRIMARY KEY,
	descripcion_dispositivo VARCHAR (50)
);

CREATE TABLE dispositivos (
    id_dispositivo serial PRIMARY KEY,
    tipo VARCHAR(50) not null ,
    nombre VARCHAR(100) not null
);

CREATE TABLE historial_dispositivos (
    id_historial SERIAL PRIMARY KEY,
    id_dispositivo INTEGER references dispositivos not null ,
    id_sucursal INTEGER references sucursales not null ,
    id_status INTEGER references status not null ,
    fecha_hora TIMESTAMP NOT NULL DEFAULT NOW(),
    conectado_a INTEGER references dispositivos not null
);




