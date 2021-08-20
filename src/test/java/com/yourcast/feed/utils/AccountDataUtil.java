package com.yourcast.feed.utils;

import com.yourcast.feed.models.AccountData;

public class AccountDataUtil {
    public static final String IBAN = "UA643003350000000002620214200";
    public static final String FULL_BLOCK_NEW = "Y";
    public static final String FULL_BLOCK_OLD = "N";
    public static final String CURISOCODE =  "USD";
    public static final String LEDGERCODE =  "CL";
    public static final String SUBLEDGCODE =  "18";
    public static final String LIENHOLD_OLD =  "0";
    public static final String LIENHOLD_NEW =  "0";
    public static final String PLEDGEHOLD_OLD =  "0";
    public static final String PLEDGEHOLD_NEW =  "0";
    public static final String GARNISHEE_OLD =  "0";
    public static final String GARNISHEE_NEW =  "0";
    public static final String ACCLOSEDATE_OLD =  "0";
    public static final String ACCLOSEDATE_NEW =  "0";
    public static final String CCLEAREDBAL_OLD =  "0";
    public static final String CCLEAREDBAL_NEW =  "0";
    public static final String LEGALREASON_OLD =  "00";
    public static final String LEGALREASON_NEW =  "00";

    public static AccountData createAccountData() {
        AccountData accountData = new AccountData();

        accountData.setIban(IBAN);
        accountData.setCurrencyCode(CURISOCODE);
        accountData.setLedger(LEDGERCODE);
        accountData.setSubledger(SUBLEDGCODE);
        accountData.setFullBlockNew(FULL_BLOCK_NEW);
        accountData.setFullBlockOld(FULL_BLOCK_OLD);
        accountData.setBlockedSumOld(LIENHOLD_OLD);
        accountData.setBlockedSumNew(LIENHOLD_NEW);
        accountData.setIrreducibleBalanceOld(PLEDGEHOLD_OLD);
        accountData.setIrreducibleBalanceNew(PLEDGEHOLD_NEW);
        accountData.setArrestedSumOld(GARNISHEE_OLD);
        accountData.setArrestedSumNew(GARNISHEE_NEW);
        accountData.setRemainingBalanceOld(CCLEAREDBAL_OLD);
        accountData.setRemainingBalanceNew(CCLEAREDBAL_NEW);
        accountData.setBlockReasonOld(LEGALREASON_OLD);
        accountData.setBlockReasonNew(LEGALREASON_NEW);
        accountData.setAccountCloseDateOld(ACCLOSEDATE_OLD);
        accountData.setAccountCloseDateNew(ACCLOSEDATE_NEW);

        return accountData;
    }
}
