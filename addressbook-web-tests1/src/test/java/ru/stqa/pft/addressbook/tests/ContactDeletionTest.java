package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import static org.testng.Assert.*;

public class ContactDeletionTest extends TestBase {




  @Test
  public void testContactDeletion() throws Exception {
    app.goToHomePage();
    app.acceptNextAlert = true;
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContact();
    assertTrue(app.closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
  }


}
