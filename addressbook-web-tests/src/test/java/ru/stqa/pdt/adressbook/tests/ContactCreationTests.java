package ru.stqa.pdt.adressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pdt.adressbook.model.ContactData;
import ru.stqa.pdt.adressbook.model.Contacts;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactCreationTests extends TestBase {

  @Test(enabled = true)
  public void testContactCreation() {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData()
            .withFirstName("onewfname")
            .withMiddleName(null)
            .withLastName("lName")
            .withAddress("Moscow")
            .withPhone("999999999")
            .withEmail("etarnovskaya@gmail.com").withGroup(null).withNotes(null)
            .withNotes(null);
    app.contact().create(contact);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(contact.withId(after.stream().mapToInt((c)->c.getId()).max().getAsInt())));
  }



}