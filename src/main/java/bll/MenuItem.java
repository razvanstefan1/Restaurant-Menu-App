package bll;

import java.io.Serializable;
import java.util.Objects;

public abstract class MenuItem implements Serializable,Comparable<MenuItem> {
    String title;
    double rating;
    int calories;
    int protein;
    int fat;
    int sodium;
    int price;

    public MenuItem(String title, double rating, int calories, int protein, int fat, int sodium, int price) {
        this.title = title;
        this.rating = rating;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.sodium = sodium;
        this.price = price;
    }

    public MenuItem() {

    }

    public abstract int computePrice();

    @Override
    public int hashCode() {
        return Objects.hash(title, rating, calories, protein, fat, sodium, price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItem menuItem = (MenuItem) o;
        return Double.compare(menuItem.rating, rating) == 0 && calories == menuItem.calories &&
                protein == menuItem.protein && fat == menuItem.fat && sodium == menuItem.sodium
                && price == menuItem.price && title.equals(menuItem.title);
    }

    public boolean equalss(MenuItem m){
        if(m==null) return false;
        if(this.title.equals(m.title)&&
           this.rating == m.rating &&
            this.calories == m.calories&&
        this.protein==m.protein&&
        this.fat==m.fat &&
        this.sodium==m.sodium &&
        this.price==m.price)
            return true;
        return false;
    }

    public boolean clientFilter(String keyw, double r, int c, int p, int f, int s, int pr){
        if(r!=-1 && this.getRating()!=r) return false;
        if(c!=-1 && this.getCalories()!=c) return false; // daca e -1 nu returnam false pt ca ins ca nu am filtrat dupa acel camp
        if(p!=-1 && this.getProtein()!=p) return false;
        if(f!=-1 && this.getFat()!=f) return false;
        if(s!=-1 && this.getSodium()!=s) return false;
        if(pr!=-1 && this.getPrice()!=pr) return false;

        if(keyw!=null && !this.getTitle().contains(keyw)) return false;
        return true;
    }


    public String toStringComma(){
        return title + "," + rating + "," + calories + ","
                + protein + "," + fat + "," + sodium + "," + price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getSodium() {
        return sodium;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int compareTo(MenuItem o) {
        if(this.equals(o))
            return 1;
        return 0;
    }
}
