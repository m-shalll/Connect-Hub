
package Frontend;
import javax.swing.*;
import java.awt.*;
import Backend.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FeedWindow extends javax.swing.JFrame {

    private PostDatabase database1;
    private StoryDatabase database2;
    private AccountManagement userDatabase = new AccountManagement();;
    private ArrayList<User> users;
    private ArrayList<ContentCreation> posts;
    private ArrayList<ContentCreation> stories;
    private int postCounter = 0;
    private int storyCounter = 0;
    private User currentUser;

    public FeedWindow(User user) {
        initComponents();
        
        CustomJFrame frame = new CustomJFrame(this);
        
        database1 = PostDatabase.getInstance();
        database2 = StoryDatabase.getInstance();
        posts = database1.loadPosts();
        stories = database2.loadStories();
        try {
            users = userDatabase.loadUsers();
        } catch (IOException ex) {
            System.out.println("error" + ex.getMessage());
        }
        
        postCounter = posts.size();
        storyCounter = stories.size();
        currentUser = user;
        
        this.setLayout(null); 
        loadPosts();
        loadStories();
        jDialog1.pack();
        jDialog2.pack();
        jDialog3.pack();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jDialog2 = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jDialog3 = new javax.swing.JDialog();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        searchBar = new javax.swing.JTextField();
        Search = new javax.swing.JButton();
        notif = new javax.swing.JButton();

        jDialog1.setTitle("Create Post");

        jLabel1.setText("Enter Caption:");

        jLabel2.setText("Insert Image");

        jButton5.setText("Browse...");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Create Post");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                            .addComponent(jTextField2)))
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 328, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 306, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jDialog3.setTitle("Create Story");

        jLabel3.setText("Enter Caption: ");

        jLabel4.setText("Insert Image");

        jButton8.setText("Browse");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Create Story");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialog3Layout = new javax.swing.GroupLayout(jDialog3.getContentPane());
        jDialog3.getContentPane().setLayout(jDialog3Layout);
        jDialog3Layout.setHorizontalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog3Layout.createSequentialGroup()
                .addGroup(jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog3Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jDialog3Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jDialog3Layout.setVerticalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog3Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDialog3Layout.createSequentialGroup()
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Feed Window");

        jScrollPane1.setOpaque(false);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(jPanel1);

        jButton4.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButton4.setText("Manage Friends");
        jButton4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, new java.awt.Color(204, 204, 204), null, null));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButton3.setText("refresh");
        jButton3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, new java.awt.Color(204, 204, 204), null, null));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButton2.setText("Create Story");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, new java.awt.Color(204, 204, 204), null, null));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButton1.setText("Create Post");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, new java.awt.Color(204, 204, 204), null, null));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jList1.setBackground(new java.awt.Color(102, 102, 102));
        jList1.setBorder(null);
        jList1.setForeground(new java.awt.Color(255, 255, 255));
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.setToolTipText("");
        jScrollPane2.setViewportView(jList1);

        jButton10.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButton10.setText("View Profile");
        jButton10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, new java.awt.Color(204, 204, 204), null, null));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButton11.setText("View Story");
        jButton11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, new java.awt.Color(204, 204, 204), null, null));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButton7.setText("Notifications");
        jButton7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, new java.awt.Color(204, 204, 204), null, null));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton12.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButton12.setText("Create Group");
        jButton12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, new java.awt.Color(204, 204, 204), null, null));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        Search.setText("Search");
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });

        notif.setText("Notifications");
        notif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notifActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(notif, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton10)
                    .addComponent(jButton4)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Search))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton10)
                        .addComponent(jButton4)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton12)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(notif)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        File file = null;
        String fileName = null;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Loading File");
        int dialog = fileChooser.showSaveDialog(null);
        if (dialog == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
            fileName = file.getAbsolutePath();
        }
        if (file != null && file.exists()) {
                fileName = file.getAbsolutePath();
                jTextField2.setText(fileName);
        } 
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        Post p = (Post)ContentFactory.createContent("post");
        String s1 = jTextField1.getText();
        String s2 = jTextField2.getText();
        File file = new File(s2);
        Content content = null;
        if(s1.equals("")){
            JOptionPane.showMessageDialog(this, "No post without text");
        } else {
            if (s2.equals("")) {
                content = new Content(s1);
            } else {
                if (file != null && file.exists()) {
                    content = new Content(s2, s1);
                }
            }
            jDialog1.setVisible(false);
            p.setContent(content);
            p.setContentID(String.valueOf(postCounter++));
            p.setContentPublisher(currentUser.getUserId());
            posts.add(p);
            database1.savePosts(posts);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jDialog1.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        FeedWindow x=new FeedWindow(currentUser);
        Friends h = new Friends(x,true);
        this.setVisible(false);
        h.setVisible(true);
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        boolean canCreateStory = true;
        for (int i = 0; i < stories.size(); i++) {
            if (stories.get(i).getContentPublisher().equals(currentUser.getUserId())) {
                canCreateStory = false;
            }
        }
        if (canCreateStory) {
            jDialog3.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Cant create story, try again after present story expires!");
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        File file = null;
        String fileName = null;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Loading File");
        int dialog = fileChooser.showSaveDialog(null);
        if (dialog == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
            fileName = file.getAbsolutePath();
        }
        if (file != null && file.exists()) {
                fileName = file.getAbsolutePath();
                jTextField4.setText(fileName);
        } 
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        Story s = (Story)ContentFactory.createContent("story");
        String s1 = jTextField3.getText();
        String s2 = jTextField4.getText();
        File file = new File(s2);
        Content content = null;
        if (s1.equals("")) {
            JOptionPane.showMessageDialog(this, "No story without text");
        } else {
            if (s2.equals("")) {
                content = new Content(s1);
            } else {
                if (file != null && file.exists()) {
                    content = new Content(s2, s1);
                }
            }
            jDialog3.setVisible(false);
            s.setContent(content);
            s.setContentID(String.valueOf(storyCounter++));
            s.setContentPublisher(currentUser.getUserId());
            stories.add(s);
            database2.saveStories(stories);
        }

    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        for(int i=0; i<stories.size(); i++){
            Story story = (Story)stories.get(i);
            if(story.isPast24Hours()){
                stories.remove(stories.get(i));            
            }
        }
        loadPosts();
        loadStories();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        FeedWindow feed = this;
        ProfilePage profile = new ProfilePage(feed);
        this.setVisible(false);
        profile.setVisible(true);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        String selectedStory = jList1.getSelectedValue();
        if (selectedStory != null) {
            if (selectedStory.equals("View Your story")) {
                Story hasStory = UserStories.returnStory(currentUser);
                if (hasStory != null) {
                    StoriesPanel userStory = new StoriesPanel(currentUser);
                    jPanel2.add(userStory);
                    jDialog2.setTitle("Your story");
                    jDialog2.setVisible(true);
                } else{
                    JOptionPane.showMessageDialog(this, "Add a story first");
                }
            } else {
                User user = null;
                for (int i = 0; i < users.size(); i++) {
                    if (selectedStory.equals(users.get(i).getUserName())) {
                        user = users.get(i);
                        break;
                    }
                }
                StoriesPanel story = new StoriesPanel(user);
                jPanel2.add(story);
                jDialog2.setTitle(user.getUserName());
                jDialog2.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Select Story!");
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try {
            Notifications pannel=new Notifications();

        } catch (IOException ex) {
            Logger.getLogger(FeedWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton7ActionPerformed

    String groupName = jList2.getSelectedValue();
        if (groupName != null) {
            if (currentUser.getRoles().get(groupName).equals("AdminRole")) {
                AdminPage newPage = new AdminPage(groupName, currentUser, this);
                newPage.setVisible(true);
                this.setVisible(false);
            } else if (currentUser.getRoles().get(groupName).equals("CoAdminRole")) {
                CoAdminPage newPage = new CoAdminPage(groupName, currentUser, this);
                newPage.setVisible(true);
                this.setVisible(false);
            } else if (currentUser.getRoles().get(groupName).equals("NormalUserRole")) {
                UserPage newPage = new UserPage(groupName, currentUser, this);
                newPage.setVisible(true);
                this.setVisible(false);
            } 
        } else {
            JOptionPane.showMessageDialog(this, "choose group first");
        }   
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        jDialog4.setVisible(true);        
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        File file = null;
        String fileName = null;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Loading File");
        int dialog = fileChooser.showSaveDialog(null);
        if (dialog == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
            fileName = file.getAbsolutePath();
        }
        if (file != null && file.exists()) {
            fileName = file.getAbsolutePath();
            jTextField7.setText(fileName);
        }        
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        String name = jTextField5.getText();
        String description = jTextField6.getText();
        String filePathtoImage = jTextField7.getText();
        if(name.equals("") || description.equals("") || filePathtoImage.equals("")){
            JOptionPane.showMessageDialog(this, "Please fill empty fields");
        } else { 
            GroupInterface newGroup = new Group();
            newGroup.setName(name);
            newGroup.setAdmin(currentUser.getUserId());
            newGroup.setDescription(description);
            newGroup.setGroupPhoto(filePathtoImage);
            userGroups.addUserToGroup(currentUser.getUserId(), newGroup);
            jDialog4.setVisible(false);
            JOptionPane.showMessageDialog(this, "Group Created successfully");
            groups.add(newGroup);
            groupDatabase.saveGroups(groups);
            loadGroups();
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        results.removeAll();
        searchPannel.revalidate();
        searchPannel.repaint();
        results.setLayout(new BoxLayout(results, BoxLayout.Y_AXIS));
        String searchText = searchBar.getText().trim();
        if (searchText.isEmpty()) {
            //System.out.println("Wrong search input");
            javax.swing.JOptionPane.showMessageDialog(this,
                " Please enter Text",
                "Error",
                javax.swing.JOptionPane.ERROR_MESSAGE);
            return; // Exit early for invalid input
        }
        ArrayList<User> userFriends = new ArrayList<>();
        ArrayList<User> userNonFriends = new ArrayList<>();
        ArrayList<User> userSentFriends = new ArrayList<>();
        ArrayList<User> userRecievedFriends = new ArrayList<>();

        ArrayList<GroupInterface> inGrp = new ArrayList<>();
        ArrayList<GroupInterface> noGrp = new ArrayList<>();
        ArrayList<GroupInterface> reqForGrp = new ArrayList<>();
        FriendManagement f =LogInPannel.f;
        System.out.println(searchText);
        // Categorize users into friends and non-friends
        for (User i : users) {
            if (!i.getUserId().equals(currentUser.getUserId()) && i.getUserName().toLowerCase().contains(searchText.toLowerCase())) {
                System.out.println("11");
                System.out.println(i.getUserName()+" "+i.getUserId());
                if (i.getFriends().contains(currentUser.getUserId())) {
                    userFriends.add(i); // viewprofile block remove
                } else if (i.getFriendReq().containsKey(currentUser.getUserId())) {
                    if (i.getFriendReq().get(currentUser.getUserId()).equals("pending")) {
                        userSentFriends.add(i); // viewprofile block
                    }
                } else if (currentUser.getFriendReq().containsKey(i.getUserId())) {
                    if (currentUser.getFriendReq().get(i.getUserId()).equals("pending")) {
                        userRecievedFriends.add(i); // viewprofile block accept decline
                    }
                }
                else if (!currentUser.getBlocked().contains(i.getUserId())) {
                    System.out.println("44");
                    userNonFriends.add(i); // viewprofile block add
                }
            }

        }
        System.out.println(userFriends);
        System.out.println(userSentFriends);
        System.out.println(userRecievedFriends);
        System.out.println(userNonFriends);
        JLabel kindLabel = new JLabel("Friends:");
        kindLabel.setPreferredSize(new Dimension(200, 30));
        results.add(kindLabel);
        JSeparator fSeparator = new JSeparator();
        results.add(fSeparator, BorderLayout.SOUTH);

        //display friends
        for (User friend : userFriends) {
            if(friend==null)
            break;
            JPanel entryPanel = friendPanel(friend);
            results.add(entryPanel);
            JSeparator separator = new JSeparator();
            results.add(separator, BorderLayout.SOUTH);
        }
        //display Rec Friendreq
        for (User friend : userSentFriends) {
            if(friend==null)
            break;
            JPanel entryPanel = friendSentPanel(friend);
            results.add(entryPanel);
            JSeparator separator = new JSeparator();
            results.add(separator, BorderLayout.SOUTH);
        }
        //display sent Friendreq
        for (User friend : userRecievedFriends) {
            if(friend==null)
            break;
            JPanel entryPanel = friendRecPanel(friend);
            results.add(entryPanel);
            JSeparator separator = new JSeparator();
            results.add(separator, BorderLayout.SOUTH);
        }
        //display non-friends
        for (User nonFriend : userNonFriends) {
            if(nonFriend==null)
            break;
            JPanel entryPanel = sugPanel(nonFriend);
            results.add(entryPanel);

            JSeparator separator = new JSeparator();
            results.add(separator, BorderLayout.SOUTH);
        }
        if(userNonFriends.isEmpty()&&userRecievedFriends.isEmpty()&&userSentFriends.isEmpty()&&userFriends.isEmpty()){
            JLabel nLabel = new JLabel("No Results that match search");
            kindLabel.setPreferredSize(new Dimension(150, 30));
            results.add(nLabel);
            JSeparator gSeparator = new JSeparator();
            results.add(gSeparator, BorderLayout.SOUTH);
        }

        //categorize groups
        for(GroupInterface g:groups){
            if(g.getName().toLowerCase().contains(searchText.toLowerCase())){
                if(g.getUsers().equals(currentUser.getUserId()))
                inGrp.add(g);
                else if(g.getGroupRequests().containsKey(currentUser.getUserId())){
                    if(g.getGroupRequests().get(currentUser.getUserId()).equals("pending"))
                    reqForGrp.add(g);}
                else if(g.getGroupRequests().containsKey(currentUser.getUserId())){
                    if(!g.getGroupRequests().get(currentUser.getUserId()).equals("declined"))
                    noGrp.add(g);
                }
            }

        }
        JLabel gLabel = new JLabel("Groups:");
        kindLabel.setPreferredSize(new Dimension(150, 30));
        results.add(gLabel);
        JSeparator gSeparator = new JSeparator();
        results.add(gSeparator, BorderLayout.SOUTH);
        //Display groups user is in
        for (GroupInterface g : inGrp) {
            if(g==null)
            break;
            JPanel entryPanel = inGrpPanel(g);
            results.add(entryPanel);
            JSeparator separator = new JSeparator();
            results.add(separator, BorderLayout.SOUTH);
        }
        //Display groups user sent req for
        for (GroupInterface g : reqForGrp) {
            if(g==null)
            break;
            JPanel entryPanel = reqForGrpPanel(g);
            results.add(entryPanel);
            JSeparator separator = new JSeparator();
            results.add(separator, BorderLayout.SOUTH);
        }
        //Display groups user is not in
        for (GroupInterface g : noGrp) {
            if(g==null)
            break;
            JPanel entryPanel = noGrpPanel(g);
            results.add(entryPanel);
            JSeparator separator = new JSeparator();
            results.add(separator, BorderLayout.SOUTH);
        }
        if(noGrp.isEmpty()&&reqForGrp.isEmpty()&&inGrp.isEmpty()){
            JLabel nLabel = new JLabel("No Results that match search");
            kindLabel.setPreferredSize(new Dimension(150, 30));
            results.add(nLabel);
            JSeparator mSeparator = new JSeparator();
            results.add(mSeparator, BorderLayout.SOUTH);
        }
        searchPannel.revalidate();
        searchPannel.repaint();
        searchPannel.setTitle("Search For Users");
        searchPannel.setSize(600, 500);
        searchPannel.setLocationRelativeTo(this);
        searchPannel.setModal(true);
        searchPannel.setVisible(true);
        searchPannel.pack();

        // TODO add your handling code here:
    }//GEN-LAST:event_SearchActionPerformed

    private void notifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notifActionPerformed
try {
            FeedWindow feed = this;
            Notifications pannel=new Notifications(feed);

        } catch (IOException ex) {
            Logger.getLogger(FeedWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_notifActionPerformed
   private JPanel friendPanel(User friend) {
    JPanel panel = new JPanel();
    panel.setLayout(new FlowLayout(FlowLayout.LEFT));

    JLabel usernameLabel = new JLabel(friend.getUserName());
     usernameLabel.setPreferredSize(new Dimension(150, 30)); // Adjust dimensions as needed
    panel.add(usernameLabel);
    JLabel useridLabel = new JLabel(friend.getUserId());
    usernameLabel.setPreferredSize(new Dimension(150, 30)); // Adjust dimensions as needed
    panel.add(useridLabel);

    // Button to view the friend's profile
    JButton viewProfileButton = new JButton("View Profile");
    //Here add view Profile functionality
    /*viewProfileButton.addActionListener(e -> {
        // Code to view profile
        System.out.println("Viewing profile of: " + friend.getUsername());
        viewProfile(friend);
    });*/
    panel.add(viewProfileButton);

    // Button to block the friend
    JButton blockButton = new JButton("Block");
    panel.add(blockButton);
    blockButton.addActionListener(e -> {
                         try {
        LogInPannel.f.blockUser(currentUser, friend);
    } catch (IOException ex) {
        Logger.getLogger(Friends.class.getName()).log(Level.SEVERE, null, ex);
    }
         panel.remove(blockButton);
                          try {
            AccountManagement.saveUsers(users);
            // TODO add your handling code here:
        } catch (IOException ex) {
            Logger.getLogger(Friends.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Blocking user: " + friend.getUserName());
        //blockUser(friend);
    });
    

    // Button to remove the friend
    JButton removeButton = new JButton("Remove Friend");
    panel.add(removeButton);
    removeButton.addActionListener(e -> {
          try {
              LogInPannel.f.removeFriend(currentUser, friend);
           } catch (IOException ex) {
               Logger.getLogger(Friends.class.getName()).log(Level.SEVERE, null, ex);
           }
          panel.remove(removeButton);
           try {
            AccountManagement.saveUsers(users);
            // TODO add your handling code here:
        } catch (IOException ex) {
            Logger.getLogger(Friends.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Removing friend: " + friend.getUserName());
        
    });
    

    return panel;
}
private JPanel friendSentPanel(User friend) {
    
    JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));   
    
    JLabel usernameLabel = new JLabel(friend.getUserName());
    usernameLabel.setPreferredSize(new Dimension(150, 30));
    panel.add(usernameLabel);
    JLabel useridLabel = new JLabel(friend.getUserId());
    usernameLabel.setPreferredSize(new Dimension(150, 30)); // Adjust dimensions as needed
    panel.add(useridLabel);

    // View Prof Button
    JButton viewProfileButton = new JButton("View Profile");
    //Do view prof functionality here
    /*viewProfileButton.addActionListener(e -> {
        
        System.out.println("Viewing profile of " + friend.getUserName());
    });*/
    panel.add(viewProfileButton);

    // Decline request
    JButton cancelRequestButton = new JButton("Decline Request");
    panel.add(cancelRequestButton);
    cancelRequestButton.addActionListener(e -> {
          try {
               LogInPannel.f.declineFriendRequest(currentUser, friend);
           } catch (IOException ex) {
               Logger.getLogger(Friends.class.getName()).log(Level.SEVERE, null, ex);
           }
          panel.remove(cancelRequestButton);
           try {
            AccountManagement.saveUsers(users);
            // TODO add your handling code here:
        } catch (IOException ex) {
            Logger.getLogger(Friends.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Cancelled friend request for " + friend.getUserName());
    });
    

    
    return panel;
}
private JPanel friendRecPanel(User friend) {
    JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    
    JLabel usernameLabel = new JLabel(friend.getUserName());
    usernameLabel.setPreferredSize(new Dimension(150, 30)); // Adjust dimensions as needed
    panel.add(usernameLabel);
    JLabel useridLabel = new JLabel(friend.getUserId());
    usernameLabel.setPreferredSize(new Dimension(150, 30)); // Adjust dimensions as needed
    panel.add(useridLabel);

    //Accept button
    JButton acceptButton = new JButton("Accept");
    panel.add(acceptButton);
    acceptButton.addActionListener(e -> {
         try {
               LogInPannel.f.acceptFriendRequest(currentUser,friend);
           } catch (IOException ex) {
               Logger.getLogger(Friends.class.getName()).log(Level.SEVERE, null, ex);
           }
         panel.remove(acceptButton);
          try {
            AccountManagement.saveUsers(users);
            // TODO add your handling code here:
        } catch (IOException ex) {
            Logger.getLogger(Friends.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Accepted friend request from " + friend.getUserName());
        
    });

    // Add Decline button
    JButton declineButton = new JButton("Decline");
    panel.add(declineButton);
    declineButton.addActionListener(e -> {
        try {
               LogInPannel.f.declineFriendRequest(currentUser, friend);
           } catch (IOException ex) {
               Logger.getLogger(Friends.class.getName()).log(Level.SEVERE, null, ex);
           }
        panel.remove(declineButton);
         try {
            AccountManagement.saveUsers(users);
            // TODO add your handling code here:
        } catch (IOException ex) {
            Logger.getLogger(Friends.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Declined friend request from " + friend.getUserName());
        
    });
    panel.add(declineButton);

    // Add View Profile button
    JButton viewProfileButton = new JButton("View Profile");
    // add view prof functionality here
    /*viewProfileButton.addActionListener(e -> {
        // Handle View Profile action
        System.out.println("Viewing profile of " + friend.getUserName());
        // Add logic to display the user's profile in the UI
    });*/
    panel.add(viewProfileButton);

    return panel;
}
private JPanel sugPanel(User nonFriend) {
    JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));

    
    JLabel usernameLabel = new JLabel(nonFriend.getUserName());
    usernameLabel.setPreferredSize(new Dimension(150, 30)); // Adjust dimensions as needed
    panel.add(usernameLabel);
    JLabel useridLabel = new JLabel(nonFriend.getUserId());
    usernameLabel.setPreferredSize(new Dimension(150, 30)); // Adjust dimensions as needed
    panel.add(useridLabel);

    //Add Friend button
    JButton addFriendButton = new JButton("Add Friend");
    panel.add(addFriendButton);
    addFriendButton.addActionListener(e -> {
        
          try {
               LogInPannel.f.sendFriendRequest(currentUser, nonFriend);
           } catch (IOException ex) {
               Logger.getLogger(Friends.class.getName()).log(Level.SEVERE, null, ex);
           }
          panel.remove(addFriendButton);
         try {
            AccountManagement.saveUsers(users);
            // TODO add your handling code here:
        } catch (IOException ex) {
            Logger.getLogger(Friends.class.getName()).log(Level.SEVERE, null, ex);
        }
          FriendRequests f=new FriendRequests();
 f.setUserId(nonFriend.getUserId());
 f.setSecondUser(currentUser.getUserId());
 f.setMessage();
 NotificationManager n=new NotificationManager();
                  try {
                      n.save(n.load());
                  } catch (IOException ex) {
                      Logger.getLogger(Friends.class.getName()).log(Level.SEVERE, null, ex);
                  }
        System.out.println("Sent friend request to " + nonFriend.getUserName());
        
    });
    

    //Block button
    JButton blockButton = new JButton("Block");
    panel.add(blockButton);
    blockButton.addActionListener(e -> {
                              try {
        LogInPannel.f.blockUser(currentUser, nonFriend);
    } catch (IOException ex) {
        Logger.getLogger(Friends.class.getName()).log(Level.SEVERE, null, ex);
    }
                              panel.remove(blockButton);
                               try {
            AccountManagement.saveUsers(users);
            // TODO add your handling code here:
        } catch (IOException ex) {
            Logger.getLogger(Friends.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Blocked " + nonFriend.getUserName());
        
    });
    

    // Add View Profile button
    JButton viewProfileButton = new JButton("View Profile");
            //do view prof functionality here//
   /* viewProfileButton.addActionListener(e -> {
        // Handle View Profile action
        System.out.println("Viewing profile of " + nonFriend.getUserName());
        // Add logic to display the user's profile in the UI
    });*/
    panel.add(viewProfileButton);

    return panel;
}
private JPanel inGrpPanel(GroupInterface g){
JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));

    
    JLabel usernameLabel = new JLabel(g.getName());
    usernameLabel.setPreferredSize(new Dimension(150, 30)); 
    panel.add(usernameLabel);
   
    JButton viewGroup = new JButton("View Group");
    //add functionality here
        viewGroup.addActionListener(e -> {
    
    });
        panel.add(viewGroup);
        JButton leaveGroup = new JButton("Leave Group");
    //add functionality here
        viewGroup.addActionListener(e -> {
    
    });
        panel.add(viewGroup);

return panel;
}
private JPanel noGrpPanel(GroupInterface g){
JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));

    // Add user details
    JLabel usernameLabel = new JLabel(g.getName());
    usernameLabel.setPreferredSize(new Dimension(150, 30)); 
    panel.add(usernameLabel);
   

    //Add Friend button
    JButton viewGroup = new JButton("View Group");
    
    //add functionality here
        viewGroup.addActionListener(e -> {
    
    });
        panel.add(viewGroup);
         JButton request = new JButton("sent Request");
         panel.add(request);
    
        viewGroup.addActionListener(e -> {
         //add functionality here   
    panel.remove(request);
    });

return panel;
}
private JPanel reqForGrpPanel(GroupInterface g){
JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));

    // Add user details
    JLabel usernameLabel = new JLabel(g.getName());
    usernameLabel.setPreferredSize(new Dimension(150, 30)); 
    panel.add(usernameLabel);
   

    //Add Friend button
    JButton viewGroup = new JButton("View Group");
    //add functionality here
        viewGroup.addActionListener(e -> {
    
    });
        panel.add(viewGroup);

return panel;
}
    public void refresh(){
        for(int i=0; i<stories.size(); i++){
            Story story = (Story)stories.get(i);
            if(story.isPast24Hours()){
                stories.remove(stories.get(i));            
            }
        }
                  try {
           users=LogInPannel.manager.loadUsers();
       } catch (IOException ex) {
           Logger.getLogger(Friends.class.getName()).log(Level.SEVERE, null, ex);
       }
            try {
           currentUser=LogInPannel.manager.getUser(LogInPannel.userName, users);
           // TODO add your handling code here:
       } catch (IOException ex) {
           Logger.getLogger(Friends.class.getName()).log(Level.SEVERE, null, ex);
       }
        loadPosts();
        loadStories();
        loadGroups();
    }
    public void loadPosts(){
        ArrayList<String> friends = currentUser.getFriends();
        jPanel1.removeAll();
        posts = database1.loadPosts();
        posts.sort((e1, e2) -> e2.getTimeStamp().compareTo(e1.getTimeStamp()));
        for (int i = 0; i < posts.size(); i++) {
            for (int j = 0; j < friends.size(); j++) {
                if (posts.get(i).getContentPublisher().equals(friends.get(j))) {
                    PostsPanel postPanel = new PostsPanel((Post)posts.get(i));
                    jPanel1.add(postPanel);
                }
            }
        }
        jPanel1.revalidate();
        jPanel1.repaint();
    }
    public void loadStories(){
        ArrayList<String> friends = currentUser.getFriends();
        ArrayList<String> friendsUserNames = new ArrayList<>();
        ArrayList<String> friendsStories = new ArrayList<>();
        friendsUserNames.add("View Your story");
        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < stories.size(); j++) {
                if(stories.get(j).getContentPublisher().equals(friends.get(i))){
                    friendsStories.add(friends.get(i));
                }
            }
        }
        try {
            users = userDatabase.loadUsers();
        } catch (IOException ex) {

        }
        for (int i = 0; i < friendsStories.size(); i++) {
            for (int j = 0; j < users.size(); j++) {
                if(friendsStories.get(i).equals(users.get(j).getUserId())){
                    friendsUserNames.add(users.get(j).getUserName());
                }
            }
        }
        String[] emptyData = {};
        jList1.setListData(emptyData);
        stories = database2.loadStories();
        stories.sort((e1, e2) -> e2.getTimeStamp().compareTo(e1.getTimeStamp()));
        String[] data = new String[stories.size()];
        data = friendsUserNames.toArray(data);
        jList1.setListData(data);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JDialog jDialog3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JButton notif;
    private javax.swing.JPanel results;
    private javax.swing.JTextField searchBar;
    private javax.swing.JDialog searchPannel;
    // End of variables declaration//GEN-END:variables
}