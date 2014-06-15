package artem.fotohost.controller;

import artem.fotohost.model.Item;
import java.io.IOException;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author artem.lysenko
 */
@Named(value = "adminBean")
@RequestScoped
public class AdminBean implements Serializable {

    private static final long serialVersionUID = 2L;
    private static int countOfItems;
    private String fileName;
    

    @Inject
    Dao dao;

    @Inject
    UploadInRam upload;

    private Item newItem = new Item();

    public AdminBean() {
    }

    public Item getNewItem() {        
        return newItem;
    }

    public void addNewItem() throws IOException {
        byte[] buffer = upload.getBuffer();
        fileName = upload.getFileName();
        newItem.setImageId(++countOfItems);
        newItem.setImage(buffer, fileName);
        newItem.setDate();
        dao.addItem(newItem);
    }
}