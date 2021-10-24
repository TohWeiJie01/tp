package seedu.address.model.notes;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class NotesTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Notes(null));
    }

    @Test
    public void constructor_invalidRole_throwsIllegalArgumentException() {
        String invalidNotes = "";
        assertThrows(IllegalArgumentException.class, () -> new Notes(invalidNotes));
    }

    @Test
    public void isValidRole() {
        // null role
        assertThrows(NullPointerException.class, () -> Notes.isValidNotes(null));

        // invalid roles
        assertFalse(Notes.isValidNotes("")); // empty string
        assertFalse(Notes.isValidNotes(" ")); // spaces only

        // valid roles
        assertTrue(Notes.isValidNotes("very good candidate")); // alphabets only
        assertTrue(Notes.isValidNotes("123456")); // numbers only
        assertTrue(Notes.isValidNotes("!?@%^-_|+/*")); // symbols only
        assertTrue(Notes.isValidNotes("I would 100% recommend him for the job!")); // alphanumeric characters and symbols
        assertTrue(Notes.isValidNotes("He is a very good candidate for the job and "
                + "I thoroughly recommend the interviewing panel to take extra note of "
                + "him during the interview")); // long notes
    }

}
