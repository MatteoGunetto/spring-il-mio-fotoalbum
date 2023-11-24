package org.project.java.fotoAlbum.db.repo;

import java.util.List;

import org.project.java.fotoAlbum.db.foto.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo extends JpaRepository<Message, Integer> {
    public List<Message> findByEmail(String email);
}