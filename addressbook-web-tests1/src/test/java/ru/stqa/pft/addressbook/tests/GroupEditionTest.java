package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupEditionTest extends TestBase {



    @Test
    public void testGroupEdition() throws Exception {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().editSelectedGroups();
        app.getGroupHelper().fillGroupForm(new GroupData("@@NameTest1", "!!Header Test", "!!Footer Test"));
        app.getGroupHelper().submitGroupEdition();
        app.getGroupHelper().returnToGroupPage();
    }


}