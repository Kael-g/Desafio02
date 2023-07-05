import java.math.BigDecimal;
import java.util.Date;

public class Venda {
    private Vendedor vendedor;
    private Cliente cliente;
    private BigDecimal valor;
    private Date dataDeRegistro;

    public Venda(Vendedor vendedor, Cliente cliente, BigDecimal valor, Date dataDeRegistro) {
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.valor = valor;
        this.dataDeRegistro = dataDeRegistro;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getDataDeRegistro() {
        return dataDeRegistro;
    }

    public void setDataDeRegistro(Date dataDeRegistro) {
        this.dataDeRegistro = dataDeRegistro;
    }
}
