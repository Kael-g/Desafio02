import java.util.ArrayList;

public class Pesquisas {

    public ArrayList<Venda> historicoComprasCliente (String cpf, ArrayList<Venda> vendasRegistradas){
        cpf = cpf.replace(".","");
        cpf = cpf.replace("-","");
        ArrayList<Venda> comprasCliente = new ArrayList<>();
        for (Venda venda : vendasRegistradas){
            if (venda.getCliente().getCpf().equals(cpf)){
                comprasCliente.add(venda);
            }
        }
        return comprasCliente;
    }


    public ArrayList<Venda> historicoVendasVendedor (String email, ArrayList<Venda> vendasRegistradas){
        ArrayList<Venda> vendasVendedor = new ArrayList<>();
        for (Venda venda : vendasRegistradas){
            if (venda.getVendedor().getEmail().equals(email)){
                vendasVendedor.add(venda);
            }
        }
        return vendasVendedor;
    }

}
