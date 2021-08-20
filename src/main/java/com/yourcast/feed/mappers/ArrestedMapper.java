package com.yourcast.feed.mappers;

import com.yourcast.feed.models.AccountData;
import com.yourcast.feed.models.ArrestedAccounts;
import com.yourcast.feed.models.dto.ArrestedDto;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ArrestedMapper {
    public ArrestedAccounts mapToArrested(final AccountData account) {
        LOG.info("[ARRESTED MAPPER] map from Account Data to Arrested Entity {}", account);
        ArrestedAccounts arrestedAccounts = new ArrestedAccounts();

        arrestedAccounts.setIban(account.getIban());
        arrestedAccounts.setActive(account.isAccountBlocked());

        LOG.info("[ARRESTED MAPPER] mapped Arrested Entity {}", arrestedAccounts);
        return arrestedAccounts;
    }

    public ArrestedAccounts fromArrestedDtoToArrested(ArrestedDto arrestedDto) {
        LOG.info("[ARRESTED MAPPER] map from ArrestedDto to Arrested Entity {}", arrestedDto);
        ArrestedAccounts arrestedAccounts = new ArrestedAccounts();

        arrestedAccounts.setIban(arrestedDto.getIban());
        arrestedAccounts.setActive(arrestedDto.isActive());
        arrestedAccounts.setCreatedAt(arrestedDto.getCreatedAt());
        arrestedAccounts.setUpdatedAt(arrestedDto.getUpdatedAt());

        LOG.info("[ARRESTED MAPPER] mapped Arrested Entity {}", arrestedAccounts);
        return arrestedAccounts;
    }

    public ArrestedDto fromArrestedToArrestedDto(ArrestedAccounts arrestedAccounts) {
        LOG.info("[ARRESTED MAPPER] mapped ArrestedDto {}", arrestedAccounts);
        return ArrestedDto.builder()
                .iban(arrestedAccounts.getIban())
                .active(arrestedAccounts.isActive())
                .createdAt(arrestedAccounts.getCreatedAt())
                .updatedAt(arrestedAccounts.getUpdatedAt())
                .build();
    }
}
