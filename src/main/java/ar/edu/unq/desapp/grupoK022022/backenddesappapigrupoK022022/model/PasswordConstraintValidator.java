package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model;


import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.MessageResolver;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.PropertiesMessageResolver;
import org.passay.RuleResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {


	private static Logger LOG = LoggerFactory.getLogger(PasswordConstraintValidator.class);
	
    @Override
    public void initialize(final ValidPassword arg0) {
    	//inherited function is overridden
    }


    //@SneakyThrows
    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {

        //customizing validation messages
        Properties props = new Properties();
        InputStream inputStream = getClass()
                .getClassLoader().getResourceAsStream("passay.properties");
        try {
			props.load(inputStream);
		} catch (Exception e) {
			LOG.warn("context", e);
		}

        MessageResolver resolver = new PropertiesMessageResolver(props);

        PasswordValidator validator = new PasswordValidator(resolver, Arrays.asList(

                // length between 8 and 16 characters
                //new LengthRule(8, 16),

                // at least one upper-case character
                new CharacterRule(EnglishCharacterData.UpperCase, 1),

                // at least one lower-case character
                new CharacterRule(EnglishCharacterData.LowerCase, 1),

                // at least one digit character
                //new CharacterRule(EnglishCharacterData.Digit, 1),

                // at least one symbol (special character)
                new CharacterRule(EnglishCharacterData.Special, 1)

                // no whitespace
                //new WhitespaceRule(),

                // rejects passwords that contain a sequence of >= 5 characters alphabetical  (e.g. abcdef)
                // new IllegalSequenceRule(EnglishSequenceData.Alphabetical, 5, false),

                // rejects passwords that contain a sequence of >= 5 characters numerical   (e.g. 12345)
                //new IllegalSequenceRule(EnglishSequenceData.Numerical, 5, false)
        ));

        RuleResult result = validator.validate(new PasswordData(password));

        if (result.isValid()) {

            return true;

        }
        
        List<String> messages = validator.getMessages(result);
        String messageTemplate = String.join(",", messages);
        context.buildConstraintViolationWithTemplate(messageTemplate)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();

        return false;

    }
}
