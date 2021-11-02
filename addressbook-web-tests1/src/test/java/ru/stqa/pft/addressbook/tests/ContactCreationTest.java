package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase{



  @Test
  public void testContactCreation() throws Exception {
    app.goToHomePage();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstName("FN Test2").withLastName("LN Test2").withAddress("Address Line Test2").withPhone("147258").withEmail("test2@test2.com");
    app.contact().create(contact);
    app.goToHomePage();
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }


}
