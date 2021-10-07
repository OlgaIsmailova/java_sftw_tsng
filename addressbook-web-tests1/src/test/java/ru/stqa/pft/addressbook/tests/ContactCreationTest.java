package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase{



  @Test
  public void testContactCreation() throws Exception {

    app.getContactHelper().newContactLink();
    app.getContactHelper().fillContactPage(new ContactData("FN Test2", "LN Test2", "Address Line Test2", "147258", "test2@test2.com"));
    app.getContactHelper().submitContactCreation();

  }


}
