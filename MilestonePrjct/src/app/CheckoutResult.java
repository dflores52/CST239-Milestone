package app;

import java.util.ArrayList;

/**
 * Represents the result of the checkout process, containing the total price and the list of items in the invoice.
 */
public class CheckoutResult {
    private double totalPrice;
    private ArrayList<SalableItem> invoice;

    /**
     * Constructs a CheckoutResult object with the given total price and invoice.
     *
     * @param totalPrice the total price of the items in the invoice
     * @param invoice    the list of items in the invoice
     */
    public CheckoutResult(double totalPrice, ArrayList<SalableItem> invoice) {
        this.totalPrice = totalPrice;
        this.invoice = invoice;
    }

    /**
     * Gets the total price of the items in the invoice.
     *
     * @return the total price
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * Gets the list of items in the invoice.
     *
     * @return the list of items in the invoice
     */
    public ArrayList<SalableItem> getInvoice() {
        return invoice;
    }
}
