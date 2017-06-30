package ru.stqa.pdt.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pdt.adressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getNavigationHelper().goToHomePage();
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("fname", "mName", "lName", "Moscow", "999999999", "etarnovskaya@gmail.com", "wow notes", "new1"), true);
    app.getContactHelper().confirmContactCreation();
  }

}