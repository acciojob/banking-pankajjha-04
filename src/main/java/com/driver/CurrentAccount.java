package com.driver;

public class CurrentAccount extends BankAccount {
    String tradeLicenseId; // consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        super(name, balance, 5000); // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        if (balance < 5000) {
            throw new Exception("Insufficient Balance");
        }
        this.tradeLicenseId = tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception

        if (!isValidLicenseId(tradeLicenseId)) {
            throw new Exception("Valid License can not be generated");
        }
    }

    private boolean isValidLicenseId(String tradeLicenseId) {
        // Implement logic to validate trade license ID
        // Return true if valid, false otherwise
        // Example: return isValid;
        for (int i = 0; i < tradeLicenseId.length() - 1; i++) {
            if (tradeLicenseId.charAt(i) == tradeLicenseId.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
