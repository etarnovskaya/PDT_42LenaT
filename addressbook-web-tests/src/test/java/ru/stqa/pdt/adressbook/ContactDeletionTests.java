package ru.stqa.pdt.adressbook;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {


  @Test
  public void testContactDeletion() {
    goToHomePage();
    selectFirstContact();
    deleteSelectedContacts();
  }


}
