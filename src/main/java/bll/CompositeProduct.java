package bll;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class CompositeProduct extends MenuItem implements Serializable {
   // private String title;
    private ArrayList<MenuItem> items;


    public CompositeProduct(String title, ArrayList<MenuItem> items) {
        super.title = title;
        this.items = items;

        int r=0,c=0,p=0,f=0,s=0,pr=0;
        for(MenuItem m : items){
            c+=m.getCalories();
            p+=m.getProtein();
            f+=m.getFat();
            s+=m.getSodium();
            pr+=m.getPrice();
            r+=m.getRating();
        }
        this.calories=c;
        this.rating=r;
        this.protein = p;
        this.price = pr;
        this.fat = f;
        this.sodium=s;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        //if(this.title==null) return false;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CompositeProduct that = (CompositeProduct) o;
        return title.equals(that.title) && items.equals(that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), title, items);
    }

    @Override
    public String toString() {
        String s = "CompositeProduct" + title + " contains:{";
        for(MenuItem m : items)
            s+=m.getTitle() + ",";
        s+="}";
        s+= "rating=" + rating +
                ", calories=" + calories +
                ", protein=" + protein +
                ", fat=" + fat +
                ", sodium=" + sodium +
                ", price=" + price +
                '}';

        return s;
    }

    @Override
    public int computePrice() {
        int p=0;
        for(MenuItem m : items)
            p+=m.getPrice();
        return p;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<MenuItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<MenuItem> items) {
        this.items = items;
    }
}
