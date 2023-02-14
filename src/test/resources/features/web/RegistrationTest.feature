#language:ru
Функционал: Регистрация.

  Сценарий: Проверяется правильность работы
  системы регистрации клиентов.

    * перейти по адресу "site.url" из конфига "config.properties"
    * инициализация страницы "BasePage"
    * на странице имеется элемент "ссылка 'Sign In'"
    * кликнуть на элемент "ссылка 'Sign In'"
    * на странице имеется элемент "ссылка 'Register Now!'"
    * кликнуть на элемент "ссылка 'Register Now!'"
    * ввести в поле "поле 'User ID:'" значение "username" из конфига "user.properties"
    * ввести в поле "поле 'New password:'" значение "password" из конфига "user.properties"
    * ввести в поле "поле 'Repeat password:'" значение "password" из конфига "user.properties"
    * ввести в поле "поле 'First name:'" значение "firstname" из конфига "user.properties"
    * ввести в поле "поле 'Last name:'" значение "lastname" из конфига "user.properties"
    * ввести в поле "поле 'Email:'" значение "email" из конфига "user.properties"
    * ввести в поле "поле 'Phone:'" значение "phone" из конфига "user.properties"
    * ввести в поле "поле 'Address 1:'" значение "address1" из конфига "user.properties"
    * ввести в поле "поле 'Address 2:'" значение "address2" из конфига "user.properties"
    * ввести в поле "поле 'City:'" значение "city" из конфига "user.properties"
    * ввести в поле "поле 'State:'" значение "state" из конфига "user.properties"
    * ввести в поле "поле 'Zip:'" значение "zip" из конфига "user.properties"
    * ввести в поле "поле 'Country:'" значение "country" из конфига "user.properties"
    * в выпадающем списке "выпадающий список 'Language Preference:'" выбрать опцию "english"
    * в выпадающем списке "выпадающий список 'Favourite Category:'" выбрать опцию "CATS"
    * активировать чекбокс на элементе "чекбокс 'Enable MyList'"
    * активировать чекбокс на элементе "чекбокс 'Enable MyBanner'"
    * кликнуть на элемент "кнопка 'Save Account Information'"
    * кликнуть на элемент "ссылка 'Sign In'"
    * ввести в поле "поле 'username'" значение "username" из конфига "user.properties"
    * очистить поле "поле 'password'"
    * ввести в поле "поле 'password'" значение "password" из конфига "user.properties"
    * кликнуть на элемент "кнопка 'Login'"
    * кликнуть на элемент "ссылка 'My Account'"
    * поле "поле 'First name:'" имеет значение "Evgeniy"
    * поле "поле 'City:'" имеет значение "Samara"


