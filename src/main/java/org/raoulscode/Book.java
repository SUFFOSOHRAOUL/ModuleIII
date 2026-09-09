package org.raoulscode;

public class Book {
    private String title;
    private String author;
    private float price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {

        return "Title - " + this.title + "\nAuthor - "
                + this.author + "\nPrice - "+ String.format("%.2f", this.price);

    }
}