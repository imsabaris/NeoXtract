package com.utilities;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GlobalLibrary {

	public static WebDriver driver;
	public static Actions act;
	public static Robot robot;
	public static Alert alerts;
	public static TakesScreenshot shot;
	public static JavascriptExecutor js;
	public static Select sel;
	public static WebDriverWait driverwait;
	public static FluentWait<WebDriver> fluentwait;

	// l.lunchChrome
	public static void lanuchChrome() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	// 2.lunchFirefox
	public static void lanuchFirefox() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}

	// 3.lunchEdge
	public static void lanuchEdge() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();

	}

	// 4.lunchInternetExplorer
	public static void lanuchchInternetExplorer() {
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
	}

	// 5.lunchOpera
	/*
	 * public static void lanuchOpera() { WebDriverManager.operadriver().setup();
	 * driver = new OperaDriver(); }
	 */

	// 7.get()
	public static void passURL(String url) {
		driver.get(url);
		maxWin();
		WaitImpcitwaitCall(5);
	}

	// 8.Maximize
	public static void maxWin() {
		driver.manage().window().maximize();
	}

	// 9.getCurent url print
	public static void getUrlPrint() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	}

	// 10
	public static String getUrlcall() {
		return driver.getCurrentUrl();
	}

	// 11. Title print
	public static void getTitlePrint() {
		String title = driver.getTitle();
		System.out.println(title);
	}

	// 12.
	public static void getTitlecall() {
		driver.getTitle();

	}

	// 13.getPageSource print
	public static void getsourePrint() {
		String pageSource = driver.getPageSource();
		System.out.println(pageSource);
	}

	// 14.getWindowHandle
	public static void getParentWindowPrint() {
		String windowHandle = driver.getWindowHandle();
		System.out.println(windowHandle);
	}

	// 15.getWindowHandles
	public static void getAllParentWindowsPrint() {
		Set<String> allWindowshandles = driver.getWindowHandles();
		for (String eachId : allWindowshandles) {
			System.out.println(eachId);
		}
	}

	// 16.siwtch Into Window
	public static void siwtchIntoWindow() {
		String parentId = driver.getWindowHandle();

		Set<String> allWindowId = driver.getWindowHandles();

		for (String eachId : allWindowId) {
			if (!parentId.equals(eachId)) {
				driver.switchTo().window(eachId);
			}
		}
	}

	// 17. Switch
	public static TargetLocator switchToany() {
		return driver.switchTo();

	}

	// 18.Navigate to(URL)
	public static void navigateInto(String url) {
		driver.navigate().to(url);
	}

	// 19.Navigate back
	public static void navigateIntoback() {
		driver.navigate().back();
	}

	// 20.Navigate Forword
	public static void navigateIntoRefresh() {
		driver.navigate().refresh();
	}

	// 21. Close Tab
	public static void closeCurrentTab() {
		driver.close();
	}

	// 22. Quit Browser
	public static void quitBrowser() {
		driver.quit();
	}

	// 23. Send Key
	public static void sendKeyCall(WebElement ele, String passValue) {
		ele.sendKeys(passValue);
	}

	// 24. click
	public static void clickbtn(WebElement ele) {
		ele.click();
	}

	// 25. get Text call
	public static String getTextCall(WebElement ele) {
		return ele.getText();
	}

	// 26 get Text print
	public static void getTextPrint(WebElement ele) {
		String text = ele.getText();
		System.out.println(text);
	}

	// 27. Attribute call
	public static String getAttributcall(WebElement ele, String attributeName) throws InterruptedException {
		Thread.sleep(3000);
		return ele.getAttribute(attributeName);
	}

	// 23. Attribute print
	public static void getAttributPrint(WebElement ele, String attributeName) {
		String attribute = ele.getAttribute(attributeName);
		System.out.println(attribute);
	}

	// 24. TagName call
	public static String getTagNameCall(WebElement ele) {
		return ele.getTagName();
	}

	// 25.TagName print
	public static void getTagNamePrint(WebElement ele) {
		System.out.println(ele.getTagName());
	}

	// 26. dropDwoncall
	public static void dropDwoncall(WebElement target) {
		act = new Actions(driver);
		act.moveToElement(target);
	}

	// 27. drag And Drop call
	public static void dragAndDropcall(WebElement Src, WebElement dest) {
		act = new Actions(driver);
		act.dragAndDrop(Src, dest);
	}

	// 28. doublic Click Call
	public static void doublicClickCall() {
		act = new Actions(driver);
		act.doubleClick();
	}

	// 29. Context Click Call
	public static void ContextClickCall() {
		act = new Actions(driver);
		act.contextClick();
	}

	// 30. bulid Perform Call
	public static void bulidPerformCall() {
		act = new Actions(driver);
		act.build().perform();
	}

	// 31. send key by Action class
	public static void SendKeyActionCall(WebElement ele, String value) {
		act = new Actions(driver);
		act.sendKeys(ele, value);
	}

	// 32. click by Action class
	public static void clickActionCall() {
		act = new Actions(driver);
		act.click();
	}

	// 33. clickAndHold by Action Class
	public static void clickAndHoldActionCall() {
		act = new Actions(driver);
		act.clickAndHold();
	}

	// 34. keyDown And keyUp Shift call
	public static void keyDownAndUpShiftcall(WebElement ele, String value) {
		act = new Actions(driver);
		act.keyDown(Keys.SHIFT).sendKeys(ele, value).keyUp(Keys.SHIFT).build().perform();
	}

	// 35. keyDown nAnd keyUp Tab call
	public static void keyDownAndUpTabcall() {
		act = new Actions(driver);
		act.keyDown(Keys.TAB).keyUp(Keys.TAB).build().perform();
	}

	// 36. Robot by ENTER
	public static void robotENTERCall() throws AWTException {
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	// 37 Robot by TAB
	public static void robotTABCall() throws AWTException {
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
	}

	// 38 Robot by CONTROL + V (COPY)
	public static void robotCOPYCall() throws AWTException, InterruptedException {
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_C);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_C);
	}

	// 39 Robot by CONTROL + X(CUT)
	public static void robotCUTCall() throws AWTException {
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_X);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_X);
	}

	// 40. Robot by CONTROL + X(PASTE)
	public static void robotPASTECall() throws AWTException {
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
	}

	// 41. Robot by SHIFT
	public static void robotSHIFTCall() throws AWTException {
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyRelease(KeyEvent.VK_SHIFT);
	}

	// 42. Robot by Delay
	public static void robotDelayCall(int time) throws AWTException {
		robot = new Robot();
		robot.delay(time);
	}

	public static void robotDown() throws AWTException {
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
	}

	public static void robotUp() throws AWTException {
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_UP);
		robot.keyRelease(KeyEvent.VK_UP);
	}

	// 43. Robot by Mouse Right click
	public static void robotMouseRightClickCall() throws AWTException {
		robot = new Robot();
		robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);

	}

	// 44. Robot by Mouse Scroll click
	public static void robotMouseScrollClickCall() throws AWTException {
		robot = new Robot();
		robot.mousePress(InputEvent.BUTTON2_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON2_DOWN_MASK);

	}

	// 45. Robot by Mouse Left click
	public static void robotMouseLeftClickCall() throws AWTException {
		robot = new Robot();
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

	}

	// 46. Robot by Mouse Move
	public static void robotMouseMoveCall(int x, int y) throws AWTException {
		robot = new Robot();
		robot.mouseMove(x, y);
	}

	// 47. Alert by accept
	public static void alertAcceptCall() {

		alerts = driver.switchTo().alert();
		alerts.accept();
	}

	// 48. Alert by Dismiss
	public static void alertDismissCall() {

		alerts = driver.switchTo().alert();
		alerts.dismiss();
	}

	// 49. Alert by Send Key
	public static void alertSendKeyCall(String vlaue) {

		alerts = driver.switchTo().alert();
		alerts.sendKeys(vlaue);
	}

	// 50 Alert by Send Key
	public static void alertGetTextPrint(String vlaue) {

		alerts = driver.switchTo().alert();
		String text = alerts.getText();
		System.out.println(text);
	}

	// 51. frame by ID and name
	public static void frameIdAndNameCall(String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}

	// 52. frame by WebElement
	public static void frameWebElementCall(WebElement ele) {
		driver.switchTo().frame(ele);
	}

	// 53. frame by Index
	public static void frameIndexCall(int index) {
		driver.switchTo().frame(index);
	}

	// 54. frame by Parent Frame
	public static void frameParentCall() {
		driver.switchTo().parentFrame();
	}

	// 55. frame by main html
	public static void frameMainHtmlCall() {
		driver.switchTo().defaultContent();
	}

	// 56. TakeScreenShot
	public static void takeScreenshotFullCall(String fileName) throws IOException {
		String currentDirectory = System.getProperty("user.dir");
		shot = (TakesScreenshot) driver;
		File src = shot.getScreenshotAs(OutputType.FILE);
		File dest = new File(currentDirectory + "\\src\\test\\resources\\Screenshot\\" + fileName + ".jpg");
		FileUtils.copyFile(src, dest);
	}

	// 57. java Script Excutor by Send Key
	public static void javaScriptExecutorSendKeycall(String attributeName, String SendValue, WebElement ele) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('" + attributeName + "','" + SendValue + "')", ele);
	}

	// 58. java Script Excutor by return
	public static void javaScriptExecutorReturnPrint(String attributeName, WebElement ele) {
		js = (JavascriptExecutor) driver;
		Object executeScript = js.executeScript("return arguments[0].getAttribute('" + attributeName + "')", ele);
		String text = executeScript.toString();
		System.out.println(attributeName + " :" + text);
	}

	// 59. java Script Excutor by Click
	public static void javaScriptExecutorClickcall(WebElement ele) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click ()", ele);
	}

	// 60. java Script Excutor by Scroll top view
	public static void javaScriptExecutorScrollTopcall(WebElement ele) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", ele);
	}

	// 61. java Script Excutor by Scroll Bottom view
	public static void javaScriptExecutorScrollBottomcall(WebElement ele) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", ele);
	}

	// 62. java Script Excutor by Send Key
	public static void javaScriptExecutorHighLightWebElementcall(String backgoungColour, int pixel, String broderColour,
			WebElement ele) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style','background:" + backgoungColour + "; border:" + pixel
				+ "px " + broderColour + ";');", ele);
	}

	// 63. DropDown by Select Visible text
	public static void dropDownVisibleTextCall(WebElement ele, String attributeText) throws InterruptedException {
		sel = new Select(ele);
		Thread.sleep(1000);
		sel.selectByVisibleText(attributeText);
	}

	// 64. DropDown by Select Value
	public static void dropDownValueTextCall(WebElement ele, String attributeValue) {
		sel = new Select(ele);
		sel.selectByValue(attributeValue);
	}

	// 65. DropDown by Select Index
	public static void dropDownIndexCall(WebElement ele, int index) {
		sel = new Select(ele);
		sel.selectByIndex(index);
	}

	// 66. DropDown by deSelect Visiable text
	public static void dropDownDeselectVisiableTextCall(WebElement ele, String attributeText) {
		sel = new Select(ele);
		sel.deselectByVisibleText(attributeText);
	}

	// 67. DropDown by DeSelect Value
	public static void dropDownDeselectValueTextCall(WebElement ele, String attributeValue) {
		sel = new Select(ele);
		sel.deselectByValue(attributeValue);
	}

	// 68. DropDown by DeSelect Index
	public static void dropDownDeselectIndexCall(WebElement ele, int index) {
		sel = new Select(ele);
		sel.deselectByIndex(index);
	}

	// 69. DropDown by Multiple Select
	public static void dropDownMultipleSelectPrint(WebElement ele) {
		sel = new Select(ele);
		if (sel.isMultiple()) {
			System.out.println("The DropDown is Multiple Select Options");
		} else {
			System.out.println("The DropDown is NOT Multiple Select Options");
		}
	}

	// 70. DropDown by get Options
	public static void dropDownGetOptionPrint(WebElement ele) {
		sel = new Select(ele);
		List<WebElement> options = sel.getOptions();
		System.out.println("Number of Options :" + options.size());
		for (int i = 0; i < options.size(); i++) {
			String text = options.get(i).toString();
			System.out.println(text);
		}
	}

	// 71. DropDown by get all selected Options
	public static void dropDownGetALLSelectedOptionPrint(WebElement ele) {
		sel = new Select(ele);
		List<WebElement> options = sel.getAllSelectedOptions();
		System.out.println("Number of Options :" + options.size());
		for (int i = 0; i < options.size(); i++) {
			String text = options.get(i).toString();
			System.out.println(text);
		}
	}

	// 72. DropDown by get First select Options
	public static void dropDownGetFirstSelectedOptionPrint(WebElement ele) {
		sel = new Select(ele);
		WebElement firstSelectedOption = sel.getFirstSelectedOption();
		System.out.println(firstSelectedOption.getText());
	}

	// 73. DropDown by get all Deselected Options
	public static void dropDownGetALLDeSelectedOptionCall(WebElement ele) {
		sel = new Select(ele);
		sel.deselectAll();
	}

	// 74. Wait by Implict wait
	public static void WaitImpcitwaitCall(int sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}

	// 75. Wait by Explicit wait-----Webdriver Wait
	public static void WaitWebDriverCall(Duration sec) {
		driverwait = new WebDriverWait(driver, sec);

	}

	// 76. Wait by Explicit wait-----Fluent Wait
	public static FluentWait<WebDriver> WaitFluentCall(int sec, int eachSec, String message) {
		return fluentwait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(sec))
				.pollingEvery(Duration.ofSeconds(eachSec)).withMessage(message).ignoring(Throwable.class);
	}

	// 77. Wait by Explicit wait-----Fluent Wait
	public static void elementToBeClickable(int sec, int eachSec, WebElement element, String message) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(sec))
				.pollingEvery(Duration.ofSeconds(eachSec)).withMessage(message).ignoring(Exception.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// 78. Wait by Explicit wait-----Fluent Wait
	public static void visibilityOf(int sec, int eachSec, WebElement element, String message) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(sec))
				.pollingEvery(Duration.ofSeconds(eachSec)).withMessage(message).ignoring(Exception.class);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// 79. Wait by Explicit wait-----Fluent Wait
	public static void invisibilityOf(int sec, int eachSec, WebElement element, String message) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(sec))
				.pollingEvery(Duration.ofSeconds(eachSec)).withMessage(message).ignoring(Exception.class);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	// 80. Wait by Explicit wait-----Fluent Wait
	public static void invisibilityOfElementLocated(int sec, int eachSec, String message) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(sec))
				.pollingEvery(Duration.ofSeconds(eachSec)).withMessage(message).ignoring(Exception.class);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(message)));
	}

	// 80. Wait by Explicit wait-----Fluent Wait
	public static void presenceOfElementLocated(int sec, int eachSec, String message) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(sec))
				.pollingEvery(Duration.ofSeconds(eachSec)).withMessage(message).ignoring(Exception.class);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(message)));
	}

	// 81. Wait by Explicit wait-----Fluent Wait
	public static Boolean elementIsEnabled(WebElement element) {
		Boolean elementStatus = element.isEnabled();
		return elementStatus;
	}

	// 82. Wait by Explicit wait-----Fluent Wait
	public static void clear(WebElement element) {
		element.clear();
	}

	// 83. to Handle Dynamic xpaths in step definition
	public static WebElement customXpath(String string) {
		return driver.findElement(By.xpath(string));
	}

	// 84. Wait by Explicit wait-----Fluent Wait
	public static Boolean isPresent(WebElement element) {
		return element.isEnabled();

	}

	// 85. Robot by CONTROL ARROW
	public static void robotCONTROLRIGHTCall() throws AWTException {
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_RIGHT);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_RIGHT);
	}

	// 86. Robot by CONTROL ARROW
	public static void robotCONTROLLEFTCall() throws AWTException {
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_LEFT);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_LEFT);
	}

//87. Robot by CONTROL ARROW
	public static void robotUPCall() throws AWTException {
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_UP);
		robot.keyRelease(KeyEvent.VK_UP);
	}

	// 88. Robot by CONTROL ARROW
	public static void robotDOWNCall() throws AWTException {
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
	}

	// 89. Robot by CONTROL ARROW
	public static void robotALTNCall() throws AWTException {
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_ALT);
		robot.keyPress(KeyEvent.VK_N);
		robot.keyRelease(KeyEvent.VK_ALT);
		robot.keyRelease(KeyEvent.VK_N);
	}

	// 90. Robot by CONTROL ARROW
	public static void robotCONTROLUPCall() throws AWTException {
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_UP);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_UP);
	}

	// 90. Robot by CONTROL ARROW
	public static void robotCONTROLDOWNCall() throws AWTException {
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_DOWN);
	}

	// 91. Robot by CONTROL ARROW
	public static void robotCONTROLSPACECall() throws AWTException {
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_SPACE);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_SPACE);
	}

	// 92. Robot by CONTROL ARROW
	public static void robotCONTROLBACKSPACECall() throws AWTException {
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_BACK_SPACE);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_BACK_SPACE);
	}
	
	// 92. Robot by CONTROL ARROW
		public static void robotCONTROLMCall() throws AWTException {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_M);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_M);
		}

}
