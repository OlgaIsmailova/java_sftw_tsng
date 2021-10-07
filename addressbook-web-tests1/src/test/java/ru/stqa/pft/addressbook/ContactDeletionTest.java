package ru.stqa.pft.addressbook;

import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;

public class ContactDeletionTest extends TestBase {




  @Test
  public void testContactDeletion() throws Exception {
    goToHomePage();
    acceptNextAlert = true;
    selectContact();
    deleteSelectedContact();
    assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
  }


}
