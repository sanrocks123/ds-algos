/**
 * Copyright (c) @Sanjeev Saxena 2017. All Rights Reserved.
 */

package com.creditsuisse.operationsimpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

/**
 * Java Source ShoppingOperationsImpl.java created on Nov 19, 2019
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */

public class ShoppingOperationsImpl implements ShoppingOperation {

    private final ItemRepository itemRepo;
    private final List<Item> items;
    private final Map<Item, Integer> itemCountMap;

    /**
     *
     */
    public ShoppingOperationsImpl(ItemRepository itemRepo) {
        this.itemRepo = itemRepo;
        this.items = new ArrayList<>();
        this.itemCountMap = new HashMap<>();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.sanrocks.operations.ShoppingOperation#addItem(java.lang.String)
     */
    @Override
    public Item addItem(String barCode) {
        final Item i = itemRepo.getItemByCode(barCode);
        final Item newItem = new Item(i.getBarCode(), i.getName(), i.getPrice());
        items.add(newItem);
        updateItemCountMap(newItem);
        return newItem;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.sanrocks.operations.ShoppingOperation#count()
     */
    @Override
    public int count() {
        return items.size();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.sanrocks.operations.ShoppingOperation#summary()
     */
    @Override
    public void summary() {

        BigDecimal sum = new BigDecimal("0.00");
        for (final Entry<Item, Integer> entry : itemCountMap.entrySet()) {

            final BigDecimal totalItemPrice = entry.getKey().getPrice().multiply(new BigDecimal(entry.getValue()));

            // 3 x Apple @ 1.30 = 3.90
            System.out.println(entry.getValue() + " x " + entry.getKey().getName() + " @ " + entry.getKey().getPrice()
                    + " = " + totalItemPrice);
            sum = sum.add(totalItemPrice);
        }
        System.out.println("Total : " + sum.toString());
    }

    /**
     * @param newItem
     */
    private void updateItemCountMap(final Item newItem) {
        Integer value = itemCountMap.putIfAbsent(newItem, new Integer(1));
        if (Objects.nonNull(value)) {
            value++;
            itemCountMap.put(newItem, value);
        }
    }

}
