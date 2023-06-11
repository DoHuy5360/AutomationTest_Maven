package org.example.selenium.setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chromium.ChromiumOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;


import java.util.function.Consumer;

public class Browser{

    static ChromiumOptions<?> options;
    static WebDriver driver;
    static MutableCapabilities mutableCapabilities = new MutableCapabilities();

    public void execute(Consumer<WebDriver> callback){
        callback.accept(driver);
    }
    public Browser useEdge(){
        WebDriverManager webDriverManager = WebDriverManager.edgedriver();
        webDriverManager.setup();

        options = new EdgeOptions();

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
        mutableCapabilities.setCapability("user_experience_metrics", false);

        options.merge(mutableCapabilities);

        EdgeOptions edgeOptions = (EdgeOptions) options;

        driver = new EdgeDriver(edgeOptions);

        try {
            Alert alert = driver.switchTo().alert();
            if (alert.getText().contains("Personalize your experience")) {
                alert.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        WebDriver driver = new ChromeDriver(options);

        return this;

    }

}