package com.example.unforgettable.entities;

import com.example.unforgettable.util.Contact;

import java.io.Serializable;
import java.util.Objects;

/**
 * <h3>
 * <strong>Class that represents the structure of an {@link User User}</strong>
 * </h3>
 *
 * @author Luis Marques
 */
public class User implements Serializable {

    /**
     * int reference to id
     */
    private int id;

    /**
     * String reference to name
     */
    private String name;

    /**
     * String reference to the age
     */
    private String age;

    /**
     * String reference to the gender
     */
    private String gender;

    /**
     * Contact reference to the emergency contact
     */
    private Contact sosContact;

    /**
     * Creates an instance of a {@link User User} without attributes
     */
    public User() {
    }

    /**
     * Creates an instance of an {@link User User} with the default attributes
     *
     * @param id         int id
     * @param name       String name
     * @param age        String age
     * @param gender     String gender
     * @param sosContact Contact sosContact
     */
    public User(int id, String name, String age, String gender, Contact sosContact) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.sosContact = sosContact;
    }

    /**
     * Gets the id
     *
     * @return int id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id
     *
     * @param id int id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the name
     *
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name
     *
     * @param name String name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the age
     *
     * @return String age
     */
    public String getAge() {
        return age;
    }

    /**
     * Sets the age
     *
     * @param age String age
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * Gets the gender
     *
     * @return String gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the gender
     *
     * @param gender String gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Gets the emergency contact
     *
     * @return Contact emergency contact
     */
    public Contact getSosContact() {
        return sosContact;
    }

    /**
     * Sets the emergency contact
     *
     * @param sosContact Contact emergency contact
     */
    public void setSosContact(Contact sosContact) {
        this.sosContact = sosContact;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        User other = (User) obj;
        return id == other.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User {\nid = " + id + "\nname = " + name + "\nage = " + age + "\ngender = "
                + gender + "\nsosContact = " + sosContact + "\n}";
    }

}
