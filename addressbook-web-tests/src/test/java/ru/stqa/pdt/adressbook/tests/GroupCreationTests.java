package ru.stqa.pdt.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pdt.adressbook.model.GroupData;

public class GroupCreationTests extends TestBase{

    @Test
    public void testGroupCreation() {

        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().createGroup(new GroupData("new1", null, null));
          }

}
