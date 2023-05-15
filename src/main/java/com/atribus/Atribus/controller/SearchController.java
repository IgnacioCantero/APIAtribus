package com.atribus.Atribus.controller;

import com.atribus.Atribus.entity.Categorie;
import com.atribus.Atribus.entity.Search;
import com.atribus.Atribus.entity.TwittersTweet;
import com.atribus.Atribus.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
@CrossOrigin(origins = "*")
public class SearchController {

    @Autowired
    SearchService searchService;

    //MOSTRAR SEARCH -> GET ALL (READ):
    @GetMapping("/list")
    public ResponseEntity<List<Search>> List() {
        List<Search> list = searchService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //PAGINACIÓN -> GET:
    @GetMapping("/list/pagina={page}&resultadosporpagina={size}")
    public ResponseEntity<Slice<Search>> ListPage(@PathVariable("page") int page, @PathVariable("size") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Slice<Search> list = searchService.listPage(pageable);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


}
