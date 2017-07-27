package ru.stqa.pdt.adressbook.tests;

import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import ru.stqa.pdt.adressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.equalToObject;

public class ContactEmailTests  extends  TestBase{

  @Test
  public void contactAddressTests(){
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();

    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    MatcherAssert.assertThat((contact.getAllEmails()), equalTo(mergeEmails(contactInfoFromEditForm)));


  }

  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s)-> ! equals(""))
            .map(ContactEmailTests::cleaned)
            .collect(Collectors.joining(""));
  }


  public static String cleaned (String email){
    return email.replaceAll("\\s", "");
  }
}
