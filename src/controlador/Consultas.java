/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.Mesa;
import modelo.Pedido;
import modelo.Producto;
import modelo.Productos_Pedidos;
import modelo.Reserva;
import modelo.Trabajador;
import modelo.Usuario;
import utilidades.Constantes;
import utilidades.Decodificaciones;
import utilidades.HttpRequest;
import utilidades.RespuestaJson;

/**
 *
 * @author Esme
 */
public class Consultas {
    
    public static ArrayList<Usuario> ListarUsuarios(){
        ArrayList<Usuario> lista = new ArrayList<>();
        Gson gson = new Gson();
        String values = "tabla=usuarios";
        String respuesta = HttpRequest.GET_REQUEST(Constantes.URL_SELECT, values);
        lista = (ArrayList<Usuario>) Decodificaciones.deserializeArrayUsuario(respuesta);
        return lista;
    }
    
     public static Usuario existeUsuario(String nombretabla,Usuario object){
        Gson gson = new Gson();
        String jsonObject = gson.toJson(object);
        String values = "tabla=" +nombretabla+"&datos=" + jsonObject;
        String respuesta = HttpRequest.POST_REQUEST(Constantes.URL_EXIST, values);
        Usuario user = Decodificaciones.deserializeUsuario(respuesta);
        return user;
    } 
     
     public static Usuario existeUsuario(Usuario object){
        Gson gson = new Gson();
        String jsonObject = gson.toJson(object);
        String values = "tabla=usuarios&datos=" + jsonObject;
        String respuesta = HttpRequest.POST_REQUEST(Constantes.URL_EXIST_USER, values);
        Usuario user = Decodificaciones.deserializeUsuario(respuesta);
        return user;
    } 
    
    public static ArrayList<Trabajador> ListarTrabajadores(){
        ArrayList<Trabajador> lista = new ArrayList<>();
        Gson gson = new Gson();
        String values = "tabla=trabajadores";
        String respuesta = HttpRequest.GET_REQUEST(Constantes.URL_SELECT, values);
        lista = (ArrayList<Trabajador>) Decodificaciones.deserializeArrayTrabajador(respuesta);
        return lista;
    }
    
     public static Trabajador existeTrabajador(Trabajador object){
        Gson gson = new Gson();
        String jsonObject = gson.toJson(object);
        String values = "tabla=trabajadores&datos=" + jsonObject;
        String respuesta = HttpRequest.POST_REQUEST(Constantes.URL_EXIST, values);
        Trabajador trabajador = (Trabajador) Decodificaciones.deserializeTrabajador(respuesta);
        return trabajador;
    } 
    
    public static ArrayList<Cliente> ListarClientes(){
        ArrayList<Cliente> lista = new ArrayList<>();
        Gson gson = new Gson();
        String values = "tabla=clientes";
        String respuesta = HttpRequest.GET_REQUEST(Constantes.URL_SELECT, values);
        lista = (ArrayList<Cliente>) Decodificaciones.deserializeArrayCliente(respuesta);
        return lista;
    }
    
      public static Cliente existeCliente(String nombretabla,Cliente object){
        Gson gson = new Gson();
        String jsonObject = gson.toJson(object);
        String values = "tabla=" +nombretabla+"&datos=" + jsonObject;
        String respuesta = HttpRequest.POST_REQUEST(Constantes.URL_EXIST, values);
        Cliente cliente = Decodificaciones.deserializeCliente(respuesta);
        return cliente;
    }
      
      public static ArrayList<Mesa> ListarMesas(){
        ArrayList<Mesa> lista = new ArrayList<>();
        Gson gson = new Gson();
        String values = "tabla=mesas";
        String respuesta = HttpRequest.GET_REQUEST(Constantes.URL_SELECT, values);
        lista = (ArrayList<Mesa>) Decodificaciones.deserializeArrayMesa(respuesta);
        return lista;
    }
    
      public static Mesa existeMesa(String nombretabla,Mesa object){
        Gson gson = new Gson();
        String jsonObject = gson.toJson(object);
        String values = "tabla=" +nombretabla+"&datos=" + jsonObject;
        String respuesta = HttpRequest.POST_REQUEST(Constantes.URL_EXIST, values);
        Mesa mesa = Decodificaciones.deserializeMesa(respuesta);
        return mesa;
    }
      
      public static ArrayList<Pedido> ListarPedidos(){
        ArrayList<Pedido> lista = new ArrayList<>();
        Gson gson = new Gson();
        String values = "tabla=pedidos";
        String respuesta = HttpRequest.GET_REQUEST(Constantes.URL_SELECT, values);
        lista = (ArrayList<Pedido>) Decodificaciones.deserializeArrayPedido(respuesta);
        return lista;
    }
    
      public static Pedido existePedido(String nombretabla,Pedido object){
        Gson gson = new Gson();
        String jsonObject = gson.toJson(object);
        String values = "tabla=" +nombretabla+"&datos=" + jsonObject;
        String respuesta = HttpRequest.POST_REQUEST(Constantes.URL_EXIST, values);
        Pedido pedido = Decodificaciones.deserializePedido(respuesta);
        return pedido;
    }
      
      public static ArrayList<Producto> ListarProductos(){
        ArrayList<Producto> lista = new ArrayList<>();
        Gson gson = new Gson();
        String values = "tabla=productos";
        String respuesta = HttpRequest.GET_REQUEST(Constantes.URL_SELECT, values);
        lista = (ArrayList<Producto>) Decodificaciones.deserializeArrayProducto(respuesta);
        return lista;
    }
    
      public static Producto existeProducto(String nombretabla,Producto object){
        Gson gson = new Gson();
        String jsonObject = gson.toJson(object);
        String values = "tabla=" +nombretabla+"&datos=" + jsonObject;
        String respuesta = HttpRequest.POST_REQUEST(Constantes.URL_EXIST, values);
        Producto producto = Decodificaciones.deserializeProducto(respuesta);
        return producto;
    }
      
      public static ArrayList<Productos_Pedidos> ListarProductos_Pedidos(){
        ArrayList<Productos_Pedidos> lista = new ArrayList<>();
        Gson gson = new Gson();
        String values = "tabla=productos_pedidos";
        String respuesta = HttpRequest.GET_REQUEST(Constantes.URL_SELECT, values);
        lista = (ArrayList<Productos_Pedidos>) Decodificaciones.deserializeArrayProductos_Pedidos(respuesta);
        return lista;
    }
    
      public static Productos_Pedidos existeProductos_Pedidos(String nombretabla,Productos_Pedidos object){
        Gson gson = new Gson();
        String jsonObject = gson.toJson(object);
        String values = "tabla=" +nombretabla+"&datos=" + jsonObject;
        String respuesta = HttpRequest.POST_REQUEST(Constantes.URL_EXIST, values);
        Productos_Pedidos productos_pedidos = Decodificaciones.deserializeProductos_Pedidos(respuesta);
        return productos_pedidos;
    }
      
      public static ArrayList<Reserva> ListarReservas(){
        ArrayList<Reserva> lista = new ArrayList<>();
        Gson gson = new Gson();
        String values = "tabla=reservas";
        String respuesta = HttpRequest.GET_REQUEST(Constantes.URL_SELECT, values);
        lista = (ArrayList<Reserva>) Decodificaciones.deserializeArrayReserva(respuesta);
        return lista;
    }
    
      public static Reserva existeReserva(String nombretabla,Reserva object){
        Gson gson = new Gson();
        String jsonObject = gson.toJson(object);
        String values = "tabla=" +nombretabla+"&datos=" + jsonObject;
        String respuesta = HttpRequest.POST_REQUEST(Constantes.URL_EXIST, values);
        Reserva reserva = Decodificaciones.deserializeReserva(respuesta);
        return reserva;
    }
      
      public static Reserva reservaYaHecha(Reserva object){
        Gson gson = new Gson();
        String jsonObject = gson.toJson(object);
        String values = "tabla=reservas&datos=" + jsonObject;
        String respuesta = HttpRequest.POST_REQUEST(Constantes.URL_EXIST_RESERVA, values);
        Reserva reserva = Decodificaciones.deserializeReserva(respuesta);
        return reserva;
    }
    
    public static RespuestaJson insertar(String nombretabla,Object object){
        Gson gson = new Gson();
        String jsonObject = gson.toJson(object);
        String values = "tabla=" +nombretabla+"&datos=" + jsonObject;
        String respuesta = HttpRequest.POST_REQUEST(Constantes.URL_INSERT, values);
        JsonElement jsonElement = gson.fromJson(respuesta, JsonElement.class);
        RespuestaJson respuestaJson = Decodificaciones.deserializeMensajes(jsonElement.getAsString());
        return respuestaJson;
    }
    
    public static RespuestaJson actualizar(String nombretabla,Object object){
        Gson gson = new Gson();
        String jsonObject = gson.toJson(object);
        String values = "tabla=" +nombretabla+"&datos=" + jsonObject;
        String respuesta = HttpRequest.POST_REQUEST(Constantes.URL_MODIFY, values);
        JsonElement jsonElement = gson.fromJson(respuesta, JsonElement.class);
        RespuestaJson respuestaJson = Decodificaciones.deserializeMensajes(jsonElement.getAsString());
        return respuestaJson;
    }
    
 public static RespuestaJson eliminar(String nombretabla,Object object){
        Gson gson = new Gson();
        String jsonObject = gson.toJson(object);
        String values = "tabla=" +nombretabla+"&datos=" + jsonObject;
        String respuesta = HttpRequest.POST_REQUEST(Constantes.URL_DELETE, values);
        JsonElement jsonElement = gson.fromJson(respuesta, JsonElement.class);
        RespuestaJson respuestaJson = Decodificaciones.deserializeMensajes(jsonElement.getAsString());
        return respuestaJson;
    }   
}