package ru.stqa.pdt.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pdt.adressbook.model.GroupData;

/**
 * Created by Lena on 24/06/2017.
 */
public class GroupModificationTests extends TestBase {
  @Test
  public void testGroupModification() {
    app.getNavigationHelper().goToGroupPage();
    if (! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("new1", null, null));
    }
    int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().selectGroup(1);
    app.getGroupHelper().initGroupModification();

    app.getGroupHelper().fillGroupForm(new GroupData("Renew1", "REheader", "footer"));
    app.getGroupHelper().submitGroupModification();
    app.getNavigationHelper().goToGroupPage();
    int after=app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before);
  }
}
