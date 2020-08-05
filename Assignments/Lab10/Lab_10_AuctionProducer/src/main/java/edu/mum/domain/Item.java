package edu.mum.domain;

import java.io.Serializable;

public class Item  implements Serializable {


     /**
	 * 
	 */
	private static final long serialVersionUID = -526850437911485980L;

	private Long id = null;

     private int version = 0;

     private String name;

     private float price;
 
     private String description;

     public Item() {
    	 
     }
 
     public Item(String name, String description) {
    	 this.name = name;
    	 this.description = description;
    	 
     }

    public Item(Long id, int version, String name, float price, String description) {
		this.id = id;
		this.version = version;
		this.name = name;
		this.price = price;
		this.description = description;
	}

	// ********************** Accessor Methods ********************** //

    public Long getId() { return id; }
    
    public int getVersion() { return version; }

    public String getName() { return name; }
    
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    
    public void setDescription(String description) { this.description = description; }

    public void setId(Long id) {
		this.id = id;
	}
 
      public float getPrice() {
  		return price;
  	}

  	public void setPrice(float price) {
  		this.price = price;
  	}

  	public void setVersion(int version) {
  		this.version = version;
  	}      
      
    // ********************** Common Methods ********************** //



	public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;

        final Item item = (Item) o;

         if (name != null ? !name.equals(item.name) : item.name != null) return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (name != null ? name.hashCode() : 0);
         return result;
    }

    public String toString() {
        return  "Item ('" + getId() + "'), " +
                "Name: '" + getName() + "' " +  "'";
    }

  
}
