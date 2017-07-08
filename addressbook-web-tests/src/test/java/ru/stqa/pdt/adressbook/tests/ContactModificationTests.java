package ru.stqa.pdt.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pdt.adressbook.appmanager.ContactHelper;
import ru.stqa.pdt.adressbook.model.ContactData;

import java.util.List;

/**
 * Created by Lena on 24/06/2017.
 */
public class ContactModificationTests extends TestBase {
  @Test
  public void testContactModificationLastInList() {
    app.getNavigationHelper().goToHomePage();
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("fname", "mName", "lName", "Moscow", "999999999", "etarnovskaya@gmail.com", "wow notes", "new1"), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    //int before = app.getContactHelper().getContactCount();
    app.getContactHelper().selectContact(before.size() -1);
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("newfname", "mName",
            "lName", "Moscow", "999999999", "etarnovskaya@gmail.com",
            "wow notes", null), false);
    app.getContactHelper().confirmContactModification();
    List<ContactData> after = app.getContactHelper().getContactList();
    //int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after.size(), before.size());

  }
}
