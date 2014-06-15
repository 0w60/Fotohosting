package artem.fotohost.model;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author artem.lysenko
 */
public class Item {

    private int imageId;
    private StreamedContent image;
    private String description = "";
    private Date date;
    private int countOfLikes = 0;
    private String comment;
    private byte[] buffer;
    private List<String> commentsList = new ArrayList<>(5);

    public Item() {

    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imgId) {
        this.imageId = imgId;
    }

    public byte[] getBuffer() {
        return buffer;
    }

    public void setBuffer(byte[] buffer) {
        this.buffer = buffer;
    }

    public StreamedContent getImage() {
        image = new DefaultStreamedContent(new ByteArrayInputStream(buffer), "image/jpeg");
        return image;
    }

    public void setImage(byte[] buff, String fileName) {
        buffer = buff;
        image = new DefaultStreamedContent(new ByteArrayInputStream(buff), "image/jpeg", fileName);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate() {
        this.date = new Date();
    }

    public int getCountOfLikes() {
        return countOfLikes;
    }

    public void addLike() {
        this.countOfLikes++;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<String> getCommentsList() {
        return commentsList;
    }

    public void addCommentToCommentsList() {
        commentsList.add(comment);
    }
}
