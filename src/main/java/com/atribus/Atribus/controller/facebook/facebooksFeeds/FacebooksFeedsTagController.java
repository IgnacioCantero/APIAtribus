package com.atribus.Atribus.controller.facebook.facebooksFeeds;

import com.atribus.Atribus.entity.facebook.facebooksFeeds.FacebooksFeed;
import com.atribus.Atribus.entity.facebook.facebooksFeeds.FacebooksFeedsTag;
import com.atribus.Atribus.service.facebook.facebooksFeeds.FacebooksFeedsTagService;
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
@RequestMapping("/facebooksfeedstags")
@CrossOrigin(origins = "*")
public class FacebooksFeedsTagController {

    @Autowired
    FacebooksFeedsTagService facebooksFeedsTagService;

    //MOSTRAR FACEBOOKSFEEDSTAGS -> GET ALL (READ):
    @GetMapping("/list")
    public ResponseEntity<List<FacebooksFeedsTag>> List() {
        List<FacebooksFeedsTag> list = facebooksFeedsTagService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //PAGINACIÓN -> GET:
    @GetMapping("/list/pagina={page}&resultadosporpagina={size}")
    public ResponseEntity<Slice<FacebooksFeedsTag>> ListPage(@PathVariable("page") int page, @PathVariable("size") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Slice<FacebooksFeedsTag> list = facebooksFeedsTagService.listPage(pageable);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //MÉTODO findByFacebooksFeedsId:
    @GetMapping("/listByFacebooksFeedsId")
    public ResponseEntity<List<FacebooksFeedsTag>> findByFacebooksFeedsId(
            @RequestParam("facebooksFeedsId") Long id) {
        List<FacebooksFeedsTag> tweets = facebooksFeedsTagService.findByFacebooksFeedsId(id);
        return new ResponseEntity<>(tweets, HttpStatus.OK);
    }

}
