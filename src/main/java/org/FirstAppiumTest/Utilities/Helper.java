package org.FirstAppiumTest.Utilities;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;

public class Helper {

    private final AppiumDriver driver;
    private Dimension size;
    private PointerInput pointerInput;
    private Sequence swipe;
    private int height;
    private int width;

    public Helper(AppiumDriver driver) {
        this.driver = driver;
        this.size = driver.manage().window().getSize();
        this.pointerInput = new PointerInput(PointerInput.Kind.TOUCH, "finger");

    }

    public void swipeFullPage() {

        Point pointOneStart = new Point((size.width / 2),(int) (size.height * 0.8));
        Point pointOneEnd = new Point((size.width / 2),(int) (size.height * 0.2));

        Sequence swipe = new Sequence(pointerInput, 0);
        swipe(swipe, pointOneStart,pointOneEnd);
    }

    public void swipeHalfPage() {

        Point pointOneStart = new Point((size.width / 2), (int) (size.height * 0.8));
        Point pointOneEnd = new Point((size.width / 2), (int) (size.height * 0.4));

        Sequence swipe = new Sequence(pointerInput, 0);
        swipe(swipe, pointOneStart,pointOneEnd);
    }


    public void swipeLeft()  {
        Point pointOneStart = new Point((int)(size.width * .8), (size.height / 2));
        Point pointOneEnd = new Point((int)(size.width * .2), (size.height / 2));

        Sequence swipe = new Sequence(pointerInput, 0);
        swipe(swipe, pointOneStart,pointOneEnd);
    }

    private void swipe(Sequence swipe,Point pointOneStart, Point pointOneEnd) {
        swipe.addAction(pointerInput
                .createPointerMove(Duration.ofMillis(0),PointerInput.Origin.viewport(),pointOneStart.x,pointOneStart.y));
        swipe.addAction(pointerInput.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(pointerInput
                .createPointerMove(Duration.ofMillis(700),PointerInput.Origin.viewport(),pointOneEnd.x,pointOneEnd.y));
        swipe.addAction(pointerInput.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(swipe));
    }
}
