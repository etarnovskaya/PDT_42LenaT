package ru.stqa.pdt.adressbook.tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import ru.stqa.pdt.adressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getNavigationHelper().goToGroupPage();
    GroupData group = new GroupData("new1", null, null);
    app.getGroupHelper().createGroup(group);
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1);
    int max=0;
    for(GroupData g: after){

      if(group.getId()>max){
        max = g.getId();
      }
    }
    group.setId(max);

    before.add(group);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }

}
