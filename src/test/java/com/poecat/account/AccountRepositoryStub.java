package com.poecat.account;

import java.util.Arrays;
import java.util.List;

public class AccountRepositoryStub implements AccountRepository {

    @Override
    public List<Account> getAllAccounts() {

        Address address1 = new Address("Kwiatowa", "33/5");
        Account account = new Account(address1);

        Account account2 = new Account();

        Address address2 = new Address("Różana", "12b");
        Account account3 = new Account(address2);

        return Arrays.asList(account, account2, account3);
    }
}
