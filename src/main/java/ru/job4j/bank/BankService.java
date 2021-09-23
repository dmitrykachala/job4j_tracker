package ru.job4j.bank;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает услуги банка по обслуживанию клиентов
 * @author не я
 * @version 1.0
 */
public class BankService {
    /**
     * Данные хранятся в карточках, где ключом является {@link User},
     * у которого может быть несколько счетов, указанных в коллекции List
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавление нового пользователя
     * @param user пользователь, которго нужно добавить в систему
     */
    public void addUser(User user) {
            users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Добавление счёта пользователю
     * @param passport ключ пользователя, которому ддобавляется счёт
     * @param account счёт, который добавляем
     */
    public void addAccount(String passport, Account account) {
        User user = this.findByPassport(passport);
        if (user != null) {
            List<Account> userAccounts = users.get(user);
            if (!userAccounts.contains(account)) {
                userAccounts.add(account);
            }
        }
    }

    /**
     * Метод, реализующий поиск пользователя по паспортным данным
     * @param passport паспортные данные искомого пользователя
     * @return возвращает пользователя с требуемыми паспортными данными или null
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(u -> u.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод, осуществляющий поиск счёта пользователя по заданным реквизитам
     * @param passport паспортные данные пользователя, которому принадледит искомый счёт
     * @param requisite данные требуемого счёта
     * @return возвращает необходимый счёт или null
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = this.findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(a -> a.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод, осуществляющий денежный перевод с одного счёта на другой
     * @param srcPassport паспортные данные переводящего
     * @param srcRequisite реквизиты счёта, с которого должен осуществиться перевод
     * @param destPassport паспортные данные получателя перевода
     * @param destRequisite реквизиты счёта, на который планируется осуществить перевод
     * @param amount суммма перевода
     * @return true (перевод проведен успешно) или false (перевод не проведен: неверно указаны
     * данные для перевода или недостаточно средств на счёте)
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAcc = this.findByRequisite(srcPassport, srcRequisite);
        Account destAcc = this.findByRequisite(destPassport, destRequisite);
            if (srcAcc != null && destAcc != null && srcAcc.getBalance() >= amount) {
                destAcc.setBalance(destAcc.getBalance() + amount);
                srcAcc.setBalance(srcAcc.getBalance() - amount);
                rsl = true;
            }
        return rsl;
    }
}