package ru.stqa.pdt.adressbook.model;

public class ContactData {
  private final String firstName;
  private final String middleName;
  private final String lastName;
  private final String address;
  private final String phone;
  private final String email;
  private final String notes;

  public ContactData(String firstName, String middleName, String lastName, String address, String phone, String email, String notes) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.address = address;
    this.phone = phone;
    this.email = email;
    this.notes = notes;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getAddress() {
    return address;
  }

  public String getPhone() {
    return phone;
  }

  public String getEmail() {
    return email;
  }

  public String getNotes() {
    return notes;
  }
}
