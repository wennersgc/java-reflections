package wennersgc;

public class PessoaFixture {

    public static Pessoa buildPessoa() {
       return new Pessoa(1, "wenner", "99999");
    }

    public static Pessoa buildPessoaSemCPF() {
       return new Pessoa("wenner");
    }

}
