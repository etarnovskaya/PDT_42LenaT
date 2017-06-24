package ru.stqa.pdt.adressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {


  @Test
  public void testContactDeletion() {
    app.goToHomePage();
    app.selectFirstContact();
    app.deleteSelectedContacts();
  }


}
