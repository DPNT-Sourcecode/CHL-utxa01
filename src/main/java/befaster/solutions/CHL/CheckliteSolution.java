package befaster.solutions.CHL;

import befaster.runner.SolutionNotImplementedException;

import java.util.HashMap;
import java.util.Map;

public class CheckliteSolution {
    public static void main(String[] args) {
        CheckliteSolution sol = new CheckliteSolution();
        System.out.println(sol.checklite("AAAA"));
    }
    public Integer checklite(String skus) {
        Integer price = 0;
        if (skus.isEmpty()) {
            return price;
        }
        Map<String, Integer> priceMap = new HashMap<>();
        priceMap.put("A", 50);
        priceMap.put("B", 30);
        priceMap.put("C", 20);
        priceMap.put("D", 15);
        priceMap.put("E", 40);
        String[] skusArr = skus.split("");
        Map<String, Integer> skuMap = new HashMap<>();
        for(String sku : skusArr) {
            if (!priceMap.containsKey(sku)) {
                return -1;
            }
            if (skuMap.containsKey(sku)) {
                Integer count = skuMap.get(sku);
                skuMap.put(sku, count + 1);
            } else {
                skuMap.put(sku, 1);
            }
        }
        for (String sku : skuMap.keySet()) {
            int qty = skuMap.get(sku);
            if (sku.equalsIgnoreCase("A") && qty >= 3) {
                if (qty >= 5) {
                    price = price + qty/5 * 200;
                    Integer remainingQty = qty%5;
                    if (remainingQty % 3 >= 0) {
                        price = price + remainingQty/3 * 130 + remainingQty%3 * 50;
                    } else {
                        price = price + priceMap.get(sku) * remainingQty;
                    }
                } else {
                    price = price + qty/3 * 130 + qty%3 * 50;
                }
            } else if (sku.equalsIgnoreCase("B") && qty >= 2) {
                price = price + qty/2 * 45 + qty%2 * 30;
            } else {
                price = price + priceMap.get(sku) * qty;
            }
        }
        return price;
    }
}


