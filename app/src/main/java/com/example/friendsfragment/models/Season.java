package com.example.friendsfragment.models;

public class Season {
    private String number;
    private String episodeOrder;
    private SeasonImage image;
    private String premiereDate;
    private String endDate;

    public String getNumber() {
        return number;
    }

    public int getNumberInt() {
        return Integer.parseInt(getNumber());
    }

    public String getEpisodeOrder() {
        return episodeOrder;
    }

    public SeasonImage getImage() {
        return image;
    }

    public String getPremiereDate() {
        return premiereDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public Season(String number, String episodeOrder, SeasonImage image, String premiereDate, String endDate) {
        this.number = number;
        this.episodeOrder = episodeOrder;
        this.image = image;
        this.premiereDate = premiereDate;
        this.endDate = endDate;
    }

    public class SeasonImage {
        private String original;

        public String getOriginal() {
            return original;
        }

        public SeasonImage(String original) {
            this.original = original;
        }
    }
}

