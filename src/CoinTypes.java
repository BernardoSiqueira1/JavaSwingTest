public enum CoinTypes {
    US_DOLLAR(5.14f),
    CA_DOLLAR(3.94f),
    JP_YEN(0.03f);

    private float value;

    CoinTypes(float value) {
        this.value = value;
    }

    public float getValue(){
        return this.value;
    }

}
