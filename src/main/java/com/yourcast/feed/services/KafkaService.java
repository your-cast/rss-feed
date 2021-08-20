package com.yourcast.feed.services;

import com.yourcast.feed.models.AccountData;
import com.yourcast.feed.models.ArrestedAccounts;

public interface KafkaService {
    void save(ArrestedAccounts arrestedAccounts);
    void consume(AccountData string);
}
