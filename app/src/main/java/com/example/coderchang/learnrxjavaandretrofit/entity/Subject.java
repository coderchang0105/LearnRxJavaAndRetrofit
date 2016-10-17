package com.example.coderchang.learnrxjavaandretrofit.entity;

import java.util.List;

/**
 * Created by coderchang on 16/10/17.
 */
public class Subject {
  private Rating rating;
  private List<String> genres;
  private String title;
  private List<Cast> casts;
  private double collectCount;
  private String subType;
  private List<Cast> directors;
  private String year;
  private Avatars images;
  private String alt;
  private String id;

  public Subject() {
  }

  public Subject(String alt, List<Cast> casts, double collectCount, List<Cast> directors,
      List<String> genres, String id, Avatars images, Rating rating, String subType, String title,
      String year) {
    this.alt = alt;
    this.casts = casts;
    this.collectCount = collectCount;
    this.directors = directors;
    this.genres = genres;
    this.id = id;
    this.images = images;
    this.rating = rating;
    this.subType = subType;
    this.title = title;
    this.year = year;
  }

  public String getAlt() {
    return alt;
  }

  public void setAlt(String alt) {
    this.alt = alt;
  }

  public List<Cast> getCasts() {
    return casts;
  }

  public void setCasts(List<Cast> casts) {
    this.casts = casts;
  }

  public double getCollectCount() {
    return collectCount;
  }

  public void setCollectCount(double collectCount) {
    this.collectCount = collectCount;
  }

  public List<Cast> getDirectors() {
    return directors;
  }

  public void setDirectors(List<Cast> directors) {
    this.directors = directors;
  }

  public List<String> getGenres() {
    return genres;
  }

  public void setGenres(List<String> genres) {
    this.genres = genres;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Avatars getImages() {
    return images;
  }

  public void setImages(Avatars images) {
    this.images = images;
  }

  public Rating getRating() {
    return rating;
  }

  public void setRating(Rating rating) {
    this.rating = rating;
  }

  public String getSubType() {
    return subType;
  }

  public void setSubType(String subType) {
    this.subType = subType;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }

  private class Rating{
    private int max;
    private float average;
    private String stars;
    private int min;

    public Rating() {
    }

    public Rating(float average, int max, int min, String stars) {
      this.average = average;
      this.max = max;
      this.min = min;
      this.stars = stars;
    }

    public float getAverage() {
      return average;
    }

    public void setAverage(float average) {
      this.average = average;
    }

    public int getMax() {
      return max;
    }

    public void setMax(int max) {
      this.max = max;
    }

    public int getMin() {
      return min;
    }

    public void setMin(int min) {
      this.min = min;
    }

    public String getStars() {
      return stars;
    }

    public void setStars(String stars) {
      this.stars = stars;
    }
  }

  private class Cast {
    private String alt;
    private Avatars avatars;
    private String name;
    private String id;

    public Cast() {
    }

    public Cast(String alt, Avatars avatars, String id, String name) {
      this.alt = alt;
      this.avatars = avatars;
      this.id = id;
      this.name = name;
    }

    public String getAlt() {
      return alt;
    }

    public void setAlt(String alt) {
      this.alt = alt;
    }

    public Avatars getAvatars() {
      return avatars;
    }

    public void setAvatars(Avatars avatars) {
      this.avatars = avatars;
    }

    public String getId() {
      return id;
    }

    public void setId(String id) {
      this.id = id;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }
  }

  private class Avatars {
    private String small;
    private String large;
    private String medium;

    public Avatars() {
    }
    public Avatars(String large, String medium, String small) {
      this.large = large;
      this.medium = medium;
      this.small = small;
    }

    public String getLarge() {
      return large;
    }

    public void setLarge(String large) {
      this.large = large;
    }

    public String getMedium() {
      return medium;
    }

    public void setMedium(String medium) {
      this.medium = medium;
    }

    public String getSmall() {
      return small;
    }

    public void setSmall(String small) {
      this.small = small;
    }
  }
}
