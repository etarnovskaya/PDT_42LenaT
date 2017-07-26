package ru.stqa.pdt.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pdt.adressbook.model.GroupData;
import ru.stqa.pdt.adressbook.model.Groups;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Lena on 24/06/2017.
 */
public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void submitGroupCreation() {
    wd.findElement(By.name("submit")).click();
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getGroupName());
    type(By.name("group_header"), groupData.getGroupName());
    type(By.name("group_footer"), groupData.getGroupName());
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void deleteSelectedGroup() {
    click(By.xpath("//div[@id='content']/form/input[5]"));
  }

  public void selectGroup(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
     }

public void selectGroupById(int id) {
  wd.findElement(By.cssSelector("input[value='"+ id+"']")).click();

}

  public void submitGroupModification() {
    click(By.name("update"));
  }

  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }


  public void create(GroupData group) {
    initGroupCreation();
    fillGroupForm(group);
    submitGroupCreation();
    groupCache = null;
    returnToGroupPage();
  }



  public void delete(GroupData group) {
    selectGroupById(group.getId());
    deleteSelectedGroup();
    groupCache = null;
    returnToGroupPage();
  }


  public void modify(GroupData group) {
    selectGroupById(group.getId());
    initGroupModification();
    fillGroupForm(group);
    submitGroupModification();
    groupCache = null;
    returnToGroupPage();
  }

  public boolean isThereAGroup() {
    return isElementPresent(By.name("selected[]"));
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();

  }

  public void initGroupModification() {
    click(By.xpath("//div[@id='content']/form/input[6]"));
  }

  private Groups groupCache = null;



  public Groups all() {
    if (groupCache != null){
      return new Groups(groupCache);
    }
    groupCache = new Groups();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements) {
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.name("selected[]")).getAttribute("value"));
      groupCache.add(new GroupData().withId(id).withName(name));
    }
    return new Groups(groupCache);
  }



}
