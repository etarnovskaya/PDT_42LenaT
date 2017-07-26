package ru.stqa.pdt.adressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pdt.adressbook.model.ContactData;
import ru.stqa.pdt.adressbook.model.Contacts;

import java.util.List;
import java.util.Set;

public class ContactDeletionTests extends TestBase {
  @BeforeMethod
  public void insurePreconditions() {
    if (app.contact().all().size() == 0) {
      app.contact().create(
              new ContactData()
                      .withFirstName("newfname")
                      .withLastName("lName")
                      .withAddress("Moscow")
                      .withPhone("999999999")
                      .withEmail("etarnovskaya@gmail.com"),true);
    }
  }

  @Test(enabled = true)
  public void testContactDeletion() {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Contacts after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() - 1);

   MatcherAssert.assertThat(before, CoreMatchers.equalTo(before.withOut(deletedContact)));


  }
}
