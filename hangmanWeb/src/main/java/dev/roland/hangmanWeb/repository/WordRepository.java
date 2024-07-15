package dev.roland.hangmanWeb.repository;

import dev.roland.hangmanWeb.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WordRepository extends JpaRepository<Word, Integer> {

    List<Word> findAllByTopic_Id(int id);
}
