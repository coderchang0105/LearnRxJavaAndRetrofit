package com.example.coderchang.learnrxjavaandretrofit.entity;

import java.util.List;

/**
 * Created by coderchang on 16/10/17.
 */
public class HttpResult <T> {
  private int count;
  private int start;
  private int total;
  private T subjects;
  private String title;

  public HttpResult(int count, int start, T subjects, String title, int total) {
    this.count = count;
    this.start = start;
    this.subjects = subjects;
    this.title = title;
    this.total = total;
  }

  public HttpResult() {
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public int getStart() {
    return start;
  }

  public void setStart(int start) {
    this.start = start;
  }

  public T getSubjects() {
    return subjects;
  }

  public void setSubjects(T subjects) {
    this.subjects = subjects;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

}
