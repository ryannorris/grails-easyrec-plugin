package grails.plugin.easyrec

/**
 * TODO
 *
 * @since 21.09.11
 * @author Igor Artamonov (http://igorartamonov.com)
 */
class EasyrecItem {

    String id
    String type
    String description
    String url
    String imageUrl

    boolean equals(o) {
        if (this.is(o)) return true;
        if (!(o instanceof EasyrecItem)) return false;

        EasyrecItem that = (EasyrecItem) o;

        if (description != that.description) return false;
        if (id != that.id) return false;
        if (imageUrl != that.imageUrl) return false;
        if (type != that.type) return false;
        if (url != that.url) return false;

        return true;
    }

    int hashCode() {
        int result;
        result = (id != null ? id.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        return result;
    }


    public String toString () {
        return "EasyrecItem{" +
        "id='" + id + '\'' +
        ", type='" + type + '\'' +
        ", description='" + description + '\'' +
        ", url='" + url + '\'' +
        ", imageUrl='" + imageUrl + '\'' +
        '}' ;
    }

}
