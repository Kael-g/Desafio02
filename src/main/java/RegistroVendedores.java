import java.util.ArrayList;

public class RegistroVendedores {
    private ArrayList<Vendedor> vendedoresRegistrados;

    public RegistroVendedores() {
        this.vendedoresRegistrados = new ArrayList<>();
    }

    public ArrayList<Vendedor> getVendedoresRegistrados() {
        return vendedoresRegistrados;
    }

    public void novoVendedor(Vendedor vendedor){
        vendedoresRegistrados.add(vendedor);
    }
}
