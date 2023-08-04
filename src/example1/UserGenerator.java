package example1;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class UserGenerator {
    // İsim havuzu
    private static String[] names = {
            "Ahmet", "Mehmet", "Ayşe", "Fatma", "Ali", "Mustafa", "Zeynep", "Emine", "Can", "Burak", "Esra", "Elif", "Merve", "Selin"
    };

    // Soyisim havuzu
    private static String[] lastNames = {
            "Yılmaz", "Kaya", "Demir", "Çelik", "Arslan", "Öztürk", "Özdemir", "Koç", "Şahin", "Yıldız", "Doğan", "Güneş", "Özkan", "Yıldırım"
    };

    // Şehir havuzu
    private static String[] cities = {
            "İstanbul", "Ankara", "İzmir", "Bursa", "Antalya", "Adana", "Konya", "Kayseri", "Eskişehir", "Diyarbakır", "Trabzon", "Samsun", "Gaziantep", "Mersin"
    };

    public static List<User> getRandomUser(int val) {
        User[] users = new User[val];
        Random random = new Random();

        for (int i = 0; i < val; i++) {
            String id = String.valueOf(i + 1); // Her kullanıcı için farklı bir ID atayabilirsiniz veya başka bir yöntem kullanabilirsiniz.
            String name = names[random.nextInt(names.length)];
            String lastName = lastNames[random.nextInt(lastNames.length)];
            String city = cities[random.nextInt(cities.length)];
            int age = random.nextInt(50) + 18; // 18-67 arasında rastgele bir yaş seçiyorum.

            users[i] = new User(id, name, lastName, city, age);
        }

        // Oluşturulan kullanıcıları kullanabilirsiniz...
        for (User user : users) {
            System.out.println(user.getName() + " " + user.getLastName() + " - " + user.getCity() + " - " + user.getAge());
        }
        System.out.println("******************************************************************");
        System.out.println("******************************************************************");
        return Arrays.asList(users);
    }
}
