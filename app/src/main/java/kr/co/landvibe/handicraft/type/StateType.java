package kr.co.landvibe.handicraft.type;


public enum StateType {
    NEW, NEW_FAULT, GOOD, USED, USED_FAULT, EMPTY;

    public static StateType get(int idx) {
        switch (idx) {
            case 0:
                return NEW;
            case 1:
                return NEW_FAULT;
            case 2:
                return GOOD;
            case 3:
                return USED;
            case 4:
                return USED_FAULT;
            default:
                return EMPTY;
        }
    }
}
