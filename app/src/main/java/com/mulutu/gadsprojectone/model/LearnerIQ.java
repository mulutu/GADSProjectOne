package com.mulutu.gadsprojectone.model;

public class LearnerIQ implements Comparable< LearnerIQ > {
    private String name;
    private Integer score;
    private String country;
    private String badgeUrl;
    private Integer criteria; // 1 = IQ,  2 = Hours

    public LearnerIQ(String name, Integer score, String country, String badgeUrl, Integer criteria) {
        this.name = name;
        this.score = score;
        this.country = country;
        this.badgeUrl = badgeUrl;
        this.criteria = criteria;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }

    public void setBadgeUrl(String badgeUrl) {
        this.badgeUrl = badgeUrl;
    }

    public Integer getCriteria() {
        return criteria;
    }

    public void setCriteria(Integer criteria) {
        this.criteria = criteria;
    }

    @Override
    public int compareTo(LearnerIQ o) {
        return this.getScore().compareTo(o.getScore());
    }
}
