package XMLParser;

import java.util.ArrayList;

public class Book {
    private String title;
    private String isbn;
    private ArrayList<String> authors;
    private String cover;
    private String edition;
    private String publisher;
    private String publisherURL;

    public Book() {
        this.authors = new ArrayList<>();
    }

    public Book(String title, String isbn, String cover, String edition, String publisher, String publisherURL) {
        this();
        this.title = title;
        this.isbn = isbn;
        this.cover = cover;
        this.edition = edition;
        this.publisher = publisher;
        this.publisherURL = publisherURL;
    }

    public void addAuthor(String author) {
        this.authors.add(author);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPublisherURL(String publisherURL) {
        this.publisherURL = publisherURL;
    }

    @Override
    public String toString() {
        return "Book" + "\n" +
                "title: '" + title + "\'\n" +
                "isbn: '" + isbn + "\'\n" +
                "authors: " + authors + "\n" +
                "cover: '" + cover + "\'\n" +
                "edition: '" + edition + "\'\n" +
                "publisher: '" + publisher + "\'\n" +
                "publisherURL: '" + publisherURL + "\'\n";
    }
}
