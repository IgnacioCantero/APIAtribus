package com.atribus.Atribus.service;

import com.atribus.Atribus.dao.SearchRepository;
import com.atribus.Atribus.entity.Search;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class SearchService {

    @Autowired
    SearchRepository searchRepository;

    //MOSTRAR SEARCH -> GET ALL (READ):
    public List<Search> list() { return searchRepository.findAll(); }

    //PAGINACIÓN -> GET:
    public Slice<Search> listPage(Pageable pageable) {
        return searchRepository.findAll(pageable);
    }

}
