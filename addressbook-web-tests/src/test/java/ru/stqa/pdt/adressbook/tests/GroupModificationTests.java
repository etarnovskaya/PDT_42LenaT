package ru.stqa.pdt.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pdt.adressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Lena on 24/06/2017.
 */
public class GroupModificationTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().groupPage();
    if (app.group().list().size() == 0){
      app.group().create(new GroupData("new1", null, null));
    }
  }
  @Test
  public void testGroupModificationByIndex1() {

    List<GroupData> before = app.group().list();
    int index = before.size()-1;
    GroupData group = new GroupData(before.get(index).getId(), "Renew1", "REheader", "footer");
    app.group().modify(index, group);
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(group);
    Comparator<? super GroupData> ById = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(ById);
    after.sort(ById);

    Assert.assertEquals(before, after);
  }


}
