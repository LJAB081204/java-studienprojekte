# Lab 4: JavaFX table app (MVC)

A small desktop application that loads a CSV list of German railway companies (`evu_brd_gekuerzt.csv`) and shows it in a table.

- **Model:** loads and parses the file into an observable list
- **View:** JavaFX UI with a search field and a drop-down for freight/passenger transport
- **Controller:** applies live text search and category filtering through a `FilteredList`

Run with `mvn clean javafx:run`. Java 11 or newer.
