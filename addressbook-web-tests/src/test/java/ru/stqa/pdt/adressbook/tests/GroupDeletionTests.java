package ru.stqa.pdt.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pdt.adressbook.model.GroupData;

public class GroupDeletionTests extends TestBase{

    
    @Test
    public void testGroupDeletion() {
      app.getNavigationHelper().goToGroupPage();
      if (! app.getGroupHelper().isThereAGroup()){
        app.getGroupHelper().createGroup(new GroupData("new1", null, null));
      }
      app.getGroupHelper().selectGroup();
      app.getGroupHelper().deleteSelectedGroup();
      app.getNavigationHelper().goToGroupPage();
    }


}
