package ru.stqa.pdt.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pdt.adressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {


  @Test(enabled = false)
  public void testContactDeletion() {
    app.getNavigationHelper().goToHomePage();
     if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("fname", "mName", "lName", "Moscow", "999999999", "etarnovskaya@gmail.com", "wow notes", "new1"), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    //int before = app.getContactHelper().getContactCount();
    app.getContactHelper().selectContactCheckBox(0);
    app.getContactHelper().deleteSelectedContacts();
    app.getContactHelper().confirmAlertContactDeletion();
    app.getNavigationHelper().goToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size()-1);

    before.remove(0);

    //int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(before, after);


  }


}
