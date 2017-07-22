package ru.stqa.pdt.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pdt.adressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Lena on 24/06/2017.
 */
public class ContactModificationTests extends TestBase {
  @BeforeMethod
  public void insurePreconditions(){
    if (app.contact().list().size()==0){
      app.contact().create(new ContactData("fname", "mName", "lName", "Moscow", "999999999", "etarnovskaya@gmail.com", "wow notes", "new1"), true);
    }
  }
  @Test(enabled = true)
  public void testContactModificationLastInList() {
    app.goTo().homePage();

    List<ContactData> before = app.contact().list();
    int index = before.size() -1;
    ContactData contact = new ContactData(before.get(index).getId(), "newfname", "mName",
            "lName", "Moscow", "999999999", "etarnovskaya@gmail.com",
            "wow notes", null);
    //int before = app.getContactHelper().getContactCount();
    app.contact().modify(index, contact);
    List<ContactData> after = app.contact().list();
    //int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> ById = (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
    contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.sort(ById);
    after.sort(ById);

   // Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    Assert.assertEquals(before, after);

  }


}
