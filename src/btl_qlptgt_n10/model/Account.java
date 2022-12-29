package btl_qlptgt_n10.model;

public class Account {

    private Integer accountId;
    private String username;
    private String password;
    private String displayName;
    private String role;

    public Account() {
    }

    public Account(Integer accountId, String username, String password, String displayName, String role) {
        this.accountId = accountId;
        this.username = username;
        this.password = password;
        this.displayName = displayName;
        this.role = role;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Account{" + "accountId=" + accountId + ", username=" + username + ", password=" + password + ", displayName=" + displayName + ", role=" + role + '}';
    }

}
