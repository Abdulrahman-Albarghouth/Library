package com.bnaeirtlibrary;

public class Books {
    String book_author;
    String book_cathegory;
    String book_like;
    String book_detail;
    String url;
    public  Books(String url,String book_author){}
    public  Books(){}

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public String getBook_cathegory() {
        return book_cathegory;
    }

    public void setBook_cathegory(String book_cathegory) {
        this.book_cathegory = book_cathegory;
    }

    public String getBook_like() {
        return book_like;
    }

    public void setBook_like(String book_like) {
        this.book_like = book_like;
    }

    public String getBook_detail() {
        return book_detail;
    }

    public void setBook_detail(String book_detail) {
        this.book_detail = book_detail;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
