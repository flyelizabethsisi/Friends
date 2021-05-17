package com.example.friendsfragment.models;

public class Crew {
    private String type;
    private CrewPerson person;

    public String getType() {
        return type;
    }

    public CrewPerson getPerson() {
        return person;
    }

    public class CrewPerson {
        private String name;
        private String url;

        public String getUrl() {
            return url;
        }

        public String getName() {
            return name;
        }
    }
}

