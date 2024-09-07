package me.yukun.striparmour.config.validator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import me.yukun.striparmour.config.ConfigTypeEnum;
import me.yukun.striparmour.config.FieldTypeEnum;
import org.bukkit.configuration.file.FileConfiguration;

public class MessagesValidator implements IValidator {

  private final Map<String, FieldTypeEnum> fields = new HashMap<>(5) {{
    put("Prefix", FieldTypeEnum.STRING);
    put("Strip", FieldTypeEnum.STRING);
    put("Stripped.Enable", FieldTypeEnum.BOOLEAN);
    put("Stripped.Message", FieldTypeEnum.STRING);
    put("NoSpace", FieldTypeEnum.STRING);
  }};

  private final Set<String> playerPlaceholderFields = new HashSet<>(1) {{
    add("Strip");
  }};

  private final Set<String> itemsPlaceholderFields = new HashSet<>(1) {{
    add("NoSpace");
  }};

  @Override
  public void validate(FileConfiguration messages) throws ValidationException {
    validateFields(messages);
  }

  private void validateFields(FileConfiguration messages) throws ValidationException {
    for (String field : fields.keySet()) {
      FieldTypeEnum fieldType = fields.get(field);
      validateField(fieldType, messages, field);
    }
  }

  @Override
  public void validateStringField(FileConfiguration messages, String field)
      throws ValidationException {
    if (!messages.isString(field)) {
      throw new ValidationException(
          ValidationException.getErrorMessage(ConfigTypeEnum.MESSAGES, FieldTypeEnum.STRING,
              field));
    }
    validatePlayerStringField(messages, field);
    validateItemsStringField(messages, field);
  }

  @Override
  public void validateBooleanField(FileConfiguration messages, String field)
      throws ValidationException {
    if (!messages.isBoolean(field)) {
      throw new ValidationException(
          ValidationException.getErrorMessage(ConfigTypeEnum.MESSAGES, FieldTypeEnum.BOOLEAN,
              field));
    }
  }

  private void validatePlayerStringField(FileConfiguration messages, String field)
      throws ValidationException {
    if (playerPlaceholderFields.contains(field)) {
      return;
    }
    if (Objects.requireNonNull(messages.getString(field)).contains("%player%")) {
      throw new ValidationException(
          ValidationException.getErrorMessage(ConfigTypeEnum.MESSAGES, FieldTypeEnum.STRING,
              field));
    }
  }

  private void validateItemsStringField(FileConfiguration messages, String field)
      throws ValidationException {
    if (itemsPlaceholderFields.contains(field)) {
      return;
    }
    if (Objects.requireNonNull(messages.getString(field)).contains("%items%")) {
      throw new ValidationException(
          ValidationException.getErrorMessage(ConfigTypeEnum.MESSAGES, FieldTypeEnum.STRING,
              field));
    }
  }
}
