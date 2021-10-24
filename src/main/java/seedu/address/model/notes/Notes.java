package seedu.address.model.notes;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents the notes about an applicant in the address book.
 */
public class Notes {

    public static final Notes EMPTY_NOTES = new Notes("-NIL-");
    public static final String MESSAGE_CONSTRAINTS = "Notes should not be blank";

    public final String information;

    /**
     * Constructs a {@code Notes}.
     *
     * @param information A valid level of education.
     */
    public Notes(String information) {
        if (information.isEmpty()) {
            this.information = "-NIL-";
        } else {
            requireNonNull(information);
            checkArgument(isValidNotes(information), MESSAGE_CONSTRAINTS);
            this.information = information;
        }
    }

    /**
     * Returns true if a given string is valid information for Notes.
     *
     * @param test String to be tested.
     * @return Boolean indicating if given string is valid information for Notes.
     */
    public static boolean isValidNotes(String test) {
        return !test.isBlank();
    }

    @Override
    public String toString() {
        return information;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Notes // instanceof handles nulls
                && information.equals(((Notes) other).information)); // state check
    }

    @Override
    public int hashCode() {
        return information.hashCode();
    }
}
