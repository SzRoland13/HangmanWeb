package dev.roland.hangmanWeb.model;

import jakarta.persistence.*;

@Entity
@Table(name = "word")
public class Word {

    @Id
    @Column(name = "word_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "word_name")
    private String name;

    @Column(name = "topic_id")
    private int topicId;


    public Word() {
    }

    public Word(int id, String name, int topicId) {
        this.id = id;
        this.name = name;
        this.topicId = topicId;
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

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", topic_id=" + topicId +
                '}';
    }
}
