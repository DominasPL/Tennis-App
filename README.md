# Aplikacja do wyszukiwania przeciwnika oraz symulacji pojedynku
![tennis_app1](https://user-images.githubusercontent.com/47396707/58972323-99c67680-87bd-11e9-9c5c-5ebbf13fba12.jpg)
## Wprowadzenie
Celem projektu było stworzenie aplikacji umożliwiającej użytkownikowi wylosowanie 
rywala na podstawie rankingu oraz przeprowadzenie symulacji pojedynku. Przed wylosowaniem przeciwnika wyświetlane są ostatnie pojedynki użytkownika. 
Po przejściu do doboru kolejnego rywala wyświetlana jest ilość dostępnych przeciwników oraz ich średnia ilość puntków. Po doborze rywala przeprowadzana jest symulacja pojedynku. Za zwycięstwo użytkownik otrzymuje +25pkt, a za porażkę -25pkt.
Ostatnie pojedynki można zobaczyć  w zakładce "Ostatnie mecze". Istnieje możliwość dodawania komentarzy do każdego meczu. Wszystkie statystyki użytkowników można zobaczyć w zakładce "Ranking".
![tennis_app2](https://user-images.githubusercontent.com/47396707/58972390-c4b0ca80-87bd-11e9-8cc7-7fd19afeb382.jpg)
![tennis_app3](https://user-images.githubusercontent.com/47396707/58972426-d7c39a80-87bd-11e9-8e79-89792e97bede.jpg)
### Technologie
* Java
* Spring Boot
* Spring Security
* Hibernate
* HTML
* JSP
* CSS
* Bootstrap

## Funkcjonalności
* Rejestracja
* Logowanie
* Edycja profilu
* Wyświetlanie ostatnich pojedynków przed wylosowaniem przeciwnika
* Wylosowanie rywala
* Przeprowadznie symulacji pojedynku
* Możliwość komentowania ostatnich meczów

## Uruchomienie
Przed uruchomieniem aplikacji należy utworzyć baze danych "tennis" lub skorzystać z własnej bazy. 
Jeżeli nazwa bazy będzie inna należy edytować plik application.properties znajdujący się w folderze resources
i zmienić nazwę na własną.


