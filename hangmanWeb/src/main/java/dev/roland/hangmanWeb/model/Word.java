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

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

    public Word() {
    }

    public Word(int id, String name, Topic topic) {
        this.id = id;
        this.name = name;
        this.topic = topic;
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
        return topic.getId();
    }

    public void setTopicId(int topicId) {
        this.topic.setId(topicId);
    }
    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", topic=" + topic.toString() +
                '}';
    }
}
