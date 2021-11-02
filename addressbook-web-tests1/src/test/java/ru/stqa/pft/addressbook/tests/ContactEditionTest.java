package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.HelperBase;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactEditionTest extends TestBase {

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
    public void testContactEdition() throws Exception {
        Contacts before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withId(modifiedContact.getId()).withFirstName("New fn").withLastName("New ln").withAddress("!!Address Line Test2").withPhone("!!147258").withEmail("!!test2@test2.com");
        app.contact().modify(contact);
        app.goTo().homePage();
        Contacts after = app.contact().all();
        assertEquals(after.size(), before.size());
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    }


    }

