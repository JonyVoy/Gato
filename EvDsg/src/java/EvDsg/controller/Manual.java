package EvDsg.controller;

import java.io.Serializable;
import java.io.InputStream;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@Named(value = "manual")
@ViewScoped
public class Manual implements Serializable {

    private StreamedContent file;
     
    public Manual() {        
        InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/Manual_SEDSG.pdf");
        file = new DefaultStreamedContent(stream, "application/pdf" ,"Manual_SEDSG.pdf");
    }

    public StreamedContent getFile() {
        return file;
    }

    public void setFile(StreamedContent file) {
        this.file = file;
    }
 
    

}
