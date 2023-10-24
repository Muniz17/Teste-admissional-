package teste02;

public class empresa {
    private Integer id;
    private String nome;
    private String cnpj;
    private Double taxaDeJuros;
    private Double saldo;

    public empresa(Integer id, String nome, String cnpj, Double taxaDeJuros, Double saldo) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.taxaDeJuros = taxaDeJuros;
        this.saldo = saldo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Double getTaxaDeJuros() {
        return taxaDeJuros;
    }

    public void setTaxaDeJuros(Double taxaDeJuros) {
        this.taxaDeJuros = taxaDeJuros;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
