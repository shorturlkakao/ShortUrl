package kakaopay.test.demo.enumeration;

/**
 * 다양한 서비스 지원을 위해 단축URL을 사용하는 서비스 집합
 */
public enum ServiceType {
    DEFAULT(1),
    ETC1(2),
    ETC2(3);

    private int type;

    private ServiceType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
