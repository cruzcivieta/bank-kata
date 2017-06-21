package com.alexsimo.bankkata;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class AcceptanceTest {

    @Mock
    Console console;
    private Account account;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        account = new Account();
    }

    @Test
    public void account_should_print_statement_with_all_transactions() throws Exception {
        account.deposit(1000);
        account.withdraw(100);
        account.deposit(500);

        account.printStatement();

        verify(console).printLine("DATE |   AMOUNT  |   BALANCE");
        verify(console).printLine("03/08/2017 |   500  |   1400");
        verify(console).printLine("02/08/2017 |   -100  |   900");
        verify(console).printLine("01/08/2017 |   1000  |   1000");
    }
}