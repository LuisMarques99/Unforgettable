package com.example.unforgettable.util;

import com.example.unforgettable.exceptions.InvalidContactException;

/**
 * <h3>
 * <strong>Class that represents the structure of a {@link Contact Contact}</strong>
 * </h3>
 *
 * @author Luis Marques
 */
public class Contact {

    /**
     * String reference to the phone number
     */
    private String number;

    /**
     * Creates an instance of a {@link Contact contact} with a phone number
     *
     * @param number String phone number
     * @throws InvalidContactException
     */
    public Contact(String number) throws InvalidContactException {
        setNumber(number);
    }

    /**
     * Gets the phone number
     *
     * @return String phone number
     */
    public String getNumber() {
        return number;
    }

    /**
     * Sets the phone number
     *
     * @param number String phone number
     * @throws InvalidContactException
     */
    public void setNumber(String number) throws InvalidContactException {
        if (number.length() > 9) {
            throw new InvalidContactException("O Contacto não pode ter mais que nove dígitos!");
        }
        if (number.charAt(1) == 9) {
            if (number.charAt(2) != 1 || number.charAt(2) != 2 || number.charAt(2) != 3
                    || number.charAt(2) != 6) {
                throw new InvalidContactException("O Contact tem de ser válido");
            }
        }

        this.number = number;
    }

    @Override
    public String toString() {
        return number;
    }
}
