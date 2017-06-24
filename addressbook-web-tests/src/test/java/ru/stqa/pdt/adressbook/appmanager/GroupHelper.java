package ru.stqa.pdt.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pdt.adressbook.model.GroupData;

/**
 * Created by Lena on 24/06/2017.
 */
public class GroupHelper extends  HelperBase{

  public GroupHelper(FirefoxDriver wd) {
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

  public void selectGroup() {
    click(By.name("selected[]"));
  }
}
