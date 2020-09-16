/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author 54351
 */
public class Oferta {
    
    private int id;
    private double precioNormal;
    private double precioOferta;
    private int stockDisponible;
    private String fechaInicioOferta;
    private int diasVigencia;
    private Articulo articulo;

    public Oferta(int id, double precioNormal, double precioOferta, int stockDisponible, String fechaInicioOferta, int diasVigencia, Articulo articulo) {
        this.id = id;
        this.precioNormal = precioNormal;
        this.precioOferta = precioOferta;
        this.stockDisponible = stockDisponible;
        this.fechaInicioOferta = fechaInicioOferta;
        this.diasVigencia = diasVigencia;
        this.articulo = articulo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrecioNormal() {
        return precioNormal;
    }

    public void setPrecioNormal(double precioNormal) {
        this.precioNormal = precioNormal;
    }

    public double getPrecioOferta() {
        return precioOferta;
    }

    public void setPrecioOferta(double precioOferta) {
        this.precioOferta = precioOferta;
    }

    public int getStockDisponible() {
        return stockDisponible;
    }

    public void setStockDisponible(int stockDisponible) {
        this.stockDisponible = stockDisponible;
    }

    public String getFechaInicioOferta() {
        return fechaInicioOferta;
    }

    public void setFechaInicioOferta(String fechaInicioOferta) {
        this.fechaInicioOferta = fechaInicioOferta;
    }

    public int getDiasVigencia() {
        return diasVigencia;
    }

    public void setDiasVigencia(int diasVigencia) {
        this.diasVigencia = diasVigencia;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    @Override
    public String toString() {
        return "Oferta{" + "id=" + id + ", precioNormal=" + precioNormal + ", precioOferta=" + precioOferta + ", stockDisponible=" + stockDisponible + ", fechaInicioOferta=" + fechaInicioOferta + ", diasVigencia=" + diasVigencia + ", articulo=" + articulo + '}';
    }
    
    
    
}
