package edu.cueb.cueb_usedbooks.core.manager;

import java.util.List;

import edu.cueb.cueb_usedbooks.model.NetWorkListener;
import edu.cueb.cueb_usedbooks.model.classN.Book;

/**
 * Created by caoguodong on 15/4/2.
 */
public class BookManager {

    private String isbn;

    private BookManager(){}

    private static class Holder{
        public static BookManager bookManager = new BookManager();
    }

    public static BookManager getInstance(){
        return Holder.bookManager;
    }

    public void init(){

    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }
}
