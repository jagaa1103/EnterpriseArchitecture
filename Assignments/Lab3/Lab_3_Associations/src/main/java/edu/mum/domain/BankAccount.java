package edu.mum.domain;

import javax.persistence.Entity;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Column;

/**
 * This billing strategy uses a simple bank account.
 *
 * @author Christian Bauer
 */
@Entity
public class BankAccount extends BillingDetails {

    @Column(name = "BA_ACCOUNT", nullable = true, length = 16)
    private String account;

    @Column(name = "BA_BANKNAME", nullable = true, length = 255)
    private String bankname;

    @Column(name = "BA_SWIFT", nullable = true, length = 15)
    private String swift;

 
    // ********************** Accessor Methods ********************** //

    public String getAccount() { return account; }
    public void setAccount(String account) { this.account = account; }

    public String getBankname() { return bankname; }
    public void setBankname(String bankname) { this.bankname = bankname; }

    public String getSwift() { return swift; }
    public void setSwift(String swift) { this.swift = swift; }

    // ********************** Common Methods ********************** //

    public String toString() {
        return  "BankAccount ('" + getId() + "'), " +
                "Account: '" + getAccount() + "'";
    }

    // ********************** Business Methods ********************** //
    public boolean isValid() {
        // TODO: Validate bank account syntax.
        return true;
    }

}
