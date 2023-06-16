package org.example.selenium.setup;

import com.google.common.collect.ImmutableMap;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


import java.util.HashMap;
import java.util.function.Consumer;

public class Driver {
    static WebDriver driver;
    static MutableCapabilities mutableCapabilities = new MutableCapabilities();
    public void execute(Consumer<WebDriver> callback){
        callback.accept(driver);
    }
    public Driver useEdge(){
        WebDriverManager webDriverManager = WebDriverManager.edgedriver();
        webDriverManager.setup();

        EdgeOptions options = new EdgeOptions();

        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
//        options.addArguments("--ignore-certificate-errors");
//        options.setAcceptInsecureCerts(true);
//        options.setHeadless(true);

        // Tác dụng: Tùy chọn này cho phép bạn cấu hình cách xử lý các thông báo (alert) không được xử lý bởi trình duyệt.
        // Nếu giá trị được thiết lập là "ignore", các thông báo không được xử lý sẽ bị bỏ qua.
        options.setCapability("unhandledPromptBehavior", "ignore");

        // Tác dụng: Tùy chọn này cho phép bạn tắt các thông báo mặc định của trình duyệt Edge,
        // bao gồm cả thông báo về kết nối mạng, cập nhật trình duyệt, v.v.
        options.setCapability("ms:suppressesInitialDiagnosticInformation", true);

        // Tác dụng: Tùy chọn này cho phép bạn tắt thu thập các số liệu về trải nghiệm người dùng (user experience metrics) của trang web.
        // Các số liệu này bao gồm thời gian tải trang, thời gian phản hồi của máy chủ, v.v.
        options.setCapability("ms:edgeOptions", ImmutableMap.of("prefs", ImmutableMap.of("download.default_directory", "D:\\Java\\intellij\\mavenProject")));
        options.setCapability("ms:edgeChromium", false);

        options.setCapability("ms:inPrivate", true);
//        String downloadPath = "D:\\Java\\intellij\\mavenProject\\src\\main\\java\\org\\example\\selenium\\projects\\files";

        options.merge(mutableCapabilities);

        driver = new EdgeDriver(options);
        System.out.println(options);
        System.out.println(System.getProperty("user.dir"));

        return this;

    }
    public Driver useFirefox(){
        String downloadPath = "D:/Java/intellij/mavenProject/src/main/java/org/example/selenium/projects/files";
        WebDriverManager webDriverManager = WebDriverManager.firefoxdriver();
        webDriverManager.setup();

        FirefoxOptions options = new FirefoxOptions();

        options.addPreference("browser.startup.page", "maximized");
        options.addPreference("dom.webnotifications.enabled", false);

        // Thiết lập cấu hình tải xuống
        options.addPreference("browser.download.folderList", 2);
        options.addPreference("browser.download.dir", downloadPath);
        options.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");

        // Khởi tạo trình duyệt Firefox với các tùy chọn đã thiết lập
        driver = new FirefoxDriver(options);

        return this;
    }
    public WebDriver useChrome() {
        String downloadPath  = "D:\\Java\\intellij\\mavenProject\\src\\main\\java\\org\\example\\selenium\\projects\\files";

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);

        chromePrefs.put("download.default_directory", downloadPath);

        options.setExperimentalOption("prefs", chromePrefs);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        return driver;
    }


}