package mainpkg;

import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Jasper
 */
public class ProductFXProperty {
    SimpleStringProperty name;
    SimpleIntegerProperty quantity, vatRate;
    SimpleFloatProperty price, orgPrice;

    public ProductFXProperty(String name, int quantity, int vatRate, float orgPrice) {
        this.name = new SimpleStringProperty(name);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.vatRate = new SimpleIntegerProperty(vatRate);
        this.orgPrice = new SimpleFloatProperty(orgPrice);
        this.price.bind(Bindings.multiply(orgPrice, this.quantity));
    }

    public SimpleStringProperty getName() {
        return name;
    }

    public SimpleIntegerProperty getQuantity() {
        return quantity;
    }

    public SimpleIntegerProperty getVatRate() {
        return vatRate;
    }

    public SimpleFloatProperty getPrice() {
        return price;
    }

    public SimpleFloatProperty getOrgPrice() {
        return orgPrice;
    }

    public void setName(SimpleStringProperty name) {
        this.name = name;
    }

    public void setQuantity(SimpleIntegerProperty quantity) {
        this.quantity = quantity;
    }

    public void setVatRate(SimpleIntegerProperty vatRate) {
        this.vatRate = vatRate;
    }

    public void setPrice(SimpleFloatProperty price) {
        this.price = price;
    }

    public void setOrgPrice(SimpleFloatProperty orgPrice) {
        this.orgPrice = orgPrice;
    }
    
}
