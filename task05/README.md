# pjatk-tpo-tasks/task05

Piąte zadanie laboratoryjne z przedmiotu TPO.

## Otwieranie

Po sklonowaniu repozytorium, projekt należy otworzyć (lub zaimportować) w IDE własnego wyboru.

## Licencja

Kod źródłowy jest objęty licencją [Creative Commons BY-SA 4.0](../LICENSE.txt).

---

## Treść zadania

Develop a simple web application which allows particular users to display the resources available to them.

The application would hold user directory in a database table `Users`. A `Users` entry contains: technical (so called surrogate) identifier, login, first name, surname and the password.

The resources are stored in `Resources` database table. Each resource has: surrogate identifier, name and content – i.e. a 2048-byte long string.

A resource may be accessible to multiple users, as well as each user may access multiple resources, which implies that in the relational model there should be a junction table between the two above entity types.

Your web application should allow a user to establish a session after successful authentication. Within a session a user can browse the resources he/she has access to. This means that your application should provide 3 different user screens:

1. Entry login screen for user authentication;
2. A screen listing resources available to the user – each resource entry presents only name of a resource – the resource details page (see below) is displayed when a user follows a corresponding link or presses a ‘Details’ button besides the name of the resource;
3. A screen presenting details of particular resource displaying both the name and the content.

NOTE: Screens (2) and (3) should contain a ‘Log Out’ button which invalidates the session. Screen (3) should have a button/link to navigate back to the list of the available resources.

NOTE: Your solution should utilize `DataSource` mechanism which supports database connection pooling.
