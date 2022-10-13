package book.enums;

/**
 * @author fanhongtao
 * 2022/10/12 15:29
 */
public enum ActionType {
    INSERT(1),
    UPDATE(2),
    DELETE(3),
    UPLOAD(4),
    LOGIN(5),
    LOGOUT(6);

    private final int value;
    ActionType(int value) {
        this.value = value;
    }
    public int value() {
        return this.value;
    }
}
