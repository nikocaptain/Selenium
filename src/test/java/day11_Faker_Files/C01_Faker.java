package day11_Faker_Files;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C01_Faker {

    @Test
    public void faker() {
/*
    Faker class'ı ile sahte datalar oluşturabilmek için öncelikle mvnrepository.com adresinden github-javafaker
dependency'i pom.xml dosyasına koymamız gerekiyor. Sonra Faker class'ından bir obje oluşturup fake datalar
üretebiliriz.
 */
        Faker faker=new Faker();
        System.out.println(faker.name().firstName());

        System.out.println(faker.name().lastName());

        System.out.println(faker.address().fullAddress());

        System.out.println(faker.phoneNumber().phoneNumber());

        System.out.println(faker.internet().emailAddress());

        System.out.println(faker.number().digits(15));

        System.out.println(faker.name().fullName());

        String avatar=faker.avatar().image();
        System.out.println(faker.pokemon().name());
        System.out.println(faker.pokemon().location());
    }
}
