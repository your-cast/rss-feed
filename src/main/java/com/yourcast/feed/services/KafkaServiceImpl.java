package com.yourcast.feed.services;

import com.yourcast.feed.mappers.ArrestedMapper;
import com.yourcast.feed.models.AccountData;
import com.yourcast.feed.models.ArrestedAccounts;
import com.yourcast.feed.repository.ArrestedRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaServiceImpl implements KafkaService {
    private final ArrestedMapper arrestedMapper;
    private final ArrestedRepository arrestedRepository;

    @Override
    public void save(ArrestedAccounts arrestedAccounts) {
        LOG.info("[KAFKA SERVICE] save {}", arrestedAccounts);

        this.arrestedRepository.save(arrestedAccounts);
    }

    @Override
    @KafkaListener(id = "Arrests", topics = {"${kafka.topic}"}, containerFactory = "singleFactory")
    public void consume(AccountData accountData) {
        LOG.info("[KAFKA SERVICE] consumed {}", accountData);

        if (isArrested(accountData)) {
            LOG.info("[KAFKA SERVICE] need save status changed {}", accountData);
            save(arrestedMapper.mapToArrested(accountData));
        }
    }

    private boolean isArrested(AccountData accountData) {
        String[] reasons = {"01","02","11","12"};
        if (Arrays.stream(reasons).anyMatch(accountData.getBlockReasonNew()::equals)) {
            return !accountData.getArrestedSumNew().equals("0");
        }
        return false;
    }
}
