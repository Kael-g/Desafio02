import java.util.ArrayList;

public class RegistroVendas {
    private ArrayList<Venda> vendasRegistradas;

    public RegistroVendas() {
        this.vendasRegistradas = new ArrayList<>();
    }

    public ArrayList<Venda> getVendasRegistradas() {
        return vendasRegistradas;
    }

    public void novaVenda (Venda venda){
        vendasRegistradas.add(venda);
    }
}
