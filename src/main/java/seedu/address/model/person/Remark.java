package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.exceptions.IllegalValueException;

/**
 * Represents a Person's remark in the address book.
 */

public class Remark {
    public static final String REMARK_CONSTRAINTS =
            "Remark should be in the format MODULENAME/MODULETYPE/NUM. Example: CS2101/SEC/2";
    public static final String REMARK_VALIDATION_REGEX = "[\\w\\.]+/[\\w\\.]+/[\\d\\.]";
    private String moduleLists;

    public Remark(String remark) throws IllegalValueException {
        requireNonNull(remark);
        String[] test = remark.split(",");
        for (String t : test) {
            if (!isValidRemark(t)) {
                System.out.println(t);
                throw new IllegalValueException(REMARK_CONSTRAINTS);
            }
        }
        this.moduleLists = remark;
    }

    /**
     * Returns true if a given string is a valid Remark.
     */
    public static boolean isValidRemark(String test) {
        return test.matches(REMARK_VALIDATION_REGEX);
    }

    /**
     * Get the moduleLists.
     */
    public String getModuleLists() {
        return moduleLists;
    }

    @Override
    public String toString() {
        return moduleLists;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Remark // instanceof handles nulls
                && this.moduleLists.equals(((Remark) other).moduleLists)); // state check
    }

    @Override
    public int hashCode() {
        return moduleLists.hashCode();
    }
}
