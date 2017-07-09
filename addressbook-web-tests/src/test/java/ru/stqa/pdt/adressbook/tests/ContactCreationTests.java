package ru.stqa.pdt.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pdt.adressbook.model.ContactData;
import ru.stqa.pdt.adressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getNavigationHelper().goToHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData contact = new ContactData("fname", "mName",
            "lName1", "Moscow", "999999999", "etarnovskaya@gmail.com",
            "wow notes", "new1");
    //int before = app.getContactHelper().getContactCount();
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(contact, true);
    app.getContactHelper().confirmContactCreation();
    List<ContactData> after = app.getContactHelper().getContactList();

    //int after = app.getContactHelper().getContactCount();
//    Assert.assertEquals(after.size(), before.size()+1);
//    int max =1;
//    for (ContactData c: after){
//      if(contact.getId()> max){
//        max= c.getId();
//      }
//    }

    Comparator<? super ContactData> ById =(o1, o2) -> Integer.compare(o1.getId(), o2.getId());
    contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());

    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }

}