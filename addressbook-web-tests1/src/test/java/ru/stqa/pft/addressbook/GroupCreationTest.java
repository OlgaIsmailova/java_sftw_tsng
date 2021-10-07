package ru.stqa.pft.addressbook;

import org.testng.annotations.*;

public class GroupCreationTest extends TestBase {


  @Test
  public void testGroupCreation() throws Exception {

    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("NameTest1", "Header Test", "Footer Test"));
    submitGroupCreation();
    returnToGroupPage();

  }


}
