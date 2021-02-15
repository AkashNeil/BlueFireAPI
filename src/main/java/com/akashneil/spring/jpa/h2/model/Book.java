/*
* @author : Akash S.
*/

package com.akashneil.spring.jpa.h2.model;


import com.sun.istack.NotNull;
import org.aspectj.bridge.IMessage;

import javax.persistence.*;

@Entity
@Table(name="books")
public class Book {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    public int id;

    @Column(name = "name")
    public String name;

    @Column(name = "author")
    public String author;

    @Column(name = "format")
    public String format;

    @Column(name = "read")
    public boolean read;

    public Book() {}

    public Book(String name, String author, String format, boolean read) {
        this.name = name;
        this.author = author;
        this.format = format;
        this.read = read;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    @Override
    public String toString() {
        return "Book [id=" + id
                + ", name=" + name
                + ", author=" + author
                + ", format=" + format
                + ", read=" + read
                + "]";
    }
}
