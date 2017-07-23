package ru.stqa.pdt.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pdt.adressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactCreationTests extends TestBase {

  @Test(enabled = true)
  public void testContactCreation() {
    app.goTo().homePage();
    Set<ContactData> before = app.contact().all();
    ContactData contact = new ContactData()
            .withFirstName("onewfname")
            .withMiddleName(null)
            .withLastName("lName")
            .withAddress("Moscow")
            .withPhone("999999999")
            .withEmail("etarnovskaya@gmail.com").withGroup(null).withNotes(null)
            .withNotes(null);
    app.contact().create(contact);
    Set<ContactData> after = app.contact().all();


    contact.withId(after.stream().mapToInt((c)->c.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);
  }



}