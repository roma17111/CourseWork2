public enum Type {
    WORKED("Рабочая"),
    PERSONAL("Личная");

    private final String type;

    public String getType() {
        return type;
    }

    Type(String type) {
        this.type = type;
    }
}
