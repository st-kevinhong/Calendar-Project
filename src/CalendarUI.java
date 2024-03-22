import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JCalendar;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;

public class CalendarUI {
    private static JTable eventTable;
    private static DefaultTableModel tableModel;  // 테이블 모델을 조작하기 위한 모델

    public static void createAndShowGUI() {
        // 기본 프레임 설정
        JFrame frame = new JFrame("Calendar");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);

        // 상단 캘린더 패널
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        JCalendar calendar = new JCalendar();
        topPanel.add(calendar, BorderLayout.CENTER);

        // 이벤트 테이블 설정
        String[] columnNames = {"Event ID", "Title", "Date", "Start", "End", "Location", "Host", "Details"};
        tableModel = new DefaultTableModel(null, columnNames);
        eventTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(eventTable);

        // 캘린더 날짜 선택될 시 이벤트 발생
        calendar.addPropertyChangeListener("day", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent e) {
                Date selectedDate = calendar.getDate(); // 선택한 날짜 호출
                // 선택된 날짜에 따라 이벤트 데이터 조회 및 테이블 업데이트 필요
                updateTableData(selectedDate);
            }
        });

        // 하단 버튼 패널
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        // Menu 버튼
        JButton menuButton = new JButton("Menu");
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                UserMenuUI.showUserMenu("User"); // 현재 사용자 이름/ID로 수정 필요
            }
        });

        bottomPanel.add(menuButton);

        frame.getContentPane().add(topPanel, BorderLayout.NORTH);
        frame.getContentPane().add(tableScrollPane, BorderLayout.CENTER);
        frame.getContentPane().add(bottomPanel, BorderLayout.SOUTH);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void updateTableData(Date selectedDate) {
        // 데이터 호출 API 필요 (현재는 임시)

        tableModel.setRowCount(0); // 데이터 리프레시

        // 데이터 호출 API 필요 (현재는 임시)
        Object[] rowData = new Object[]{"1", "Sample Event", selectedDate.toString(), "12:00", "14:00", "Some Place", "Somebody", "Some details"};
        tableModel.addRow(rowData);
        // 반복문으로

        // UI 갱신
        eventTable.revalidate();
        eventTable.repaint();
    }

    public static void main(String[] args) {
        // 테스트용 Main
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}