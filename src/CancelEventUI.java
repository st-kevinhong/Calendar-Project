import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CancelEventUI {
    public static void showCancelEventForm() {
        // 프레임 생성
        JFrame frame = new JFrame("My Event List");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // 메인 패널 설정
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // 이벤트 테이블 설정
        String[] columnNames = {"Event ID", "Title", "Date", "Start", "End", "Location", "Host"};
        Object[][] data = {};  // 데이터 호출 필요
        JTable eventTable = new JTable(data, columnNames);
        JScrollPane tableScrollPane = new JScrollPane(eventTable);
        mainPanel.add(tableScrollPane, BorderLayout.NORTH);

        // 이벤트 수정 섹션 설정
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        // 컴포넌트 추가 부분 (제목, 위치 등의 텍스트 필드)
        JLabel idLabel = new JLabel("ID to Cancel:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        formPanel.add(idLabel, constraints);

        JTextField idField = new JTextField(20);
        constraints.gridx = 1;
        formPanel.add(idField, constraints);

        // 수정/취소 버튼 설정
        JButton modifyButton = new JButton("Cancel Event");
        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // DB 수정 API 필요

                JOptionPane.showMessageDialog(frame, "Successfully Cancelled!");

                frame.dispose();
                UserMenuUI.showUserMenu("YourUsernameHere");  // 실제 사용자명으로 변경 필요
            }
        });

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                UserMenuUI.showUserMenu("YourUsernameHere");
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

        // 화면 중앙에 UI 표시
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
