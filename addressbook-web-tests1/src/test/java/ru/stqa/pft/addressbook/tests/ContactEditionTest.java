package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.testng.Assert.*;

public class ContactEditionTest extends TestBase {




    @Test
    public void testContactDeletion() throws Exception {
        app.goToHomePage();
        app.acceptNextAlert = true;
        app.getContactHelper().selectContact();
        app.getContactHelper().editSelectedContact();
        app.getContactHelper().fillContactPage(new ContactData("FN!! Test2", "LN!! Test2", "!!Address Line Test2", "!!147258", "!!test2@test2.com"));
        app.getContactHelper().submitContactUpdate();
    }


}