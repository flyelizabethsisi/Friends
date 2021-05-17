package com.example.friendsfragment.models;

public class CastWrapper {
    public Cast person, character;

    public Cast getPerson() {
        return person;
    }

    public Cast getCharacter() {
        return character;
    }

    public CastWrapper(Cast person, Cast character) {
        this.person = person;
        this.character = character;
    }
}