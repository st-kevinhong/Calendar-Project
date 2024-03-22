import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModifyEventUI {
    public static void showModifyEventForm() {
        // 프레임 생성
        JFrame frame = new JFrame("Modify Event Hosted by Me");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // 메인 패널 설정
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // 이벤트 테이블 설정
        String[] columnNames = {"Event ID", "Title", "Date", "Start", "End", "Location"};
        Object[][] data = {};  // 데이터베이스나 실제 데이터 소스에서 데이터를 가져와야 함.
        JTable eventTable = new JTable(data, columnNames);
        JScrollPane tableScrollPane = new JScrollPane(eventTable);
        mainPanel.add(tableScrollPane, BorderLayout.NORTH);  // 테이블 추가

        // 이벤트 수정 섹션 설정
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        // 컴포넌트 추가
        JLabel idLabel = new JLabel("ID to Modify:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        formPanel.add(idLabel, constraints);

        JTextField idField = new JTextField(20);
        constraints.gridx = 1;
        formPanel.add(idField, constraints);

        // Event Title 부분
        JLabel titleLabel = new JLabel("Event Title:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        formPanel.add(titleLabel, constraints);

        JTextField titleField = new JTextField(20);
        constraints.gridx = 1;
        formPanel.add(titleField, constraints);

        // Location 부분
        JLabel locationLabel = new JLabel("Location:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        formPanel.add(locationLabel, constraints);

        JTextField locationField = new JTextField(20);
        constraints.gridx = 1;
        formPanel.add(locationField, constraints);

        // Date 부분
        JLabel dateLabel = new JLabel("Date:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        formPanel.add(dateLabel, constraints);

        JTextField dateField = new JTextField(20);
        constraints.gridx = 1;
        formPanel.add(dateField, constraints);

        // Start Time 부분
        JLabel startTimeLabel = new JLabel("Start Time:");
        constraints.gridx = 0;
        constraints.gridy = 4;
        formPanel.add(startTimeLabel, constraints);

        JTextField startTimeField = new JTextField(20);
        constraints.gridx = 1;
        formPanel.add(startTimeField, constraints);

        // End Time 부분
        JLabel endTimeLabel = new JLabel("End Time:");
        constraints.gridx = 0;
        constraints.gridy = 5;
        formPanel.add(endTimeLabel, constraints);

        JTextField endTimeField = new JTextField(20);
        constraints.gridx = 1;
        formPanel.add(endTimeField, constraints);

        // Description 부분
        JLabel descriptionLabel = new JLabel("Description:");
        constraints.gridx = 0;
        constraints.gridy = 6;
        formPanel.add(descriptionLabel, constraints);

        JTextArea descriptionArea = new JTextArea(5, 20);
        constraints.gridx = 1;
        constraints.gridwidth = 2; // span across 2 columns
        constraints.fill = GridBagConstraints.BOTH;
        formPanel.add(new JScrollPane(descriptionArea), constraints);

        // 수정 및 취소 버튼
        JButton modifyButton = new JButton("Modify Event");
        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 수정 로직을 여기에 구현 (예: 폼 검증, 데이터베이스 업데이트 등)

                // 성공 메시지
                JOptionPane.showMessageDialog(frame, "Successfully Modified!");

                // 이 화면을 닫고 사용자 메뉴로 돌아감
                frame.dispose();
                UserMenuUI.showUserMenu("YourUsernameHere");  // 실제 사용자명으로 변경 필요
            }
        });

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 아무 작업도 수행하지 않고 사용자 메뉴로 돌아감
                frame.dispose();
                UserMenuUI.showUserMenu("YourUsernameHere");  // 실제 사용자명으로 변경 필요
            }
        });

        // 버튼 패널에 버튼 추가
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(modifyButton);
        buttonPanel.add(cancelButton);

        // 메인 패널에 폼 패널 및 버튼 패널 추가
        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // 프레임에 메인 패널 추가
        frame.getContentPane().add(mainPanel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
