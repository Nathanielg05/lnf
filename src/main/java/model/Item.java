package model;
//added imports for flexibility and firebase compatibility - Nate
import com.google.cloud.firestore.annotation.DocumentId;

public class Item {

    //Firebase uses String Ids instead of integers
    @DocumentId
    private String id;

    private String status;        //lost or found
    private String category;      //Modular descriptor
    private String description;   //extra details 
    private String location;      //location where item was found (shortened for easier use)
    private String foundername;   //Name of the user submitting
    private String whenfound;     //Tilestamp or date string 
    
    //added a default constructor for firebase to read -Nate
    public Item() {}

    //For new submission
    public Item(String status, String category, String description, String location, String foundername){
        this.status = status;
        this.category = category;
        this.description = description;
        this.location = location;
        this.foundername = foundername;
    }

    //Getters and Setters (maps the data already no no need for the matching block) 
    //cleaned up the block and changed id to String - Nate

    //ItemID
    public String getID() { return id; }
    public void setID(String id) { this.id = id; }

    //Status
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    //Category
    public String getCategory() { return category;}
    public void setCategory(String category) { this.category = category; }

    //Description
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    //Location
    public String getlocation() { return location; }
    public void setlocation(String location) { this.location = location; }

    //Founder Name
    public String getFoundername() { return foundername; }
    public void setFoundername(String foundername) { this.foundername = foundername; }

    //When Found
    public String getWhenfound() { return whenfound; }
    public void setWhenfound(String whenfound) { this.whenfound = whenfound; }

@Override 
public String toString(){
    return String.format("[%s] %s: %s (Location: %s)", status, category, description, location);
    }

}