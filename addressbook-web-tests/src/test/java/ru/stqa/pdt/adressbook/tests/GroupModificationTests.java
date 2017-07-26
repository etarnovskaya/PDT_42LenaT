package ru.stqa.pdt.adressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pdt.adressbook.model.GroupData;
import ru.stqa.pdt.adressbook.model.Groups;

import java.util.Comparator;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

/**
 * Created by Lena on 24/06/2017.
 */
public class GroupModificationTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().groupPage();
    if (app.group().all().size() == 0){
      app.group().create(new GroupData().withName("test1"));
    }
  }
  @Test
  public void testGroupModificationByIndex1() {

    Groups before= app.group().all();
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData()
            .withId(modifiedGroup.getId())
            .withName("Renew1")
            .withHeader("REheader")
            .withFooter("footer");
    app.group().modify(group);
    Groups after = app.group().all();
    Assert.assertEquals(after.size(), before.size());

    assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
  }


}
