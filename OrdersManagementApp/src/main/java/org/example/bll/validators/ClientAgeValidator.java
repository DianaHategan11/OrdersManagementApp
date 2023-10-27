package org.example.bll.validators;

import org.example.model.Client;

public class ClientAgeValidator implements Validator<Client> {
    private static final int MIN_AGE = 18;

    @Override
    public void validate(Client t) {
        if (t.getAge() < MIN_AGE) {
            throw new IllegalArgumentException("The client doesn't have the minimum age!");
        }
    }
}
