package ru.stqa.pdt.adressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase{

    @Test
    public void testGroupCreation() {

        goToGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("new1", "header", "footer"));
        submitGroupCreation();
        returnToGroupPage();
    }

}
