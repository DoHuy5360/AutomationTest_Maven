package org.example;

import org.example.project.Page;

public class Main {
    public static void main(String[] args) {
        Page page = new Page();
        page.accessWebPage();
        page.login();
        page.accessMyinfoPage();
        page.fillNames();
    }

}