package wennersgc;

import wennersgc.rfl.Transformator;

import java.lang.reflect.InvocationTargetException;

public class PessoaService {

    public PessoaDTO list() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        PessoaRepository pessoaRepository = new PessoaRepository();
        Pessoa pessoa = pessoaRepository.list();
        Transformator transformator = new Transformator();
        return transformator.transform(pessoa);
    }
}
