package ru.stqa.pdt.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pdt.adressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getNavigationHelper().goToHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData contact = new ContactData("fname", "mName",
            "lName", "Moscow", "999999999", "etarnovskaya@gmail.com",
            "wow notes", "new1");
    //int before = app.getContactHelper().getContactCount();
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(contact, true);
    app.getContactHelper().confirmContactCreation();
    List<ContactData> after = app.getContactHelper().getContactList();

    //int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after.size(), before.size()+1);
    int max =1;
    for (ContactData c: after){
      if(contact.getId()> max){
        max= c.getId();
      }
    }



    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }

}