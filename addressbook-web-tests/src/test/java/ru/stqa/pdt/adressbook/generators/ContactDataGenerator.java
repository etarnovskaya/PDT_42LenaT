package ru.stqa.pdt.adressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pdt.adressbook.model.ContactData;
import ru.stqa.pdt.adressbook.model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {
  @Parameter(names = "-c", description = "ContactCount")
  public int count;

  @Parameter (names = "-f", description = "TargetFile")
  public String file;

  @Parameter (names = "-d", description = "DataFormat")
  public String format;

  public static void main(String[] args) throws IOException {
    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    } catch (ParameterException ex){
    jCommander.usage();
    return;
  }
  generator.run();


    int count = Integer.parseInt(args[1]);
    File file = new File(args[3]);
  }

  private void run() throws IOException {
    List<ContactData> contacts = generateContacts(count);
    if (format.equals("csv")) {
      saveAsCSV(contacts, new File(file));
    } else if (format.equals("xml")){
      saveAsXML(contacts, new File(file));
    }
    else{
      System.out.println("Unrecognized file format "+ format);
    }
  }

  private void saveAsXML(List<ContactData> contacts, File file) throws IOException {
    XStream xstream = new XStream();
    xstream.alias("contact", ContactData.class);
    xstream.processAnnotations(ContactData.class);
    String xml = xstream.toXML(contacts);
    Writer writer = new FileWriter(file);
    writer.write(xml);
    writer.close();
  }

  private static void saveAsCSV(List<ContactData> contacts, File file) throws IOException {
    System.out.println(new File(".").getAbsolutePath());
    Writer writer = new FileWriter(file);
       for(ContactData contact : contacts){
         writer.write(String.format("%s, %s\n", contact.getFirstName(), contact.getLastName()));
       }
       writer.close();

  }

  private static List<ContactData> generateContacts(int count) {
    List<ContactData> contacts = new ArrayList<>();
    for(int i=0; i<count;i++){
      contacts.add(new ContactData().withFirstName(String.format("test %s", i))
              .withLastName(String.format("test %s", i)));
    }
    return contacts;
  }
}
