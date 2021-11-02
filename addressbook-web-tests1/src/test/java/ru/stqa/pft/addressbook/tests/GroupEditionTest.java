package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupEditionTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (app.group().list().size() == 0) {
            app.group().create(new GroupData().withName("NameTest1"));
        }
    }

    @Test
    public void testGroupEdition() throws Exception {
        List<GroupData> before = app.group().list();
        int index = before.size()-1;
        GroupData group = new GroupData()
                .withId(before.get(index).getId()).withName("@@NameTest1").withHeader("!!Header Test").withFooter("!!Footer Test");
        app.group().modify(index, group);
        List<GroupData> after = app.group().list();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(group);
        Assert.assertEquals(new HashSet<>(before), new HashSet<>(after));

    }




}