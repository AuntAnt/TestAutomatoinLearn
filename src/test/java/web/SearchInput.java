package web;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import web.steps.UiBaseTest;

@Test(description = "Поиск по введенному значению")
public class SearchInput extends UiBaseTest {

    @Parameters({"URL"})
    @Test
    public void inputFindTest(String URL) throws InterruptedException {
        DRIVER.get(URL);
        DRIVER.manage().window().fullscreen();

        WebElement element = DRIVER.findElement(By.xpath("//input[@name='keywords']"));

        element.sendKeys("Одни из нас", Keys.ENTER);

        Thread.sleep(5000);
        DRIVER.close();
    }
}
