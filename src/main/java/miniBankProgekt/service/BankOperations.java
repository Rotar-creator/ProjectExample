package miniBankProgekt.service;

import miniBankProgekt.model.Transaction;
import miniBankProgekt.model.TransactionType;
import miniBankProgekt.model.UserAccount;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Класс Сервис "Банковские операции".
 *
 * @author Rotar Mikhail
 * @version 1.1
 * @since 13.01.2021
 */
@Service
public class BankOperations {
    // карта счета
    public static ConcurrentHashMap<Long, UserAccount> accountMap = new ConcurrentHashMap<Long, UserAccount>();
    /**
     * поле номер счета
     */
    public static long accountNumber = 10000;
    /**
     * поле идентификатор транзакции
     */
    public static long transactionId = 100;

    /**
     * метод возвращает текущюю дату
     */
    public String returnCurrentDate() {
        Date myDate = new Date();
        return new SimpleDateFormat("MM-dd-yyyy").format(myDate);
    }

    /**
     * метод возвращает  номер счета
     */
    public Long returnAccountNumber() {
        accountNumber++;
        return accountNumber;
    }

    /**
     * метод возвращает  идентификатор транзакции
     */
    public String getTransactionID() {
        transactionId++;
        return Long.toString(transactionId);
    }

    /**
     * метод вывода денег
     */
    public float withDrawMoney(float withDrawMoney, Long accountNumber) {

        UserAccount userAccount = accountMap.get(accountNumber);

        Transaction transaction = new Transaction();      // создание новой транзакции
        transaction.setDate(returnCurrentDate());         // установка даты
        transaction.setTransactionAmout(withDrawMoney);   // количество денежных средств
        transaction.setType(TransactionType.DEBIT);       //  установка типа транзакции
        transaction.setTransactionId(getTransactionID()); // установка кода транзакции
        LinkedList<Transaction> transactions = userAccount.getTransactions();
        if (transactions != null) {
            transactions.add(transaction);
            userAccount.setTransactions(transactions);
        } else {
            userAccount.setTransactions(new LinkedList<>((Arrays.asList(transaction)))); // Добавляем транзакцию в массив
        }
        //Бизнес-Логика
        float currentBalace = userAccount.getBalance(); // проверяем баланс если меньше наличных средств выдает ошибку
        if (currentBalace < withDrawMoney) {
            throw new RuntimeException("У вас нет достаточной суммы, Вы не можете снять больше, чем" + currentBalace + " сумма");
        }
        userAccount.setBalance(currentBalace - withDrawMoney);
        return userAccount.getBalance();
    }

    /**
     * метод внесения денег на депозит
     */
    public float depositMoney(float depositMoney, Long accountNumber) {
        UserAccount userAccount = accountMap.get(accountNumber);

        Transaction transaction = new Transaction();
        transaction.setDate(returnCurrentDate());
        transaction.setTransactionAmout(depositMoney);
        transaction.setType(TransactionType.CREDIT);
        transaction.setTransactionId(getTransactionID());

        LinkedList<Transaction> transactions = userAccount.getTransactions();
        if (transactions != null) {
            transactions.add(transaction);
            userAccount.setTransactions(transactions);
        } else {
            userAccount.setTransactions(new LinkedList<>((Arrays.asList(transaction))));
        }

        //Бизнес-Логика
        float currentBalace = userAccount.getBalance();
        if (depositMoney > 10000) {
            throw new RuntimeException("Вы не можете внести более 10000 рублей за один раз");
        }
        userAccount.setBalance(currentBalace + depositMoney);
        return userAccount.getBalance();
    }

    /**
     * метод определения текущегео баланса
     */
    public float getBalance(Long accountNumber) {
        UserAccount userAccount = accountMap.get(accountNumber);
        System.out.println("Текущий Баланс " + userAccount.getBalance());
        return userAccount.getBalance();
    }

    /**
     * метод установки ФИО клиента
     */
    public void setUserName(long accountNumber, String newUserName) {
        UserAccount userAccount = accountMap.get(accountNumber);
        if (userAccount != null) {
            System.out.println("был Клиент " + userAccount.getUsername());
            userAccount.setUsername(newUserName);
            System.out.println("стал Клиент " + userAccount.getUsername());
        } else {
            System.out.println("не нашли Клиента с кодом " + accountNumber);
        }
    }

    /**
     * метод получения счета по номеру
     */
    public UserAccount getOpeningAccount(Long accountNumber) {
        UserAccount userAccount = accountMap.get(accountNumber);
        if (userAccount != null) {
            System.out.println("Нашли Клиента " + userAccount.getAccountnumber());
        } else {
            System.out.println("не Нашли Клиента " + accountNumber);
        }
        return userAccount;
    }

    /**
     * метод создания нового счета
     */
    public UserAccount OpeningNewAccount() {
        UserAccount userAccount = new UserAccount();
        userAccount.setBalance(0);
        userAccount.setaccountOpeningDate(returnCurrentDate());
        userAccount.setAccountnumber(returnAccountNumber());
        accountMap.put(userAccount.getAccountnumber(), userAccount);
        return userAccount;
    }

    /**
     * метод вывода информации о транзакции
     */
    public List<Transaction> getTransactions(String accountnumber) {
        UserAccount userAccount = accountMap.get(accountnumber);
        List<Transaction> transactions = null;
        if (userAccount.getTransactions() != null) {
            transactions = userAccount.getTransactions();
        }
        System.out.println("Id  Сумма         Дата    Тран-Тип");
        for (Transaction transaction : transactions) {
          // System.out.println(transaction.getTransactionId() + "  " + transaction.getTransactionAmout() + "      " + transaction.getDate() + "  " + transaction.getType());
            System.out.println(transaction.getTransactionId() + "  " + transaction.getTransactionAmout() + "      " + transaction.getDate() + "  " + transaction.getType());
        }
        return transactions;

    }
    /**
     * метод вывода информации о транзакции
     */
    public List<Transaction> getAllTransactions() {

        List<Transaction> transactions = new ArrayList<>();
        if (!accountMap.isEmpty()){
            for (UserAccount userAccount : accountMap.values()){
                if (userAccount.getTransactions() != null) {
                    for (Transaction iTransaction : userAccount.getTransactions()){
                        transactions.add(iTransaction);
                        System.out.println(iTransaction.getTransactionId() + "  " + iTransaction.getTransactionAmout() + "      " + iTransaction.getDate() + "  " + iTransaction.getType());
                    }
                }
            }
        }
        return transactions;

    }

}

