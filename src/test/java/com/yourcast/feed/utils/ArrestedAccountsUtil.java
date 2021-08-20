package com.yourcast.feed.utils;

import com.yourcast.feed.models.ArrestedAccounts;

public class ArrestedAccountsUtil {
    public static final String IBAN = "UA643003350000000002620214200";

    public static ArrestedAccounts createArrestedAccount() {
        ArrestedAccounts arrestedAccounts = new ArrestedAccounts();

        arrestedAccounts.setIban(IBAN);
        arrestedAccounts.setActive(true);

        return arrestedAccounts;
    }
}
