package com.mysuperscore.controller;

import com.mysuperscore.dao.SongDAO;
import com.mysuperscore.model.Song;
import com.mysuperscore.validator.FileValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

import static com.mysuperscore.RandString.RandomString.generateString;

@Controller
@RequestMapping("/")
public class HomeController {
     @Autowired
	 SongDAO songDAO ;

    @Autowired
    FileValidator fileValidator;


    private static String UPLOADED_FOLDER = System.getProperty("user.dir") +"\\src\\main\\webapp\\resources\\uploads\\";
	private static String UPLOADED_FOLDER2 = System.getProperty("user.dir") +"\\target\\MySuperScore\\resources\\uploads\\";
    private String strAllowedCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private String newFileName = ((generateString(new Random(),strAllowedCharacters,20)) + ".jpg");

    @RequestMapping(value = { "/create"},method = RequestMethod.GET)
	public String newRegistration(ModelMap model) {
        songDAO.createTable();
		Song song = new Song();
		model.addAttribute("song", song);
		return "create";
	}

    @RequestMapping(value = { "/create"},method = RequestMethod.POST)
	public String saveRegistration(@Valid   Song song,
                                   BindingResult result, ModelMap model ) {

        MultipartFile file = song.getFile();
        fileValidator.validate(song, result);

        if (result.hasErrors()) {
            return "create";
        }

		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER + newFileName);
            Path path2 = Paths.get(UPLOADED_FOLDER2 + newFileName);
			Files.write(path, bytes);
            Files.write(path2, bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
        song.setFileName(newFileName);
		songDAO.create(song);
		model.addAttribute("success", "  " + song.getTitle()
				+ " !   Registration completed successfully and your file " + newFileName + " was loaded successfully!");
		return "success";
	}

	/*@GetMapping("/uploadStatus")
	public String uploadStatus() {
		return "uploadStatus";
	}
*/


    @RequestMapping(value = { "/products"}, method = RequestMethod.GET)
    public String productsPage(ModelMap model) {
        return "products";
    }

	/*@RequestMapping(value = { "/{id}"}, method = RequestMethod.GET)
	public String homePage(@PathVariable Integer id, ModelMap model) {

	    Song song = songDAO.find(id);

		model.addAttribute("song", song);
		return "home";
	}*/

	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
	public String homePage(ModelMap model) {

		List<Song> songs = songDAO.findAll();

		model.addAttribute("songs", songs);
		return "home";
	}




}
