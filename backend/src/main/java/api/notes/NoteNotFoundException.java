package api.notes;

public class NoteNotFoundException extends RuntimeException
{
  long id;

  public NoteNotFoundException(long id)
  {
    this.id = id;
  }

  public String getMessage()
  {
    return "Could not find note " + this.id + "\n";
  }
}