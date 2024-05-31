package wennersgc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import wennersgc.rfl.Transformator;

import java.lang.reflect.InvocationTargetException;

class TransformatorTest {

    Endereco endereco = new Endereco("rua 10", 3);


    @Test
    public void deveTransformar() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Transformator transformator = new Transformator();
        Pessoa pessoa = PessoaFixture.buildPessoa();
        PessoaDTO pessoaDTO = transformator.transform(pessoa);

        Assertions.assertInstanceOf(PessoaDTO.class, pessoaDTO);
        Assertions.assertEquals(pessoa.getNome(), pessoaDTO.getNome());
    }

    @Test
    public void naoDeveTransformar() {
        Assertions.assertThrows(ClassNotFoundException.class, () -> {
            Transformator transformator = new Transformator();
            transformator.transform(endereco);
        });
    }

    @Test
    public void deveTransformarSeCampoForNull() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        Transformator transformator = new Transformator();
        Pessoa pessoaSemCPF = PessoaFixture.buildPessoaSemCPF();
        PessoaDTO pessoaDToSemCPF = transformator.transform(pessoaSemCPF);

        Assertions.assertEquals(pessoaSemCPF.getNome(), pessoaDToSemCPF.getNome());
        Assertions.assertNull(pessoaSemCPF.getCpf());
    }

}