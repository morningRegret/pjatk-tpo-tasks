# pjatk-tpo-tasks/task13

Trzynaste zadanie laboratoryjne z przedmiotu TPO.

## Wymagania

To zadanie wymaga trzech zewnętrznych bibliotek z Maven:

- `org.glassfish.jersey.bundles:jaxrs-ri:2.26`
- `org.glassfish.jersey.test-framework:jersey-test-framework-core:2.26`
- `org.glassfish.jersey.test-framework.providers:jersey-test-framework-provider-grizzly2:2.26`

## Otwieranie

Po sklonowaniu repozytorium, projekt należy otworzyć (lub zaimportować) w IDE własnego wyboru.

## Licencja

Kod źródłowy jest objęty licencją [Creative Commons BY-SA 4.0](../LICENSE.txt).

---

## Treść zadania

Based on the samples for JAX-RS implementation provided for the lecture create your own WebAPI aka. REST web service which will hold information about people (e.g. in a map). Each person has the following attributes:

- First name;
- Surname;
- Birth date.

Your web service will respond to a query which will filter the stored entries based on:

- Surname;
- Birth date.

Based on the provided samples create a JUnit test for verifying whether your REST web service works as expected.
