package artframe.study.sunshine.artframe.model.bean;

import org.litepal.crud.DataSupport;

/**
 * Created by xiaofeng on 2016/12/23.
 */

public class BookBean extends DataSupport {

    public int id;
    public String author;
    public double priice;
    public int pages;
    public String name;
    public String press;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPriice() {
        return priice;
    }

    public void setPriice(double priice) {
        this.priice = priice;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    @Override
    public String toString() {
        return "BookBean{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", priice=" + priice +
                ", pages=" + pages +
                ", name='" + name + '\'' +
                ", press='" + press + '\'' +
                '}';
    }
}
