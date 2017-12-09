import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReportsController implements ActionListener {
   private ReportsView reportsView;
   private DataAdapter dataAdapter;
   
   public ReportsController(ReportsView reportsView, DataAdapter dataAdapter) {
        this.dataAdapter = dataAdapter;
        this.reportsView = reportsView;
        
        reportsView.getBtnSearch().addActionListener(this);
        reportsView.getBtnSortDate().addActionListener(this);
        reportsView.getBtnSortPrice().addActionListener(this);
        reportsView.getBtnSortId().addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == reportsView.getBtnSearch())
        {
            String startDate = reportsView.getTxtStartDate().getText().trim();
            String endDate = reportsView.getTxtEndDate().getText().trim();
            String report = dataAdapter.loadReport(startDate, endDate);
            reportsView.getTxtReportField().setText(report);
        }
        else if (e.getSource() == reportsView.getBtnSortDate())
        {
            String startDate = reportsView.getTxtStartDate().getText().trim();
            String endDate = reportsView.getTxtEndDate().getText().trim();
            String report = dataAdapter.sortReport(startDate, endDate, "Date");
            reportsView.getTxtReportField().setText(report);
        }
        else if (e.getSource() == reportsView.getBtnSortPrice())
        {
            String startDate = reportsView.getTxtStartDate().getText().trim();
            String endDate = reportsView.getTxtEndDate().getText().trim();
            String report = dataAdapter.sortReport(startDate, endDate, "Amount");
            reportsView.getTxtReportField().setText(report);
        }   
        else if (e.getSource() == reportsView.getBtnSortId())
        {
            String startDate = reportsView.getTxtStartDate().getText().trim();
            String endDate = reportsView.getTxtEndDate().getText().trim();
            String report = dataAdapter.loadReport(startDate, endDate);
            reportsView.getTxtReportField().setText(report);
        }
    }
}