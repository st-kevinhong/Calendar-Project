import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AcceptEvent {

    // 이벤트 데이터
    private Object[][] eventData = {
            {"1", "Conference", "2023-12-25", "09:00", "18:00", "Main Hall", "John", "Details"}
            // 추가
    };

    private String[] columnNames = {"Event ID", "Title", "Date", "Start", "End", "Location", "Host", "Details"};

    private JFrame frame;

    public AcceptEvent() {
        frame = new JFrame("Accept Event");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initializeUI();
        frame.pack();
        frame.setLocationRelativeTo(null); // 창을 화면 중앙에 배치
    }

    public void showWindow() {
        frame.setVisible(true);
    }

    private void initializeUI() {
        // 모델 및 테이블 생성
        JTable eventTable = new JTable(eventData, columnNames);

        // 이벤트 정보와 버튼 패널 설정
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        for (Object[] event : eventData) {
            JPanel row = new JPanel(new FlowLayout(FlowLayout.LEFT));
            row.add(new JLabel(event[1].toString())); // 이벤트 제목

            JButton acceptButton = new JButton("Accept");
            acceptButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Accept
                    JOptionPane.showMessageDialog(frame, "Invitation Accepted");
                    // UI 갱신 API
                }
            });

            JButton declineButton = new JButton("Decline");
            declineButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Decline
                    JOptionPane.showMessageDialog(frame, "Invitation Declined");
                    // UI 갱신 API
                }
            });

            row.add(acceptButton);
            row.add(declineButton);
            mainPanel.add(row);
        }

        JScrollPane scrollPane = new JScrollPane(eventTable);
        mainPanel.add(scrollPane);

        // 'Close' 버튼 추가
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                UserMenuUI.showUserMenu("User");
            }
        });
        mainPanel.add(closeButton);

        frame.add(mainPanel);
    }
}