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
        Map<String, Integer> priceMap = getPriceMap();
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
        if (skuMap.containsKey("E") && skuMap.containsKey("B") && skuMap.get("E") >= 2) {
            Integer qtyOfE = skuMap.get("E");
            Integer qtyOfB = skuMap.get("B");
            if ( qtyOfE / 2 > qtyOfB) {
                skuMap.put("B", 0);
            } else {
                skuMap.put("B", qtyOfB - qtyOfE / 2);
            }
        }
        if (skuMap.containsKey("N") && skuMap.containsKey("M") && skuMap.get("N") >= 3) {
            Integer qtyOfN = skuMap.get("N");
            Integer qtyOfM = skuMap.get("M");
            if ( qtyOfN / 3 > qtyOfM) {
                skuMap.put("M", 0);
            } else {
                skuMap.put("M", qtyOfM - qtyOfN / 3);
            }
        }
        if (skuMap.containsKey("R") && skuMap.containsKey("Q") && skuMap.get("R") >= 3) {
            Integer qtyOfR = skuMap.get("R");
            Integer qtyOfQ = skuMap.get("Q");
            if ( qtyOfR / 3 > qtyOfQ) {
                skuMap.put("Q", 0);
            } else {
                skuMap.put("Q", qtyOfQ - qtyOfR / 3);
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
            } else if (sku.equalsIgnoreCase("F") && qty >= 3) {
                price = price + qty/3 * 20 + qty%3 * 10;

            } else if(sku.equalsIgnoreCase("H") && qty >= 5) {
                if (qty >= 10) {
                    price = price + qty/10 * 80;
                    Integer remainingQty = qty%10;
                    if (remainingQty % 5 >= 0) {
                        price = price + remainingQty/5 * 45 + remainingQty%5 * 10;
                    } else {
                        price = price + priceMap.get(sku) * remainingQty;
                    }
                } else {
                    price = price + qty/5 * 45 + qty%5 * 10;
                }
            } else if (sku.equalsIgnoreCase("K") && qty >= 2) {
                price = price + qty/2 * 150 + qty%2 * 80;
            } else if (sku.equalsIgnoreCase("P") && qty >= 5) {
                price = price + qty/5 * 200 + qty%5 * 50;
            } else if (sku.equalsIgnoreCase("Q") && qty >= 3) {
                price = price + qty/3 * 80 + qty%3 * 30;
            } else if (sku.equalsIgnoreCase("U") && qty >= 4) {
                price = price + qty/4 * 120 + qty%4 * 40;
            } else if(sku.equalsIgnoreCase("V") && qty >= 2) {
                if (qty >= 3) {
                    price = price + qty/3 * 130;
                    Integer remainingQty = qty%3;
                    if (remainingQty % 2 >= 0) {
                        price = price + remainingQty/2 * 90 + remainingQty%2 * 50;
                    } else {
                        price = price + priceMap.get(sku) * remainingQty;
                    }
                } else {
                    price = price + qty/2 * 90 + qty%2 * 50;
                }
            }
            else {
                price = price + priceMap.get(sku) * qty;
            }
        }
        return price;
    }

    private Map<String, Integer> getPriceMap() {
        Map<String, Integer> priceMap = new HashMap<>();
        priceMap.put("A", 50);
        priceMap.put("B", 30);
        priceMap.put("C", 20);
        priceMap.put("D", 15);
        priceMap.put("E", 40);
        priceMap.put("F", 10);
        priceMap.put("G", 20);
        priceMap.put("H", 10);
        priceMap.put("I", 35);
        priceMap.put("J", 60);
        priceMap.put("K", 80);
        priceMap.put("L", 90);
        priceMap.put("M", 15);
        priceMap.put("N", 40);
        priceMap.put("O", 10);
        priceMap.put("P", 50);
        priceMap.put("Q", 30);
        priceMap.put("R", 50);
        priceMap.put("S", 30);
        priceMap.put("T", 20);
        priceMap.put("U", 40);
        priceMap.put("V", 50);
        priceMap.put("W", 20);
        priceMap.put("X", 90);
        priceMap.put("Y", 10);
        priceMap.put("Z", 50);
        return priceMap;
    }
}

