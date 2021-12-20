package properties;



public enum VerifyNavigationProperties {
    AUTOTEST_WEBSITE;

    private final static PropertyHelper propertyHelper = new PropertyHelper("properties/VerifyNavigation.properties");

    public String get() {
        return propertyHelper.get(this.name());
    }
}
