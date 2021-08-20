package com.yourcast.feed.utils;

import com.yourcast.feed.models.dto.ArrestedDto;

public class ArrestedDtoUtil {
    public static final String IBAN = "UA643003350000000002620214200";

    public static ArrestedDto createArrestedDto() {
        ArrestedDto dto = new ArrestedDto();

        dto.setIban(IBAN);
        dto.setActive(true);

        return dto;
    }
}
