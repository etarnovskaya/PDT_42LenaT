package ru.stqa.pdt.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pdt.adressbook.model.GroupData;

public class GroupCreationTests extends TestBase{

    @Test
    public void testGroupCreation() {

        app.goToGroupPage();
        app.initGroupCreation();
        app.fillGroupForm(new GroupData("new1", "header", "footer"));
        app.submitGroupCreation();
        app.returnToGroupPage();
    }

}
