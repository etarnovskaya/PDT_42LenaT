package ru.stqa.pdt.adressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import ru.stqa.pdt.adressbook.appmanager.ApplicationManager;
import ru.stqa.pdt.adressbook.model.ContactData;
import ru.stqa.pdt.adressbook.model.Contacts;
import ru.stqa.pdt.adressbook.model.GroupData;
import ru.stqa.pdt.adressbook.model.Groups;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

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

  public void verifyGroupListInUI() {
    if (Boolean.getBoolean("verifyUI")) {
      Groups dbGroups = app.db().groups();
      Groups uiGroups = app.group().all();
      assertThat(uiGroups, equalTo(dbGroups.stream()
              .map((g) -> new GroupData().withId(g.getId()).withName(g.getGroupName()))
              .collect(Collectors.toSet())));
    }
  }

    public void verifyContactsListInUI() {
    if(Boolean.getBoolean("verifyUI")){
      Contacts dbContacts = app.db().contacts();
      Contacts uiContacts= app.contact().all();
      assertThat(uiContacts, equalTo(dbContacts.stream()
              .map((c) -> new ContactData().withId(c.getId()).withFirstName(c.getFirstName())
                      .withLastName(c.getLastName())).collect(Collectors.toSet())));
    }

  }



}
