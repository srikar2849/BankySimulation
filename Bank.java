package in.srikar;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<String, Account> accounts;

    public Bank() {
        accounts = new HashMap<>();
    }

    public void createAccount(String accountId, String accountName, double initialBalance) {
        if (!accounts.containsKey(accountId)) {
            Account account = new Account(accountId, accountName, initialBalance);
            accounts.put(accountId, account);
            System.out.println("Account created successfully.");
        } else {
            System.out.println("Account ID already exists.");
        }
    }

    public Account getAccount(String accountId) {
        return accounts.get(accountId);
    }
}

