package kakaopay.test.demo.util;

public class BaseEncodeUtil {
    public enum EncodeType {
        BASE52, BASE62
    }

    static final char[] BASE52 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
    static final char[] BASE62 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();


    /**
     * BASE62 or BASE52 로 인코딩
     * @param value         인코딩 대상
     * @param encodeType    인코딩 방식({@link EncodeType})
     * @return
     */
    public static String encode(long value, EncodeType encodeType) {
        char[] BASE = null;
        switch (encodeType) {
            case BASE52:
                BASE = BASE52;
                break;
            case BASE62:
                BASE = BASE62;
                break;
            default:
                BASE = BASE52;
                break;
        }
        final StringBuilder sb = new StringBuilder();
        do {
            int i = (int) (value % BASE.length);
            sb.append(BASE[i]);
            value /= BASE.length;
        } while (value > 0);
        return sb.toString();
    }


}


