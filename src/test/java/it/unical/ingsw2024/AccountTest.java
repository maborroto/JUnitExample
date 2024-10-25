package it.unical.ingsw2024;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    private Account account;

    @BeforeEach
    public void prepareTests(){
        this.account = new Account();
    }

    @Test
    public void constructorWorks(){
        Account account = new Account();
        assertEquals(0.0, account.getBalance());
    }
}
