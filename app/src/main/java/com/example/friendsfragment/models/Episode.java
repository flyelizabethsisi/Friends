package com.example.friendsfragment.models;

public class Episode {
    private String url;
    private String name;
    private String season;
    private String number;
    private String airdate;
    private EpisodeImage image;
    private String summary;

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public String getSeason() {
        return season;
    }

    public String getNumber() {
        return number;
    }

    public String getAirdate() {
        return airdate;
    }

    public EpisodeImage getImage() {
        return image;
    }

    public String getSummary() {
        return summary;
    }

    public class EpisodeImage {
        private String original;

        public String getOriginal() {
            return original;
        }
    }
}


