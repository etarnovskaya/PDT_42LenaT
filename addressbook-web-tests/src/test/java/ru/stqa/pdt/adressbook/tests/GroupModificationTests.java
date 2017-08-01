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
    if(app.db().groups().size()== 0){
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1"));
    }
  }
  @Test
  public void testGroupModificationByIndex1() {

    Groups before= app.db().groups();
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData()
            .withId(modifiedGroup.getId())
            .withName("Renew1")
            .withHeader("REheader")
            .withFooter("footer");
    app.group().modify(group);
    Assert.assertEquals(app.group().count(), before.size());
    Groups after = app.db().groups();


    assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
  }


}
