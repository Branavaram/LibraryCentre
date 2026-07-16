/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarycentre_package;

/**
 *
 * @author brana
 */
public class Magazine extends Item {
    
    // instance variable
    private int issueNumber;
    private String publicationFrequency;
    private String editor;

    //constructor
    public Magazine(String title, String ISBN) {
        super(title, ISBN);
    }

    // set and get method
    public int getIssueNumber() {
        return issueNumber;
    }
    public String getPublicationFrequency() {
        return publicationFrequency;
    }
    public String getEditor() {
        return editor;
    }
    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }
    public void setPublicationFrequency (String publicationFrequency) {
        this.publicationFrequency = publicationFrequency;
    }
    public void setEditor(String editor) {
        this. editor =  editor;
    }

    
    // description
    @Override
    public String toString(){
        return super.toString() + ", issue numberr: " + issueNumber+ ", pclfrq: " + publicationFrequency+ ", editor: " + editor; 
    }
    
    
}
