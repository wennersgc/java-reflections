package wennersgc;

import wennersgc.rfl.ObjectoToJson;

public class Main {
    public static void main(String[] args) {

        Pessoa wenner = new Pessoa(1, "wenner", "333");
        ObjectoToJson objectoToJson = new ObjectoToJson();
        String json = objectoToJson.transform(wenner);

        System.out.println(json);

    }
}