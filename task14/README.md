# pjatk-tpo-tasks/task14

Czternaste zadanie laboratoryjne z przedmiotu TPO.

## Otwieranie

Po sklonowaniu repozytorium należy wygenerować brakujące pliki Java z pliku IDL:
 
```bash
$ idlj -fall -td src task14.idl
```

Następnie, należy odpalić server ORB:

```bash
$ orbd -ORBInitialPort 2004 
```

Po ukończeniu powyższej konfiguracji projekt należy otworzyć (lub zaimportować) w IDE własnego wyboru.

## Licencja

Kod źródłowy jest objęty licencją [Creative Commons BY-SA 4.0](../LICENSE.txt).

---

## Treść zadania

Write a client/server solution based on CORBA technology which implements the operations discussed in task 8 (i.e. echoing messages and adding values of two operands).
