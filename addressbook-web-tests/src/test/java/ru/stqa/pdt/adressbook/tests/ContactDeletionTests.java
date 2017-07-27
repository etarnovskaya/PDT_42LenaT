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
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(
              new ContactData()
                      .withFirstName("newfname")
                      .withLastName("lName")
                      .withAddress("Moscow")
                      .withHomePhone("999999999")
                      .withMobilePhone("879787899")
                      .withWorkPhone("3354354")
                      .withEmail("etarnovskaya@gmail.com"),true);
    }
  }

  @Test(enabled = true)
  public void testContactDeletion() {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Assert.assertEquals(app.contact().count(), before.size() - 1);

    Contacts after = app.contact().all();

   MatcherAssert.assertThat(after, CoreMatchers.equalTo(before.withOut(deletedContact)));


  }
}
