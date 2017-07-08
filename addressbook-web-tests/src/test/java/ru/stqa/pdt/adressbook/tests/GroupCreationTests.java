package ru.stqa.pdt.adressbook.tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import ru.stqa.pdt.adressbook.model.GroupData;

import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().createGroup(new GroupData("new1", null, null));
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1);
  }

}
