package ch.helsana.web.hib.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by hkfq4 on 07.02.2017.
 */
@Entity
@Table
public class Books {

    @Id
    //@GeneratedValue
    private int id;
    private String isbn;
    private String title;
    private Integer year;

    public Books() {};

    public Books(int id, String isbn, String title, int year) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}

