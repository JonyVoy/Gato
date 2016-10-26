/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EvDsg.controller;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;


@Named(value = "customExp")
@ViewScoped
public class CustomExp implements Serializable{

   public void preProcessPDF(Object document) throws IOException, BadElementException, DocumentException {
      
             Document pdf = (Document) document;
		pdf.setMargins(0f, 0f, 0f, 0f);
		pdf.setPageSize(PageSize.A4.rotate());
		pdf.open();
                pdf.addTitle("Reporte mensual del SEDSG");
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        String logo = externalContext.getRealPath("") + File.separator + "resources" + File.separator + "images" + File.separator + "logo1.png";
        pdf.leftMargin();
        pdf.add(Image.getInstance(logo));
    }
}
