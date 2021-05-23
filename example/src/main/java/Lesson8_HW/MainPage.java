package Lesson8_HW;

import Lesson8.NavigationMenu;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    public NavigationMenu navigationMenu;

    public MainPage() {
        this.navigationMenu = new NavigationMenu();
    }

    private SelenideElement geekBrainsHomeButton = $(By.xpath("//a[@title='Geekbrains']"));
}
