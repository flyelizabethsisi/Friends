package com.example.friendsfragment.models;

public class Cast {
    private String name;
    private String birthday;
    private String url;
    private CastImage image;

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getUrl() {
        return url;
    }

    public CastImage getImage() {
        return image;
    }

    public Cast(String name, String birthday, String url, CastImage image) {
        this.name = name;
        this.birthday = birthday;
        this.url = url;
        this.image = image;
    }

    public class CastImage {
        private String original;

        public String getOriginal() {
            return original;
        }

        public CastImage(String original) {
            this.original = original;
        }
    }
}

