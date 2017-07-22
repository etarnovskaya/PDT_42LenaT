package ru.stqa.pdt.adressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.*;
import ru.stqa.pdt.adressbook.appmanager.ApplicationManager;

/**
 * Created by Lena on 20/06/2017.
 */
public class TestBase {

  protected static final ApplicationManager app = new ApplicationManager(BrowserType.FIREFOX);
 //protected final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);
  //protected final ApplicationManager app = new ApplicationManager(BrowserType.IE);

  @BeforeClass
  public void setUp() throws Exception {
    app.init();
  }


  @AfterClass
  public void tearDown() {
    app.stop();
  }


}
