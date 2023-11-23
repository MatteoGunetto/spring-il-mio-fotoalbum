package org.project.java.fotoAlbum.db.repo;

import org.project.java.fotoAlbum.db.foto.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {

}