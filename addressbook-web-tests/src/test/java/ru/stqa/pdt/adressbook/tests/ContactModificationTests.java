package ru.stqa.pdt.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pdt.adressbook.model.ContactData;

/**
 * Created by Lena on 24/06/2017.
 */
public class ContactModificationTests extends TestBase {
  @Test
  public void testContactModification() {
    app.getNavigationHelper().goToHomePage();
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("fname", "mName", "lName", "Moscow", "999999999", "etarnovskaya@gmail.com", "wow notes", "new1"), true);
    }
    app.getContactHelper().selectFirstContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("newfname", "mName",
            "lName", "Moscow", "999999999", "etarnovskaya@gmail.com",
            "wow notes", null), false);
    app.getContactHelper().confirmContactModification();

  }
}
