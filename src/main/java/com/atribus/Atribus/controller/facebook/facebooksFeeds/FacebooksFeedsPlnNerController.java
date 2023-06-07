package com.atribus.Atribus.controller.facebook.facebooksFeeds;

import com.atribus.Atribus.entity.facebook.facebooksFeeds.FacebooksFeedsOcr;
import com.atribus.Atribus.entity.facebook.facebooksFeeds.FacebooksFeedsPlnNer;
import com.atribus.Atribus.service.facebook.facebooksFeeds.FacebooksFeedsPlnNerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facebooksfeedsplnner")
@CrossOrigin(origins = "*")
public class FacebooksFeedsPlnNerController {

    @Autowired
    FacebooksFeedsPlnNerService facebooksFeedsPlnNerService;

    //MOSTRAR FACEBOOKSFEEDSPLNNER -> GET ALL (READ):
    @GetMapping("/list")
    public ResponseEntity<List<FacebooksFeedsPlnNer>> List() {
        List<FacebooksFeedsPlnNer> list = facebooksFeedsPlnNerService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //PAGINACIÓN -> GET:
    @GetMapping("/list/pagina={page}&resultadosporpagina={size}")
    public ResponseEntity<Slice<FacebooksFeedsPlnNer>> ListPage(@PathVariable("page") int page, @PathVariable("size") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Slice<FacebooksFeedsPlnNer> list = facebooksFeedsPlnNerService.listPage(pageable);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //MÉTODO listByFacebooksFeedsId:
    @GetMapping("/listByFacebooksFeedsId")
    public ResponseEntity<List<FacebooksFeedsPlnNer>> listByFacebooksFeedsId(
            @RequestParam("facebooksFeedsId") Long id) {
        List<FacebooksFeedsPlnNer> tweets = facebooksFeedsPlnNerService.findByFacebooksFeedsId(id);
        return new ResponseEntity<>(tweets, HttpStatus.OK);
    }

}
