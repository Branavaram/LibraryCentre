/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package librarycentre_package;

/**** ENTER HERE YOUR DETAILS:*******
         * 
         * FIRST NAME:
         * 
         * LAST NAME:
         * 
         * STUDENT ID:
         * 
         */


public class LibraryCentre {

    public static void main(String[] args) {
        
       LibraryManagerImpl libraryCentre = new LibraryManagerImpl(5);
    
        boolean exit = false;
        
        //run the menu until the user select exit
        while (!exit)
            exit = libraryCentre.runMenu();
    }
}
