package ru.stqa.pdt.adressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pdt.adressbook.model.ContactData;
import ru.stqa.pdt.adressbook.model.Contacts;
import ru.stqa.pdt.adressbook.model.GroupData;

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
    if(app.db().contacts().size()== 0){
      app.goTo().homePage();
      app.contact().create(new ContactData().withLastName("test1").withFirstName("test1").withAddress("Moscow")
              .withHomePhone("999999999").withEmail("etarnovskaya@gmail.com"));
    }
   }
  @Test(enabled = true)
  public void testContactModificationLastInList() {
    Contacts before = app.db().contacts();
    app.goTo().homePage();
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
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.withOut(modifiedContact).withAdded(contact)));

    }


}
