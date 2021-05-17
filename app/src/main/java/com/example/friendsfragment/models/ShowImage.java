package com.example.friendsfragment.models;

public class ShowImage {
    private ImageResolution resolutions;

    public ImageResolution getResolutions() {
        return resolutions;
    }

    public class ImageResolution {
        private MediumImage original;

        public MediumImage getOriginal() {
            return original;
        }

        public class MediumImage {
            private String url;

            public String getUrl() {
                return url;
            }
        }
    }
}
