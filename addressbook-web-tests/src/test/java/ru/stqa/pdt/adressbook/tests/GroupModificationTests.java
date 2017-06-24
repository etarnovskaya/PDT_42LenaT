package ru.stqa.pdt.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pdt.adressbook.model.GroupData;

/**
 * Created by Lena on 24/06/2017.
 */
public class GroupModificationTests extends TestBase {
  @Test
  public void testGroupModification() {
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("Renew1", "REheader", "footer"));
    app.getGroupHelper().submitGroupModification();
    app.getNavigationHelper().goToGroupPage();
  }
}
