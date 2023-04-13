/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;
import modelo.Mesa;
import modelo.Pedido;
import modelo.Producto;
import modelo.Productos_Pedidos;
import modelo.Reserva;
import modelo.Trabajador;
import modelo.Usuario;

/**
 *
 * @author Esme
 */
public class Decodificaciones {
    
    public static Usuario deserializeUsuario(String myJsonString) {
        Gson gson = new GsonBuilder().create();
        Usuario user = gson.fromJson(myJsonString, Usuario.class);
        return user;
    }
    
    public static List deserializeArrayUsuario(String myJsonString) {
        Gson gson = new GsonBuilder().create();
        Type listType = new TypeToken<ArrayList<Usuario>>(){}.getType();
        List<Usuario> users = gson.fromJson(myJsonString, listType);
        return users;
    }
    
    public static Cliente deserializeCliente(String myJsonString) {
        Gson gson = new GsonBuilder().create();
        Cliente cliente = gson.fromJson(myJsonString, Cliente.class);
        return cliente;
    }
    
    public static List deserializeArrayCliente(String myJsonString) {
        Gson gson = new GsonBuilder().create();
        Type listType = new TypeToken<ArrayList<Cliente>>(){}.getType();
        List<Cliente> cliente = gson.fromJson(myJsonString, listType);
        return cliente;
    }
    
    public static Mesa deserializeMesa(String myJsonString) {
        Gson gson = new GsonBuilder().create();
        Mesa mesa = gson.fromJson(myJsonString, Mesa.class);
        return mesa;
    }
    
    public static List deserializeArrayMesa(String myJsonString) {
        Gson gson = new GsonBuilder().create();
        Type listType = new TypeToken<ArrayList<Mesa>>(){}.getType();
        List<Mesa> mesa = gson.fromJson(myJsonString, listType);
        return mesa;
    }
    
    public static Pedido deserializePedido(String myJsonString) {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-mm-dd hh:mm:ss").create();
        Pedido pedido = gson.fromJson(myJsonString, Pedido.class);
        return pedido;
    }
    
    public static List deserializeArrayPedido(String myJsonString) {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-mm-dd hh:mm:ss").create();
        Type listType = new TypeToken<ArrayList<Pedido>>(){}.getType();
        List<Pedido> pedido = gson.fromJson(myJsonString, listType);
        return pedido;
    }
    
    public static Producto deserializeProducto(String myJsonString) {
        Gson gson = new GsonBuilder().create();
        Producto producto = gson.fromJson(myJsonString, Producto.class);
        return producto;
    }
    
    public static List deserializeArrayProducto(String myJsonString) {
        Gson gson = new GsonBuilder().create();
        Type listType = new TypeToken<ArrayList<Producto>>(){}.getType();
        List<Producto> producto = gson.fromJson(myJsonString, listType);
        return producto;
    }
    
    public static Productos_Pedidos deserializeProductos_Pedidos(String myJsonString) {
        Gson gson = new GsonBuilder().create();
        Productos_Pedidos productos_pedidos = gson.fromJson(myJsonString, Productos_Pedidos.class);
        return productos_pedidos;
    }
    
    public static List deserializeArrayProductos_Pedidos(String myJsonString) {
        Gson gson = new GsonBuilder().create();
        Type listType = new TypeToken<ArrayList<Productos_Pedidos>>(){}.getType();
        List<Productos_Pedidos> productos_pedidos = gson.fromJson(myJsonString, listType);
        return productos_pedidos;
    }
    
    public static Reserva deserializeReserva(String myJsonString) {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-mm-dd hh:mm:ss").create();
        Reserva reserva = gson.fromJson(myJsonString, Reserva.class);
        return reserva;
    }
    
    public static List deserializeArrayReserva(String myJsonString) {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-mm-dd hh:mm:ss").create();
        Type listType = new TypeToken<ArrayList<Reserva>>(){}.getType();
        List<Reserva> reserva = gson.fromJson(myJsonString, listType);
        return reserva;
    }
    
    public static Trabajador deserializeTrabajador(String myJsonString) {
        Gson gson = new GsonBuilder().create();
        Trabajador trabajador = gson.fromJson(myJsonString, Trabajador.class);
        return trabajador;
    }
    
    public static List deserializeArrayTrabajador(String myJsonString) {
        Gson gson = new GsonBuilder().create();
        Type listType = new TypeToken<ArrayList<Trabajador>>(){}.getType();
        List<Trabajador> trabajador = gson.fromJson(myJsonString, listType);
        return trabajador;
    }
    
    public static RespuestaJson deserializeMensajes(String myJsonString) {
        Gson gson = new GsonBuilder().create();
        RespuestaJson respuestaJson = gson.fromJson(myJsonString, RespuestaJson.class);
        return respuestaJson;
    }
}
