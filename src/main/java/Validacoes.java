import java.util.ArrayList;
import java.util.Date;

public class Validacoes {
    public boolean validaEmail(String email){
        return email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }

    public boolean validaEmailClienteNaoRegistrado(String email, ArrayList<Cliente> listaRegistrados){
        for (Cliente cliente : listaRegistrados){
            if (cliente.getEmail().equals(email)) {
                return false;
            }
        }
            return  true;
    }

    public boolean validaEmailVendedorNaoRegistrado(String email, ArrayList<Vendedor> listaRegistrados){
        for (Vendedor vendedor : listaRegistrados){
            if (vendedor.getEmail().equals(email)) {
                return false;
            }
        }
        return  true;
    }

    public boolean validaCpf(String cpf){
        return cpf.matches("^[0-9]{3}\\.?[0-9]{3}\\.?[0-9]{3}-?[0-9]{2}$");
    }

    public boolean validaCpfClienteNaoRegistrado(String cpf, ArrayList<Cliente> listaRegistrados){
        for (Cliente cliente : listaRegistrados){
            if (cliente.getCpf().equals(cpf)) {
                return false;
            }
        }
        return true;
    }

    public boolean validaCpfVendedorNaoRegistrado(String cpf, ArrayList<Vendedor> listaRegistrados){
        for (Vendedor vendedor : listaRegistrados){
            if (vendedor.getCpf().equals(cpf)) {
                return false;
            }
        }
        return true;
    }

    public boolean validaCliente(Cliente cliente, ArrayList<Cliente> clientesRegistrados){
        return clientesRegistrados.contains(cliente);
    }

    public boolean validaVendedor(Vendedor vendedor, ArrayList<Vendedor> vendedoresRegistrados){
        return vendedoresRegistrados.contains(vendedor);
    }

    public boolean validaValor(String valor){
        return valor.matches("(^[0-9]+\\.[0-9]{1,2}$)|(^[0-9]+$)");
    }
}
