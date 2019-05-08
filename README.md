## Aplikacja do wyszukiwania przeciwnika
#### Wprowadzenie
Celem projektu było stworzenie aplikacji umożliwiającej użytkownikowi wylosowanie 
rywala na podstawie rankingu oraz przeprowadzenie symulacji pojedynku. Przed wylosowaniem przeciwnika wyświetlane są ostatnie pojedynki użytkownika. 
Po przejściu do doboru kolejnego rywala wyświetlana jest ilość dostępnych przeciwników oraz ich średnia ilość puntków. Po doborze rywala przeprowadzana jest symulacja pojedynku. Za zwycięstwo użytkownik otrzymuje +25pkt, a za porażkę -25pkt.
Ostatnie pojedynki można zobaczyć  w zakładce "Ostatnie mecze". Istnieje możlowość dodawania komentarzy do każdego meczu. Wszystkie statystyki użytkowników można zobaczyć w zakładce "Ranking".

#### Technologie
* Java
* Spring Boot
* Spring Security
* Hibernate
* HTML
* JSP
* CSS
* Bootstrap

#### Funkcjonalności
* Rejestracja
* Logowanie
* Edycja profilu
* Wyświetlanie ostatnich pojedynków przed wylosowaniem przeciwnika
* Wylosowanie rywala
* Przeprowadznie symulacji pojedynku
* Możliwość komentowania ostatnich meczów

#### Uruchomienie
Przed uruchomieniem aplikacji należy utworzyć baze danych "tennis" lub skorzystać z własnej bazy. 
Jeżeli nazwa bazy będzie inna należy edytować plik application.properties znajdujący się w folderze resources
i zmienić nazwę na własną.


