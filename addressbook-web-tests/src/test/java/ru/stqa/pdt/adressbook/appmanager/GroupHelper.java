package ru.stqa.pdt.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pdt.adressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

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
   // click(By.name("selected[]"));
  }

//  public void initGroupModification(int index) {
//    wd.findElements(By.xpath("//div[@id='content']/form/input[6]")).get(index).click();
   // click(By.xpath("//div[@id='content']/form/input[6]"));
 // }

  public void submitGroupModification() {
    click(By.name("update"));
  }
  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }


  public void createGroup(GroupData group) {
    initGroupCreation();
    fillGroupForm(group);
    submitGroupCreation();
    returnToGroupPage();
  }

  public boolean isThereAGroup() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getGroupCount() {
    return  wd.findElements(By.name("selected[]")).size();

  }

  public void initGroupModification() {
    click(By.xpath("//div[@id='content']/form/input[6]"));
  }

  public List<GroupData> getGroupList() {
    List<GroupData> groups = new ArrayList<GroupData>();
  List <WebElement> elements = wd.findElements(By.cssSelector("span.group"));
  for (WebElement element: elements){
    String name = element.getText();
    String id = element.findElement(By.tagName("input")).getAttribute("value");
    GroupData group = new GroupData(id, name,null, null);
    groups.add(group);
    }
    return groups;
  }
}
