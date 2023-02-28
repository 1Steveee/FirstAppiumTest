package org.FirstAppiumTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;

import static org.FirstAppiumTest.DriverManager.createAndroidDriver;
import static org.FirstAppiumTest.DriverManager.stopDriver;

public class BaseTest {
    @BeforeClass
    public void testSetup () throws MalformedURLException {
        createAndroidDriver ();
    }

    @AfterClass
    public void tearDown () {
        stopDriver ();
    }
}
