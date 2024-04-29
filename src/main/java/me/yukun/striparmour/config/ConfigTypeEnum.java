package me.yukun.striparmour.config;

public enum ConfigTypeEnum {
  CONFIG("Config.yml"),
  MESSAGES("Messages.yml");

  private final String filename;

  ConfigTypeEnum(String filename) {
    this.filename = filename;
  }

  public String toString() {
    return this.filename;
  }
}
