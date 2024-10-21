public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        store.addProduct(new Electronic("Laptop", 1000.0));
        store.addProduct(new Electronic("Smartphone", 500.0));
        store.addProduct(new Electronic("Tablet", 300.0));
        store.addProduct(new Electronic("Smartwatch", 150.0));
        store.addProduct(new Accessory("Mouse", 25.0));
        store.addProduct(new Accessory("Keyboard", 45.0));
        store.addProduct(new Accessory("Headphones", 75.0));
        store.addProduct(new Accessory("Charger", 20.0));

        // Aplicar un descuento del 15%
        Discountable fifteenPercentDiscount = product -> product.getPrice() * 0.85;
        store.applyDiscount(fifteenPercentDiscount);

        // Aplicar un descuento fijo de $30
        Discountable thirtyDollarsDiscount = product -> product.getPrice() - 30.0;
        store.applyDiscount(thirtyDollarsDiscount);

        // Aplicar un descuento variable del 25% para productos electrónicos y 20% para accesorios
        Discountable variableDiscount = product -> {
            if (product instanceof Electronic) {
                return product.getPrice() * 0.75;
            } else if (product instanceof Accessory) {
                return product.getPrice() * 0.80;
            }
            return product.getPrice();
        };
        store.applyDiscount(variableDiscount);

        // Aplicar un descuento combinado: 15% y luego $10 adicionales
        Discountable combinedDiscount = product -> {
            Double discountedPrice = product.getPrice() * 0.85;
            return discountedPrice - 10.0;
        };
        store.applyDiscount(combinedDiscount);
    }
}