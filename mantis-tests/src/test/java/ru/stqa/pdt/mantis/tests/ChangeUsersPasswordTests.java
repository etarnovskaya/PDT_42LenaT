package ru.stqa.pdt.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pdt.mantis.model.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static ru.stqa.pdt.mantis.tests.TestBase.app;

public class ChangeUsersPasswordTests extends TestBase {

  @BeforeMethod
  public void startMailServer(){
    app.mail().start();
  }

  @Test
  public void testChangeUsersPasswordByAdmin() throws IOException, MessagingException {
    app.login().start("administrator", "root");
    app.navigate().goToManageUsersPage();
    app.user().selectUserModifyById(2);
    app.user().initChangePassword();

    List<MailMessage> mailMessages = app.mail().waitForMail(1, 3000);


  }
  @AfterMethod(alwaysRun = true)
  public void stopMailServer(){
    app.mail().stop();
  }

}
