package Project_Mini_Bank1;

import model.UserAccount;
import service.BankOperations;

/**
 * Проект мимнибанк
 *
 * @author Rotar Mikhail
 * @version 1.1
 * @since 13.01.2021
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BankOperations operations = new BankOperations();
        UserAccount arpit = operations.OpeningNewAccount();

        arpit.setMobilenumber("8975122354");
        arpit.setUsername("Ротарь Михаил Юрьевич");
        arpit.depositMoney(100, arpit.getAccountnumber());
        arpit.withDrawMoney(50, arpit.getAccountnumber());
        arpit.depositMoney(200, arpit.getAccountnumber());
        arpit.withDrawMoney(150, arpit.getAccountnumber());
        arpit.depositMoney(5000, arpit.getAccountnumber());
        arpit.withDrawMoney(1650, arpit.getAccountnumber());
        arpit.getTransactions(arpit.getAccountnumber());
        System.out.println(arpit.getUsername().toString());
        arpit.getBalance("10001");
    }
}
