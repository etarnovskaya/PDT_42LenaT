package ru.stqa.pdt.mantis.appmanager;

import org.openqa.selenium.By;

public class LogInHelper extends HelperBase {

  public LogInHelper(ApplicationManager app) {
    super(app);
  }
  public void start(String username, String password) {
    wd.get(app.getProperty("web.baseUrl")+"/login_page.php");
    type(By.name("username"), username);
    type(By.name("password"),password);
    click(By.cssSelector("input[value='Login']"));

  }
}
