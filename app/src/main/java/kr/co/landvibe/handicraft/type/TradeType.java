package kr.co.landvibe.handicraft.type;


public enum TradeType {
    SELL, SHARE, EMPTY;

    public static TradeType get(int idx) {
        switch (idx) {
            case 0:
                return SELL;
            case 1:
                return SHARE;
            default:
                return EMPTY;
        }
    }
}
