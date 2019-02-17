package my.edu.um.fsktm.cra.amazonreviewcollector.enumeration;

public enum ECommerceChannel {
    Amazon("AMZ"),Lazada("LZA"),EBay("EBY");
    private  String name;

    ECommerceChannel(String name)  {
        this.name=name;
    }

    public String toString(){
        return this.name;
    }

    public static ECommerceChannel getShortName(String shortName){
        switch (shortName){
            case "AMZ" : return ECommerceChannel.Amazon;
            case "LZA" : return ECommerceChannel.Lazada;
            case "EBY" : return ECommerceChannel.EBay;
            default: throw new IllegalArgumentException("value "+shortName+ " is not supported for channel.");
        }


    }
}
