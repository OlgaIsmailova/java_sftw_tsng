package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void submitContactCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void submitContactUpdate() {
        click(By.xpath("//div[@id='content']/form/input[22]"));
    }

    public void fillContactPage(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("address"), contactData.getAddress());
        click(By.xpath("//div[@id='content']/form/label[9]"));
        type(By.name("home"), contactData.getPhone());
        type(By.name("email"), contactData.getEmail());
    }



    public void newContactLink() {
        click(By.linkText("add new"));
    }

    public void deleteSelectedContact() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void editSelectedContact() {
        click(By.xpath("//img[@alt='Edit']"));
    }


    private void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void create(ContactData contact)
    {
        newContactLink();
        fillContactPage(contact);
        submitContactCreation();
    }

    public void modify(ContactData contact) {
        selectContactById(contact.getId());
        editSelectedContact();
        fillContactPage(contact);
        submitContactUpdate();
    }


    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        deleteSelectedContact();
    }



    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }


    public Set<ContactData> all() {
        Set<ContactData> contacts = new HashSet<ContactData>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            String lastName = element.findElement(By.cssSelector(":nth-child(2)")).getText();
            String firstName = element.findElement(By.cssSelector(":nth-child(3)")).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            contacts.add(new ContactData().withId(id).withFirstName(firstName).withLastName(lastName));
        }
        return contacts;
    }


}
