package com.poecat.order;

import com.poecat.meal.Meal;
import org.junit.jupiter.api.*;

import java.io.FileNotFoundException;
import java.io.IOException;

public class OrderBackupTest {

    private static OrderBackup orderBackup;

    @BeforeAll
    static void setup() throws FileNotFoundException {
        orderBackup = new OrderBackup();
        orderBackup.createFile();
    }

    @BeforeEach
    public void appendAtTheStartOfTheLine() throws IOException {
        orderBackup.getWriter().append("New order: ");
    }

    @AfterEach
    public void appendAtTheEndOfTheLine() throws IOException {
        orderBackup.getWriter().append(" backed up.");
    }

    @Tag("fries")
    @Test
    public void backupOrderWithOneMeal() throws IOException {

        //given
        Meal meal = new Meal(7, "Fries");
        Order order = new Order();
        order.addMealToOrder(meal);

        //when
        orderBackup.backupOrder(order);

        //then
        System.out.println("Order " + order.toString() + " backed up.");
    }

    @AfterAll
    static void tearDown() throws IOException {
        orderBackup.closeFile();
    }
}
