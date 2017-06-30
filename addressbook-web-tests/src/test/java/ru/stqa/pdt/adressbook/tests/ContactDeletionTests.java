package ru.stqa.pdt.adressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {


  @Test
  public void testContactDeletion() {
    app.getNavigationHelper().goToHomePage();
    app.getContactHelper().selectFirstContact();
    app.getContactHelper().deleteSelectedContacts();
    app.getContactHelper().confirmAlertContactDeletion();
    app.getNavigationHelper().goToHomePage();


  }


}
