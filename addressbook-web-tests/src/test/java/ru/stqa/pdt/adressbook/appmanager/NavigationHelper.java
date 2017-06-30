package ru.stqa.pdt.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Lena on 24/06/2017.
 */
public class NavigationHelper extends  HelperBase{

  public NavigationHelper(FirefoxDriver wd) {
    super(wd);
  }


  public void goToGroupPage() {

    click(By.linkText("groups"));
  }

  public void goToHomePage() {

    click(By.linkText("home"));
  }

  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }
}
