import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventDetails extends JFrame {

    public EventDetails(String eventId, String title, String date, String start, String end, String location, String host, String[] participants, String description) {
        // 기본 프레임 설정
        setTitle("Event Details");
        setSize(400, 600);
        setLayout(new BorderLayout());

        // 센터 패널에 정보 넣기
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        // 이벤트 상세 정보
        centerPanel.add(new JLabel("Event ID: " + eventId));
        centerPanel.add(new JLabel("Title: " + title));
        centerPanel.add(new JLabel("Date: " + date));
        centerPanel.add(new JLabel("Start: " + start));
        centerPanel.add(new JLabel("End: " + end));
        centerPanel.add(new JLabel("Location: " + location));
        centerPanel.add(new JLabel("Host: " + host));

        // 참가자 정보 표시
        String[] columnNames = {"Participants"};
        Object[][] data = new Object[participants.length][1];
        for (int i = 0; i < participants.length; i++) {
            data[i][0] = participants[i];
        }
        JTable participantTable = new JTable(data, columnNames);
        JScrollPane tableScrollPane = new JScrollPane(participantTable);
        centerPanel.add(tableScrollPane);

        // 이벤트 설명
        JTextArea descriptionArea = new JTextArea(5, 20);
        descriptionArea.setText(description);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setLineWrap(true);
        descriptionArea.setCaretPosition(0);
        descriptionArea.setEditable(false);
        JScrollPane descriptionScrollPane = new JScrollPane(descriptionArea);
        centerPanel.add(descriptionScrollPane);

        // 닫기 버튼
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 현재 창 닫기
                dispose();
            }
        });

        // 프레임에 컴포넌트 추가
        add(centerPanel, BorderLayout.CENTER);
        add(closeButton, BorderLayout.PAGE_END);

        // 창 설정
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
