package ru.stqa.pdt.mantis.appmanager;

import org.openqa.selenium.By;

public class UserHelper extends HelperBase {
  public UserHelper(ApplicationManager app) {
    super(app);
  }
  public void selectUserModifyById(int id) {
    wd.findElement(By.xpath("//a[@href='manage_user_edit_page.php?user_id=" + id + "']")).click();
  }

  public void initChangePassword(){
    wd.findElement(By.cssSelector("input[value='Reset Password']"));

  }

}
