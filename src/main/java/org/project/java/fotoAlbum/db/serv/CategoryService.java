package org.project.java.fotoAlbum.db.serv;

import java.util.List;
import java.util.Optional;

import org.project.java.fotoAlbum.db.foto.Category;
import org.project.java.fotoAlbum.db.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    public List<Category> findAll(){
        return categoryRepo.findAll();
    }

    public Optional<Category> findById(int id) {
        return categoryRepo.findById(id);
    }

    public void save(Category category) {
        categoryRepo.save(category);
    }

    public void deleteCategory(Category category) {
        categoryRepo.delete(category);
    }
}