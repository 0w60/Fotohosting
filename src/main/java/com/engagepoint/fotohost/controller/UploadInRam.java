package com.engagepoint.fotohost.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

@Named(value = "uploadInRam")
@RequestScoped
public class UploadInRam implements Serializable {

    private static final long serialVersionUID = 5L;
    private DefaultStreamedContent image;
    private UploadedFile file;
    private byte[] buffer;
    private String fileName;

    public UploadInRam() {
    }

    public String getFileName() {
        fileName = file.getFileName();
        return fileName;
    }

    public byte[] getBuffer() {
        return buffer;
    }

    public void makeBuffer() {
        try {
            int bufferSize = file.getInputstream().available();
            buffer = new byte[bufferSize];
            file.getInputstream().read(buffer);
        } catch (IOException ex) {
            Logger.getLogger(UploadInRam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public StreamedContent getImage() {
        return image;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public UploadedFile getFile() {
        return file;
    }
}
