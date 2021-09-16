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
        if (this.findByPassport(passport) != null) {
            List<Account> userAccounts = users.get(this.findByPassport(passport));
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
        if (this.findByPassport(passport) != null) {
            List<Account> userAccounts = users.get(this.findByPassport(passport));
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
        User srcUser = this.findByPassport(srcPassport);
        Account srcAcc = this.findByRequisite(srcPassport, srcRequisite);
        User destUser = this.findByPassport(destPassport);
        Account destAcc = this.findByRequisite(srcPassport, destRequisite);
        if (srcUser != null && destUser != null) {
            if (srcAcc != null && destAcc != null && srcAcc.getBalance() >= amount) {
                destAcc.setBalance(destAcc.getBalance() + amount);
                srcAcc.setBalance(srcAcc.getBalance() - amount);
                rsl = true;
            }
        }
        return rsl;
    }
}