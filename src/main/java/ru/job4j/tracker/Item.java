package ru.job4j.tracker;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Data
@Entity
@Table(name = "items")
public class Item {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private LocalDateTime created = LocalDateTime.now();

    private String description;
    private Timestamp createdNew;

    public Item() {

    }

    public Item(String name) {
        this.name = name;
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Item(int id, String name, LocalDateTime created) {
        this.id = id;
        this.name = name;
        this.created = created;
    }

    public Item(String name, LocalDateTime created, String description, Timestamp createdNew) {
        this.name = name;
        this.created = created;
        this.description = description;
        this.createdNew = createdNew;
    }

    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", name='" + name + '\'' + ", created="
                + created.format(FORMATTER) + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return id == item.id && Objects.equals(name, item.name)
                && Objects.equals(created.withNano(0), item.created.withNano(0));
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, created);
    }
}