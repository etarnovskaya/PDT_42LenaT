package ru.stqa.pdt.adressbook.tests;

import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import ru.stqa.pdt.adressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.equalToObject;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTests extends TestBase {
  @Test
  public void contactAddressTests(){
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();

    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    MatcherAssert.assertThat(contact.getAddress(), equalToObject(contactInfoFromEditForm.getAddress()));


  }

  private String mergeAddress(ContactData contact) {
    return Arrays.asList(contact.getAddress(), contact.getAddress())
            .stream().filter((s)-> ! equals(""))
            .map(ContactPhonesTest::cleaned)
            .collect(Collectors.joining(""));
  }

  public static String cleaned (String address){
    return address.replaceAll("\\s", "");
  }
}
