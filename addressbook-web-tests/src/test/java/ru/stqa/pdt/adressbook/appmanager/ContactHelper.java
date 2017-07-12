package ru.stqa.pdt.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pdt.adressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lena on 24/06/2017.
 */
public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("middlename"), contactData.getMiddleName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getPhone());
    type(By.name("email"), contactData.getEmail());
    type(By.name("notes"), contactData.getNotes());
    if (creation){
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void confirmContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void deleteSelectedContacts() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void selectFirstContact() {
    click(By.name("selected[]"));
  }

  public void initContactModification() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));

  }

  public void confirmContactModification() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }

  public void confirmAlertContactDeletion(){

    wd.switchTo().alert().accept();

  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public void createContact(ContactData contact, boolean b) {
    initContactCreation();
    fillContactForm(contact, true);
    confirmContactCreation();
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public void selectContactForModify(int index) {
    wd.findElements(By.xpath(".//td[8]")).get(index).click();
  }
  public void selectContactCheckBox(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public List<ContactData> getContactList() {
List<ContactData> contacts = new ArrayList<ContactData>();
List<WebElement> elements = wd.findElements(By.name("entry"));
for (WebElement element: elements){
  int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
  String lastName = element.findElement(By.xpath(".//td[2]")).getText();
  String firstName = element.findElement(By.xpath(".//td[3]")).getText();
  ContactData contact = new ContactData(id, firstName, null, lastName, null, null, null, null, null);
  contacts.add(contact);
}
return contacts;
  }
}
