
import java.util.ArrayList;
import java.util.HashMap;

public class GetOneSecondHalfPrice extends Deal{


    private HashMap<Product,Integer> findQuantity(ArrayList<Product> products)
    {
        HashMap<Product,Integer> quantity = new HashMap<Product,Integer>();
        int i=0;
        if(products.size() >= 3) i = 3;
        for(;i< products.size();i++)
        {
            quantity.putIfAbsent(products.get(i), 0);
            quantity.put(products.get(i), quantity.get(products.get(i)) + 1);
        }
        return quantity;
    }

    @Override
    public int apply(int currentPrice,ArrayList<Product> products) {
        HashMap<Product,Integer> quantity = findQuantity(products);
        int promotion = 0;
        for (Product i : quantity.keySet()) {
            promotion += quantity.get(i)/2*i.getPrice()/2;
        }
        return currentPrice - promotion;
    }
}

