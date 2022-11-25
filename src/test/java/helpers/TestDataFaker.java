package helpers;

import com.github.javafaker.Faker;

public class TestDataFaker {
    static Faker faker = new Faker();

    public static String
            password = faker.internet().password(),
            firstname = faker.name().firstName(),

            lastname = faker.name().lastName(),
            fullname = faker.name().fullName(),
            email = faker.internet().emailAddress();
}
