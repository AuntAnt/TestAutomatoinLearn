package web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import web.steps.UiBaseTest;

import java.time.Duration;
import java.util.List;

@Test(description = "Тест на ожидание")
public class Wait extends UiBaseTest {

    @Test
    public void waitTest() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(DRIVER, Duration.ofSeconds(10));

        try {
            DRIVER.get("https://pagination.js.org");
            Thread.sleep(2000);

            List<WebElement> elements = DRIVER.findElements(By.xpath("//div[@class='data-container']/ul/li"));
            List<WebElement> pages = DRIVER.findElements(By.xpath("//div[@class='paginationjs-pages']/ul/li"));

            String text = elements.get(5).getText();
            System.out.println(text);

            pages.get(2).click();
            wait.until(ExpectedConditions.stalenessOf(elements.get(5)));
            elements = DRIVER.findElements(By.xpath("//div[@class='data-container']/ul/li"));

            text = elements.get(5).getText();
            System.out.println(text);

            Assert.assertEquals(text, "16");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(5000);
            DRIVER.close();
        }
    }
}
