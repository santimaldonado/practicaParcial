/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author 54351
 */
public class Articulo {
    
    private int id;
    private String nombre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Articulo(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Articulo() {
    }
    
    

    @Override
    public String toString() {
        return "Articulo{" + "id=" + id + ", nombre=" + nombre + '}';
    }
    
    
    
}
