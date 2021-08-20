package com.yourcast.feed.validators;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Slf4j
@Component
public class IbanValidator {
    private static final Pattern IBAN_PATTERN = Pattern.compile("UA[0-9]{27}");

    public boolean isValid(String iban) {
        String trimmed = iban.trim();

        if (!IBAN_PATTERN.matcher(trimmed).matches()) {
            LOG.info("[IBAN VALIDATOR] invalid {}", iban);
            return false;
        }

        LOG.info("[IBAN VALIDATOR] valid {}", iban);
        return true;
    }
}
