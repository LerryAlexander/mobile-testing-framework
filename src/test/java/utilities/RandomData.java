package utilities;

import com.github.javafaker.Faker;
import com.github.javafaker.Lorem;

import java.util.Locale;

public class RandomData {

    Faker faker = new Faker(new Locale("en-US"));

    public String firstName(){
        return faker.name().firstName();
    }

    public String lastName(){
        return faker.name().lastName();
    }

    public String email(){
        return faker.name().username()+"@gmail.com";
    }

    public String companyName(){
        return faker.company().name();
    }

    public String companyWebsite(){
        return "https://www."+companyName()+".com";
    }

}
