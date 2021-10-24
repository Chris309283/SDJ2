package datavisualizerwithobserver.core;

import datavisualizerwithobserver.view.barchart.BarChartViewModel;
import datavisualizerwithobserver.view.piechart.PieChartViewModel;
import datavisualizerwithobserver.view.textrepresentation.TextViewModel;

public class ViewModelFactory {

    private PieChartViewModel pieChartViewModel;
    private BarChartViewModel barChartViewModel;
    private TextViewModel textViewModel;

    public ViewModelFactory(ModelFactory mf) {
        pieChartViewModel = new PieChartViewModel(mf.getModel());
        barChartViewModel = new BarChartViewModel(mf.getModel());
        textViewModel = new TextViewModel(mf.getModel());
    }

    public PieChartViewModel getPieChartViewModel() {
        return pieChartViewModel;
    }

    public BarChartViewModel getBarChartViewModel() {
        return barChartViewModel;
    }

    public TextViewModel getTextViewModel() {
        return textViewModel;
    }
}
