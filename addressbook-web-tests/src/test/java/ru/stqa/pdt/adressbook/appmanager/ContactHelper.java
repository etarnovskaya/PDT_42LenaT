package ru.stqa.pdt.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pdt.adressbook.model.ContactData;

/**
 * Created by Lena on 24/06/2017.
 */
public class ContactHelper extends HelperBase {

  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("middlename"), contactData.getMiddleName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getPhone());
    type(By.name("email"), contactData.getEmail());
    type(By.name("notes"), contactData.getNotes());
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
    click(By.id("1"));
  }

  public void initContactModification() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));

  }

  public void confirmContactModification() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }
}
