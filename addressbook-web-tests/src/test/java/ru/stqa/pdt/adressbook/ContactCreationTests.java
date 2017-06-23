package ru.stqa.pdt.adressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    goToHomePage();
    initContactCreation();
    fillContactForm(new ContactData("fname", "mName", "lName", "Moscow", "999999999", "etarnovskaya@gmail.com", "wow notes"));
    confirmContactCreation();
  }

}