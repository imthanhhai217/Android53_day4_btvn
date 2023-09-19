package com.vndevpro.android53_day4_btvn;

public class PostModel {
    private String imgAvatar, userName, postContent, imgContent;
    private boolean isLike;

    public PostModel(String imgAvatar, String userName, String postContent, String imgContent, boolean isLike) {
        this.imgAvatar = imgAvatar;
        this.userName = userName;
        this.postContent = postContent;
        this.imgContent = imgContent;
        this.isLike = isLike;
    }

    public PostModel() {
    }

    public String getImgAvatar() {
        return imgAvatar;
    }

    public void setImgAvatar(String imgAvatar) {
        this.imgAvatar = imgAvatar;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getImgContent() {
        return imgContent;
    }

    public void setImgContent(String imgContent) {
        this.imgContent = imgContent;
    }

    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }

    @Override
    public String toString() {
        return "PostModel{" +
                "imgAvatar='" + imgAvatar + '\'' +
                ", userName='" + userName + '\'' +
                ", postContent='" + postContent + '\'' +
                ", imgContent='" + imgContent + '\'' +
                ", isLike=" + isLike +
                '}';
    }
}
