import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GerenciaVendas {

    private RegistroVendas registroVendas;
    private RegistroClientes registroClientes;
    private RegistroVendedores registroVendedores;
    private Validacoes validacoes;
    private Pesquisas pesquisas;

    public GerenciaVendas() {
        this.registroVendas = new RegistroVendas();
        this.registroClientes = new RegistroClientes();
        this.registroVendedores = new RegistroVendedores();
        this.validacoes = new Validacoes();
        this.pesquisas = new Pesquisas();
    }

    public void cadastrarCliente(String nome, String cpf, String email){
        if (nome.length() == 0){
            throw new UnsupportedOperationException("Nome inválido");
        }
        if (!validacoes.validaCpf(cpf)){
            throw new IllegalArgumentException("Cpf inválido");
        }
        if (!validacoes.validaEmail(email)){
            throw new IllegalArgumentException("E-mail inválido");
        }
        cpf = removeSimbolos(cpf);
        if (!validacoes.validaCpfClienteNaoRegistrado(cpf,registroClientes.getClientesRegistrados())){
            throw new UnsupportedOperationException("Já existe cliente cadastrado com o CPF informado");
        }
        if (!validacoes.validaEmailClienteNaoRegistrado(email,registroClientes.getClientesRegistrados())){
            throw new UnsupportedOperationException("Já existe cliente cadastrado com o e-mail informado");
        }
        registroClientes.novoCliente(new Cliente(nome, cpf, email));
    }

    public void cadastrarVendedor(String nome, String cpf, String email){
        if (nome.length() == 0){
            throw new UnsupportedOperationException("Nome inválido");
        }
        if (!validacoes.validaCpf(cpf)){
            throw new IllegalArgumentException("Cpf inválido");
        }
        if (!validacoes.validaEmail(email)){
            throw new IllegalArgumentException("E-mail inválido");
        }
        cpf = removeSimbolos(cpf);
        if (!validacoes.validaCpfVendedorNaoRegistrado(cpf,registroVendedores.getVendedoresRegistrados())){
            throw new UnsupportedOperationException("Já existe vendedor cadastrado com o CPF informado");
        }
        if (!validacoes.validaEmailVendedorNaoRegistrado(email,registroVendedores.getVendedoresRegistrados())){
            throw new UnsupportedOperationException("Já existe vendedor cadastrado com o e-mail informado");
        }
        registroVendedores.novoVendedor(new Vendedor(nome, cpf, email));
    }

    public void cadastrarVenda(Cliente cliente, Vendedor vendedor, String valor, Date data){
        if (!validacoes.validaCliente(cliente, registroClientes.getClientesRegistrados())){
            throw new IllegalArgumentException("Cliente não encontrado");
        }
        if (!validacoes.validaVendedor(vendedor, registroVendedores.getVendedoresRegistrados())){
            throw new IllegalArgumentException("Vendedor não encontrado");
        }
        if (!validacoes.validaValor(valor)){
            throw new IllegalArgumentException("Valor inválido");
        }
        registroVendas.novaVenda(new Venda(vendedor,cliente,new BigDecimal(valor),data));
    }

    public void listarVendas(){
        DecimalFormat df = new DecimalFormat("#,##0.00");
        DateFormat dt = new SimpleDateFormat("dd/MM/yyyy");

        for (Venda venda : registroVendas.getVendasRegistradas()){
            System.out.println("Vendedor: " + venda.getVendedor().getNome());
            System.out.println("Cliente: " + venda.getCliente().getNome());
            System.out.println("Valor da venda: R$ " + df.format(venda.getValor()));
            System.out.println("Data de registro: " + dt.format(venda.getDataDeRegistro()) + "\n");
        }
    }

    public void listarVendedores(){
        for (Vendedor vendedor : registroVendedores.getVendedoresRegistrados()){
            System.out.println("Nome do vendedor: " + vendedor.getNome());
            System.out.println("E-mail: " + vendedor.getEmail());
            System.out.println("CPF: " + vendedor.getCpf() + "\n");
        }
    }

    public void listarClientes(){
        for (Cliente cliente : registroClientes.getClientesRegistrados()){
            System.out.println("Nome do cliente: " + cliente.getNome());
            System.out.println("E-mail: " + cliente.getEmail());
            System.out.println("CPF: " + cliente.getCpf() + "\n");
        }
    }

    public void historicoCliente(String cpf){
        DecimalFormat df = new DecimalFormat("#,##0.00");
        DateFormat dt = new SimpleDateFormat("dd/MM/yyyy");

        if (!validacoes.validaCpf(cpf)){
            throw new IllegalArgumentException("CPF inválido");
        }
        cpf = removeSimbolos(cpf);

        if (validacoes.validaCpfClienteNaoRegistrado(cpf, registroClientes.getClientesRegistrados())){
            throw new IllegalArgumentException("CPF não encontrado");
        }

        for (Venda venda : pesquisas.historicoComprasCliente(cpf,registroVendas.getVendasRegistradas())){
            System.out.println("Vendedor: " + venda.getVendedor().getNome());
            System.out.println("Valor da venda: R$ " + df.format(venda.getValor()));
            System.out.println("Data de registro: " + dt.format(venda.getDataDeRegistro()) + "\n");
        }
    }

    public void historicoVendedor(String email){
        DecimalFormat df = new DecimalFormat("#,##0.00");
        DateFormat dt = new SimpleDateFormat("dd/MM/yyyy");

        if (!validacoes.validaEmail(email)){
            throw new IllegalArgumentException("E-mail inválido");
        }
        if (validacoes.validaEmailVendedorNaoRegistrado(email, registroVendedores.getVendedoresRegistrados())){
            throw new IllegalArgumentException("Vendedor não encontrado");
        }

        for (Venda venda : pesquisas.historicoVendasVendedor(email,registroVendas.getVendasRegistradas())){
            System.out.println("Cliente: " + venda.getCliente().getNome());
            System.out.println("Valor da venda: R$ " + df.format(venda.getValor()));
            System.out.println("Data de registro: " + dt.format(venda.getDataDeRegistro()) + "\n");
        }
    }

    public Vendedor encontrarVendedorCpf(String cpf){
        Vendedor vendedor = null;
        if (!validacoes.validaCpf(cpf)){
            throw new IllegalArgumentException("CPF inválido");
        }
        cpf = removeSimbolos(cpf);
        if (validacoes.validaCpfVendedorNaoRegistrado(cpf, registroVendedores.getVendedoresRegistrados())){
            throw new IllegalArgumentException("Vendedor não encontrado");
        }
        for (Vendedor v : registroVendedores.getVendedoresRegistrados()){
            if (v.getCpf().equals(cpf)){
                vendedor = v;
            }
        }
        return vendedor;
    }

    public Cliente encontrarClienteCpf(String cpf){
        Cliente cliente = null;
        if (!validacoes.validaCpf(cpf)){
            throw new IllegalArgumentException("CPF inválido");
        }
        cpf = removeSimbolos(cpf);
        if (validacoes.validaCpfClienteNaoRegistrado(cpf, registroClientes.getClientesRegistrados())){
            throw new IllegalArgumentException("Cliente não encontrado");
        }
        for (Cliente c : registroClientes.getClientesRegistrados()){
            if (c.getCpf().equals(cpf)){
                cliente = c;
            }
        }
        return cliente;
    }

    private String removeSimbolos(String s){
        s = s.replace(".","");
        s = s.replace("-","");
        return s;
    }

}
