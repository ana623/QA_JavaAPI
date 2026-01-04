package lib;

import java.text.SimpleDateFormat;
import java.util.*;

public class DataGenerator {
    public static String getRandomEmail () {
        // здесь получаем уникальное число yyyyMMddHHmmss и затем добаляем его к email перед доменом, например learnqa20250109172855@example.com
        // теперь на основе этого метода можно написать ПОЗИТИВНЫЙ тест на регистрацию user в классе UserRegisterTest
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
        return "learnqa" + timestamp + "@example.com";
    }

    public static Map<String, String> getRegistrationData() { // метод без параметра возвращает дефолтные значения, включая случайно созданный емейл
        Map<String, String> data = new HashMap<>();
        data.put("email", DataGenerator.getRandomEmail());
        data.put("password", "123");
        data.put("username", "learnqa");
        data.put("firstName", "learnqa");
        data.put("lastName", "learnqa");

        return data;
    }
    // в тесте, когда мы пытаемся создать пользователя с уже существующим мейлом, метод выше будет неудобен: нам не нужно, чтобы метод возвращал случайный емейл
    // нам надо, чтобы он отдал конкретный емейл: тот, который уже есть в системе
    // для этого создаем второй метод (с тем же названием). В него передаем хэшмап. В хэшмапе будут те данные, которые мы хотим задать сами, а не получать дефолтные значение
    public static Map<String, String> getRegistrationData(Map<String, String> nonDefaultValues) { //передаем переменную nonDefaultValues, которая указывает на объект типа Map
        Map<String, String> defaultValues = DataGenerator.getRegistrationData();

        Map<String, String> userData = new HashMap<>();
        String[] keys = {"email", "password", "username", "firstName", "lastName"};
        for (String key : keys) { // пробегаем по массиву параметров email, password, username ...
            if (nonDefaultValues.containsKey(key)) {  // вызывается метод containsKey для объекта nonDefaultValues (любой объект типа Map имеет такой метод), возвращающий true, если присутствует такое название ключа
                userData.put(key, nonDefaultValues.get(key)); // если значение содержит значение, отличное от деолтного, что в userData запишется это значение
            } else {
                userData.put(key, defaultValues.get(key));
            }
        }
        return userData;
    }
}
