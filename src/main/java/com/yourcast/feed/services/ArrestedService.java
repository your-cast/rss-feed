package com.yourcast.feed.services;

import com.yourcast.feed.models.dto.ArrestedDto;

public interface ArrestedService {
    ArrestedDto findByIban(String iban);
}
