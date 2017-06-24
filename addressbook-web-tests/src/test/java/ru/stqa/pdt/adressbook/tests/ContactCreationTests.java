package ru.stqa.pdt.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pdt.adressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.goToHomePage();
    app.initContactCreation();
    app.fillContactForm(new ContactData("fname", "mName", "lName", "Moscow", "999999999", "etarnovskaya@gmail.com", "wow notes"));
    app.confirmContactCreation();
  }

}