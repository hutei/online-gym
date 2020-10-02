package com.hutei.annotation;

import lombok.SneakyThrows;
import org.passay.*;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class UsernameConstraintValidator implements ConstraintValidator<ValidName, String> {
   @Override
   public void initialize(final ValidName arg0) {
   }
   @SneakyThrows
   @Override
   public boolean isValid(String password, ConstraintValidatorContext context) {
      //customizing validation messages
      Properties props = new Properties();
      InputStream inputStream = getClass()
              .getClassLoader().getResourceAsStream("passay.properties");
      props.load(inputStream);
      MessageResolver resolver = new PropertiesMessageResolver(props);
      PasswordValidator validator = new PasswordValidator(resolver, Arrays.asList(
              // length between 8 and 16 characters
              new LengthRule(3, 16),
              // no whitespace
              new WhitespaceRule()
      ));
      RuleResult result = validator.validate(new PasswordData(password));
      if (result.isValid()) {
         return true;
      }
      List<String> messages = Collections.singletonList("Username must contains at least 3 chars,and no whitespace");
      String messageTemplate = String.join(",", messages);
      context.buildConstraintViolationWithTemplate(messageTemplate)
              .addConstraintViolation()
              .disableDefaultConstraintViolation();
      return false;
   }
}
