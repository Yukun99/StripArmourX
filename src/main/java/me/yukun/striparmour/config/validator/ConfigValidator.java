package me.yukun.striparmour.config.validator;

import java.util.HashMap;
import java.util.Map;
import me.yukun.striparmour.config.ConfigTypeEnum;
import me.yukun.striparmour.config.FieldTypeEnum;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigValidator implements IValidator {

  private final Map<String, FieldTypeEnum> FIELDS = new HashMap<>(37) {{
    put("StripOffHand", FieldTypeEnum.BOOLEAN);
    put("IgnoreNoSpace", FieldTypeEnum.BOOLEAN);
  }};

  @Override
  public void validate(FileConfiguration config) throws ValidationException {
    validateFields(config);
  }

  private void validateFields(FileConfiguration config) throws ValidationException {
    for (String field : FIELDS.keySet()) {
      FieldTypeEnum fieldType = FIELDS.get(field);
      validateField(fieldType, config, field);
    }
  }

  @Override
  public void validateBooleanField(FileConfiguration config, String field)
      throws ValidationException {
    if (!config.isBoolean(field)) {
      throw new ValidationException(
          ValidationException.getErrorMessage(ConfigTypeEnum.CONFIG, FieldTypeEnum.BOOLEAN, field));
    }
  }
}
