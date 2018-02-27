package com.uncc.mobileappdev.inclass07;

import java.io.Serializable;

/**
 * Created by Stephen on 2/19/2018.
 */

class Articles implements Serializable{

    private static final long serialVersionUID = 1L;

    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private String publishedAtDate;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getPublishedAtDate() {
        return publishedAtDate;
    }

    public void setPublishedAtDate(String publishedAtDate) {
        this.publishedAtDate = publishedAtDate;
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append(getDescription());
        sb.append(getPublishedAtDate());

        return sb.toString();
    }
}