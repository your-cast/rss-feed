package com.yourcast.feed.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AccountData {
    @JsonProperty("IBAN")
    private String iban;

    @JsonProperty("CURISOCODE")
    private String currencyCode;

    @JsonProperty("LEDGERCODE")
    private String ledger;

    @JsonProperty("SUBLEDGCODE")
    private String subledger;

    @JsonProperty("BLOCKEDAC_OLD")
    private String fullBlockOld;

    @JsonProperty("BLOCKEDAC_NEW")
    private String fullBlockNew;

    @JsonProperty("LIENHOLD_OLD")
    private String blockedSumOld;

    @JsonProperty("LIENHOLD_NEW")
    private String blockedSumNew;

    @JsonProperty("PLEDGEHOLD_OLD")
    private String irreducibleBalanceOld;

    @JsonProperty("PLEDGEHOLD_NEW")
    private String irreducibleBalanceNew;

    @JsonProperty("GARNISHEE_OLD")
    private String arrestedSumOld;

    @JsonProperty("GARNISHEE_NEW")
    private String arrestedSumNew;

    @JsonProperty("CCLEAREDBAL_OLD")
    private String remainingBalanceOld;

    @JsonProperty("CCLEAREDBAL_NEW")
    private String remainingBalanceNew;

    @JsonProperty("LEGALREASON_OLD")
    private String blockReasonOld;

    @JsonProperty("LEGALREASON_NEW")
    private String blockReasonNew;

    @JsonProperty("ACCLOSEDATE_OLD")
    private String accountCloseDateOld;

    @JsonProperty("ACCLOSEDATE_NEW")
    private String accountCloseDateNew;

    public boolean isAccountBlocked() {
        return "Y".equals(fullBlockNew);
    }
}
