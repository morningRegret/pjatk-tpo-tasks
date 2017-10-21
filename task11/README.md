# pjatk-utp-tasks/task11

Jedenaste zadanie laboratoryjne z przedmiotu TPO.

## Otwieranie

Po sklonowaniu repozytorium, projekt należy otworzyć (lub zaimportować) w IDE własnego wyboru.

## Licencja

Kod źródłowy jest objęty linencją MIT. Treść licencji jest dostępna w pliku [LICENSE.md](../LICENSE.md).

---

## Treść zadania

Based on samples provided for JAX-WS create a SOAP web service enabling uploading and downloading files. Each file uploaded to your web service should be stored along with its metadata:

- File name;
- File size;
- Keywords describing file content.

Your web service should support three types of requests:

- File upload – used for file uploading. Some of the aforementioned properties, such as file name or file size, could be retrieved from the file itself. Keywords should be provided as separate set of values in the request.
- File query – used for filtering files of the given keywords.
- File download – for downloading file based on file name.

Based on the provided samples create a JUnit test for verifying whether your SOAP web service works as expected.
