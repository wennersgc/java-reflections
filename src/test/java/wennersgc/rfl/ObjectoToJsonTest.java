package wennersgc.rfl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import wennersgc.Pessoa;
import wennersgc.PessoaFixture;

class ObjectoToJsonTest {

    @Test
    public void deveTransformar()  {
        ObjectoToJson transformator = new ObjectoToJson();
        Pessoa pessoa = PessoaFixture.buildPessoa();
        String pessoJson = transformator.transform(pessoa);

        Assertions.assertInstanceOf(String.class, pessoJson);;
    }
}