package miniBankProgekt.controller;

import miniBankProgekt.service.BankOperations;
import org.springframework.web.bind.annotation.*;


/**
 * Контролер для управления транзакциями по счетам клиента
 */
@RestController
public class TransactionController {
    @GetMapping("/account_sum")
    public String getClientCreate() {

        String html = "<label>Пополнене счета</label>" +
                "<form method=\"post\" action=\"/account_sum_create\">" +
                "<br><label>Сумма</label>" +
                "<br><input name=\"summa\" type=\"text\">\n" +
                "<br><input type=\"submit\"></input>\n" +
                "</form>" +
                "<br><br>" + "<button onclick=\"window.location.href = '/client_list/';\">Вернуться назад к списку клиентов (без пополнения)</button><br><br>";
        return html;
    }
    @PostMapping("/account_sum_create")
    public String setAccountSum(
         //   @PathVariable(name = "clientId") UUID clientId
         //   @PathVariable(name = "accountId") UUID accountId
         //   ,@PathVariable(name = "typeId") Integer typeId
         @RequestParam(name = "summa") float summa
    ) {
        BankOperations deposit = new BankOperations();
        deposit.depositMoney(summa, BankOperations.accountNumber);


        StringBuilder html = new StringBuilder();
            html.append("<label>Операция Зачисления на сумму " +summa+ " успешно выполнена</label>");

      //  html.append("<br><br>").append("<button onclick=\"window.location.href = '/account_list/").append(clientId).append("';\">Вернуться назад к списку счетов</button><br><br>");
        html.append("<br><br>").append("<button onclick=\"window.location.href = '/client_list/").append("';\">Вернуться назад к списку счетов</button><br><br>");
        return html.toString();

    }
    @GetMapping("/account_minus")
    public String getTransactionCreate() {

        String html = "<label>Снятие со счета</label>" +
                "<form method=\"post\" action=\"/account_minus_create\">" +
                "<br><label>Сумма</label>" +
                "<br><input name=\"summa\" type=\"text\">\n" +
                "<br><input type=\"submit\"></input>\n" +
                "</form>" +
                "<br><br>" + "<button onclick=\"window.location.href = '/client_list/';\">Вернуться назад к списку клиентов (без снятия)</button><br><br>";
        return html;
    }
    @PostMapping("/account_minus_create")
    public String setAccountminus(
            //   @PathVariable(name = "clientId") UUID clientId
            //   @PathVariable(name = "accountId") UUID accountId
            //   ,@PathVariable(name = "typeId") Integer typeId
            @RequestParam(name = "summa") float summa
    ) {
        BankOperations deposit = new BankOperations();

        StringBuilder html = new StringBuilder();
        try {
            deposit.withDrawMoney(summa, BankOperations.accountNumber);
            html.append("<label>Операция Снятия на сумму " +summa+ " успешно выполнена</label>");
        }
        catch (RuntimeException e) {
            html.append("<label>Ошибка операции:" +e.getLocalizedMessage()+ " </label>");
        }


        //  html.append("<br><br>").append("<button onclick=\"window.location.href = '/account_list/").append(clientId).append("';\">Вернуться назад к списку счетов</button><br><br>");
        html.append("<br><br>").append("<button onclick=\"window.location.href = '/client_list/").append("';\">Вернуться назад к списку счетов</button><br><br>");
        return html.toString();

    }

}
