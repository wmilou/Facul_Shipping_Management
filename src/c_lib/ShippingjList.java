package c_lib;

/* Nomes Alunos
 *  Vinicius Oliveira          RA: 72507
 *  Wedlsey Milouchine         RA: 73183
 *  Carolina Rodrigues         RA: 68097
 *  Eduardo Oliveira Batista   RA: 73026
 *  Genildo Santos             RA: 77846
 */


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
