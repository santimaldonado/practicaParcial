/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Articulo;
import Modelo.Oferta;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author 54351
 */
public class GestorBD {
    
    private Connection con;
    
    private void abrirConexion()
    {
        try
        {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Empresa","sasa","12345");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    private void cerrarConexion()
    {
           try {
                if(con != null && !con.isClosed())
                con.close();
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            } 
    }
    
    public ArrayList<Articulo> obtenerArticulos(){
         
        ArrayList<Articulo> lista = new ArrayList<Articulo>(); 
     
        try 
        {
        abrirConexion();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("Select * FROM Articulos");
        while(rs.next())
        {
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            
            Articulo art = new Articulo();
            art.setId(id);
            art.setNombre(nombre);
            lista.add(art);
        }
        rs.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally 
        {
            cerrarConexion();
        }       
        return lista;
     }
    
    public void agregarOferta(Oferta oferta){
         
     
        try 
        {
        abrirConexion();
        PreparedStatement ps = con.prepareStatement("INSERT INTO Oferta (idArticulo,precioNormal,precioOferta,stockDisponible"
                + ",fechaInicioOferta,diasVigencia) Values(?,?,?,?,?,?)");
        ps.setInt(1, oferta.getArticulo().getId());
        ps.setDouble(2, oferta.getPrecioNormal());
        ps.setDouble(3, oferta.getPrecioOferta());
        ps.setInt(4, oferta.getStockDisponible());
        ps.setString(5, oferta.getFechaInicioOferta());
        ps.setInt(6, oferta.getDiasVigencia());
        ps.executeUpdate();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally 
        {
            cerrarConexion();
        }            
    }
    
    public ArrayList<Oferta> obtenerOfertas(){
         
        ArrayList<Oferta> lista = new ArrayList<Oferta>(); 
     
        try 
        {
        abrirConexion();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select o.id,a.nombre,o.precioNormal,o.precioOferta,o.stockDisponible,o.fechaInicioOferta,o.diasVigencia\n" +
"from oferta o inner join articulos a on o.idarticulo = a.id");
        while(rs.next())
        {
            int idOferta = rs.getInt("id");
            String nombreArticulo= rs.getString("nombre");
            double precioNormal = rs.getDouble("precioNormal");
            double precioOferta = rs.getDouble("precioOferta");
            int stockDisponible = rs.getInt("stockDisponible");
            String fechaInicioOferta = rs.getString("fechaInicioOferta");
            int diasVigencia = rs.getInt("diasVigencia");
            
            Articulo art = new Articulo ();
            art.setNombre(nombreArticulo);
            
            Oferta oferta = new Oferta (idOferta,precioNormal,precioOferta,stockDisponible,fechaInicioOferta,diasVigencia,art);
            
            lista.add(oferta);
        }
        rs.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally 
        {
            cerrarConexion();
        }       
        return lista;
     }
    
}
