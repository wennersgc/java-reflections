package wennersgc.rfl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Objects;

public class Transformator {

    public <I, O> O transform(I input) throws ClassNotFoundException, NoSuchMethodException,
                                              InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> source = input.getClass();
        Class<?> target = Class.forName(source.getName() + "DTO");

        O targetClass = (O) target.getDeclaredConstructor().newInstance();

        Field[] sourceFields = source.getDeclaredFields();
        Field[] targetFields = target.getDeclaredFields();

        Arrays.stream(sourceFields).forEach(sourceField ->
                Arrays.stream(targetFields).forEach(targetField -> {
                    validate(sourceField, targetField);

                    try {
                        targetField.set(targetClass, sourceField.get(input));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }));

        return targetClass;
    }

    private void validate(Field sourceField, Field targetField) {
        if (Objects.equals(sourceField.getName(), targetField.getName())
                && Objects.equals(sourceField.getType(), targetField.getType()) ) {
            //como acessar atributos privados?
            //permitindo acesso aos campos privados (implicações?)
            sourceField.setAccessible(true);
            targetField.setAccessible(true);
        }
    }

}
