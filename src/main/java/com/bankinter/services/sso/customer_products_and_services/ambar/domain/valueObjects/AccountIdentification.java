package com.bankinter.services.sso.customer_products_and_services.ambar.domain.valueObjects;

public class AccountIdentification {
    private String iban;
    private String bban;
    private String bic;

    public AccountIdentification(String iban, String bban, String bic) {
        this.iban = iban;
        this.bban = bban;
        this.bic = bic;
    }

    public String getBban() {
        return bban;
    }

    public String getBic() {
        return bic;
    }

    public String getIban() {
        return iban;
    }

    public void setBban(String bban) {
        this.bban = bban;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }
}
