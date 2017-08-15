package ru.stqa.pdt.adressbook.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pdt.adressbook.model.ContactData;
import ru.stqa.pdt.adressbook.model.Contacts;
import ru.stqa.pdt.adressbook.model.GroupData;
import ru.stqa.pdt.adressbook.model.Groups;

public class DeleteContactFromGroup extends TestBase {
  Logger logger = LoggerFactory.getLogger(ContactCreationTests.class);

  @BeforeMethod
  public void insurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.goTo().homePage();
      app.contact().create(new ContactData().withLastName("test1").withFirstName("test1").withAddress("Moscow")
              .withHomePhone("999999999").withEmail("etarnovskaya@gmail.com"));
    }
    if (app.db().groups().size() == 0) {
      app.goTo().homePage();
      app.group().create(new GroupData().withName("test").withHeader("header").withFooter("Footer"));
    }
  }

//  @Test
//  public void testAddingContactToFirstGroup() {
//    Groups before = app.db().groups();
//    Contacts modifiedContact = app.db().contacts();
//    ContactData modifiedContact = before.iterator().next();
//    Groups contactsWithGroups = modifiedContact.getGroups();
//
//    app.goTo().homePage();
//    app.contact().displayGroup();
//    app.contact().selectContactCheckBoxById(contact().getId);
//    app.contact().clickOnRemoveContactFromGroupButton();
//
//
//  }
//}



//                            +//    проверка
//                                    +      Contacts modifiedContactFromBase = app.db().getContactByID(modifiedContact.getId());
//    +      Groups addedGroupsAfter = null;
//    +      for (ContactData c : modifiedContactFromBase) { //здесь один контакт
//      +         addedGroupsAfter = c.getGroups();
//      +         Boolean groupIsRemoved = true;
//      +         for (GroupData g : addedGroupsAfter) {
//        +            if (g.getName().equals(groupToRemove.getName())) { //потому что при добавлении в web-интерфейсе группа выбирается ПО ИМЕНИ!!!!
//          +               groupIsRemoved = false;
//          +               break;
//          +            }
//        +         }
//      +         Assert.assertTrue(groupIsRemoved);
//      +
//              +      }
//    +
//
}
