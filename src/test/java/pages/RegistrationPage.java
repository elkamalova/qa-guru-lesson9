package pages;

import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {
    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmail = $("#userEmail"),
            genderRadio = $("#genterWrapper"),
            userNumber = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            submitButton = $("#submit"),
            tableTitle = $("#example-modal-sizes-title-lg"),
            table = $(".table-responsive");


    public void typeFirstName(String firstName){
        firstNameInput.setValue(firstName);
    }

    public void typeLastName(String lastName){
        lastNameInput.setValue(lastName);
    }

    public void typeUserEmail(String email){
        userEmail.setValue(email);
    }

    public void chooseGender(String gender){
        genderRadio.$(byText(gender)).click();
    }
    public void typePhoneNumber(String mobile){
        userNumber.setValue(mobile);
    }

    public void chooseSubject(String subject){
        subjectsInput.setValue(subject).pressEnter();
    }

    public void chooseHobby(String hobby){
        hobbiesWrapper.$(byText(hobby)).click();
    }

    public void selectPicture(String picture){
        uploadPicture.uploadFile(new File("src/test/resources/"+ picture));
    }

    public void typeCurrentAddress(String address){

        currentAddress.setValue(address);
    }

    public void chooseState(String state) {

        $(stateInput).setValue(state).pressEnter();
    }

    public void chooseCity(String city) {

        $(cityInput).setValue(city).pressEnter();
    }

    public void submitForm() {

        $(submitButton).click();
    }

    public void checkRegistrationResults (String firstName,
                                          String lastName,
                                          String email,
                                          String gender,
                                          String phoneNumber,
                                          String dayOfBirth,
                                          String monthOfBirth,
                                          String yearOfBirth,
                                          String subject,
                                          String hobby,
                                          String picture,
                                          String address,
                                          String state,
                                          String city){

        tableTitle.shouldHave(text("Thanks for submitting the form"));
        table.shouldHave(text("Label"), text("Values"));
        table.shouldHave(text("Student Name"), text(firstName + " " + lastName));
        table.shouldHave(text("Student Email"), text(email));
        table.shouldHave(text("Gender"), text(gender));
        table.shouldHave(text("Mobile"), text(phoneNumber));
        table.shouldHave(text("Date of Birth"), text(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth));
        table.shouldHave(text("Subjects"), text(subject));
        table.shouldHave(text("Hobbies"), text(hobby));
        table.shouldHave(text("Picture"), text(picture));
        table.shouldHave(text("Address"), text(address));
        table.shouldHave(text("State and City"), text(state+" "+city));
    }

}