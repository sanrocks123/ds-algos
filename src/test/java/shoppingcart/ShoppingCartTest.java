/**
 * Copyright (c) @Sanjeev Saxena 2017. All Rights Reserved.
 */

package shoppingcart;

import org.junit.Assert;
import org.junit.Test;

/**
 * Java Source OperationTest.java created on Nov 19, 2019
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */

public class ShoppingCartTest {

    // addItem()
    // removeItem()
    // summary()
    // printSummary()

    @Test
    public void testAddNewItemCount() {
        final ShoppingOperation shopOperation = new ShoppingOperationsImpl(new ItemTestDataRepositoryImpl());
        shopOperation.addItem("01001");
        shopOperation.addItem("01002");
        shopOperation.addItem("01003");
        shopOperation.addItem("01003");

        Assert.assertTrue(shopOperation.count() == 4);
    }

    @Test
    public void testAddNewItemSize() {
        final ShoppingOperation shopOperation = new ShoppingOperationsImpl(new ItemTestDataRepositoryImpl());
        shopOperation.addItem("01001");
        shopOperation.addItem("01001");
        shopOperation.addItem("01001");
        shopOperation.addItem("01002");
        shopOperation.addItem("01002");
        shopOperation.addItem("01002");
        shopOperation.addItem("01003");
        shopOperation.addItem("01003");
        shopOperation.addItem("01003");

        shopOperation.summary();
    }

}
