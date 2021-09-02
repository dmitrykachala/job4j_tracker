package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("100 способов радости", 123);
        Book book2 = new Book("Всякая хня", 234);
        Book book3 = new Book("И снова здрасьте", 345);
        Book book4 = new Book("Clean code", 100);
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        for (int i = 0; i < books.length; i++) {
            Book bk = books[i];
            System.out.println(bk.getName() + " - " + bk.getPages() + " pages");
        }
        System.out.println();
        Book temp = books[3];
        books[3] = books[0];
        books[0] = temp;
        for (int i = 0; i < books.length; i++) {
            Book bk = books[i];
            System.out.println(bk.getName() + " - " + bk.getPages() + " pages");
        }
        System.out.println();
        for (int i = 0; i < books.length; i++) {
            Book bk = books[i];
            if ("Clean code".equals(bk.getName())) {
                System.out.println(bk.getName() + " - " + bk.getPages() + " pages");
            }
        }
    }
}
