package repetitiveStuff;

/**
 * This class helps you to arrange multiple colons of Strings
 * 
 * @author Tobias Jäckle
 *
 */
public abstract class Tab {

	/**
	 * Get a String with fixed lengh (characterCount). <br>
	 * Your String, you give with, will be align right in the getting String.
	 *
	 * @param characterCount (fill of spaces + your string)
	 * @param string         (your string to align)
	 * @return String
	 */
	public static String right(int characterCount, String string) {
		int spaces = characterCount - string.length();
		String fill = new String(" ");
		for (int i = 1; i < spaces; i++) {
			fill = fill + ' ';
		}
		return (fill + string);
	}

	/**
	 * Get a String with fixed lengh (characterCount). <br>
	 * Your String, you give with, will be align left in the getting String.
	 *
	 * @param characterCount (your string + fill of spaces)
	 * @param string         (your string to align)
	 * @return String
	 */
	public static String left(int characterCount, String string) {
		int spaces = characterCount - string.length();
		String fill = new String(" ");
		for (int i = 1; i < spaces; i++) {
			fill = fill + ' ';
		}
		return (string + fill);
	}

}