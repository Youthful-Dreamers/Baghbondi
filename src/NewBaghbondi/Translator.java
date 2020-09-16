package NewBaghbondi;

public class Translator {

    protected String getStringInBengali(String string) {
        Character[] bengaliNumber = {'০', '১', '২', '৩', '৪', '৫', '৬', '৭', '৮', '৯'};
        Character[] englishNumber = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        StringBuilder values = new StringBuilder();
        char[] character = string.toCharArray();

        for (char value : character) {
            char c = ' ';
            for (int j = 0; j < englishNumber.length; j++) {
                if (value == englishNumber[j]) {
                    c = bengaliNumber[j];
                    break;
                } else {
                    c = value;
                }
            }
            values.append(c);
        }
        return values.toString();
    }
}
