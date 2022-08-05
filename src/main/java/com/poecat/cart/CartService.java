package com.poecat.cart;

import com.poecat.order.OrderStatus;

public class CartService {

    private CartHandler cartHandler;

    CartService(CartHandler cartHandler) {
        this.cartHandler = cartHandler;
    }

    public Cart processCart(Cart cart) {
        if(cartHandler.canHandleCart(cart)) {
            cartHandler.sendToPrepare(cart);
            cart.getOrders().forEach(order -> {
                order.changeOrderStatus(OrderStatus.PREPARING);
            });
            return cart;
        } else {
            cart.getOrders().forEach(order -> {
                order.changeOrderStatus(OrderStatus.REJECTED);
            });
            return cart;
        }
    }
}
