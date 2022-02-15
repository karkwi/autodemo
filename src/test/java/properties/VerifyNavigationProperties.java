package properties;



public enum VerifyNavigationProperties {
    AUTOTEST_WEBSITE;

    private final static PropertyHelper propertyHelper = new PropertyHelper("./src/main/properties/VerifyNavigation.properties");

    public String get() {
        return propertyHelper.get(this.name());
    }
}
