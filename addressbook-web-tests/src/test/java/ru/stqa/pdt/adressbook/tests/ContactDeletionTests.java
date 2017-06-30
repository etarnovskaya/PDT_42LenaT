package ru.stqa.pdt.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pdt.adressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {


  @Test
  public void testContactDeletion() {
    app.getNavigationHelper().goToHomePage();
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("fname", "mName", "lName", "Moscow", "999999999", "etarnovskaya@gmail.com", "wow notes", "new1"), true);
    }
    app.getContactHelper().selectFirstContact();
    app.getContactHelper().deleteSelectedContacts();
    app.getContactHelper().confirmAlertContactDeletion();
    app.getNavigationHelper().goToHomePage();


  }


}
