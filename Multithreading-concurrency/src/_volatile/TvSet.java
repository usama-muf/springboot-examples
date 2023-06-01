package _volatile;

public class TvSet {

    private static volatile TvSet tvSetInstance = null;

    private TvSet() {
        System.out.println("TvSet Instanciated");
    }

    public static  TvSet getTvSetInstance() {

        if(tvSetInstance == null ) {
            synchronized (TvSet.class) {
                if(tvSetInstance == null)
                    tvSetInstance = new TvSet();
            }
        }
        return tvSetInstance;
    }
}
