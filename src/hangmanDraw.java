public class hangmanDraw {
    static String drawMan =
            " _____________\n" +
                    " |/      |\n" +
                    " |/       \n" +
                    " |        \n" +
                    " |        \n" +
                    " |        \n" +
                    " |        \n" +
                    " |        \n" +
                    "========\n";

    public static String draw(int counter) {
        switch (counter) {
            case 6: return " SORRY, YOU LOST \n" +
                    "  __________\n" +
                    "     |/      |\n" +
                    "     |      (_)\n" +
                    "     |     \\|/\n" +
                    "     |       |\n" +
                    "     |      / \\\n" +
                    "     |\n" +
                    "========\n";
            case 5: return "     _________\n" +
                    "     |/      |\n" +
                    "     |      (_)\n" +
                    "     |     \\|/\n" +
                    "     |       |\n" +
                    "     |      / \n" +
                    "     |\n" +
                    "========\n";
            case 4: return "     _________\n" +
                    "     |/      |\n" +
                    "     |      (_)\n" +
                    "     |     \\|/\n" +
                    "     |       |\n" +
                    "     |         \n" +
                    "     |\n" +
                    "    _|___";
            case 3: return "     _________\n" +
                    "     |/      |\n" +
                    "     |      (_)\n" +
                    "     |      \\| \n" +
                    "     |       |\n" +
                    "     |         \n" +
                    "     |\n" +
                    "    _|___";
            case 2: return "     _________\n" +
                    "     |/      |\n" +
                    "     |      (_)\n" +
                    "     |       |\n" +
                    "     |       | \n" +
                    "     |          \n" +
                    "     |\n" +
                    "    _|___";
            case 1: return "     _________\n" +
                    "     |/      |\n" +
                    "     |      (_)\n" +
                    "     |          \n" +
                    "     |          \n" +
                    "     |          \n" +
                    "     |\n" +
                    "    _|___";
            default:
                return "     _________\n" +
                        "     |/      |\n" +
                        "     |         \n" +
                        "     |          \n" +
                        "     |          \n" +
                        "     |          \n" +
                        "     |\n" +
                        "    _|___";

        }
    }
}