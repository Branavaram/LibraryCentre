# LibraryCentre

![Java](https://img.shields.io/badge/Java-17-ED8B00?logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-Build-C71A36?logo=apache-maven&logoColor=white)
![Swing](https://img.shields.io/badge/UI-Swing-4B8BBE)
![License](https://img.shields.io/badge/License-MIT-yellow.svg)

A Java console/Swing application for managing a library's collection of items — books, DVDs, and magazines — with add, edit, search, and remove flows plus a table-based GUI browser.

## Overview

The app models a library catalogue using an abstract `Item` base class extended by three item types:

- **Book** — title, ISBN, author
- **DVD** — title, ISBN, genre, director
- **Magazine** — title, ISBN, issue number, publication frequency, editor

`LibraryManagerImpl` implements the `LibraryManager` interface and handles the full lifecycle — adding, listing, editing titles, searching, and removing — with both a text menu and a Swing GUI (`ItemTableGUI` / `ItemTableModel`) for viewing items in a table.

## Menu options

1. **Add a new item** — book, DVD, or magazine
2. **Display the list of items**
3. **Open GUI** — Swing table view of the catalogue
4. **Modify Title** — edit an item's title by ISBN
5. **Search by Title** — case-insensitive substring match
6. **Remove an item by ISBN**
0. **Save and exit**

## Project structure

```
src/main/java/librarycentre_package/
├── Item.java                      # Abstract base class for library items
├── Book.java
├── DVD.java
├── Magazine.java
├── LibraryManager.java            # Interface for library management operations
├── LibraryManagerImpl.java        # Main implementation
├── ItemTableModel.java            # Table model backing the GUI
├── ItemTableGUI.java              # Swing GUI for browsing items
└── LibraryCentre.java             # Entry point (main)
```

## Running it

Requires Java 17+.

```bash
javac -d out src/main/java/librarycentre_package/*.java
java -cp out librarycentre_package.LibraryCentre
```

Or build/run via Maven (`pom.xml` included) if you have Maven installed.

## License

MIT — see [LICENSE](LICENSE).
