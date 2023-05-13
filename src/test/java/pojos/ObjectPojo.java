package pojos;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ObjectPojo {

    private StudentsPojo object;
    private String message;

    public ObjectPojo() {
    }

    public ObjectPojo(StudentsPojo object, String message) {
        this.object = object;
        this.message = message;
    }

    public StudentsPojo getObject() {
        return object;
    }

    public void setObject(StudentsPojo object) {
        this.object = object;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ObjectPojo{" +
                "object=" + object +
                ", message='" + message + '\'' +
                '}';
    }

}
