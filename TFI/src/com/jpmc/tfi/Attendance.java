package com.jpmc.tfi;

public class Attendance {
private String sid;
private String name;
private Boolean isPresent;

public Attendance(String sid, String name) {
    this.sid = sid;
    this.name = name;
    isPresent = false;
  }

public String getSID() {
    return sid;
  }

public String getName() {
    return name;
  }

  public boolean getAttendance() {
    return isPresent;
  }

  public void setAttendance(boolean isPresent) {
    this.isPresent = isPresent;
  }
  
}
