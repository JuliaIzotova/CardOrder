[![Build status](https://ci.appveyor.com/api/projects/status/h973qeoavtq7wbw3/branch/main?svg=true)](https://ci.appveyor.com/project/JuliaIzotova/cardorder/branch/main)

public class CardOrder {
@Test
void shouldSubmitRequest() {
open("http://localhost:9999/");
$("[data-test-id=name] input").setValue("Изотова Юлия");
$("[data-test-id=phone] input").setValue("+79602309950");
$("[data-test-id=agreement]").click();
$("[type=button]").click();
$("[data-test-id=order-success]").shouldHave(exactText(" Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
}