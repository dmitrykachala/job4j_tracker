package ru.job4j.bank;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
            users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        User user = this.findByPassport(passport);
        if (user != null) {
            List<Account> userAccounts = users.get(user);
            if (!userAccounts.contains(account)) {
                userAccounts.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        for (User us : users.keySet()) {
            if (us.getPassport().equals(passport)) {
                return us;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = this.findByPassport(passport);
        if (user != null) {
            List<Account> userAccounts = users.get(user);
            for (Account account : userAccounts) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAcc = this.findByRequisite(srcPassport, srcRequisite);
        Account destAcc = this.findByRequisite(srcPassport, destRequisite);
        if (this.findByPassport(srcPassport) != null
                && this.findByPassport(destPassport) != null) {
            if (srcAcc != null && destAcc != null && srcAcc.getBalance() >= amount) {
                destAcc.setBalance(destAcc.getBalance() + amount);
                srcAcc.setBalance(srcAcc.getBalance() - amount);
                rsl = true;
            }
        }
        return rsl;
    }
}