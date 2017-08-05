package ru.stqa.pdt.mantis.appmanager;

public class FtpHelper {

  private final ApplicationManager app;
  private FTPClient ftp;

  public FtpHelper(ApplicationManager app) {
    this.app = app;
    ftp = new FTPClient() {
    };
  }

//  public void upload(File file, String target, String backUp){
//    ftp.connect(app.getProperty("ftp.host"));
//    ftp.login(app.getProperty("ftp.login"), app.getProperty("ftp.password"));
//
//
//  }
//


}
