package com.mysuperscore.controller;

import com.mysuperscore.dao.SongDaoJDBC;
import com.mysuperscore.model.Song;
import com.mysuperscore.validator.FileValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    SongDaoJDBC songDaoJdbc;

    @Autowired
    FileValidator fileValidator;

    private static final int MAX_FILE_SIZE = 5 * 1024 * 1024;

    @RequestMapping(value = {"/create"}, method = RequestMethod.GET)
    public String newRegistration(ModelMap model) {
        Song song = new Song();
        model.addAttribute("song", song);
        return "create";
    }

    @RequestMapping(value = {"/create"}, method = RequestMethod.POST)
    public String saveRegistration(@Valid Song song,
                                   BindingResult result, ModelMap model) {
        MultipartFile file = song.getFile();
        fileValidator.validate(song, result);

        if (result.hasErrors()) {
            return "create";
        }
        byte[] bytes = new byte[0];

        try {
            bytes = file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        song.setData(bytes);
        song.setMimeType(file.getContentType());

        songDaoJdbc.create(song);

        model.addAttribute("success", "  " + song.getTitle()
                + " !   Registration completed successfully and your file  was loaded successfully!");
        return "success";
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public String selectOneSong(@PathVariable Integer id, ModelMap model) {
        Song song = songDaoJdbc.find(id);
        model.addAttribute("song", song);
        return "select";
    }

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String homePage(@RequestParam(value = "title", required = false) String title,
                           @RequestParam(value = "composer", required = false) String composer,
                           @RequestParam(value = "album", required = false) String albume,
                           ModelMap model) {
        songDaoJdbc.createTable();
        Map<String, String> filters = new HashMap<>();
        filters.put("title", title);
        filters.put("composer", composer);
        filters.put("album", albume);

        model.addAttribute("songs", songDaoJdbc.filter(filters));
        model.addAttribute("title", title);
        model.addAttribute("composer", composer);
        model.addAttribute("album", albume);
        return "home";
    }

    @RequestMapping(value = {"/delete/{id}"}, method = RequestMethod.GET)
    public String delete(@PathVariable Integer id, ModelMap model) {
        Song song = songDaoJdbc.find(id);
        songDaoJdbc.delete(song);
        return "redirect:/";
    }


    @RequestMapping(value = "/image/{id}", method = RequestMethod.GET)
    public void getImage(@PathVariable("id") int id, HttpServletResponse response) throws IOException {
        Song song = songDaoJdbc.findImageById(id);
        response.setContentType(song.getMimeType());
        response.setContentLength(song.getData().length);
        response.getOutputStream().write(song.getData());
        response.getOutputStream().close();
    }

    @RequestMapping(value = {"/update/{id}"}, method = RequestMethod.GET)
    public String update(@PathVariable Integer id, ModelMap model) {
        Song song = songDaoJdbc.find(id);
        model.addAttribute("song", song);
        return "update";
    }

    @RequestMapping(value = {"/update/{id}"}, method = RequestMethod.POST)
    public String updateRegistration(@Valid Song song, BindingResult result,
                                     @PathVariable Integer id, ModelMap model) {

        MultipartFile file = song.getFile();

        if (file.getSize() > MAX_FILE_SIZE) {
            fileValidator.validate(song, result);
        }
        if (result.hasErrors()) {
            return "update";
        }
        if (!file.isEmpty()) {
            if (!file.getContentType().equals("image/jpeg") && !file.getContentType().equals("image/png")
                    && !file.getContentType().equals("image/svg+xml")) {
                fileValidator.validate(song, result);
                return "update";
            }
            byte[] bytes;
            try {
                bytes = file.getBytes();
                song.setData(bytes);
                song.setMimeType(file.getContentType());
                songDaoJdbc.update(song);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            Song songDB = songDaoJdbc.findImageById(id);
            song.setData(songDB.getData());
            song.setMimeType(songDB.getMimeType());
            songDaoJdbc.update(song);
        }
        return "redirect:/{id}";
    }
}
