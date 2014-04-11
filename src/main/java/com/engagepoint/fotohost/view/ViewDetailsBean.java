package com.engagepoint.fotohost.view;

import com.engagepoint.fotohost.controller.Dao;
import com.engagepoint.fotohost.controller.UploadInRam;
import com.engagepoint.fotohost.model.Item;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author artem.lysenko
 */
@Named(value = "viewDetailsBean")
@SessionScoped
public class ViewDetailsBean implements Serializable {

    private static final long serialVersionUID = 3L;

    @Inject
    Dao dao;
    @Inject
    UploadInRam upload;

    private Item selectedItem;
    private StreamedContent image;
    private StreamedContent downloadedFile;

    public ViewDetailsBean() {

    }

    public StreamedContent getDowloadedFile() {
        return downloadedFile;
    }

    public Item getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(Item selectedItem) {
        this.selectedItem = selectedItem;
    }

    public StreamedContent getImage() {
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("viewImageId");
        id = (id == null) ? "1" : id;
        int tmpId = Integer.parseInt(id);
        for (Item item : dao.getItemList()) {
            if (tmpId == item.getImageId()) {
                downloadedFile = item.getImage();
                image = item.getImage();
                return image;
            }
        }
        image = selectedItem.getImage();
        return image;
    }
}
