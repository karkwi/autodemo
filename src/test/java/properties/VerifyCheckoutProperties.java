package properties;

public enum VerifyCheckoutProperties {
    SIZE_M_CHECKBOX,
    ACTIVE_FILTERS,
    FIRST_PRODUCT_IMG,
    QUICK_VIEW,
    ADD_QTY_BUTTON,
    ADD_TO_CART_BUTTON,
    CART_QUANTITY_COUNT,
    TOTAL_PRICE,
    PROCEED_TO_CHECKOUT_BUTTON;

    private final static PropertyHelper propertyHelper = new PropertyHelper("VerifyCheckout.properties");

    public String get() {
        return propertyHelper.get(this.name());
    }
}
