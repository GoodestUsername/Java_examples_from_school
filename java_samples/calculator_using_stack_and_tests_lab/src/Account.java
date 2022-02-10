public interface Account {

    boolean getOverdraftProtection();

    void setOverdraftProtection(boolean hasOverdraftProtection);

    String setChargeType(String chargeType);

    char getAccountType();

    int getAccountNumber();

    String getEmail();

    String getFirstName();

    String getMiddleName();

    String getLastName();

    void setEmail(String email);

    void setPassword(String password);

}