package c_lib;

public class ShippingjList{
    static{
        System.loadLibrary("ShippingList");
    }
    //the function is defined in a c-file
    private static native double ShippingList(double[] values);

    public int get_menor_valor(double[] value){

		return (int) ShippingList(value);
    }
}
