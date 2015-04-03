package org.vaadin.marcus;


import com.vaadin.annotations.JavaScript;
import com.vaadin.annotations.StyleSheet;
import com.vaadin.ui.AbstractJavaScriptComponent;
import org.vaadin.marcus.client.PivotTableState;

import java.util.List;

@JavaScript({
        "jquery-1.8.3.min.js",
        "jquery-ui-1.9.2.custom.min.js",
        "jquery.csv-0.71.min.js",
        "pivot.min.js",
        "d3.v3.min.js",
        "c3.min.js",
        "pivot-table-connector.js"
})
@StyleSheet({
        "pivot.min.css",
        "c3.min.css"
})
public class PivotTable extends AbstractJavaScriptComponent {


    public void setData(String csv) {
        getState().csv = csv;
    }

    public void setData(String csv, List<String> rows, List<String> cols){
        getState().csv = csv;
        getState().rows = rows;
        getState().cols = cols;
    }

    @Override
    protected PivotTableState getState() {
        return (PivotTableState) super.getState();
    }
}
