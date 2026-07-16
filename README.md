# LibraryCentre

A Java console/Swing application for managing a library's collection of items (books, DVDs, and magazines).

## Overview

The app models a library catalogue using an abstract `Item` base class extended by three item types:

- **Book** — title, ISBN, author
- **DVD** — title, ISBN, genre, director
- **Magazine** — title, ISBN, issue number, publication frequency, editor

`LibraryManagerImpl` implements the `LibraryManager` interface and handles adding items, listing them, and editing titles, with both a text menu and a Swing GUI (`ItemTableGUI` / `ItemTableModel`) for viewing items in a table.

## Project structure

```
src/main/java/librarycentre_package/
├── Item.java                      # Abstract base class for library items
├── Book.java
├── DVD.java
├── Magazine.java
├── LibraryManager.java            # Interface for library management operations
├── LibraryManagerImpl.java         # Main implementation
├── ItemTableModel.java            # Table model backing the GUI
├── ItemTableGUI.java              # Swing GUI for browsing items
└── LibraryCentre.java              # Entry point (main)
```

## Running it

Requires Java 17+.

```bash
javac -d out src/main/java/librarycentre_package/*.java
java -cp out librarycentre_package.LibraryCentre
```

Or build/run via Maven (`pom.xml` included) if you have Maven installed.
