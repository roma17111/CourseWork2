public enum Repeatability {


    SINGLE("Однократная"),
    DAILY("Ежедневная"),
    WEEKLY("Еженедельная"),
    MONTHLY("Еженедельная"),
    ANNUAL("Ежегодная");

    private String nameR;

    Repeatability(String nameR) {
        this.nameR = nameR;
    }

    public String getNameR() {
        return nameR;
    }
}
