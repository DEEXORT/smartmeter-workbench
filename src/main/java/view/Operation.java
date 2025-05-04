package view;

public enum Operation {
    ADD_PRODUCT("Добавить продукт"),
    DELETE_PRODUCT("Удалить продукт");

    private String name;

    Operation(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
