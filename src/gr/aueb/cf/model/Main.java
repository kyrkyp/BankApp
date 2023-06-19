package gr.aueb.cf.model;

import gr.aueb.cf.exceptions.InsufficientBalanceException;
import gr.aueb.cf.exceptions.NegativeAmountException;
import gr.aueb.cf.exceptions.SsnNotValidException;

public class Main {

    public static void main(String[] args) {

        User kyriakos = new User("Kyriakos", "K.", "1234");
        Account account = new Account(kyriakos, "GR12346", 1234);

        User anna = new User("Anna", "G.", "56896");
        Account overJointAccount = new OverdraftJointAccount(kyriakos, "GR25863", 500, anna);

        Account overKyriakos = new OverdraftAccount(kyriakos, "Gr8968", 8056);

        try {
            System.out.println("Account: \n" + account);

            System.out.println("OverdraftAccount: \n" + overKyriakos);

            overJointAccount.deposit(100);

            overJointAccount.withdraw(50, "56896");

            System.out.println("Overdraft Joint Account: \n" + overJointAccount);

        } catch (NegativeAmountException | InsufficientBalanceException | SsnNotValidException e) {
            System.out.println(e.getMessage());
        }

    }
}
