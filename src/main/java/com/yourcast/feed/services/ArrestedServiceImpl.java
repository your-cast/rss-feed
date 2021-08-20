package com.yourcast.feed.services;

import com.yourcast.feed.mappers.ArrestedMapper;
import com.yourcast.feed.models.ArrestedAccounts;
import com.yourcast.feed.models.dto.ArrestedDto;
import com.yourcast.feed.repository.ArrestedRepository;
import com.yourcast.feed.validators.IbanValidator;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import lombok.AllArgsConstructor;

import javax.validation.ValidationException;

@Service
@Slf4j
@AllArgsConstructor
public class ArrestedServiceImpl implements ArrestedService {
    private final ArrestedRepository arrestedRepository;
    private final ArrestedMapper arrestedMapper;
    private final IbanValidator validator;

    private void validate(String iban) throws ValidationException {
        if (iban == null) {
            throw new ValidationException("IBAN is null.");
        }

        if (!validator.isValid(iban)) {
            throw new ValidationException("Invalid IBAN.");
        }
    }

    @Override
    public ArrestedDto findByIban(String iban) {
        LOG.info("[ARRESTED SERVICE] validate {}", iban);
        this.validate(iban);

        LOG.info("[ARRESTED SERVICE] find by iban in repository {}", iban);
        ArrestedAccounts arrestedAccounts = arrestedRepository.findByIban(iban);

        if (arrestedAccounts != null) {
            LOG.info("[ARRESTED SERVICE] not found iban {}", iban);
            return arrestedMapper.fromArrestedToArrestedDto(arrestedAccounts);
        }

        return null;
    }
}
