package com.example.bottomnavigationactivity;

public class Item {
    private String title;
    private String description;
    private String[] images;
    private String[] videos;
    private String[] audios;

    public Item(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }

    public String[] getVideos() {
        return videos;
    }

    public void setVideos(String[] videos) {
        this.videos = videos;
    }

    public String[] getAudios() {
        return audios;
    }

    public void setAudios(String[] audios) {
        this.audios = audios;
    }
}
