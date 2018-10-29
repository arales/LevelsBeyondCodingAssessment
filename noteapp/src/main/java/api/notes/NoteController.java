package api.notes;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
class NoteController {

  private final NoteRepository repository;

  private final String API_DIRECTORY = "/api/notes";

  NoteController(NoteRepository repository) {
    this.repository = repository;
  }

  /**
   * Returns all notes currently in repository.
   */
  @GetMapping(API_DIRECTORY)
  List<Note> getNotes() {
    return repository.findAll();
  }

  /**
   * POST: creates a new note and is stored in repository.
   */
  @PostMapping(API_DIRECTORY)
  Note newNote(@RequestBody Note newNote) {
    return repository.save(newNote);
  }

  /**
   * GET: returns a single note by note id.
   */
  @GetMapping(API_DIRECTORY + "/{id}")
  Note getSingleNote(@PathVariable Long id) {

    return repository.findById(id)
      .orElseThrow(() -> new NoteNotFoundException(id));
  }

  /**
   * PUT: replaces an existing note currently in the repository.
   */
  @PutMapping(API_DIRECTORY + "/{id}")
  Note replaceNote(@RequestBody Note newNote, @PathVariable Long id) {

    return repository.findById(id)
      .map(note -> {
        note.setBody(newNote.getBody());
        return repository.save(note);
      })
      .orElseGet(() -> {
        newNote.setId(id);
        return repository.save(newNote);
      });
  }

  /**
   * DELETE: removes note from repository.
   */
  @DeleteMapping(API_DIRECTORY + "/{id}")
  void deleteNote(@PathVariable Long id) {
    repository.deleteById(id);
  }

  /**
   * Returns all notes that contain the queried value 
   * and saves them to repository.
   */
  @RequestMapping(value = "API_DIRECTORY" , method = RequestMethod.GET)
  public List<Note> findByBody(@RequestParam("val") String val) {
    List<Note> notes = repository.findAll();
    System.out.println(notes.toString());
    return repository.findAll();
  }
}















