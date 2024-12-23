package com.Portfolio.MyPortfolio;

import java.io.IOException;
import java.util.List;

import com.Portfolio.MyPortfolio.entities.Artwork;
import com.Portfolio.MyPortfolio.repositories.ArtworkRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class SimpleController {

    private final static Logger logger = LoggerFactory.getLogger(SimpleController.class);

    @Autowired
    private ArtworkRepository artworkRepository;

    @GetMapping("/")
    public String homePage(Model model) {
        List<Artwork> artworkList = artworkRepository.findAll();
        model.addAttribute("artworkList", artworkList);
        model.addAttribute("imgUtil", new ImageUtil());
        return "index";
    }

    @GetMapping("/ui/upload")
    public String uploadPage(Model model) {
        return "upload";
    }

    @PostMapping("/uploadartwork")
    public String uploadArtwork(@RequestParam("artworkfile") MultipartFile file,
                                @RequestParam("artworkNameInput") String artworkNameInput, Model model) {
        logger.info("Upload file name=" + artworkNameInput + ", size=" + file.getSize());
        try {
            if (file != null && !file.isEmpty()) {
                logger.info("Uploading file...");
                Artwork artwork = new Artwork();
                artwork.setData(file.getBytes());
                artwork.setFileName(file.getOriginalFilename());
                artwork.setName(artworkNameInput);
                artwork.setFileType(file.getContentType());
                artworkRepository.save(artwork);
                model.addAttribute("Message", "Upload successful");
            }
        } catch (IOException e) {
            logger.error("Error happened during uploading of artwork!", e);
            model.addAttribute("Message", "Upload error happened!");
        }
        return "upload";
    }
}
