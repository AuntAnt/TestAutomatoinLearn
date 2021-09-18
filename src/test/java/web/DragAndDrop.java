package web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import web.steps.UiBaseTest;

import java.time.Duration;

@Test(description = "Драг-н-дроп тест")
public class DragAndDrop extends UiBaseTest {

    @Test
    public static void main(String[] args) throws InterruptedException {

        try {
            DRIVER.get("https://crossbrowsertesting.github.io/drag-and-drop");
            DRIVER.manage().window().fullscreen();
            Thread.sleep(2000);

            WebElement draggable = DRIVER.findElement(By.id("draggable"));
            WebElement droppable = DRIVER.findElement(By.id("droppable"));

            Actions actions = new Actions(DRIVER);

            actions.clickAndHold(draggable)
                    .pause(Duration.ofSeconds(1))
                    .moveToElement(droppable)
                    .release()
                    .build()
                    .perform();

            //существующий метод
//            actions.dragAndDrop(draggable, droppable);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(5000);
            DRIVER.close();
        }
    }

}
