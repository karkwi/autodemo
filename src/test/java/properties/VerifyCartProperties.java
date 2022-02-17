package properties;

public enum VerifyCartProperties {

    PRODUCT_IMG,
    CLOSE_BUTTON;

    private final static PropertyHelper propertyHelper = new PropertyHelper("VerifyNavigation.properties");

    public String get() {
        return propertyHelper.get(this.name());
    }
}
