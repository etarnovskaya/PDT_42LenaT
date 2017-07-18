package ru.stqa.pdt.adressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pdt.adressbook.appmanager.ApplicationManager;

/**
 * Created by Lena on 20/06/2017.
 */
public class TestBase {

  protected final ApplicationManager app = new ApplicationManager(BrowserType.FIREFOX);
 //protected final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);
  //protected final ApplicationManager app = new ApplicationManager(BrowserType.IE);

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }


  @AfterSuite
  public void tearDown() {
    app.stop();
  }


}
