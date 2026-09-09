package org.raoulscode;

import java.util.Scanner;

public class BooksMenu {

    public static Book CompareTwoBooks(Book book1, Book book2){

        if(book1.getPrice()>=book2.getPrice()){
            return  book1;
        }else {
            return book2;
        }

    }

    public static void main(String s[]){
        Scanner scanner = new Scanner(System.in);
        Book[] books = new Book[10];
        int bkIdx = 0;
        while(true){
            System.out.println("Press 1 to view books, 2 to add books, 3 compare two books any other key to exit");
            String userAction = scanner.nextLine();
            if(userAction.equals("1")){
                for (int i = 0; i<books.length;i++){
                    if(books[i] != null){
                        System.out.println(books[i]);
                    }
                }
            }else if (userAction.equals("2")){
                if(bkIdx ==10){
                    System.out.println("10 books added already, Cannot ad any more book!");
                    continue;
                }

                System.out.println("Enter book title");
                String tmpTitle = scanner.nextLine();
                System.out.println("Enter book author");
                String tmpAuthor = scanner.nextLine();
                System.out.println("Enter book price");
                float tmpPrice = Float.parseFloat(scanner.nextLine());
                Book bkTmp = new Book();
                bkTmp.setTitle(tmpTitle);
                bkTmp.setAuthor(tmpAuthor);
                bkTmp.setPrice(tmpPrice);
                books[bkIdx++] = bkTmp;

            } else if(userAction.equals("3")){
                System.out.println("Enter index of first book to compare");
                int book1Idx = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter index of second book to compare");
                int book2Idx = Integer.parseInt(scanner.nextLine());

                // Check if the selected indices contain valid Book objects
                if (books[book1Idx] != null && books[book2Idx] != null) {
                    // Compare the books and print the details of the more expensive book
                    System.out.println("The details of expensive book is \n" +
                            CompareTwoBooks(books[book1Idx], books[book2Idx]));


                } else {
                break;
            }
            }
        }
    }}