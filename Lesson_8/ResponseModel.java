import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseModel {
    private Args args;
    private String data;
    private Object files;
    private Object form;
    private Headers headers;
    private Object json;
    private String url;

    // Getters and Setters
    public Args getArgs() { return args; }
    public void setArgs(Args args) { this.args = args; }

    public String getData() { return data; }
    public void setData(String data) { this.data = data; }

    public Object getFiles() { return files; }
    public void setFiles(Object files) { this.files = files; }

    public Object getForm() { return form; }
    public void setForm(Object form) { this.form = form; }

    public Headers getHeaders() { return headers; }
    public void setHeaders(Headers headers) { this.headers = headers; }

    public Object getJson() { return json; }
    public void setJson(Object json) { this.json = json; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
}

class Args {
    private String test;
    public String getTest() { return test; }
    public void setTest(String test) { this.test = test; }
}

class Headers {
    private String host;
    private String accept;
    public String getHost() { return host; }
    public void setHost(String host) { this.host = host; }
    public String getAccept() { return accept; }
    public void setAccept(String accept) { this.accept = accept; }
}
