/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pages;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.border.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;

/**
 *
 * @author godpo
 */
public class Dashboard extends javax.swing.JFrame {
    
    //Two different types of button hover effects & borders
    //Current user information:
    private String firstname;
    private String lastname;
    private String username;
    private String birthday;
    private String enclaveRank;

    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        initComponents();
        this.setLocationRelativeTo(null);
        String query = "SELECT * FROM currentuser";
        try {
            Statement queryStatement = DataLink.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                                                 ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = queryStatement.executeQuery(query);
            if(rs.first()){
                firstname = rs.getString("firstName");
                lastname = rs.getString("lastName");
                username = rs.getString("userName");
                birthday = rs.getString("birthDay");
                enclaveRank = rs.getString("enclaveRank");
                CurrentUser cu = new CurrentUser(firstname, lastname, username, birthday, enclaveRank);
            } else {
                System.out.println("RegisteredUser Table Currently Has No Tuple");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        initialize();
    }
    
    public Dashboard(String firstname, String lastname, String username, String birthday, String rank){
        initComponents();
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.birthday = birthday;
        this.enclaveRank = rank;
        initialize();
    }
    
    private void initialize(){
        categoriesCount();
        displayUsername.setText("Welcome: " + username + "!");
        DisplayName.setText("Your Honorable Mr/Ms/Mrs " + lastname);
        TimeAndDate.setText("Current Time: " + java.time.LocalDateTime.now().toString());
        displayUserRank.setText("Current Rank: " + enclaveRank);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                closingSequence();
            }
        });
    }
    
    private void categoriesCount(){
        Categories cur = new Categories();
        int count = cur.count();
        currentCount.setText("Count: " + count);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void closingSequence(){
        int choice = JOptionPane.showConfirmDialog(rootPane, "Do You Wish To Close This Window?", "SELECT AN OPTION:",JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION){
            try {
                Statement cleanUp = DataLink.getConnection().createStatement();
                String query = "DELETE FROM currentuser";
                cleanUp.executeUpdate(query);
            } catch (SQLException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.dispose();
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        EnclaveLogo = new javax.swing.JLabel();
        BooksBar = new javax.swing.JLabel();
        AddPub = new javax.swing.JButton();
        AboutSystem = new javax.swing.JButton();
        AddPub5 = new javax.swing.JButton();
        AddPub6 = new javax.swing.JButton();
        AddPub7 = new javax.swing.JButton();
        displayUsername = new javax.swing.JLabel();
        displayUserRank = new javax.swing.JLabel();
        DisplayName = new javax.swing.JLabel();
        CurAuthors = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        CurPublications = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        CurMembers = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        News = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        ViewButton = new javax.swing.JButton();
        currentCount = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        BrowseCatalogTitle = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        LogoutButton = new javax.swing.JButton();
        TimeAndDate = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 51, 204));

        EnclaveLogo.setIcon(new javax.swing.ImageIcon("P:\\Coding Files\\EnclaveSystem\\InformationAccess\\src\\main\\java\\VisualFiles\\MediumLogo.jpg")); // NOI18N

        BooksBar.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        BooksBar.setText("Publications:");

        AddPub.setBackground(new java.awt.Color(0, 0, 0));
        AddPub.setForeground(new java.awt.Color(255, 255, 255));
        AddPub.setText("Add A Publication");
        AddPub.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AddPubMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AddPubMouseExited(evt);
            }
        });

        AboutSystem.setBackground(new java.awt.Color(0, 0, 0));
        AboutSystem.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        AboutSystem.setForeground(new java.awt.Color(255, 255, 255));
        AboutSystem.setText("About@");
        AboutSystem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AboutSystemMouseClicked(evt);
            }
        });

        AddPub5.setBackground(new java.awt.Color(0, 0, 0));
        AddPub5.setForeground(new java.awt.Color(255, 255, 255));
        AddPub5.setText("Add A Publication");
        AddPub5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AddPub5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AddPub5MouseExited(evt);
            }
        });

        AddPub6.setBackground(new java.awt.Color(0, 0, 0));
        AddPub6.setForeground(new java.awt.Color(255, 255, 255));
        AddPub6.setText("Add A Publication");
        AddPub6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AddPub6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AddPub6MouseExited(evt);
            }
        });

        AddPub7.setBackground(new java.awt.Color(0, 0, 0));
        AddPub7.setForeground(new java.awt.Color(255, 255, 255));
        AddPub7.setText("Add A Publication");
        AddPub7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AddPub7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AddPub7MouseExited(evt);
            }
        });

        displayUsername.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        displayUsername.setForeground(new java.awt.Color(0, 255, 0));
        displayUsername.setText("Welcome ");

        displayUserRank.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        displayUserRank.setForeground(new java.awt.Color(0, 255, 0));
        displayUserRank.setText("User Rank: ");

        DisplayName.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        DisplayName.setForeground(new java.awt.Color(51, 255, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EnclaveLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(AboutSystem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BooksBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AddPub, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AddPub5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AddPub6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AddPub7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(displayUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(displayUserRank, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(DisplayName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(EnclaveLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(BooksBar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AddPub, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(AddPub7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(AddPub5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(AddPub6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(displayUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DisplayName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(displayUserRank, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(AboutSystem)
                .addGap(45, 45, 45))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 1050));

        CurAuthors.setBackground(new java.awt.Color(0, 102, 255));
        CurAuthors.setPreferredSize(new java.awt.Dimension(350, 350));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Archives:");

        javax.swing.GroupLayout CurAuthorsLayout = new javax.swing.GroupLayout(CurAuthors);
        CurAuthors.setLayout(CurAuthorsLayout);
        CurAuthorsLayout.setHorizontalGroup(
            CurAuthorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CurAuthorsLayout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(jLabel3)
                .addContainerGap(118, Short.MAX_VALUE))
        );
        CurAuthorsLayout.setVerticalGroup(
            CurAuthorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CurAuthorsLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addContainerGap(251, Short.MAX_VALUE))
        );

        getContentPane().add(CurAuthors, new org.netbeans.lib.awtextra.AbsoluteConstraints(1422, 61, -1, 300));

        CurPublications.setBackground(new java.awt.Color(102, 102, 255));
        CurPublications.setPreferredSize(new java.awt.Dimension(350, 350));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Current Publications:");

        javax.swing.GroupLayout CurPublicationsLayout = new javax.swing.GroupLayout(CurPublications);
        CurPublications.setLayout(CurPublicationsLayout);
        CurPublicationsLayout.setHorizontalGroup(
            CurPublicationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CurPublicationsLayout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(55, 55, 55))
        );
        CurPublicationsLayout.setVerticalGroup(
            CurPublicationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CurPublicationsLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addContainerGap(248, Short.MAX_VALUE))
        );

        getContentPane().add(CurPublications, new org.netbeans.lib.awtextra.AbsoluteConstraints(468, 61, -1, 300));

        CurMembers.setBackground(new java.awt.Color(0, 0, 255));
        CurMembers.setPreferredSize(new java.awt.Dimension(350, 350));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Current Members:");

        javax.swing.GroupLayout CurMembersLayout = new javax.swing.GroupLayout(CurMembers);
        CurMembers.setLayout(CurMembersLayout);
        CurMembersLayout.setHorizontalGroup(
            CurMembersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CurMembersLayout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(69, 69, 69))
        );
        CurMembersLayout.setVerticalGroup(
            CurMembersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CurMembersLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addContainerGap(248, Short.MAX_VALUE))
        );

        getContentPane().add(CurMembers, new org.netbeans.lib.awtextra.AbsoluteConstraints(934, 61, -1, 300));

        News.setBackground(new java.awt.Color(255, 153, 0));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel4.setText("Categories");

        ViewButton.setBackground(new java.awt.Color(0, 0, 0));
        ViewButton.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        ViewButton.setForeground(new java.awt.Color(0, 255, 0));
        ViewButton.setText("View");
        ViewButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ViewButtonMouseClicked(evt);
            }
        });
        ViewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewButtonActionPerformed(evt);
            }
        });

        currentCount.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        currentCount.setForeground(new java.awt.Color(0, 0, 255));
        currentCount.setText("Count:");

        javax.swing.GroupLayout NewsLayout = new javax.swing.GroupLayout(News);
        News.setLayout(NewsLayout);
        NewsLayout.setHorizontalGroup(
            NewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewsLayout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addGroup(NewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ViewButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(currentCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        NewsLayout.setVerticalGroup(
            NewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewsLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ViewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(currentCount, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(143, Short.MAX_VALUE))
        );

        getContentPane().add(News, new org.netbeans.lib.awtextra.AbsoluteConstraints(468, 456, 350, -1));

        jPanel2.setBackground(new java.awt.Color(0, 204, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 838, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(934, 529, 838, -1));

        jPanel3.setBackground(new java.awt.Color(153, 51, 255));

        BrowseCatalogTitle.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        BrowseCatalogTitle.setText("Browse Catalog:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(BrowseCatalogTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(574, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(BrowseCatalogTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(934, 456, 838, 67));

        jPanel4.setBackground(new java.awt.Color(0, 0, 255));

        LogoutButton.setBackground(new java.awt.Color(0, 0, 0));
        LogoutButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        LogoutButton.setForeground(new java.awt.Color(255, 0, 51));
        LogoutButton.setText("Log Out");
        LogoutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutButtonMouseClicked(evt);
            }
        });
        LogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutButtonActionPerformed(evt);
            }
        });

        TimeAndDate.setBackground(new java.awt.Color(0, 0, 255));
        TimeAndDate.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        TimeAndDate.setForeground(new java.awt.Color(0, 255, 0));
        TimeAndDate.setText("Current Time Is");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(TimeAndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1083, Short.MAX_VALUE)
                .addComponent(LogoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(LogoutButton, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                .addComponent(TimeAndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(359, 0, 1570, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AboutSystemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AboutSystemMouseClicked
        AboutProgram ab = new AboutProgram();
        ab.setVisible(true);
    }//GEN-LAST:event_AboutSystemMouseClicked

    private void AddPubMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddPubMouseEntered
        AddPub.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white));
    }//GEN-LAST:event_AddPubMouseEntered

    private void AddPubMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddPubMouseExited
        AddPub.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(36, 47, 42)));
    }//GEN-LAST:event_AddPubMouseExited

    private void AddPub5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddPub5MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_AddPub5MouseEntered

    private void AddPub5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddPub5MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_AddPub5MouseExited

    private void AddPub6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddPub6MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_AddPub6MouseEntered

    private void AddPub6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddPub6MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_AddPub6MouseExited

    private void AddPub7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddPub7MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_AddPub7MouseEntered

    private void AddPub7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddPub7MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_AddPub7MouseExited

    private void LogoutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutButtonMouseClicked
        int choice = JOptionPane.showConfirmDialog(rootPane, "Confirm To Log Off Of This Account?", "Logoff Confirmation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (choice == JOptionPane.OK_OPTION){
            try {
                Statement cleanUp = DataLink.getConnection().createStatement();
                String query = "DELETE FROM currentuser";
                cleanUp.executeUpdate(query);
            } catch (SQLException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.dispose();
            Login lgn = new Login();
            lgn.setVisible(true);
            lgn.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_LogoutButtonMouseClicked

    private void LogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LogoutButtonActionPerformed

    private void ViewButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewButtonMouseClicked
        
    }//GEN-LAST:event_ViewButtonMouseClicked

    private void ViewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewButtonActionPerformed
        PublicationCategories pc = new PublicationCategories();
        pc.setVisible(true);
        pc.pack();
        pc.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_ViewButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AboutSystem;
    private javax.swing.JButton AddPub;
    private javax.swing.JButton AddPub5;
    private javax.swing.JButton AddPub6;
    private javax.swing.JButton AddPub7;
    private javax.swing.JLabel BooksBar;
    private javax.swing.JLabel BrowseCatalogTitle;
    private javax.swing.JPanel CurAuthors;
    private javax.swing.JPanel CurMembers;
    private javax.swing.JPanel CurPublications;
    private javax.swing.JLabel DisplayName;
    private javax.swing.JLabel EnclaveLogo;
    private javax.swing.JButton LogoutButton;
    private javax.swing.JPanel News;
    private javax.swing.JLabel TimeAndDate;
    private javax.swing.JButton ViewButton;
    private javax.swing.JLabel currentCount;
    public javax.swing.JLabel displayUserRank;
    public javax.swing.JLabel displayUsername;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
