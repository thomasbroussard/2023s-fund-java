package fr.epita.bank.launcher;

import fr.epita.bank.datamodel.Customer;
import fr.epita.bank.datamodel.InvestmentAccount;
import fr.epita.bank.datamodel.Stock;
import fr.epita.bank.datamodel.StockOrder;
import fr.epita.bank.services.AccountService;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to the bank account system");
        Customer customer = new Customer("Thomas", "Paris");
        Stock stock = new Stock("GOLD", 2000.0);

        System.out.println(stock);

        System.out.println(customer);

        //usecase 1 :
        // create a customer, an investment account, a stock.
        // the customer buys 2 stock units through his investment account
        // the result is a stock order.
        // the balance of the investment account is impacted

        InvestmentAccount investmentAccount = new InvestmentAccount(10000);
        int quantity = 2;

        AccountService.buyStock(stock, investmentAccount, quantity);

    }


}
