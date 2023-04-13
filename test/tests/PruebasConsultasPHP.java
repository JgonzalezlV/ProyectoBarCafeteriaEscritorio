/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import java.sql.Timestamp;
import java.util.ArrayList;
import modelo.Cliente;
import modelo.Pedido;
import modelo.Reserva;
import modelo.Trabajador;
import modelo.Usuario;
import utilidades.Constantes;
import utilidades.Decodificaciones;
import utilidades.HttpRequest;
import utilidades.RespuestaJson;
import utilidades.ValidarDatos;

/**
 *
 * @author negu2
 */
public class PruebasConsultasPHP {

    public static void main(String[] args) {
        //Funciona
        //logueoUsuario();
        //Funciona, ya esta insertado el usuario
        //insertarUsuario();
        //No FUNCIONA!!!!
        //eliminarUsuario();
        //mostrarTodosLosUsuarios();
        /*Usuario user = new Usuario("652000111");
        user = existeUsuario("usuarios", user);
        System.out.println(user);
        Cliente c = new Cliente(3);
        c = existeCliente("clientes", c);
        System.out.println(c);*/
 /*Cliente cliente = existeCliente("clientes", new Cliente(2));
        System.out.println(cliente);*/
 /*Trabajador trabajador = existeTrabajador("trabajadores", new Trabajador(1));
        System.out.println(trabajador);*/
 /*System.out.println(ValidarDatos.validarTelefono("5896321478"));
        System.out.println(ValidarDatos.validarTelefono("589632147"));
        System.out.println(ValidarDatos.validarTelefono("58967"));*/
        //System.out.println(existePedido("pedidos", new Pedido(2)));
        System.out.println(reservaYaHecha(new Reserva(1,"2023-03-08 16:30:00")));
    }

    public static Reserva reservaYaHecha(Reserva object) {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-mm-dd hh:mm:ss").create();
        String jsonObject = gson.toJson(object);
        String values = "datos=" + jsonObject;
        String url = values.replace(" ", "%20");
        String respuesta = HttpRequest.GET_REQUEST(Constantes.URL_EXIST_RESERVA, url);
        System.out.println(url);
        System.out.println(respuesta);
        Reserva reserva = Decodificaciones.deserializeReserva(respuesta);
        return reserva;
    }

    public static Pedido existePedido(String nombretabla, Pedido object) {
        Gson gson = new Gson();
        String jsonObject = gson.toJson(object);
        String values = "tabla=" + nombretabla + "&datos=" + jsonObject;
        String respuesta = HttpRequest.POST_REQUEST(Constantes.URL_EXIST, values);
        Pedido pedido = Decodificaciones.deserializePedido(respuesta);
        return pedido;
    }

    public static Trabajador existeTrabajador(String nombretabla, Trabajador object) {
        Gson gson = new Gson();
        String jsonObject = gson.toJson(object);
        String values = "tabla=" + nombretabla + "&datos=" + jsonObject;
        String respuesta = HttpRequest.POST_REQUEST(Constantes.URL_EXIST, values);
        Trabajador trabajador = (Trabajador) Decodificaciones.deserializeTrabajador(respuesta);
        return trabajador;
    }

    public static Cliente existeCliente(String nombretabla, Cliente object) {
        Gson gson = new Gson();
        String jsonObject = gson.toJson(object);
        String values = "tabla=" + nombretabla + "&datos=" + jsonObject;
        String respuesta = HttpRequest.POST_REQUEST(Constantes.URL_EXIST, values);
        Cliente cliente = Decodificaciones.deserializeCliente(respuesta);
        return cliente;
    }

    public static Usuario existeUsuario(String nombretabla, Usuario object) {
        Gson gson = new Gson();
        String jsonObject = gson.toJson(object);
        String values = "tabla=" + nombretabla + "&datos=" + jsonObject;
        String respuesta = HttpRequest.POST_REQUEST(Constantes.URL_EXIST, values);
        Usuario user = Decodificaciones.deserializeUsuario(respuesta);
        return user;
    }

    private static void mostrarTodosLosUsuarios() {
        ArrayList<Usuario> users = new ArrayList<>();
        Gson gson = new Gson();
        String values = "tabla=usuarios";
        String respuesta = HttpRequest.POST_REQUEST(Constantes.URL_SELECT, values);
        //JsonElement jsonElement = gson.fromJson(respuesta, JsonElement.class);
        users = (ArrayList<Usuario>) Decodificaciones.deserializeArrayUsuario(respuesta);
        for (Usuario user : users) {
            System.out.println(user.toString());
        }
    }

    private static void insertarUsuario() {
        Usuario user = new Usuario("cocinero2", "cocinero2", "Cocinero", "", "365892154", "trabajador");
        Gson gson = new Gson();
        String jsonObject = gson.toJson(user);
        String values = "tabla=usuarios&datos=" + jsonObject;
        String respuesta = HttpRequest.POST_REQUEST(Constantes.URL_INSERT, values);
        System.out.println(respuesta);
        JsonElement jsonElement = gson.fromJson(respuesta, JsonElement.class);
        RespuestaJson respuestaJson = Decodificaciones.deserializeMensajes(jsonElement.getAsString());
        System.out.println(respuestaJson);
    }

    private static void logueoUsuario() throws JsonSyntaxException {
        Usuario user = new Usuario("cocinero1", "cocinero1");
        Gson gson = new Gson();
        String jsonObject = gson.toJson(user);
        String values = "datos=" + jsonObject;
        String respuesta = HttpRequest.GET_REQUEST(Constantes.URL_LOGUEO, values);
        user = Decodificaciones.deserializeUsuario(respuesta);
        System.out.println(user);
    }

    private static void eliminarUsuario() {
        Usuario user = new Usuario(42);
        Gson gson = new Gson();
        String jsonObject = gson.toJson(user);
        String values = "tabla=usuarios&datos=" + jsonObject;
        String respuesta = HttpRequest.POST_REQUEST(Constantes.URL_DELETE, values);
        String jsonRespuesta = gson.toJson(respuesta);
        JsonElement json = gson.fromJson(jsonRespuesta, JsonElement.class);
        System.out.println(json.getAsString());
    }

}
