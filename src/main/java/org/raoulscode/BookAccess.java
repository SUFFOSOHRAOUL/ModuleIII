package org.raoulscode;


public class BookAccess {
    public static void main() throws CloneNotSupportedException {
       Book book1 = new Book("Atomic Habits", "james Clear", 30.00f);

       Book book2 = new Book();
       book2.setTitle("Sapiens");
       book2.setAuthor("Yuval Noah Harari");
       book2.setPrice(25.00f);

        System.out.println("\nThe first book object is\n");
        System.out.println(book1);
        System.out.println("\nthe second book object is\n");
        System.out.println(book2);

        comparePrices(book1,book2);

        Book book3 =(Book)(book1.clone());
        System.out.println("The third book cloned object is ");
        System.out.println(book3);


    }

    private static void comparePrices(Book book1, Book book2){
        float book1Price = book1.getPrice();
        float book2Price = book2.getPrice();
        String priceCmp = "";
        if(book1Price < book2Price){
            priceCmp =book1.getTitle()+ "cost less than" + book2.getTitle();

        }else if (book1Price == book2Price){
            priceCmp = book1.getTitle()+ "costs as much as" + book2.getTitle();
        }else {
            priceCmp = book1.getTitle()+" costs more than " + book2.getTitle();
        }
        System.out.println(priceCmp);

    }



}