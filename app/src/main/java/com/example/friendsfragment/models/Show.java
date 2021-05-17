package com.example.friendsfragment.models;

public class Show {
    private String name;
    private String premiered;
    private String summary;
    private ImageShow image;

    public String getName() {
        return name;
    }

    public String getPremiered() {
        return premiered;
    }

    public String getSummary() {
        return summary;
    }

    public ImageShow getImage() {
        return image;
    }

    public Show(String name, String premiered, String summary, ImageShow image) {
        this.name = name;
        this.premiered = premiered;
        this.summary = summary;
        this.image = image;
    }

    public class ImageShow {
        private String medium;
        private String original;

        public ImageShow(String medium, String original) {
            this.medium = medium;
            this.original = original;
        }

        public String getMedium() {
            return medium;
        }

        public String getOriginal() {
            return original;
        }
    }
}
