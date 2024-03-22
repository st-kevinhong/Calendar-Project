import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ViewEventList {

    public static void showEventList() {
        // 프레임 생성
        JFrame frame = new JFrame("View All Events");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // 메인 프레임
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Title
        JLabel titleLabel = new JLabel("View All Events", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Event 테이블
        String[] columnNames = {"Event ID", "Title", "Date", "Time", "Location", "Description", "Participants"};
        Object[][] data = {}; // 데이터 호출하도록 변경 필요
        JTable eventTable = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(eventTable);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Back 버튼
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                UserMenuUI.showUserMenu("User"); // 실제 유저 아이디 가져와야
            }
        });

        // 패널에 Back 버튼 추가
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(backButton);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        
        frame.add(mainPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // 테스트 포인트
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                showEventList();
            }
        });
    }
}