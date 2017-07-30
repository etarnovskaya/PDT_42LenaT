package ru.stqa.pdt.adressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import ru.stqa.pdt.adressbook.appmanager.ApplicationManager;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by Lena on 20/06/2017.
 */
public class TestBase {
  Logger logger = LoggerFactory.getLogger(TestBase.class);


  protected static final ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
 //protected final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);
  //protected final ApplicationManager app = new ApplicationManager(BrowserType.IE);

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }


  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    app.stop();
  }

  @BeforeMethod
  public void logTestStart(Method m, Object[] p){
    logger.info("start test "+ m.getName() + " with parameters " + Arrays.asList(p));

  }

  @AfterMethod(alwaysRun = true)
  public void logTestStop(Method m){
    logger.info("stop test "+ m.getName());

  }


}
