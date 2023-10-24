package teste02;

import java.util.Objects;

public class Cliente{
    private String cpf;
    private String nome;
    private String username;
    private Integer idade;

    public Cliente(String cpf, String nome, String username, Integer idade) {
        this.cpf = cpf;
        this.nome = nome;
        this.username = username;
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    
    public String toString() {
        return "Cliente [cpf=" + cpf + ", nome=" + nome + ", username=" + username + ", idade=" + idade + "]";
    }

    
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Cliente other = (Cliente) obj;
        return Objects.equals(cpf, other.cpf) &&
               Objects.equals(nome, other.nome) &&
               Objects.equals(username, other.username) &&
               Objects.equals(idade, other.idade);
    }

    
    public int hashCode() {
        return Objects.hash(cpf, nome, username, idade);
    }
}