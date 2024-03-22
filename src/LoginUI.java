import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;

public class LoginUI {

    private static JFrame frame; // 메인프레임

    public static void main(String[] args) {
        // 로그인 폼이자 프로젝트 진입점
        showLoginForm();
    }

    public static void showLoginForm() {
        // 프레임 생성
        frame = new JFrame("Login");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 새 패널
        JPanel panel = new JPanel(new GridBagLayout());
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(10, 10, 10, 10);

        // Title 라벨
        JLabel titleLabel = new JLabel("Family Calendar");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        panel.add(titleLabel, constraints);

        // Username 라벨
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1; // Back to 1 column
        JLabel userLabel = new JLabel("User:");
        panel.add(userLabel, constraints);

        // Username 필드
        constraints.gridx = 1;
        JTextField userText = new JTextField(20);
        panel.add(userText, constraints);

        // Password 라벨
        constraints.gridx = 0;
        constraints.gridy = 2;
        JLabel passwordLabel = new JLabel("Password:");
        panel.add(passwordLabel, constraints);

        // Password 필드
        constraints.gridx = 1;
        JPasswordField passwordText = new JPasswordField(20);
        panel.add(passwordText, constraints);

        // 로그인 버튼
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2; // Button spans across 2 columns
        constraints.anchor = GridBagConstraints.CENTER;
        JButton loginButton = new JButton("Login");
        panel.add(loginButton, constraints);

        // Register/Delete 버튼
        constraints.gridy = 4;
        JButton registerButton = new JButton("Register/Delete");
        panel.add(registerButton, constraints);

        // 로그인 버튼 리스너
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 인증 API 들어갈 자리

                frame.dispose(); // 닫기

                // 사용자 메뉴로
                UserMenuUI.showUserMenu(userText.getText());
            }
        });

        // Register/Delete 버튼 리스너
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 회원 가입/탈퇴 폼 표시
                frame.setVisible(false);
                showRegistrationForm();
            }
        });

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void showRegistrationForm() {
        // 회원 가입/탈퇴 폼을 위한 새 프레임
        JFrame regFrame = new JFrame("Register/Delete");
        regFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel regPanel = new JPanel();
        regFrame.getContentPane().add(regPanel, BorderLayout.CENTER);
        regPanel.setLayout(new GridBagLayout());

        GridBagConstraints regConstraints = new GridBagConstraints();
        regConstraints.anchor = GridBagConstraints.CENTER;
        regConstraints.insets = new Insets(10, 10, 10, 10);

        // ID 라벨 및 텍스트 필드 생성
        regConstraints.gridx = 0;
        regConstraints.gridy = 0;
        JLabel idLabel = new JLabel("ID:");
        regPanel.add(idLabel, regConstraints);

        regConstraints.gridx = 1;
        JTextField idField = new JTextField(15);
        regPanel.add(idField, regConstraints);

        // 비밀 번호 라벨 및 텍스트 필드 생성
        regConstraints.gridx = 0;
        regConstraints.gridy = 1;
        JLabel passwordLabel = new JLabel("Password:");
        regPanel.add(passwordLabel, regConstraints);

        regConstraints.gridx = 1;
        JPasswordField passwordField = new JPasswordField(15);
        regPanel.add(passwordField, regConstraints);

        // Register 버튼 생성, 리스너 할당
        regConstraints.gridx = 0;
        regConstraints.gridy = 2;
        regConstraints.gridwidth = 2; // 버튼이 두 칸을 차지하도록 조정
        regConstraints.fill = GridBagConstraints.HORIZONTAL; // 컴포넌트가 수평 공간을 모두 채우도록 설정

        JButton regButton = new JButton("Register");
        regPanel.add(regButton, regConstraints);
        regButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 쿼리 및 API 삽입 필요
                JOptionPane.showMessageDialog(regFrame, "Register Complete!");
            }
        });

        // Delete 버튼 생성, 리스너 할당
        regConstraints.gridy = 3;
        JButton delButton = new JButton("Delete");
        regPanel.add(delButton, regConstraints);
        delButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 사용자 삭제 API 필요
                JOptionPane.showMessageDialog(regFrame, "Delete Complete!");
            }
        });

        // Back 버튼 생성, 리스너 할당
        regConstraints.gridy = 4;
        JButton backButton = new JButton("Back");
        regPanel.add(backButton, regConstraints);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regFrame.dispose(); // 회원 가입/삭제 창을 닫습니다.
                frame.setVisible(true); // 로그인 폼을 다시 표시합니다.
            }
        });

        // 프레임 설정
        regFrame.pack();
        regFrame.setLocationRelativeTo(null);
        regFrame.setVisible(true);
    }
}
