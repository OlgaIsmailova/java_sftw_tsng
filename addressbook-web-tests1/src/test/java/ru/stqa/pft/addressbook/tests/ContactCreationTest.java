package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.Set;

public class ContactCreationTest extends TestBase{



  @Test
  public void testContactCreation() throws Exception {
    app.goToHomePage();
    Set<ContactData> before = app.contact().all();
    ContactData contact = new ContactData().withFirstName("FN Test2").withLastName("LN Test2").withAddress("Address Line Test2").withPhone("147258").withEmail("test2@test2.com");
    app.contact().create(contact);
    app.goToHomePage();
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);


    contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(new HashSet<>(before), new HashSet<>(after));
  }


}
