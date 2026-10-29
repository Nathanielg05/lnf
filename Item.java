package model;

public class Item {
    private int itemID;
    private String status;
    private String category;
    private String description;
    private String locationFound;
    private String foundername;
    private String whenfound;
    
    //For new
    public Item(String status, String category, String description, String locationFound, String foundername){
        this.status=status;
        this.category=category;
        this.description=description;
        this.locationFound=locationFound;
        this.foundername=foundername;
    }
    //Find existing
    public Item(int itemID, String status, String category, String description, String locationFound, String foundername, String whenfound){
        this.itemID=itemID;
        this.status=status;
        this.category=category;
        this.description=description;
        this.locationFound=locationFound;
        this.foundername=foundername;
        this.whenfound=whenfound;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocationFound() {
        return locationFound;
    }

    public void setLocationFound(String locationFound) {
        this.locationFound = locationFound;
    }

    public String getFoundername() {
        return foundername;
    }

    public void setFoundername(String foundername) {
        this.foundername = foundername;
    }

    public String getWhenfound() {
        return whenfound;
    }

    public void setWhenfound(String whenfound) {
        this.whenfound = whenfound;
    }

@Override 
public String toString(){
    return String.format("[%d] %s: %s (Found at: %s)",itemID,category,description,locationFound);
}



}