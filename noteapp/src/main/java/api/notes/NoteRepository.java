/**
 * Interface extended from JpaRepository to support:
 * creating new instances, updating, deleting, 
 * and search Notes within repository.
 */

package api.notes;

import java.util.Optional;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

interface NoteRepository extends JpaRepository<Note, Long> {
  List<Note> findByBody(@Param("val") String val);
}