package ru.stqa.pdt.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pdt.adressbook.model.GroupData;

import java.util.HashSet;
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
    app.getGroupHelper().selectGroup(before.size()-1);
    app.getGroupHelper().initGroupModification();
    GroupData group = new GroupData(before.get(before.size()-1).getId(), "Renew1", "REheader", "footer");

    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupModification();
    app.getNavigationHelper().goToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
   // int after=app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size()-1);
    before.add(group);

    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }
}
