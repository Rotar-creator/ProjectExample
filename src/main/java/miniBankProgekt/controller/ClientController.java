package miniBankProgekt.controller;


import miniBankProgekt.model.Transaction;
import miniBankProgekt.service.BankOperations;

import miniBankProgekt.model.UserAccount;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контролер для управления клиентами
 */

@RestController
public class ClientController {

/*    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }*/

    /**
     * Окно вывода списка клиентов
     *
     * @return html данные клиентоа
     */
    @GetMapping("/client_list")
    public String getClientList() {
        BankOperations operations = new BankOperations();
        UserAccount arpit = operations.getOpeningAccount(BankOperations.accountNumber);

        if (arpit == null){
            arpit = operations.OpeningNewAccount();
        }
//---------------------------------------------------------------
     //   arpit.setMobilenumber("8975122354");
      //  arpit.setUsername("Ротарь Михаил Юрьевич");
      //  arpit.depositMoney(100, arpit.getAccountnumber());
    //    arpit.withDrawMoney(50, arpit.getAccountnumber());
    //    arpit.depositMoney(200, arpit.getAccountnumber());
    //    arpit.withDrawMoney(150, arpit.getAccountnumber());
      //  arpit.depositMoney(5000, arpit.getAccountnumber());
    //    arpit.withDrawMoney(1650, arpit.getAccountnumber());
        //  System.out.println(arpit.getUsername());
        //   arpit.getBalance("10001");
//---------------------------------------------------------------
        StringBuilder html = new StringBuilder();

        //html.append("<br><br>").append("<a href=/client_create").append(">Создать нового клиента</a><br><br>");
        html.append("<br><br>").append("<button onclick=\"window.location.href = '/client_create';\">Создать нового клиента</button><br><br>");
        html.append("<br><br>").append("<button onclick=\"window.location.href = '/account_sum/';\">Зачисление на счет</button><br><br>");
        html.append("<br><br>").append("<button onclick=\"window.location.href = '/account_minus/';\">Снятие со  счета</button><br><br>");

        html.append("<br>Баланс счета клиента " + arpit.getUsername()).append("<pre>" + arpit.getBalance(BankOperations.accountNumber) + "</pre>");

        List<Transaction> transactions = operations.getAllTransactions();

        html.append("<br>Id     Сумма         Дата    Тран-Тип");
        for (Transaction transaction : transactions) {
            html.append("<br>" + transaction.getTransactionId() + "    "
                    + transaction.getTransactionAmout() + "      "
                    + transaction.getDate() + "    "
                    + transaction.getType());
        }
        html.append("<br>");
        //  html.append("<br><br>").append("<a href=/").append(">Вернуться назад на главную</a><br><br>");
        html.append("<br><br>").append("<button onclick=\"window.location.href = '/';\">Вернуться назад на главную </button><br><br>");
        return html.toString();
    }
    @GetMapping("/client_create")
    public String getClientCreate() {

        String html = "<label>Создание нового клиента</label>" +
                "<form method=\"post\" action=\"/client_save_new\">" +
                "<br><label>Имя</label>" +
                "<br><input name=\"firstName\" type=\"text\">\n" +
                "<br><label>Фамилия</label>" +
                "<br><input name=\"lastName\"  type=\"text\">\n" +
                "<br><label>Отчетсво</label>" +
                "<br><input name=\"middleName\"  type=\"text\">\n" +
                "<br><input type=\"submit\"></input>\n" +
                "</form>" +
                "<br><br>" + "<button onclick=\"window.location.href = '/client_list/';\">Вернуться назад к списку клиентов (без создания)</button><br><br>";
        return html;
    }
    /**
     * Окно сохранение новой карточки клиента
     * @param firstName - Имя клиента
     * @param lastName - фамилия клиента
     * @param middleName - отчетсов клиента
     * @return html форма подтверждения
     */
/*    @PostMapping("/client_save_new")
    public String setClientSave(
            @RequestParam(name = "firstName") String firstName,
            @RequestParam(name = "lastName") String lastName,
            @RequestParam(name = "middleName") String middleName,
    ) {
        Client client = clientService.create();
        client.setFirstName(firstName);
        client.setLastName(lastName);
        client.setMiddleName(middleName);

        StringBuilder html = new StringBuilder();
        html.append("<label>Сохранили клиента с id=" + client.toString() + "</label>");
        html.append("<br><br>").append("<button onclick=\"window.location.href = '/client_list/';\">Вернуться назад к списку клиентов</button><br><br>");
        return html.toString();
    }*/
   @PostMapping("/client_save_new")
    public String setClientSave(
            @RequestParam(name = "firstName") String firstName,
            @RequestParam(name = "lastName") String lastName,
            @RequestParam(name = "middleName") String middleName
    ) {
        //UserAccount client1 = new UserAccount();
        //client1.setUsername(firstName+" "+lastName+" "+middleName);

       String newClientName = firstName+" "+lastName+" "+middleName;
       BankOperations operations = new BankOperations();
       operations.setUserName(BankOperations.accountNumber,newClientName);

        StringBuilder html = new StringBuilder();
        html.append("<label>Сохранили клиента  : " + newClientName + "</label>");
        html.append("<br><br>").append("<button onclick=\"window.location.href = '/client_list/';\">Вернуться назад к списку клиентов</button><br><br>");
        return html.toString();
    }
}