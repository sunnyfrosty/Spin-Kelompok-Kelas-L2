import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class mainProgram extends JFrame {

    private final DefaultListModel<String> participantModel =
            new DefaultListModel<>();

    private final JList<String> participantList =
            new JList<>(participantModel);

    private final JSpinner groupSpinner =
            new JSpinner(new SpinnerNumberModel(10, 1, 50, 1));

    private final JSpinner maxMemberSpinner =
            new JSpinner(new SpinnerNumberModel(3, 1, 50, 1));

    private final JCheckBox allowExtra =
            new JCheckBox(
                    "Izinkan anggota tambahan",
                    true
            );

    private final JPanel resultPanel =
            new JPanel();

    private final Random random =
            new Random();

    public mainProgram() {
        setTitle("Group Spinner");
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initParticipants();
        initUI();
    }

    private void initParticipants() {

        String[] names = {
                "ACHMAD ATTARIVANO SYAHPUTRA",
                "EYCEL SHAZADA AL KHALIFI",
                "EVANDRA BUDI DEWATRA",
                "MUHAMMAD FATIH MAQIL ESHAN",
                "ADHA FIRDAUS KUSUMA",
                "MUHAMMAD ALVIN ALFARIZI",
                "MUHAMAD FARHAN",
                "MUHAMMAD ADE ALFIRANDA FIRDAUS",
                "JANUARI HAIKAL AL FATHIR",
                "JEFFREY LEONARDO WIJAYA",
                "M. RAFA AL-FAWWAZ",
                "ANDREAS SETIAWAN",
                "M.SOLAHUDIN AYUBI",
                "ALI AKBAR FAHLEVI",
                "MUHAMAD RAFLI",
                "M. REZALDI APRIAN",
                "MAHESWARA RASENDRYA RAHMADANI PUTRA",
                "MUHAMMAD ALKYZALIANO ILHAM",
                "MUHAMMAD RAMJI HIDAYATULLAH",
                "AHMAD FAJRI ROMADHAN",
                "AHMAD IBNU FAKHRI",
                "ANGGUN ANGGRAINI",
                "JAUZA ALYA ZAHIRA",
                "MELINDA AURELIA",
                "ZAHRA AMELIA NURYANTI",
                "DINDA AZAKIA",
                "SITI ROHANA",
                "SHAYNA WAZIRA",
                "TIARA QANITA NAJIYAH",
                "KHANSA HAURA",
                "CHERRI PRIMA ANDHINI",
                "RAFIQAH FAIRUZ",
                "UMMU FADHLA"
        };

        for (String name : names) {
            participantModel.addElement(name);
        }
    }

    private void initUI() {

        JPanel mainPanel =
                new JPanel(new BorderLayout(15, 15));

        mainPanel.setBorder(
                new EmptyBorder(15, 15, 15, 15)
        );

        JPanel leftPanel =
                new JPanel(new BorderLayout(10, 10));

        leftPanel.setPreferredSize(
                new Dimension(350, 0)
        );

        JLabel participantTitle =
                new JLabel(
                        "Daftar Peserta (" +
                                participantModel.size() +
                                ")"
                );

        participantTitle.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        18
                )
        );

        participantList.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );

        participantList.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION
        );

        JScrollPane participantScroll =
                new JScrollPane(participantList);

        JPanel editPanel =
                new JPanel(
                        new GridLayout(
                                1,
                                2,
                                5,
                                5
                        )
                );

        JButton addButton =
                new JButton("Tambah");

        JButton deleteButton =
                new JButton("Hapus");

        editPanel.add(addButton);
        editPanel.add(deleteButton);

        addButton.addActionListener(
                e -> addParticipant()
        );

        deleteButton.addActionListener(
                e -> deleteParticipant()
        );

        leftPanel.add(
                participantTitle,
                BorderLayout.NORTH
        );

        leftPanel.add(
                participantScroll,
                BorderLayout.CENTER
        );

        leftPanel.add(
                editPanel,
                BorderLayout.SOUTH
        );

        JPanel rightPanel =
                new JPanel(
                        new BorderLayout(
                                10,
                                10
                        )
                );

        JPanel settingsPanel =
                new JPanel(
                        new GridBagLayout()
                );

        settingsPanel.setBorder(
                BorderFactory.createTitledBorder(
                        "Pengaturan"
                )
        );

        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.insets =
                new Insets(5, 5, 5, 5);

        gbc.anchor =
                GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;

        settingsPanel.add(
                new JLabel(
                        "Jumlah kelompok:"
                ),
                gbc
        );

        gbc.gridx = 1;

        settingsPanel.add(
                groupSpinner,
                gbc
        );

        gbc.gridx = 0;
        gbc.gridy = 1;

        settingsPanel.add(
                new JLabel(
                        "Anggota ideal:"
                ),
                gbc
        );

        gbc.gridx = 1;

        settingsPanel.add(
                maxMemberSpinner,
                gbc
        );

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;

        settingsPanel.add(
                allowExtra,
                gbc
        );

        JButton spinButton =
                new JButton(
                        "SPIN / ACAK KELOMPOK"
                );

        spinButton.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        18
                )
        );

        spinButton.setPreferredSize(
                new Dimension(
                        300,
                        50
                )
        );

        spinButton.addActionListener(
                e -> spinGroups()
        );

        gbc.gridy = 3;
        gbc.fill =
                GridBagConstraints.HORIZONTAL;

        settingsPanel.add(
                spinButton,
                gbc
        );

        resultPanel.setLayout(
                new GridLayout(
                        0,
                        2,
                        10,
                        10
                )
        );

        JScrollPane resultScroll =
                new JScrollPane(
                        resultPanel
                );

        resultScroll.setBorder(
                BorderFactory.createTitledBorder(
                        "Hasil Pembagian"
                )
        );

        rightPanel.add(
                settingsPanel,
                BorderLayout.NORTH
        );

        rightPanel.add(
                resultScroll,
                BorderLayout.CENTER
        );

        mainPanel.add(
                leftPanel,
                BorderLayout.WEST
        );

        mainPanel.add(
                rightPanel,
                BorderLayout.CENTER
        );

        add(mainPanel);
    }

    private void addParticipant() {

        String name =
                JOptionPane.showInputDialog(
                        this,
                        "Masukkan nama peserta:"
                );

        if (name != null &&
                !name.trim().isEmpty()) {

            participantModel.addElement(
                    name.trim()
            );
        }
    }

    private void deleteParticipant() {

        int index =
                participantList.getSelectedIndex();

        if (index >= 0) {

            participantModel.remove(index);

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Pilih peserta yang ingin dihapus."
            );
        }
    }

    private void spinGroups() {

        int groupCount =
                (Integer) groupSpinner.getValue();

        int idealMembers =
                (Integer) maxMemberSpinner.getValue();

        List<String> participants =
                new ArrayList<>();

        for (int i = 0;
             i < participantModel.size();
             i++) {

            participants.add(
                    participantModel.getElementAt(i)
            );
        }

        if (participants.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Tidak ada peserta."
            );

            return;
        }

        int totalParticipants =
                participants.size();

        int minimumMembers =
                totalParticipants / groupCount;

        int remainder =
                totalParticipants % groupCount;

        int maximumMembers =
                minimumMembers;

        if (remainder > 0) {
            maximumMembers++;
        }

        if (!allowExtra.isSelected() &&
                maximumMembers > idealMembers) {

            JOptionPane.showMessageDialog(
                    this,
                    "Peserta tidak dapat dibagi rata " +
                            "tanpa anggota tambahan.\n\n" +

                            "Peserta: " +
                            totalParticipants + "\n" +

                            "Kelompok: " +
                            groupCount + "\n" +

                            "Anggota ideal: " +
                            idealMembers + "\n\n" +

                            "Aktifkan \"Izinkan anggota tambahan\" " +
                            "atau tambah jumlah kelompok."
            );

            return;
        }

        Collections.shuffle(
                participants,
                random
        );

        List<Integer> groupSizes =
                new ArrayList<>();

        for (int i = 0;
             i < groupCount;
             i++) {

            int size =
                    minimumMembers;

            if (i < remainder) {
                size++;
            }

            groupSizes.add(size);
        }

        /*
         * Acak kelompok mana yang mendapat
         * anggota tambahan.
         */
        Collections.shuffle(
                groupSizes,
                random
        );

        List<List<String>> groups =
                new ArrayList<>();

        int participantIndex = 0;

        for (int i = 0;
             i < groupCount;
             i++) {

            List<String> group =
                    new ArrayList<>();

            int targetSize =
                    groupSizes.get(i);

            for (int j = 0;
                 j < targetSize;
                 j++) {

                if (participantIndex <
                        participants.size()) {

                    group.add(
                            participants.get(
                                    participantIndex
                            )
                    );

                    participantIndex++;
                }
            }

            groups.add(group);
        }

        displayGroups(groups);
    }

    private void displayGroups(
            List<List<String>> groups
    ) {

        resultPanel.removeAll();

        for (int i = 0;
             i < groups.size();
             i++) {

            List<String> group =
                    groups.get(i);

            JPanel card =
                    new JPanel(
                            new BorderLayout(
                                    5,
                                    5
                            )
                    );

            card.setBorder(
                    BorderFactory.createCompoundBorder(
                            BorderFactory.createLineBorder(
                                    Color.GRAY,
                                    1
                            ),
                            new EmptyBorder(
                                    10,
                                    10,
                                    10,
                                    10
                            )
                    )
            );

            JLabel title =
                    new JLabel(
                            "KELOMPOK " +
                                    (i + 1) +
                                    " (" +
                                    group.size() +
                                    " orang)"
                    );

            title.setFont(
                    new Font(
                            "Arial",
                            Font.BOLD,
                            16
                    )
            );

            JTextArea members =
                    new JTextArea();

            members.setEditable(false);

            members.setFont(
                    new Font(
                            "Arial",
                            Font.PLAIN,
                            13
                    )
            );

            StringBuilder text =
                    new StringBuilder();

            for (int j = 0;
                 j < group.size();
                 j++) {

                text.append(j + 1)
                        .append(". ")
                        .append(group.get(j))
                        .append("\n");
            }

            members.setText(
                    text.toString()
            );

            card.add(
                    title,
                    BorderLayout.NORTH
            );

            card.add(
                    new JScrollPane(members),
                    BorderLayout.CENTER
            );

            resultPanel.add(card);
        }

        resultPanel.revalidate();
        resultPanel.repaint();
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            try {

                UIManager.setLookAndFeel(
                        UIManager.getSystemLookAndFeelClassName()
                );

            } catch (Exception ignored) {
            }

            mainProgram app =
                    new mainProgram();

            app.setVisible(true);
        });
    }
}
