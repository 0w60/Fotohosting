package com.engagepoint.fotohost.view;

import com.engagepoint.fotohost.controller.Dao;
import com.engagepoint.fotohost.controller.UploadInRam;
import com.engagepoint.fotohost.model.Item;
import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author artem.lysenko
 */
@Named(value = "indexBean")
@ApplicationScoped
public class IndexBean implements Serializable {

    private static final long serialVersionUID = 4L;

    @Inject
    Dao dao;
    @Inject
    UploadInRam upload;

    public IndexBean() {
    }

    public StreamedContent getImage() {
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("imageId");
        id = (id == null) ? "1" : id;
        int tmpId = Integer.parseInt(id);
        for (Item item : dao.getItemList()) {
            if (tmpId == item.getImageId()) {
                return item.getImage();
            }
        }
        return new DefaultStreamedContent(new ByteArrayInputStream(upload.getBuffer()), "image/jpeg");
    }

    public Dao getDao() {
        return dao;
    }

    public List<Item> getItems() {
        return dao.getItemList();
    }
}
