package Test.Holiday;

import java.util.*;
import java.util.concurrent.TimeUnit;

//import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HolidayTest {
	@Test
	public void H1() {
	System.setProperty("webdriver.chrome.driver","C:\\TCB\\chromedriver_win32\\chromedriver.exe");
    WebDriver driver=new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.get("https://jam.sasken.com/");
    driver.findElement(By.xpath("//span[contains(text(),'Myapps')]")).click();
    driver.findElement(By.xpath("//a[contains(text(),'Holiday list')]")).click();
    String url = driver. getCurrentUrl();
    System.out.println(driver.getWindowHandles().size());
    System.out.println(url);
    
    java.util.Set<String> windowIds=driver.getWindowHandles();
    Iterator<String> Iterator=((java.util.Set<String>) windowIds).iterator();
    List<String>windex=new ArrayList<String>();
    while(Iterator.hasNext()) {
    	windex.add(Iterator.next());
    }
    
    driver.switchTo().window(windex.get(1));
    String url1 = driver. getCurrentUrl();
    System.out.println(url1);
    driver.findElement(By.linkText("Holiday List 2022")).click();
    String str=driver.findElement(By.xpath("//strong[contains(text(),'BANGALORE')]")).getText();
    System.out.println(str);
    List<String> al=new ArrayList<String>();
    int i=3;
   // if(str=="BANGALORE") {
    while(i<=7){
           al.add(driver.findElement(By.xpath("//tbody/tr["+i+"]/td[2]/font[1]")).getText());
//           al.add(driver.findElement(By.xpath("//tbody/tr[4]/td[2]/font[1]")).getText());
//           al.add(driver.findElement(By.xpath("//tbody/tr[5]/td[2]/font[1]")).getText());
           i++;
        }
 
    System.out.println(al);
//    for(int j =0; j < al.size(); j++) {
//        if (al.contains(al.get(j))) {
//            System.out.println(al.get(j)+" is duplicated");
//        }
//   }
    
    HashSet<String> s = new HashSet<String>();

    for(String al1 : al) {
        if(s.add(al1) == false)
            System.out.println(al1 + " has maximum holidays");
    }

}
}