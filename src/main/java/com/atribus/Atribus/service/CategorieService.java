package com.atribus.Atribus.service;

import com.atribus.Atribus.dao.CategorieRepository;
import com.atribus.Atribus.entity.Categorie;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CategorieService {

    @Autowired
    CategorieRepository categorieRepository;

    //MOSTRAR CATEGORIE -> GET ALL (READ):
    public List<Categorie> list() { return categorieRepository.findAll(); }

    //PAGINACIÓN -> GET:
    public Slice<Categorie> listPage(Pageable pageable) {
        return categorieRepository.findAll(pageable);
    }

}
