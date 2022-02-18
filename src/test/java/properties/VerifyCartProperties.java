package properties;

public enum VerifyCartProperties {

    PRODUCT_IMG,
    QUICK_VIEW,
    CART_PRODUCTS_QTY,
    CART_PRODUCTS_PRICE,
    CART_DELETE,
    CART_INFO,
    CONTINUE_SHOPPING;

    private final static PropertyHelper propertyHelper = new PropertyHelper("VerifyCart.properties");

    public String get() {
        return propertyHelper.get(this.name());
    }
}
