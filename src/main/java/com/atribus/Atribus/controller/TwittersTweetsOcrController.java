package com.atribus.Atribus.controller;

import com.atribus.Atribus.entity.TwittersTweet;
import com.atribus.Atribus.entity.TwittersTweetsOcr;
import com.atribus.Atribus.service.TwittersTweetsOcrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/twitterstweetsocr")
@CrossOrigin(origins = "*")
public class TwittersTweetsOcrController {

    @Autowired
    TwittersTweetsOcrService twittersTweetsOcrService;

    //MOSTRAR TWITTERSTWEETSOCR -> GET ALL (READ):
    @GetMapping("/list")
    public ResponseEntity<List<TwittersTweetsOcr>> List() {
        List<TwittersTweetsOcr> list = twittersTweetsOcrService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //PAGINACIÓN -> GET:
    @GetMapping("/list/pagina={page}&resultadosporpagina={size}")
    public ResponseEntity<Slice<TwittersTweetsOcr>> ListPage(@PathVariable("page") int page, @PathVariable("size") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Slice<TwittersTweetsOcr> list = twittersTweetsOcrService.listPage(pageable);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


}
