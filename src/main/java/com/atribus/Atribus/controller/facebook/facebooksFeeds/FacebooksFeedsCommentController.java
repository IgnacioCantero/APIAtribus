package com.atribus.Atribus.controller.facebook.facebooksFeeds;

import com.atribus.Atribus.entity.facebook.facebooksFeeds.FacebooksFeedsComment;
import com.atribus.Atribus.service.facebook.facebooksFeeds.FacebooksFeedsCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/facebooksfeedscomments")
@CrossOrigin(origins = "*")
public class FacebooksFeedsCommentController {

    @Autowired
    FacebooksFeedsCommentService facebooksFeedsCommentService;

    //MOSTRAR FACEBOOKSFEEDSCOMMENTS -> GET ALL (READ):
    @GetMapping("/list")
    public ResponseEntity<List<FacebooksFeedsComment>> List() {
        List<FacebooksFeedsComment> list = facebooksFeedsCommentService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //PAGINACIÓN -> GET:
    @GetMapping("/list/pagina={page}&resultadosporpagina={size}")
    public ResponseEntity<Slice<FacebooksFeedsComment>> ListPage(@PathVariable("page") int page, @PathVariable("size") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Slice<FacebooksFeedsComment> list = facebooksFeedsCommentService.listPage(pageable);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //MÉTODO findByCategoryIdAndSearchIdAndDateCreated:
    @GetMapping("/listByCategoryAndSearchAndDate")
    //todo -> REVISAR POR QUÉ NO LA TIRA!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public ResponseEntity<List<FacebooksFeedsComment>> listByCategoryAndSearchAndDate(
            @RequestParam("category") int category,
            @RequestParam("search") int search,
            @RequestParam("dateCreated") long dateCreatedMil) {

        Date dateCreated = new Date(dateCreatedMil * 1000);

        if (category == -1 && search != -1) {
            List<FacebooksFeedsComment> tweets = facebooksFeedsCommentService.findBySearchAndDateCreated(search, dateCreated);
            return new ResponseEntity<>(tweets, HttpStatus.OK);
        }
        if (search == -1 && category != -1) {
            List<FacebooksFeedsComment> tweets = facebooksFeedsCommentService.findByCategoryIdAndDateCreated(category, dateCreated);
            return new ResponseEntity<>(tweets, HttpStatus.OK);
        } else if (category == -1) {
            List<FacebooksFeedsComment> tweets = facebooksFeedsCommentService.findByDateCreated(dateCreated);
            return new ResponseEntity<>(tweets, HttpStatus.OK);
        }
        List<FacebooksFeedsComment> tweets = facebooksFeedsCommentService.findByCategoryIdAndSearchAndDateCreated(category, search, dateCreated);
        return new ResponseEntity<>(tweets, HttpStatus.OK);
    }

}
