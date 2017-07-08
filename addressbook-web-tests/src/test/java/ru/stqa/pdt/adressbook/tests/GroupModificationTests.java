package ru.stqa.pdt.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pdt.adressbook.model.GroupData;

import java.util.List;

/**
 * Created by Lena on 24/06/2017.
 */
public class GroupModificationTests extends TestBase {
  @Test
  public void testGroupModificationByIndex1() {
    app.getNavigationHelper().goToGroupPage();
    if (! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("new1", null, null));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();
    //int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().selectGroup(1);
    app.getGroupHelper().initGroupModification();

    app.getGroupHelper().fillGroupForm(new GroupData("Renew1", "REheader", "footer"));
    app.getGroupHelper().submitGroupModification();
    app.getNavigationHelper().goToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
   // int after=app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after.size(), before.size());
  }
}
