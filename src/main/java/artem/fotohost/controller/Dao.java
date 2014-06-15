package artem.fotohost.controller;

import artem.fotohost.model.Item;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author artem.lysenko
 */
@Named(value = "dao")
@ApplicationScoped
public class Dao implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<Item> itemList = new ArrayList<>();

    public Dao() {
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void addItem(Item item) {
        itemList.add(item);
    }

    public void deleteItem(Item item) {
        itemList.remove(item);
    }
}
