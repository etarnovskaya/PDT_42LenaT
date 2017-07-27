package ru.stqa.pdt.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pdt.adressbook.model.ContactData;
import ru.stqa.pdt.adressbook.model.Contacts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("mobile"), contactData.getMobilePhone());
    type(By.name("work"), contactData.getWorkPhone());
    type(By.name("email"), contactData.getEmail());
    type(By.name("notes"), contactData.getNotes());


    if(contactData.getGroup() != null){
    if (creation){
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));

    }
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

  public void create(ContactData contact, boolean b) {
    initContactCreation();
    fillContactForm(contact, true);
    confirmContactCreation();
  }

  public void create(ContactData contact) {
    initContactCreation();
    fillContactForm(contact, true);
    confirmContactCreation();
    contactCache= null;
  }


  public void delete(ContactData contact) {
    selectContactCheckBoxById(contact.getId());
    deleteSelectedContacts();
    confirmAlertContactDeletion();
    contactCache= null;
    returnToHomePage();
  }

  public void modify(ContactData contact) {
    selectContactForModifyById(contact.getId());
    fillContactForm(contact, false);
    confirmContactModification();
    contactCache= null;

  }

  private void selectContactForModifyById(int id) {
    wd.findElement(By.xpath("//a[@href='edit.php?id="+id+"']")).click();
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public void selectContactForModify(int index) {
    wd.findElements(By.xpath(".//td[8]")).get(index).click();
  }
  public void selectContactCheckBox(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }
  public void selectContactCheckBoxById(int id) {
    wd.findElement(By.cssSelector("input[value='"+ id+"']")).click();
  }

  public List<ContactData> list() {
List<ContactData> contacts = new ArrayList<ContactData>();
List<WebElement> elements = wd.findElements(By.name("entry"));
for (WebElement element: elements){
  int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
  String lastName = element.findElement(By.xpath(".//td[2]")).getText();
  String firstName = element.findElement(By.xpath(".//td[3]")).getText();
  contacts.add(new ContactData().withId(id).withFirstName(firstName).withLastName(lastName));
}
return contacts;
  }

  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache!= null){
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement row: rows){
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String lastName = cells.get(1).getText();
      String firstName = cells.get(2).getText();
      String allPhones = cells.get(5).getText();
      String allEmails = cells.get(4).getText();
      String address = cells.get(3).getText();
      contactCache.add(new ContactData().withId(id).withFirstName(firstName).withLastName(lastName)
              .withAllPhones(allPhones). withAddress(address). withAllEmails(allEmails));
    }
    return new Contacts(contactCache);
  }

  public void returnToHomePage() {
    click(By.xpath("html/body/div/div[3]/ul/li[1]/a"));
  }


  public ContactData infoFromEditForm(ContactData contact) {
    selectContactForModifyById(contact.getId());
    String lastName = wd.findElement(By.name("lastname")).getAttribute("value");
    String firstName = wd.findElement(By.name("firstname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");

    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstName(firstName).withLastName(lastName)
            .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work)
            .withEmail(email).withEmail2(email2).withEmail3(email3).withAddress(address);

  }


}
