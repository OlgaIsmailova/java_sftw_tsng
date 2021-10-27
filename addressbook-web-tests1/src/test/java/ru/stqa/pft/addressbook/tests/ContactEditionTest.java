package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.HelperBase;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactEditionTest extends TestBase {




    @Test
    public void testContactEdition() throws Exception {
        app.goToHomePage();
        app.acceptNextAlert = true;
        HelperBase helperBase = new HelperBase(app.getWd());
        if (! helperBase.isElementPresent(By.name("selected[]"))) {
            app.getContactHelper().createContact(new ContactData("FN Test2", "LN Test2", "Address Line Test2", "147258", "test2@test2.com"));
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().editSelectedContact();
        app.getContactHelper().fillContactPage(new ContactData("FN >))):> Test2", "LN!! Test2", "!!Address Line Test2", "!!147258", "!!test2@test2.com"));
        app.getContactHelper().submitContactUpdate();
        app.goToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());
    }


}