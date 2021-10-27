package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.appmanager.HelperBase;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

import static org.testng.Assert.*;

public class ContactDeletionTest extends TestBase {




  @Test
  public void testContactDeletion() throws Exception {
    app.goToHomePage();
    app.acceptNextAlert = true;
    HelperBase helperBase = new HelperBase(app.getWd());
    if (! helperBase.isElementPresent(By.name("selected[]"))) {
      app.getContactHelper().createContact(new ContactData("FN Test2", "LN Test2", "Address Line Test2", "147258", "test2@test2.com"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().deleteSelectedContact();
    assertTrue(app.closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
    app.goToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);


    before.remove(before.size()-1);
    Assert.assertEquals(before, after);
  }


}
