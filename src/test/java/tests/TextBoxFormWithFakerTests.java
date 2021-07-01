package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import components.CalendarComponent;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.util.Random;

import static com.codeborne.selenide.Selenide.*;

public class TextBoxFormWithFakerTests {

    private final String[] genders = {"Male", "Female", "Other"};
    private final String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private final static int START_YEAR = 1990;
    private final static int END_YEAR = 2020;
    private final static int START_DATE = 10;
    private final static int END_DATE = 28;
    private final String[] subjects = {"English", "Art", "Physics"};
    private final String[] hobbies = {"Sports", "Reading", "Music"};


    Faker faker = new Faker();
    Random random = new Random();
    RegistrationPage registrationpage = new RegistrationPage();
    CalendarComponent calendarcomponent = new CalendarComponent();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = genders[faker.random().nextInt(genders.length)],
            mobile = faker.phoneNumber().subscriberNumber(10),
            monthOfBirth = months[faker.random().nextInt(months.length)],
            yearOfBirth = faker.random().nextInt(START_YEAR, END_YEAR).toString(),
            dayOfBirth = faker.random().nextInt(START_DATE, END_DATE).toString(),
            subject1 = subjects[faker.random().nextInt(subjects.length)],
            hobby1 = hobbies[faker.random().nextInt(hobbies.length)],
            picture = "1.png",
            address = faker.address().fullAddress(),
            state = "Haryana",
            city = "Karnal";

    @BeforeAll
    static void setUpConfig() {
        Configuration.startMaximized = true;
    }

    @Test
    void successfulSubmitFormTest() {
        open("https://demoqa.com/automation-practice-form");
        registrationpage.typeFirstName(firstName);
        registrationpage.typeLastName(lastName);
        registrationpage.typeUserEmail(email);
        registrationpage.chooseGender(gender);
        registrationpage.typePhoneNumber(mobile);
        calendarcomponent.chooseDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth);
        registrationpage.chooseSubject(subject1);
        registrationpage.chooseHobby(hobby1);
        registrationpage.selectPicture(picture);
        registrationpage.typeCurrentAddress(address);
        registrationpage.chooseState(state);
        registrationpage.chooseCity(city);
        $("#submit").scrollIntoView(true);
        registrationpage.submitForm();

        registrationpage.checkRegistrationResults(
                firstName,
                lastName,
                email,
                gender,
                mobile,
                dayOfBirth,
                monthOfBirth,
                yearOfBirth,
                subject1,
                hobby1,
                picture,
                address,
                state,
                city);

    }

}
