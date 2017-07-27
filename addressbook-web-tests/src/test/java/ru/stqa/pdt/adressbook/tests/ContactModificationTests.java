package ru.stqa.pdt.adressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pdt.adressbook.model.ContactData;
import ru.stqa.pdt.adressbook.model.Contacts;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

/**
 * Created by Lena on 24/06/2017.
 */
public class ContactModificationTests extends TestBase {
  @BeforeMethod
  public void insurePreconditions(){
    app.goTo().homePage();
    if (app.contact().all().size()==0){
      app.contact().create(new ContactData()
              .withFirstName("fname")
              .withLastName("lName")
              .withAddress("Moscow")
              .withHomePhone("999999999").withEmail("etarnovskaya@gmail.com"), true);
    }
  }
  @Test(enabled = true)
  public void testContactModificationLastInList() {
    app.goTo().homePage();

    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId())
            .withFirstName("newfname")
            .withLastName("lName")
            .withAddress("Moscow")
            .withHomePhone("999999999")
            .withEmail("etarnovskaya@gmail.com")
            .withNotes("hhkjhk");

    app.contact().modify(contact);
    Assert.assertEquals(app.contact().count(), before.size());
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.withOut(modifiedContact).withAdded(contact)));

    }


}
