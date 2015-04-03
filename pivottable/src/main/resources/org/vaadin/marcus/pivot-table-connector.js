'use strict';
window.org_vaadin_marcus_PivotTable = function () {

    var table = $(this.getElement());
    table.addClass("pivot-table");

    this.onStateChange = function () {
        var state = this.getState();
        if (state.csv) {
            var options = {};
            if (state.rows) options.rows = state.rows;
            if (state.cols) options.cols = state.cols;
            table.pivotUI($.csv.toArrays(state.csv), options);
        }
    }
};