package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase{



  @Test
  public void testContactCreation() throws Exception {

    newContactLink();
    fillContactPage(new ContactData("FN Test2", "LN Test2", "Address Line Test2", "147258", "test2@test2.com"));
    submitContactCreation();

  }


}
