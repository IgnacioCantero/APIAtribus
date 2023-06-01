package com.atribus.Atribus.controller.twitter.twittersProfiles;

import com.atribus.Atribus.entity.twitter.twittersProfiles.TwittersProfilesUser;
import com.atribus.Atribus.service.twitter.twittersProfiles.TwittersProfilesUserService;
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
@RequestMapping("/twittersprofilesusers")
@CrossOrigin(origins = "*")
public class TwittersProfilesUserController {

    @Autowired
    TwittersProfilesUserService twittersProfilesUserService;

    //MOSTRAR TWITTERSPROFILESUSERS -> GET ALL (READ):
    @GetMapping("/list")
    public ResponseEntity<List<TwittersProfilesUser>> List() {
        List<TwittersProfilesUser> list = twittersProfilesUserService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //PAGINACIÓN -> GET:
    @GetMapping("/list/pagina={page}&resultadosporpagina={size}")
    public ResponseEntity<Slice<TwittersProfilesUser>> ListPage(@PathVariable("page") int page, @PathVariable("size") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Slice<TwittersProfilesUser> list = twittersProfilesUserService.listPage(pageable);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //MÉTODO findByTwittersProfileUsersId:
    @GetMapping("/listByTwittersProfileUsersId")
    public ResponseEntity<List<TwittersProfilesUser>> listByTwittersProfileUsersId(
            @RequestParam("id") Long id) {
        List<TwittersProfilesUser> tweets = twittersProfilesUserService.findByTwittersProfileUsersId(id);
        return new ResponseEntity<>(tweets, HttpStatus.OK);
    }

    //MÉTODO findByTwittersProfileUsersId:
    @GetMapping("/listByDateCreated")
    public ResponseEntity<List<TwittersProfilesUser>> listByDateCreated(
            @RequestParam("dateCreated") Date dateCreated) {
        List<TwittersProfilesUser> tweets = twittersProfilesUserService.findByDateCreated(dateCreated);
        return new ResponseEntity<>(tweets, HttpStatus.OK);
    }

}
