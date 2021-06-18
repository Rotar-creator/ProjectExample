package miniBankProgekt.model;

/**
 * Класс Сервис "Транзакции".
 *
 * @author Rotar Mikhail
 * @version 1.1
 * @since 13.01.2021
 */
//@Data
//@AllArgsConstructor
public class Transaction {
    /**
     * поле дата транзакции
     */
    String date;

    /**
     * поле тип транзакции дебет кредит
     */
    TransactionType type;

    /**
     * поле сумма сделки
     */
    float transactionAmout;

    /**
     * поле код транзакции
     */
    String transactionId;

    /**
     * Функция получения значения поля {@link Transaction#date}
     *
     * @return возвращает дату создания транзакции
     */
    public String getDate() {
        return date;
    }

    /**
     * Процедура определения даты {@link Transaction#date}
     *
     * @param date - дата
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Функция получения значения поля {@link Transaction#type}
     *
     * @return type - возвращает тип транзакции
     */
    public TransactionType getType() {
        return type;
    }

    /**
     * Процедура определения типа транзакции {@link Transaction#type}
     *
     * @param type - тип транзакции
     */
    public void setType(TransactionType type) {
        this.type = type;
    }

    /**
     * Функция получения значения поля {@link Transaction#transactionAmout}
     *
     * @return transactionAmout - возвращает сумму транзакции
     */
    public float getTransactionAmout() {
        return transactionAmout;
    }

    /**
     * Процедура определения суммы транзакции {@link Transaction#transactionAmout}
     *
     * @param transactionAmout - сумму транзакции
     */
    public void setTransactionAmout(float transactionAmout) {
        this.transactionAmout = transactionAmout;
    }

    /**
     * Функция получения значения поля {@link Transaction#transactionId}
     *
     * @return transactionId - возвращает код транзакции
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * Процедура определения кода транзакции {@link Transaction#transactionId}
     *
     * @param transactionId - код транзакции
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

}

