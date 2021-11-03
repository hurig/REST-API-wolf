package hu.forestwolf.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Wolf {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int rank;

    public Wolf(int id, String name, int rank) {
        this.id = id;
        this.name = name;
        this.rank = rank;
    }

    public Wolf(String name, int rank) {
        this.name = name;
        this.rank = rank;
    }

    public Wolf() {
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

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
