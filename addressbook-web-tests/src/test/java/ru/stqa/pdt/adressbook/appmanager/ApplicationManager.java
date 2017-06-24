package ru.stqa.pdt.adressbook.appmanager;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Lena on 24/06/2017.
 */
public class ApplicationManager {
  FirefoxDriver wd;

  private SessionHelper sessionHelper;
  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper;
  private ContactHelper contactHelper;

  public void init() {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/group.php");
    groupHelper = new GroupHelper(wd);
    contactHelper = new ContactHelper(wd);

    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    sessionHelper.logIn("admin", "secret");
  }



  public void stop() {
    wd.quit();
  }


  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }

  public ContactHelper getContactHelper() {
    return contactHelper;
  }

  public SessionHelper getSessionHelper() {
    return sessionHelper;
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

}
