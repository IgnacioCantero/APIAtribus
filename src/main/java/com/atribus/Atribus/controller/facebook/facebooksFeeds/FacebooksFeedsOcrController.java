package com.atribus.Atribus.controller.facebook.facebooksFeeds;

import com.atribus.Atribus.entity.facebook.facebooksFeeds.FacebooksFeedsOcr;
import com.atribus.Atribus.service.facebook.facebooksFeeds.FacebooksFeedsOcrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/facebooksfeedsocrs")
@CrossOrigin(origins = "*")
public class FacebooksFeedsOcrController {

    @Autowired
    FacebooksFeedsOcrService facebooksFeedsOcrService;

    //MOSTRAR FACEBOOKSFEEDSOCR -> GET ALL (READ):
    @GetMapping("/list")
    public ResponseEntity<List<FacebooksFeedsOcr>> List() {
        List<FacebooksFeedsOcr> list = facebooksFeedsOcrService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //PAGINACIÓN -> GET:
    @GetMapping("/list/pagina={page}&resultadosporpagina={size}")
    public ResponseEntity<Slice<FacebooksFeedsOcr>> ListPage(@PathVariable("page") int page, @PathVariable("size") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Slice<FacebooksFeedsOcr> list = facebooksFeedsOcrService.listPage(pageable);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //MÉTODO listByFacebooksFeedsId:
    @GetMapping("/listByFacebooksFeedsId")
    public ResponseEntity<List<FacebooksFeedsOcr>> listByFacebooksFeedsId(
            @RequestParam("facebooksFeedsId") Long id) {
        List<FacebooksFeedsOcr> tweets = facebooksFeedsOcrService.findByFacebooksFeedsId(id);
        return new ResponseEntity<>(tweets, HttpStatus.OK);
    }

}
