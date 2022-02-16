package properties;



public enum VerifyNavigationProperties {
    AUTOTEST_WEBSITE,
    CLOTHES_TAB,
    WOMEN_TAB;

    private final static PropertyHelper propertyHelper = new PropertyHelper("VerifyNavigation.properties");

    public String get() {
        return propertyHelper.get(this.name());
    }
}
