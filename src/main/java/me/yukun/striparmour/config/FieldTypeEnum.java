package me.yukun.striparmour.config;

public enum FieldTypeEnum {
  STRING("String value"),
  BOOLEAN("Boolean value");

  private final String name;

  FieldTypeEnum(String name) {
    this.name = name;
  }

  public String toString() {
    return this.name;
  }
}
