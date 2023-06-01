package com.atribus.Atribus.dao;

import com.atribus.Atribus.entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface CategorieRepository extends JpaRepository<Categorie, Long> {

    //FUNCIONES DINÁMICAS:
    @Query("select cat from Categorie cat where cat.categoryId = ?1")
    List<Categorie> getCategorieByCategoryId(int category);
    //Show by category_id

}
