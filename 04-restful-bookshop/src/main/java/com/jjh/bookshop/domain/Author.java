package com.jjh.bookshop.domain;

import java.util.StringJoiner;

public class Author {
  private String name;
  private String address;

  public Author(){}

  public Author(String name, String address) {
    this.name = name;
    this.address = address;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Author.class.getSimpleName() + "[", "]")
      .add("name='" + name + "'")
      .add("address='" + address + "'")
      .toString();
  }
}
