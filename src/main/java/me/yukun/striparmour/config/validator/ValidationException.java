package me.yukun.striparmour.config.validator;

import me.yukun.striparmour.config.ConfigTypeEnum;
import me.yukun.striparmour.config.FieldTypeEnum;

public class ValidationException extends Exception {

  public ValidationException(String errorMessage) {
    super(errorMessage);
  }

  public static String getErrorMessage(ConfigTypeEnum configType, FieldTypeEnum fieldType,
      String item) {
    return "Error in " + configType + ": " + fieldType + " not found at " + item + ".";
  }
}
