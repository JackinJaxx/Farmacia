package com.klmj.ridi_api;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class MunicipioPrueba implements Serializable {
    public List<String> Aguascalientes;
    @JsonAlias("Baja California")
    public List<String> bajaCalifornia;
    @JsonAlias("Baja California Sur")
    public List<String> bajaCaliforniaSur;
    @JsonAlias("Campeche")
    public List<String> campeche;
    public List<String> Coahuila;
    public List<String> Colima;
    public List<String> Chiapas;
    public List<String> Chihuahua;
    @JsonAlias("Ciudad de Mexico")
    public List<String> ciudadMexico;
    public List<String> Durango;
    public List<String> Guanajuato;
    public List<String> Guerrero;
    public List<String> Hidalgo;
    public List<String> Jalisco;
    @JsonAlias("Estado de Mexico")
    public List<String> EstadoMexico;
    public List<String> Michoacan;
    public List<String> Morelos;
    public List<String> Nayarit;
    @JsonAlias("Nuevo Leon")
    public List<String> NuevoLeon;
    public List<String> Oaxaca;
    public List<String> Puebla;
    public List<String> Queretaro;
    @JsonAlias("Quintana Roo")
    public List<String> QuintanaRoo;
    @JsonAlias("San Luis Potosi")
    public List<String> SanLuisPotosi;
    public List<String> Sinaloa;
    public List<String> Sonora;
    public List<String> Tabasco;
    public List<String> Tamaulipas;
    public List<String> Zacatecas;
    public List<String> Tlaxcala;
    public List<String> Veracruz;
    public List<String> Yucatan;
}
