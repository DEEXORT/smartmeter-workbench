public enum SectionProduct {
    CONSUMABLE_MATERIAL("Расходные материалы"), // расходный материал
    PURCHASED_PRODUCT("Комплектующие изделия"), // покупное изделие
    PACKAGING_MATERIAL("Упаковочные материалы"),
    PRODUCT("Продукция"); // упаковочный материал

    private final String name;

    private SectionProduct(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
