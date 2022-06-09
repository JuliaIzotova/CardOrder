package ru.netology;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class CardOrder {
    @Test
    void shouldSubmitRequest() {
        open("http://0.0.0.0:7777/");
        $("[data-test-id=name] input").setValue("Изотова Юлия");
        $("[data-test-id=phone] input").setValue("+79602309950");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $("[data-test-id=order-success]").shouldHave(exactText(" Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    void checkWhenInvalidName() {
        open("http://0.0.0.0:7777/");
        $("[data-test-id=name] input").setValue("Izotova Yulia");
        $("[data-test-id=phone] input").setValue("+79602309950");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $("[data-test-id=name].input_invalid .input__sub").shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    void checkWhenInvalidTel() {
        open("http://0.0.0.0:7777/");
        $("[data-test-id=name] input").setValue("Изотова Юлия");
        $("[data-test-id=phone] input").setValue("+796023099");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $("[data-test-id=phone].input_invalid .input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    void checkWhenFieldsEmpty() {
        open("http://0.0.0.0:7777/");
        $("[data-test-id=name] input").setValue("");
        $("[data-test-id=phone] input").setValue("");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $("[data-test-id=name].input_invalid .input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
    }
}










