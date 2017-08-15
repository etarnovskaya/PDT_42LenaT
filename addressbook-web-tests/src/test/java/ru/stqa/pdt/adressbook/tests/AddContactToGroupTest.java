package ru.stqa.pdt.adressbook.tests;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pdt.adressbook.model.ContactData;
import ru.stqa.pdt.adressbook.model.Contacts;
import ru.stqa.pdt.adressbook.model.GroupData;
import ru.stqa.pdt.adressbook.model.Groups;

public class AddContactToGroupTest extends TestBase {
  Logger logger = LoggerFactory.getLogger(ContactCreationTests.class);
  @BeforeMethod
  public void insurePreconditions(){
    if(app.db().contacts().size()== 0){
      app.goTo().homePage();
      app.contact().create(new ContactData().withLastName("test1").withFirstName("test1").withAddress("Moscow")
              .withHomePhone("999999999").withEmail("etarnovskaya@gmail.com"));
    }
    if(app.db().groups().size()==0){
      app.goTo().homePage();
      app.group().create(new GroupData().withName("test").withHeader("header").withFooter("Footer"));
    }
  }
@Test
  public void testAddingContactToFirstGroup(){
  Contacts before = app.db().contacts();
    app.goTo().homePage();
    app.contact().selectExistsGroup();
    app.contact().selectContactCheckBox(1);

    app.contact().clickOnTheAddGroup();

    }

//  @Test
//  public void testAddingContactToGroupWhenGroupListIsEmpty(){
//    //to check,that GroupListIsEmpty
//    app.goTo().homePage();
//    app.contact().selectContactCheckBox(1);
//    app.contact().clickOnTheAddGroup();
//
//  }


}

