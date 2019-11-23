package by.berdmival.bookstore.controller;

import by.berdmival.bookstore.entity.book.Genre;
import by.berdmival.bookstore.service.book.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GenreStorageController {
    @Autowired
    private GenreService genreService;

    @GetMapping(path = "/genres")
    public ResponseEntity<List<Genre>> getAllGenres() {
        return ResponseEntity.ok(genreService.findAll());
    }

    @PostMapping(path = "/genres")
    public ResponseEntity<Genre> createGenre(@RequestBody Genre genre) {
        return ResponseEntity.ok(genreService.saveOne(genre));
    }

    @PutMapping(path = "/genres/{genreId}")
    public ResponseEntity<Genre> updateGenre(@RequestBody Genre genre, @PathVariable("genreId") Long genreId) {
        genre.setId(genreId);
        return ResponseEntity.ok(genreService.saveOne(genre));
    }

    @GetMapping(path = "/genres/{genreId}")
    public ResponseEntity<Genre> getGenreById(@PathVariable("genreId") Long genreId) {
        Genre genre = genreService.findById(genreId);
        if (genre.getId() == genreId) {
            return ResponseEntity.ok(genre);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/genres/{genreId}")
    public void deleteGenreById(@PathVariable("genreId") Long genreId) {
        genreService.deleteOneById(genreId);
    }

    @DeleteMapping(path = "/genres")
    public void deleteGenre(@RequestBody Genre genre) {
        genreService.deleteOne(genre);
    }

}
