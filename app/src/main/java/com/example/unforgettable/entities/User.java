package com.example.unforgettable.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;

import com.example.unforgettable.exceptions.InvalidContactException;
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
@Entity(tableName = "Users")
public class User implements Serializable {

    /**
     * int reference to id
     */
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    private int id;

    /**
     * String reference to name
     */
    @ColumnInfo(name = "Name")
    private String name;

    /**
     * String reference to the age
     */
    @ColumnInfo(name = "Age")
    private String age;

    /**
     * String reference to the gender
     */
    @ColumnInfo(name = "Gender")
    private String gender;

    /**
     * String reference to the emergency contact
     */
    @ColumnInfo(name = "SosContact")
    private String sosContact;

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
     * @param sosContact String sosContact
     */
    public User(int id, String name, String age, String gender, String sosContact) throws InvalidContactException {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        setSosContact(sosContact);
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
     * @return String emergency contact
     */
    public String getSosContact() {
        return sosContact;
    }

    /**
     * Sets the emergency contact
     *
     * @param sosContact String emergency contact
     */
    public void setSosContact(String sosContact) throws InvalidContactException {
        if (sosContact.length() > 9) {
            throw new InvalidContactException("O Contacto não pode ter mais que nove dígitos!");
        }
        if (sosContact.charAt(0) == 9) {
            if (sosContact.charAt(1) != 1 || sosContact.charAt(1) != 2 || sosContact.charAt(1) != 3
                    || sosContact.charAt(1) != 6) {
                throw new InvalidContactException("O Contacto tem de ser válido");
            }
        }

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
