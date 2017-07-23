package ru.stqa.pdt.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pdt.adressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

/**
 * Created by Lena on 24/06/2017.
 */
public class ContactModificationTests extends TestBase {
  @BeforeMethod
  public void insurePreconditions(){
    if (app.contact().all().size()==0){
      app.contact().create(new ContactData()
              .withFirstName("fname")
              .withLastName("lName")
              .withAddress("Moscow")
              .withPhone("999999999").withEmail("etarnovskaya@gmail.com"), true);
    }
  }
  @Test(enabled = true)
  public void testContactModificationLastInList() {
    app.goTo().homePage();

    Set<ContactData> before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId())
            .withFirstName("newfname")
            .withLastName("lName")
            .withAddress("Moscow")
            .withPhone("999999999")
            .withEmail("etarnovskaya@gmail.com")
            .withNotes("hhkjhk");

    app.contact().modify(contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedContact);

    Assert.assertEquals(before, after);

  }


}
