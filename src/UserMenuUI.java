import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserMenuUI {
    private static void addButton(JPanel panel, String title, JFrame frame) {
        JButton button = new JButton(title);
        panel.add(button);

        if ("Book Event".equals(title)) {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose(); // 현재 프레임 닫기
                    BookEventUI.showBookingForm(); // 새로운 UI를 열기
                }
            });
        }
        if ("Accept Event".equals(title)) {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose(); // 현재 프레임 닫기
                    AcceptEvent acceptEvent = new AcceptEvent();
                    acceptEvent.showWindow(); // 새로운 UI를 열기
                }
            });
        }
        if ("Modify Event".equals(title)) {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    ModifyEventUI.showModifyEventForm();
                }
            });
        }
        if ("Cancel Event".equals(title)) {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    CancelEventUI.showCancelEventForm();
                }
            });
        }
        if ("View Event List".equals(title)) {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    ViewEventList.showEventList();
                }
            });
        }
        if ("View Calendar".equals(title)) {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    CalendarUI.createAndShowGUI();
                }
            });
        }
        if ("Logout".equals(title)) {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    LoginUI.showLoginForm();
                }
            });
        }
    }

    public static void showUserMenu(String userName) {
        // 프레임 설정
        JFrame frame = new JFrame("User Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600); // 넓은 창을 위한 크기 설정

        // 상단 레이블
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        JLabel welcomeLabel = new JLabel("Welcome " + userName, SwingConstants.CENTER);
        topPanel.add(welcomeLabel, BorderLayout.NORTH);

        JLabel eventLabel = new JLabel("Upcoming Events", SwingConstants.CENTER);
        topPanel.add(eventLabel, BorderLayout.CENTER);

        // 표 데이터 설정 (현재는 예시 - DB 호출 필요)
        String[] columnNames = {"Event ID", "Title", "Date", "Start", "End","Location", "Host", "Details"};
        Object[][] data = {
                {"1", "Meeting", "2023-10-20", "10:00 AM", "11:30AM", "Conference Room",  "Alex", "View Details"},
        };

        JTable eventTable = new JTable(data, columnNames);
        eventTable.setPreferredScrollableViewportSize(new Dimension(500, 70));
        eventTable.setFillsViewportHeight(true);

        // Details 버튼을 위한 셀 렌더러
        TableColumn detailsColumn = eventTable.getColumn("Details");
        detailsColumn.setCellRenderer(new ButtonRenderer());
        detailsColumn.setPreferredWidth(120);

        // 클릭 이벤트 처리를 위한 마우스 어댑터
        eventTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = eventTable.rowAtPoint(e.getPoint());
                int col = eventTable.columnAtPoint(e.getPoint());
                if (col == eventTable.getColumn("Details").getModelIndex()) {
                    String eventId = eventTable.getModel().getValueAt(row, 0).toString();
                    String eventTitle = eventTable.getModel().getValueAt(row, 1).toString();
                    String eventDate = eventTable.getModel().getValueAt(row, 2).toString();
                    String eventStart = eventTable.getModel().getValueAt(row, 3).toString();
                    String eventEnd = eventTable.getModel().getValueAt(row, 4).toString();
                    String eventLocation = eventTable.getModel().getValueAt(row, 5).toString();
                    String eventHost = eventTable.getModel().getValueAt(row, 6).toString();

                    // EventDetails 창 띄우기
                    EventDetails eventDetails = new EventDetails(eventId, eventTitle, eventDate, eventStart, eventEnd, eventLocation, eventHost, new String[]{"Kevin", "Ellen"}, "Hello HYU");
                    eventDetails.setVisible(true);
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(eventTable);


        // 하단 버튼 설정
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        addButton(buttonPanel, "Book Event", frame);
        addButton(buttonPanel, "Accept Event", frame);
        addButton(buttonPanel, "Modify Event", frame);
        addButton(buttonPanel, "Cancel Event", frame);
        addButton(buttonPanel, "View Event List", frame);
        addButton(buttonPanel, "View Calendar", frame);
        addButton(buttonPanel, "Logout", frame);

        // 컴포넌트를 프레임에 추가
        frame.getContentPane().add(topPanel, BorderLayout.NORTH);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        // UI 보이기
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // 버튼 렌더러 정의
    static class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }
}
