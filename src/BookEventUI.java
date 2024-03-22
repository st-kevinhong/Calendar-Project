import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookEventUI {
    public static void showBookingForm() {
        // Frame 설정
        JFrame frame = new JFrame("Book New Event");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 700);

        // 패널 설정
        JPanel panel = new JPanel(new GridBagLayout());
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        // Event title
        JLabel titleLabel = new JLabel("Event Title:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(titleLabel, constraints);

        JTextField titleField = new JTextField(20);
        constraints.gridx = 1;
        panel.add(titleField, constraints);

        // Location
        JLabel locationLabel = new JLabel("Location:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(locationLabel, constraints);

        JTextField locationField = new JTextField(20);
        constraints.gridx = 1;
        panel.add(locationField, constraints);

        // Date
        JLabel dateLabel = new JLabel("Date:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(dateLabel, constraints);

        JTextField dateField = new JTextField(20);
        constraints.gridx = 1;
        panel.add(dateField, constraints);

        // Start
        JLabel startLabel = new JLabel("Start:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(startLabel, constraints);

        JTextField startField = new JTextField(20);
        constraints.gridx = 1;
        panel.add(startField, constraints);

        // End
        JLabel endLabel = new JLabel("End:");
        constraints.gridx = 0;
        constraints.gridy = 4;
        panel.add(endLabel, constraints);

        JTextField endField = new JTextField(20);
        constraints.gridx = 1;
        panel.add(endField, constraints);

        // Invite Members Section
        JLabel inviteLabel = new JLabel("Invite Members:");
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 2;
        panel.add(inviteLabel, constraints);

        // 멤버 리스트 (나중에 실제 사용자 목록으로 대체 필요)
        JCheckBox member1 = new JCheckBox("Member 1");
        JCheckBox member2 = new JCheckBox("Member 2");
        // 추가 멤버

        constraints.gridy = 6;
        panel.add(member1, constraints);
        constraints.gridy = 7;
        panel.add(member2, constraints);
        // 추가 멤버들 constraints 설정

        // Description
        JLabel descriptionLabel = new JLabel("Description:");
        constraints.gridx = 0;
        constraints.gridy = 8;
        panel.add(descriptionLabel, constraints);

        JTextArea descriptionArea = new JTextArea(5, 20);
        constraints.gridx = 1;
        constraints.gridwidth = 2;
        panel.add(descriptionArea, constraints);
        descriptionArea.setLineWrap(true);

        // Host Event button
        JButton hostButton = new JButton("Host Event");
        constraints.gridx = 0;
        constraints.gridy = 9;
        constraints.gridwidth = 1;
        panel.add(hostButton, constraints);

        // Cancel button
        JButton cancelButton = new JButton("Cancel");
        constraints.gridx = 1;
        panel.add(cancelButton, constraints);

        // Button 액션
        hostButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // DB 저장 API
                JOptionPane.showMessageDialog(frame, "Created Successfully!");
                frame.dispose();  // 현재 창을 닫고,
                UserMenuUI.showUserMenu("");
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                UserMenuUI.showUserMenu("");
            }
        });

        // UI 최종 보이기
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}