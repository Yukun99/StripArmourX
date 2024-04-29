package me.yukun.striparmour.config.validator;

import me.yukun.striparmour.config.FieldTypeEnum;
import org.bukkit.configuration.file.FileConfiguration;

public interface IValidator {

  /**
   * Validate specified configuration file according to spec.
   *
   * @param config Configuration file to be verified.
   * @throws ValidationException If any field is missing or has wrong value type.
   */
  void validate(FileConfiguration config) throws ValidationException;

  /**
   * Validate specified field in specified configuration file.
   *
   * @param fieldType Type that specified field is supposed to be.
   * @param config    Configuration file that field is supposed to be in.
   * @param field     Field to be validated.
   * @throws ValidationException If field is missing, has wrong fieldType, or extra placeholders.
   */
  default void validateField(FieldTypeEnum fieldType, FileConfiguration config, String field)
      throws ValidationException {
    switch (fieldType) {
      case STRING -> validateStringField(config, field);
      case BOOLEAN -> validateBooleanField(config, field);
      default -> {
      }
    }
  }

  /**
   * Validates a field with fieldType String.
   *
   * @param config Configuration file that field is supposed to be in.
   * @param field  Field to be evaluated.
   * @throws ValidationException If field is missing, has wrong fieldType, or extra placeholders.
   */
  default void validateStringField(FileConfiguration config, String field)
      throws ValidationException {
    throw new ValidationException("No string fields!");
  }

  /**
   * Validates a field with fieldType Boolean.
   *
   * @param config Configuration file that field is supposed to be in.
   * @param field  Field to be evaluated.
   * @throws ValidationException If field is missing, has wrong fieldType, or extra placeholders.
   */
  default void validateBooleanField(FileConfiguration config, String field)
      throws ValidationException {
    throw new ValidationException("No boolean fields!");
  }
}
