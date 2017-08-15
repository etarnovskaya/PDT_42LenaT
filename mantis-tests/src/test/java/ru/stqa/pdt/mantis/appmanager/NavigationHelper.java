package ru.stqa.pdt.mantis.appmanager;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {
  public NavigationHelper(ApplicationManager app) {
    super(app);
  }

  public void goToManageUsersPage(){
    click(By.xpath("//a[text()=\"Manage Users\"]"));
  }
}
