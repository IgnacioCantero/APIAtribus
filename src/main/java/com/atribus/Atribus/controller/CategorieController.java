package com.atribus.Atribus.controller;

import com.atribus.Atribus.entity.Categorie;
import com.atribus.Atribus.entity.TwittersTweet;
import com.atribus.Atribus.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorie")
@CrossOrigin(origins = "*")
public class CategorieController {

    @Autowired
    CategorieService categorieService;

    //MOSTRAR CATEGORIE -> GET ALL (READ):
    @GetMapping("/list")
    public ResponseEntity<List<Categorie>> List() {
        List<Categorie> list = categorieService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //PAGINACIÓN -> GET:
    @GetMapping("/list/pagina={page}&resultadosporpagina={size}")
    public ResponseEntity<Slice<Categorie>> ListPage(@PathVariable("page") int page, @PathVariable("size") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Slice<Categorie> list = categorieService.listPage(pageable);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


}
