package org.example.selenium;

import org.example.selenium.utils.PrintColor;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.util.function.Consumer;

public class TestAction {

    public WebDriver driver;
    public Properties properties;
    public String webUrl;

    public TestAction(WebDriver driver, String webUrl, Properties properties){
        this.driver = driver;
        this.webUrl = webUrl;
        this.properties = properties;
    }
    public TestAction(WebDriver driver, String webUrl){
        this.driver = driver;
        this.webUrl = webUrl;
    }
    public TestAction get(String webUrl){
        this.driver.get(webUrl);
        return this;
    }
    public void quit(){
        this.driver.quit();
    }
    public TestAction pause(long millisecond) {
        try {
            Thread.sleep(millisecond);
        }catch (InterruptedException e){
            System.out.printf("Something went wrong when involve pause(%d)%n", millisecond);
            e.printStackTrace();
        }
        return this;
    }
    public WebElement checkExisting(String path){
        try {
            WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
        }catch (NoSuchElementException e){
            PrintColor.yellow(String.format("Could not find %s", path));
        }
        return null;
    }
    public TestAction sendKeys(String path, String value) {
        checkExisting(path).sendKeys(value);
        return this;
    }
    public TestAction click(String path){
        checkExisting(path).click();
        return this;
    }

    public TestAction getText(String path, Consumer<String> callback){
        callback.accept(checkExisting(path).getText());
        return this;
    }

    public TestAction clear(String path) {
        checkExisting(path).clear();
        return this;
    }
    public TestAction saveFile(String fileName, String xPath, String destPath)  {
        try {
            // Tìm đối tượng WebElement tương ứng với nút tải về hoặc link tải về
            WebElement downloadLink = driver.findElement(By.xpath(xPath));

            // Lấy đường dẫn file cần tải về
            String fileUrlA = downloadLink.getAttribute("href");

//            Path path = Paths.get(fileUrlA);
//            String fileName = path.getFileName().toString();

            // Tạo đối tượng URL từ đường dẫn file
            URL url = new URL(fileUrlA);
            InputStream inputStream = url.openStream();

            // Lưu file vào thư mục mong muốn
            FileOutputStream outputStream = new FileOutputStream(destPath + fileName);

            byte[] buffer = new byte[2048];
            int length = 0;
            while ((length = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, length);
            }

            outputStream.close();
            inputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return this;
    }

    public TestAction scrollTo(String xPath) {
        // Thực hiện scroll đến cuối trang web
        JavascriptExecutor js = (JavascriptExecutor) this.driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        // Thực hiện scroll đến vị trí cụ thể trên trang web
        WebElement element = checkExisting(xPath);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        return this;
    }

    public TestAction highlight(String xPath) {
        // Tìm đối tượng element
        WebElement element = checkExisting(xPath);

        // Thực thi mã JavaScript để thay đổi thuộc tính CSS
        JavascriptExecutor js = (JavascriptExecutor) this.driver;
        js.executeScript("arguments[0].style.transition = '1000ms linear'", element);
        js.executeScript("arguments[0].style.outline = '2px red dashed'", element);
        return this;
    }
    public TestAction addCSS(String xPath, String attr, String val) {
        // Tìm đối tượng element
        WebElement element = checkExisting(xPath);

        // Thực thi mã JavaScript để thay đổi thuộc tính CSS
        JavascriptExecutor js = (JavascriptExecutor) this.driver;
        js.executeScript(String.format("arguments[0].style.%s = '%s'", attr,val), element);
        return this;
    }
}