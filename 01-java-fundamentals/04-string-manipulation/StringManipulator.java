public class StringManipulator {
    public String trimAndConcat(String str1, String str2) {
        String str3 = str1.trim()+str2.trim();
        return str3;
    }

    public Integer getIndexOrNull(String str1, char char1) {
        Integer index = str1.indexOf(char1);
        if (index < 0) {
            index = null;
        }
        return index;
    }

    public Integer getIndexOrNull(String str1, String str2) {
        Integer index = str1.indexOf(str2);
        if (index < 0) {
            index = null;
        }
        return index;
    }

    public String concatSubString(String str1, int int1, int int2, String str2) {
        String str3 = str1.substring(int1, int2)+str2;
        return str3;
    }
}