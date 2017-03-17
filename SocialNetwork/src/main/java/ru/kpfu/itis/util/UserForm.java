package ru.kpfu.itis.util;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;


public class UserForm {

    private static final String BLANK_MESSAGE = "This field is mandatory";

    @NotBlank(message = BLANK_MESSAGE)
    private String firstName;

    @NotBlank(message = BLANK_MESSAGE)
    private String lastName;

    @NotBlank(message = BLANK_MESSAGE)
    @Email
    private String email;

    @NotBlank(message = BLANK_MESSAGE)
    @Size(min = 7, max = 20, message = "Password should be from 7 to 20 symbols")
    private String password;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
