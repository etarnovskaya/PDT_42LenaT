package ru.stqa.pdt.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pdt.adressbook.model.ContactData;
import ru.stqa.pdt.adressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactCreationTests extends TestBase {

  @Test(enabled = true)
  public void testContactCreation() {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/swiss.JPG");
    ContactData contact = new ContactData()
            .withFirstName("onewfname")
            .withMiddleName(null)
            .withLastName("lName")
            .withAddress("Moscow")
            .withHomePhone("999999999")
            .withEmail("etarnovskaya@gmail.com").withGroup(null).withNotes(null)
            .withNotes(null)
            .withPhoto(photo);
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();


    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((c)->c.getId()).max().getAsInt()))));
  }



}