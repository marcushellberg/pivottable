package org.vaadin.marcus.demo;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.vaadin.ui.Upload;
import com.vaadin.ui.VerticalLayout;
import org.vaadin.marcus.PivotTable;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

@Theme("valo")
@Title("PivotTable Add-on Demo")
@SuppressWarnings("serial")
public class DemoUI extends UI
{

    private ByteArrayOutputStream tempCSV;
    private PivotTable pivotTable;

    @Override
    protected void init(VaadinRequest request) {

        final VerticalLayout layout = new VerticalLayout();
        layout.setSpacing(true);
        layout.setMargin(true);
        setContent(layout);

        Upload upload = new Upload("Upload CSV",
                new Upload.Receiver() {
                    @Override
                    public OutputStream receiveUpload(String name, String mime) {
                        tempCSV = new ByteArrayOutputStream();
                        return tempCSV;
                    }
                }
        );
        upload.setImmediate(true);

        upload.addFinishedListener(new Upload.FinishedListener() {
            @Override
            public void uploadFinished(Upload.FinishedEvent finishedEvent) {
                pivotTable.setData(tempCSV.toString());
            }
        });

        pivotTable = new PivotTable();

        layout.addComponents(upload, pivotTable);

    }
}
