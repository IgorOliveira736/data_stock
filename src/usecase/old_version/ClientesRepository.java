package repository;

import model.Clientes;
import model.Produto;

import java.util.ArrayList;

public class ClientesRepository {

    private static ArrayList<Clientes> listaClientes = new ArrayList<>();

    public static String adicionarClientes(Clientes clientes) {
        listaClientes.add(clientes);
        return "Cliente adicionado com sucesso!";
    }

    public static String mostrarClientes() {
        StringBuilder sb = new StringBuilder();
        for (Clientes clientes : listaClientes){
            sb.append(clientes.toString()).append("\n");
        }
        return sb.toString();
    }

    public static Clientes pesquisarClientes(int numeroPedido) {
        for (Clientes clientes : listaClientes) {
            if (clientes.getNumeroPedido() == numeroPedido) return clientes;
        }
        return null;
    }

    public static boolean apagarCliente(int numeroPedido) {
        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).getNumeroPedido() == numeroPedido) listaClientes.remove(i);
            return true;
        }
        return false;
    }

    public static Clientes editarCliente(int numeroPedido, Clientes novoCliente) {
        apagarCliente(numeroPedido);
        adicionarClientes(novoCliente);
        return novoCliente;
    }

    public static boolean clienteExiste(int numeroPedido) {
        return listaClientes.stream().anyMatch(cliente -> cliente.getNumeroPedido() == numeroPedido);
    }
}
