package cyou.zhaojin.utility;

/**
 * @author Zhao JIN
 */
public class Pair <F, S>{
    private F first;
    private S second;

    public Pair (F f, S s) {
        this.first = f;
        this.second = s;
    }

    public F first() {
        return first;
    }

    public S second() {
        return second;
    }

    public void setFirst(F first) {
        this.first = first;
    }

    public void setSecond(S second) {
        this.second = second;
    }
}
