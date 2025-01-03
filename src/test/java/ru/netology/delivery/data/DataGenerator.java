package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;
import lombok.val;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        LocalDate currentDate = LocalDate.now().plusDays(3);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String date = currentDate.format(formatter);
        return date;
    }

    public static String generateCity(String locale) {
        Faker faker = new Faker(new Locale("ru"));
        String city = faker.address().city();
        return city;
    }

    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale("ru"));
        String name = faker.name().fullName();
        return name;
    }

    public static String generatePhone(String locale) {
        Faker faker = new Faker(new Locale("ru"));
        String phone = faker.phoneNumber().phoneNumber();
        return phone;
    }
    public static String generateWrongPhone(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.numerify("####");
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            Faker faker = new Faker(new Locale("ru"));
            return new UserInfo(
                    faker.address().city(),
                    faker.name().fullName(),
                    faker.phoneNumber().phoneNumber()
            );

        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}
