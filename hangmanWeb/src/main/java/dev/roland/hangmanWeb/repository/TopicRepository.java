package dev.roland.hangmanWeb.repository;

import dev.roland.hangmanWeb.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Integer> {
}
