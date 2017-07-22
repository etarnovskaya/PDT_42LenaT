package ru.stqa.pdt.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pdt.adressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test(enabled = true)
  public void testContactCreation() {
    app.goTo().homePage();
    List<ContactData> before = app.contact().list();
    ContactData contact = new ContactData("fname", "mName",
            "nextlName1", "Moscow", "999999999", "etarnovskaya@gmail.com",
            "wow notes", "new1");
    //int before = app.getContactHelper().getContactCount();
    app.contact().create(contact);
    List<ContactData> after = app.contact().list();

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