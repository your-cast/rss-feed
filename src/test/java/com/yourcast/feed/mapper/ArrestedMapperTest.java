package com.yourcast.feed.mapper;

import com.yourcast.feed.mappers.ArrestedMapper;
import com.yourcast.feed.models.AccountData;
import com.yourcast.feed.models.ArrestedAccounts;
import com.yourcast.feed.models.dto.ArrestedDto;
import com.yourcast.feed.utils.AccountDataUtil;
import com.yourcast.feed.utils.ArrestedAccountsUtil;
import com.yourcast.feed.utils.ArrestedDtoUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrestedMapperTest {
    private final ArrestedMapper mapper = new ArrestedMapper();

    @Test
    void mapToArrested() {
        AccountData account = AccountDataUtil.createAccountData();

        ArrestedAccounts arrestedAccounts = mapper.mapToArrested(account);

        Assertions.assertEquals(arrestedAccounts.getIban(), account.getIban());
        Assertions.assertEquals(arrestedAccounts.isActive(), account.isAccountBlocked());
    }

    @Test
    void mapFromArrestedToDto() {
        ArrestedAccounts arrestedAccounts = ArrestedAccountsUtil.createArrestedAccount();

        ArrestedDto dto = mapper.fromArrestedToArrestedDto(arrestedAccounts);

        Assertions.assertEquals(dto.getIban(), arrestedAccounts.getIban());
        Assertions.assertEquals(dto.isActive(), arrestedAccounts.isActive());
    }

    @Test
    void fromArrestedDtoToArrested() {
        ArrestedDto dto = ArrestedDtoUtil.createArrestedDto();

        ArrestedAccounts arrestedAccounts = mapper.fromArrestedDtoToArrested(dto);

        Assertions.assertEquals(dto.getIban(), arrestedAccounts.getIban());
        Assertions.assertEquals(dto.isActive(), arrestedAccounts.isActive());
    }
}
