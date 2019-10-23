package befaster.solutions.CHL;

import befaster.runner.SolutionNotImplementedException;

import java.util.HashMap;
import java.util.Map;

public class CheckliteSolution {
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
                price = price + qty/3 * 130 + qty%3 * 50;
            } else if (sku.equalsIgnoreCase("B") && qty >= 2) {
                price = price + qty/2 * 45 + qty%2 * 30;
            } else {
                price = price + priceMap.get(sku) * qty;
            }
        }
        return price;
    }
}
