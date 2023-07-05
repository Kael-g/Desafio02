import java.util.ArrayList;

public class RegistroClientes {
    private ArrayList<Cliente> clientesRegistrados;

    public RegistroClientes() {
        this.clientesRegistrados = new ArrayList<>();
    }

    public ArrayList<Cliente> getClientesRegistrados() {
        return clientesRegistrados;
    }

    public void novoCliente(Cliente cliente){
        clientesRegistrados.add(cliente);
    }
}
