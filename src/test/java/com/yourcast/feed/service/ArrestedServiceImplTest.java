package com.yourcast.feed.service;

import com.yourcast.feed.mappers.ArrestedMapper;
import com.yourcast.feed.models.ArrestedAccounts;
import com.yourcast.feed.models.dto.ArrestedDto;
import com.yourcast.feed.utils.ArrestedAccountsUtil;
import com.yourcast.feed.utils.ArrestedDtoUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.yourcast.feed.repository.ArrestedRepository;
import com.yourcast.feed.services.ArrestedServiceImpl;
import com.yourcast.feed.validators.IbanValidator;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class ArrestedServiceImplTest {
    private static final String IBAN = "UA643003350000000002620214200";

    @Mock
    private ArrestedRepository repository;

    @Mock
    private IbanValidator validator;

    @Mock
    private ArrestedMapper arrestedMapper;

    @InjectMocks
    private ArrestedServiceImpl arrestedService;

    @Test
    void arrestedFound() {
        ArrestedAccounts arrestedAccounts = ArrestedAccountsUtil.createArrestedAccount();
        ArrestedDto dto = ArrestedDtoUtil.createArrestedDto();
        doReturn(arrestedAccounts).when(repository).findByIban(IBAN);
        doReturn(true).when(validator).isValid(IBAN);
        doReturn(dto).when(arrestedMapper).fromArrestedToArrestedDto(arrestedAccounts);

        ArrestedDto response = arrestedService.findByIban(IBAN);

        assertNotNull(response, "Account found");
    }
}
