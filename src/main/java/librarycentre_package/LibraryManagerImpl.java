/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarycentre_package;

import java.util.ArrayList;
import java.util.Scanner;


public class LibraryManagerImpl implements LibraryManager {
    
    // ArrayLists
    public ArrayList<Item> itemList;
    public int item_limit;
    
    public LibraryManagerImpl(int maxItemNumber){
        itemList = new ArrayList<Item>();
        item_limit = maxItemNumber;
    }

    @Override
    public boolean runMenu() {
         boolean exit = false; // Exit flag
        
        // Run console menu
        System.out.println("\n-- LIBRARY MANAGER CONSOLE MENU--");
        
        System.out.println("To save and exit, press 0");
        
        System.out.println("To Add a new item, press 1");
        
        System.out.println("To Display the list of item press 2");
        
        System.out.println("To Open GUI, press 3");
        
        System.out.println("Modify Title, press 4");

        System.out.println("Search by Title, press 5");

        // Switch based on selected option
        Scanner s = new Scanner(System.in);
        int choice;
        choice = s.nextInt();

        
        switch(choice){
            
             // Exit
            case 0:
                exit = true;
                break;
            
            // Add staff member
            case 1:
                this.addItem();
                break;
            // Print staff members
            case 2:
                this.displayItems();
                break;
            
            // GUI
            case 3:
                this.runGUI();
                break;
           case 4:
                this.editTitleItem();
                break;
           case 5:
                this.searchByTitle();
                break;
        }
        
        return exit;
    }

    @Override
    public void addItem() {
        Scanner s = new Scanner (System.in);
        
        if(itemList.size() < item_limit){
            System.out.println("Press 1 if you want to add a Book");
            System.out.println("Press 2 if you want to add a DVD");
            System.out.println("Press 3 if you want to add a Magazine");
            
            int choiceItem = s.nextInt();
            s.nextLine();
            
            //common questions
            System.out.println("Enter the Title");
            String title = s.nextLine();
            
            System.out.println("Enter the ISBN");
            String isbn = s.nextLine();
            
            System.out.println("Enter the publication year ");
            int year = s.nextInt();
            s.nextLine();
            
            // check if the item is a book or a dvd
            switch(choiceItem){
                case 1:
                    // it is a book
                    System.out.println("Enter the author's name");
                    String author = s.nextLine();
                    
                    // create a new book and add to the list
                    Book book = new Book(title, isbn);
                    book.setAuthor(author);
                    book.setPublicationYear(year);
                   
                    this.addItemToList(book);
                    
                    break;
                    
                case 2:
                    //it is a dvd
                    System.out.println("Enter the genre");
                    String genre = s.nextLine();

                    System.out.println("Enter the director's name");
                    String director = s.nextLine();

                    DVD dvd = new DVD(title, isbn);
                    dvd.setGenre(genre);
                    dvd.setDirector(director);
                    dvd.setPublicationYear(year);

                    this.addItemToList(dvd);
                    break;

                case 3:
                    //it is a magazine
                    System.out.println("Enter the issue number");
                    int issueNumber = s.nextInt();
                    s.nextLine();

                    System.out.println("Enter the publication frequency (e.g. Weekly, Monthly)");
                    String frequency = s.nextLine();

                    System.out.println("Enter the editor's name");
                    String editor = s.nextLine();

                    Magazine magazine = new Magazine(title, isbn);
                    magazine.setIssueNumber(issueNumber);
                    magazine.setPublicationFrequency(frequency);
                    magazine.setEditor(editor);
                    magazine.setPublicationYear(year);

                    this.addItemToList(magazine);
                    break;

                default:
                    System.out.println("Invalid item type. Add cancelled.");
            }
            
        }
        else {
            System.out.println("No more space in the system");
        }
    }
    
    public void addItemToList(Item item){
        
        //check if there are space avilable
        if(this.itemList.size() < item_limit) {
            itemList.add(item);
        }
        else{
            System.out.println("No more space in the list");
        }
    }

    @Override
    public void displayItems() {
        
        
        if (!itemList.isEmpty()){
            for(Item item : itemList) {
                // print the type of item and the the description
                if(item instanceof Book)
                    System.out.print("BOOK - ");
                else if (item instanceof DVD)
                    System.out.print("DVD - ");
                else if (item instanceof Magazine)
                    System.out.print("MAGAZINE - ");

                System.out.println(item.toString());
            }
        }
        else{
            System.out.println("There are no items in the system.");
        }
    }

    @Override
    public void runGUI() {
        ItemTableGUI table = new ItemTableGUI(itemList);
        table.setVisible(true);
    }
    @Override
    public void searchByTitle() {
        if (itemList.isEmpty()) {
            System.out.println("There are no items in the system.");
            return;
        }

        Scanner s = new Scanner(System.in);
        System.out.println("Enter a title (or part of one) to search for:");
        String query = s.nextLine().toLowerCase();

        int matches = 0;
        for (Item item : itemList) {
            if (item.getTitle().toLowerCase().contains(query)) {
                if (item instanceof Book) System.out.print("BOOK - ");
                else if (item instanceof DVD) System.out.print("DVD - ");
                else if (item instanceof Magazine) System.out.print("MAGAZINE - ");
                System.out.println(item.toString());
                matches++;
            }
        }
        if (matches == 0) {
            System.out.println("No items matched '" + query + "'.");
        } else {
            System.out.println(matches + " item(s) matched.");
        }
    }

    @Override
    public void removeItem() {
        // stub — implemented in next commit
    }

    @Override
    public void  editTitleItem() {
        Scanner s = new Scanner(System.in);
        
        
        if (!itemList.isEmpty()){
            System.out.println("Enter the ISBN");
            String isbn = s.nextLine();
            boolean found = false;   
            for(Item item : itemList) {
                if (item.getISBN().equals(isbn)){
                    found= true;
                    System.out.println("Current Title: " + item.getTitle());
                    System.out.println("Publication Year: " + item.getPublicationYear());
                    if(item instanceof Book){
                        System.out.print("BOOK - ");
                        
                    }else if (item instanceof DVD){
                        System.out.print("DVD - ");    
                    }else {
                    System.out.println("Type: Magazine");
                    }
                    System.out.println("Enter the new Title:");
                    String newTitle = s.nextLine();
                
              
                    item.setTitle(newTitle);
                    System.out.println("Title updated successfully.");
                }
            }    
             if (!found) {
            System.out.println("No item found with that ISBN.");
            } 
                
               
        }
        else{
            System.out.println("There are no items in the system.");
        }
    }
    
    
}
