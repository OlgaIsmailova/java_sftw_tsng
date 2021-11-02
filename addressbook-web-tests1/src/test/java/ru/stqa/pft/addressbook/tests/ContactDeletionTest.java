package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.appmanager.HelperBase;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

import static org.testng.Assert.*;

public class ContactDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    app.acceptNextAlert = true;
    HelperBase helperBase = new HelperBase(app.getWd());
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstName("FN Test2").withLastName("LN Test2").withAddress("Address Line Test2").withPhone("147258").withEmail("test2@test2.com"));
    }
    app.goTo().homePage();
  }


  @Test
  public void testContactDeletion() throws Exception {
    Set<ContactData> before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    assertTrue(app.closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
    app.goTo().homePage();
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() - 1);


    before.remove(deletedContact);
    Assert.assertEquals(before, after);
  }




}
