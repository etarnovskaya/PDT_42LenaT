package ru.stqa.pdt.adressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias("group")
public class GroupData {
  @XStreamOmitField
  private int id = Integer.MAX_VALUE;
  @Expose
  private String groupName;
  @Expose
  private String header;
  @Expose
  private String footer;

  public GroupData withId(int id) {
    this.id = id;
    return this;
  }

  public GroupData withName(String groupName) {
    this.groupName = groupName;
    return this;

  }

  public GroupData withHeader(String header) {
    this.header = header;
    return this;

  }

  public GroupData withFooter(String footer) {
    this.footer = footer;
    return this;

  }

  public int getId() {
    return id;
  }

  public String getGroupName() {
    return groupName;
  }

  public String getHeader() {
    return header;
  }

  public String getFooter() {
    return footer;
  }



  @Override
  public String toString() {

    return "GroupData{" +

            "id='" + id + '\'' +
            ", groupName='" + groupName + '\'' +
            '}';
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    GroupData groupData = (GroupData) o;

    if (id != groupData.id) return false;
    return groupName != null ? groupName.equals(groupData.groupName) : groupData.groupName == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
    return result;
  }
}
