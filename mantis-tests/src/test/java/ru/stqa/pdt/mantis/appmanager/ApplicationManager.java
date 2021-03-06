package ru.stqa.pdt.mantis.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by Lena on 24/06/2017.
 */
public class ApplicationManager {
  private final Properties properties;
  private WebDriver wd;
  private String browser;
  private RegistrationHelper registrationHelper;
  private LogInHelper loginHelper;
  private  NavigationHelper navigationHelper;
  private UserHelper userHelper;
  private MailHelper mailHelper;
  private SOAPHelper soapHelper;


  public ApplicationManager(String browser){
    this.browser = browser;
    properties = new Properties();

  }

  public void init() throws IOException {
    String target = System.getProperty("target", "local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
  }

  public void stop() {
    if(wd != null){
      wd.quit();
    }
  }

  public HttpSession newSession(){
    return new HttpSession(this);}

  public String getProperty(String key) {
    return properties.getProperty(key);
  }

  public RegistrationHelper registration() {
    if(registrationHelper == null){
      registrationHelper = new RegistrationHelper(this);
    } return registrationHelper;
  }

  public MailHelper mail(){
    if(mailHelper == null){
      mailHelper = new MailHelper(this);
    } return mailHelper;
  }

  public NavigationHelper navigate() {
    if(navigationHelper == null){
      navigationHelper = new NavigationHelper(this);
    } return navigationHelper;
  }

  public UserHelper user() {
    if(userHelper == null){
      userHelper = new UserHelper(this);
    } return userHelper;
  }

  public SOAPHelper soap(){
    if( soapHelper == null){
      soapHelper = new SOAPHelper(this);
    }
    return soapHelper;
  }



  public  LogInHelper login(){
    if (loginHelper == null){
      loginHelper = new LogInHelper(this);
    } return  loginHelper;
  }

//  public FtpHelper ftp() {
//    if(ftp == null){
//      ftp = new FtpHelper(this);
//    } return ftp;
//     }

  public WebDriver getDriver() {
    if(wd == null){
      if (browser.equals(BrowserType.FIREFOX)){
        wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true).setBinary("C:/Program Files/Mozilla Firefox ESR/firefox.exe"));
      } else if (browser.equals(BrowserType.CHROME)){
        wd = new ChromeDriver();
      } else if (browser.equals(BrowserType.IE)) {
        wd = new InternetExplorerDriver();
      }
      wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      wd.get(properties.getProperty("web.baseUrl"));
    }
    return wd;
  }




}
