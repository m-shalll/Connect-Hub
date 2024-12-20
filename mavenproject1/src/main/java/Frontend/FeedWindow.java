package Frontend;

import javax.swing.*;
import Backend.*;
import Backend.PostInteraction.InteractionFactory;
import Backend.PostInteraction.Like;
import Backend.PostInteraction.PostInteractionManagement;
import Backend.notifications.Notification;
import Backend.notifications.NotificationRefresher;
import Chatting_System.*;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.swing.FontIcon;

import java.awt.Color;

import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.Image;


public class FeedWindow extends javax.swing.JFrame {

    private UserGroupsInterface userGroups;

    private PostDatabase database1;
    private StoryDatabase database2;
    private AccountManagement userDatabase;
    private GroupManagement groupDatabase;

    private ArrayList<User> users;
    private ArrayList<ContentCreation> posts;
    private ArrayList<ContentCreation> stories;
    private ArrayList<GroupInterface> groups;

    private int postCounter = 0;
    private int storyCounter = 0;

    private User currentUser;
    private Chat currentChat;
    
    public static ArrayList<Notification> notificationList;

    public FeedWindow(User user) {
        initComponents();

        CustomJFrame frame = new CustomJFrame(this);

        userDatabase = AccountManagement.getInstance();
        database1 = PostDatabase.getInstance();
        database2 = StoryDatabase.getInstance();
        groupDatabase = GroupManagement.getInstance();

        posts = database1.loadPosts();
        stories = database2.loadStories();
        try {
            users = userDatabase.loadUsers();
        } catch (IOException ex) {
            System.out.println("error" + ex.getMessage());
        }
        groups = groupDatabase.loadGroups();

        postCounter = posts.size();
        storyCounter = stories.size();
        currentUser = user;
        userGroups = new UserGroups();

        this.setLayout(null);
        refresh();
        jDialog1.pack();
        jDialog2.pack();
        jDialog3.pack();
        jDialog4.pack();
        friends.pack();
        chat.pack();
        postInteract.pack();
        FontIcon sendIcon = FontIcon.of(FontAwesomeSolid.PAPER_PLANE, 20, Color.WHITE);
        send.setIcon(sendIcon);
        NotificationRefresher refresher = new NotificationRefresher();
        Thread refresherThread = new Thread(refresher);
        refresherThread.start();
        this.notificationList=refresher.getNotifications();
    }

    public void LoadGroupSuggestions() {
        String[] emptyData = {};
        RequestList.setListData(emptyData);
        ArrayList<String> friends = currentUser.getFriends();
        ArrayList<String> groupNames = new ArrayList<>();
        for (String friend : friends) {
            try {
                User friendUser = userDatabase.getUser(friend);
                Map<String, String> groupRoles = friendUser.getRoles();
                for (String key : groupRoles.keySet()) {
                    if (!groupNames.contains(key)) {
                        groupNames.add(key);
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(FeedWindow.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        String[] data = new String[groupNames.size()];
        data = groupNames.toArray(data);
        RequestList.setListData(data);

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
        jDialog4 = new javax.swing.JDialog();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        friends = new javax.swing.JDialog();
        friendPanel = new javax.swing.JPanel();
        chat = new javax.swing.JDialog();
        chatPane = new javax.swing.JScrollPane();
        chatPanel = new javax.swing.JPanel();
        textMsg = new javax.swing.JTextField();
        send = new javax.swing.JButton();
        introPanel = new javax.swing.JPanel();
        postInteract = new javax.swing.JDialog();
        jScrollPane5 = new javax.swing.JScrollPane();
        postList = new javax.swing.JList<>();
        jLabel8 = new javax.swing.JLabel();
        likeButton = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
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
        jScrollPane3 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jButton7 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        RequestList = new javax.swing.JList<>();
        jSeparator1 = new javax.swing.JSeparator();
        jButton15 = new javax.swing.JButton();
        notifications = new javax.swing.JButton();
        Chat = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();

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

        jDialog4.setTitle("Create Group");

        jLabel5.setText("Name");

        jLabel6.setText("Description");

        jLabel7.setText("Group Photo");

        jButton13.setText("Create Group");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setText("Browse...");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialog4Layout = new javax.swing.GroupLayout(jDialog4.getContentPane());
        jDialog4.getContentPane().setLayout(jDialog4Layout);
        jDialog4Layout.setHorizontalGroup(
            jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog4Layout.createSequentialGroup()
                .addGroup(jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog4Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jDialog4Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jDialog4Layout.createSequentialGroup()
                                .addGroup(jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                    .addComponent(jTextField6)
                                    .addComponent(jTextField7)))))
                    .addGroup(jDialog4Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jDialog4Layout.setVerticalGroup(
            jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton14)
                .addGap(18, 18, 18)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        friends.setTitle("Chat with Friends");

        javax.swing.GroupLayout friendPanelLayout = new javax.swing.GroupLayout(friendPanel);
        friendPanel.setLayout(friendPanelLayout);
        friendPanelLayout.setHorizontalGroup(
            friendPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 388, Short.MAX_VALUE)
        );
        friendPanelLayout.setVerticalGroup(
            friendPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 288, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout friendsLayout = new javax.swing.GroupLayout(friends.getContentPane());
        friends.getContentPane().setLayout(friendsLayout);
        friendsLayout.setHorizontalGroup(
            friendsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(friendsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(friendPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        friendsLayout.setVerticalGroup(
            friendsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, friendsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(friendPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        chat.setTitle("Chat");

        javax.swing.GroupLayout chatPanelLayout = new javax.swing.GroupLayout(chatPanel);
        chatPanel.setLayout(chatPanelLayout);
        chatPanelLayout.setHorizontalGroup(
            chatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 548, Short.MAX_VALUE)
        );
        chatPanelLayout.setVerticalGroup(
            chatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 323, Short.MAX_VALUE)
        );

        chatPane.setViewportView(chatPanel);

        send.setText("Send");
        send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout introPanelLayout = new javax.swing.GroupLayout(introPanel);
        introPanel.setLayout(introPanelLayout);
        introPanelLayout.setHorizontalGroup(
            introPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        introPanelLayout.setVerticalGroup(
            introPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 49, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout chatLayout = new javax.swing.GroupLayout(chat.getContentPane());
        chat.getContentPane().setLayout(chatLayout);
        chatLayout.setHorizontalGroup(
            chatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chatLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(textMsg)
                .addGap(18, 18, 18)
                .addComponent(send)
                .addGap(16, 16, 16))
            .addComponent(chatPane)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(introPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        chatLayout.setVerticalGroup(
            chatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chatLayout.createSequentialGroup()
                .addComponent(introPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chatPane, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(chatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(send, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        postList.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane5.setViewportView(postList);

        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Posts");

        likeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                likeButtonActionPerformed(evt);
            }
        });

        jButton18.setText("Comment");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout postInteractLayout = new javax.swing.GroupLayout(postInteract.getContentPane());
        postInteract.getContentPane().setLayout(postInteractLayout);
        postInteractLayout.setHorizontalGroup(
            postInteractLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(postInteractLayout.createSequentialGroup()
                .addGroup(postInteractLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(postInteractLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(postInteractLayout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(postInteractLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(likeButton)
                        .addGap(39, 39, 39)
                        .addComponent(jButton18)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        postInteractLayout.setVerticalGroup(
            postInteractLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(postInteractLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(postInteractLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(likeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton18))
                .addContainerGap(62, Short.MAX_VALUE))
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

        jList2.setBackground(new java.awt.Color(102, 102, 102));
        jList2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(jList2);

        jButton7.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButton7.setText("View Group");
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

        RequestList.setBackground(new java.awt.Color(102, 102, 102));
        RequestList.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane4.setViewportView(RequestList);

        jSeparator1.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jButton15.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButton15.setText("Send Request");
        jButton15.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, new java.awt.Color(204, 204, 204), null, null));
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        notifications.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        notifications.setText("Notifications");
        notifications.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, new java.awt.Color(204, 204, 204), null, null));
        notifications.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notificationsActionPerformed(evt);
            }
        });

        Chat.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        Chat.setText("Chats");
        Chat.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, new java.awt.Color(204, 204, 204), null, null));
        Chat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChatActionPerformed(evt);
            }
        });

        jButton16.setText("Choose Post");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(notifications, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Chat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(jButton16)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton10)
                            .addComponent(jButton4)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton12)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(notifications)
                            .addComponent(Chat))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton11)
                                    .addComponent(jButton2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        Post p = (Post) ContentFactory.createContent("post");
        String s1 = jTextField1.getText();
        String s2 = jTextField2.getText();
        File file = new File(s2);
        Content content = null;
        if (s1.equals("")) {
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
        FeedWindow x = new FeedWindow(currentUser);
        Friends h = new Friends(x, true);
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
        Story s = (Story) ContentFactory.createContent("story");
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
        refresh();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        FeedWindow feed = this;
        ProfilePage profile = new ProfilePage(currentUser, feed);
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
                } else {
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
        if (name.equals("") || description.equals("") || filePathtoImage.equals("")) {
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

            Map<String, String> role = currentUser.getRoles();
            role.put(name, "AdminRole");
            currentUser.setRoles(role);
            try {
                users = userDatabase.loadUsers();
            } catch (IOException ex) {

            }
            for (int i = 0; i < users.size(); i++) {
                if (currentUser.getUserId().equals(users.get(i).getUserId())) {
                    users.get(i).setRoles(role);
                    break;
                }
            }
            try {
                AccountManagement.saveUsers(users);
            } catch (IOException ex) {

            }
            loadGroups();
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        String groupName = RequestList.getSelectedValue();
        if (groupName != null) {
            GroupInterface currentGroup = userGroups.returnGroup(groupName);
            Map<String, String> requests = currentGroup.getGroupRequests();
            requests.put(currentUser.getUserId(), "pending");
            JOptionPane.showMessageDialog(this, "Request Sent Successfully!");
            currentGroup.setGroupRequests(requests);
            ArrayList<GroupInterface> groups = groupDatabase.loadGroups();
            for (GroupInterface group : groups) {
                if (group.getName().equals(currentGroup.getName())) {
                    group = currentGroup;
                }
            }
            groupDatabase.saveGroups(groups);
        }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void notificationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notificationsActionPerformed
        try {
            Notifications window = new Notifications(this);
        } catch (IOException ex) {
            Logger.getLogger(FeedWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_notificationsActionPerformed

    private void ChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChatActionPerformed
        friendPanel.setLayout(new BoxLayout(friendPanel, BoxLayout.Y_AXIS));
        friends.setVisible(true);
        for (String i : currentUser.getFriends()) {
            JPanel entryPanel = friendPanel(i);
            friendPanel.add(entryPanel);
            friendPanel.revalidate();
            friendPanel.repaint();
        }
    }//GEN-LAST:event_ChatActionPerformed

    private void sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendActionPerformed
        String message = textMsg.getText();
        currentChat.addMessage(message, currentUser.getUserId());
        loadChats(currentChat.getReciever());
        textMsg.setText("");
    }//GEN-LAST:event_sendActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        loadPostList();
        postInteract.setVisible(true);
        ArrayList<String> friends = currentUser.getFriends();
        String selectedPost = postList.getSelectedValue();
        PostInteractionManagement interactManager = new PostInteractionManagement(getPostId(),getAuthorId());
        postList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) { // Ensure the event is not a duplicate
                    int selectedIndex = postList.getSelectedIndex();
                    interactManager.setAuthorId(getAuthorId());
                    interactManager.setPostId(getPostId());
                    interactManager.initialize();
                    if (selectedIndex != -1) {
                        if (isLiked(interactManager.getLikes(), interactManager.getPostId())) {
                            likeButton.setBackground(Color.BLUE);
                            likeButton.setText("Liked");
                        }
                    } else {
                        // Reset the button's color when no post is selected
                        likeButton.setBackground(Color.LIGHT_GRAY);
                        likeButton.setText("Like");
                    }
                }
            }
        });
    }//GEN-LAST:event_jButton16ActionPerformed

    private void likeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_likeButtonActionPerformed

    }//GEN-LAST:event_likeButtonActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        
    }//GEN-LAST:event_jButton18ActionPerformed

    public String getPostId() {
        ArrayList<String> friends = currentUser.getFriends();
        String selectedPost = postList.getSelectedValue();
        int counter = 0, postIndex = postList.getSelectedIndex();
        if (selectedPost != null) {
            for (int i = 0; i < posts.size(); i++) {
                for (int j = 0; j < friends.size(); j++) {
                    if (posts.get(i).getContentPublisher().equals(friends.get(j))) {
                        if (counter == postIndex) {
                            String postid = posts.get(i).getContentID();
                            return postid;
                        }
                    }
                }
            }
        }
        return null;
    }

    public String getAuthorId() {
        ArrayList<String> friends = currentUser.getFriends();
        String selectedPost = postList.getSelectedValue();
        int counter = 0, postIndex = postList.getSelectedIndex();
        if (selectedPost != null) {
            for (int i = 0; i < posts.size(); i++) {
                for (int j = 0; j < friends.size(); j++) {
                    if (posts.get(i).getContentPublisher().equals(friends.get(j))) {
                        if (counter == postIndex) {
                            String author = posts.get(i).getContentPublisher();
                            return author;
                        }
                    }
                }
            }
        }
        return null;
    }

    public boolean isLiked(List<Like> likes, String postId) {
        Like like = InteractionFactory.createLike(postId, currentUser.getUserId());
        if (likes.contains(like)) {
            return true;
        }
        return false;
    }

    public void refresh() {
        for (int i = 0; i < stories.size(); i++) {
            Story story = (Story) stories.get(i);
            if (story.isPast24Hours()) {
                stories.remove(stories.get(i));
            }
        }
        loadPosts();
        loadStories();
        loadGroups();
        LoadGroupSuggestions();
    }

    public void loadPosts() {
        ArrayList<String> friends = currentUser.getFriends();
        jPanel1.removeAll();
        posts = database1.loadPosts();
        posts.sort((e1, e2) -> e2.getTimeStamp().compareTo(e1.getTimeStamp()));
        for (int i = 0; i < posts.size(); i++) {
            for (int j = 0; j < friends.size(); j++) {
                if (posts.get(i).getContentPublisher().equals(friends.get(j))) {
                    PostsPanel postPanel = new PostsPanel((Post) posts.get(i));
                    jPanel1.add(postPanel);
                }
            }
        }
        jPanel1.revalidate();
        jPanel1.repaint();
    }

    public void loadStories() {
        stories = database2.loadStories();
        ArrayList<String> friends = currentUser.getFriends();
        ArrayList<String> friendsUserNames = new ArrayList<>();
        ArrayList<String> friendsStories = new ArrayList<>();
        friendsUserNames.add("View Your story");
        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < stories.size(); j++) {
                if (stories.get(j).getContentPublisher().equals(friends.get(i))) {
                    friendsStories.add(friends.get(i));
                    break;
                }
            }
        }
        try {
            users = userDatabase.loadUsers();
        } catch (IOException ex) {

        }
        for (int i = 0; i < friendsStories.size(); i++) {
            for (int j = 0; j < users.size(); j++) {
                if (friendsStories.get(i).equals(users.get(j).getUserId())) {
                    friendsUserNames.add(users.get(j).getUserName());
                    break;
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

    public void loadPostList() {
        String caption;
        ArrayList<String> postCaptions = new ArrayList<>();
        ArrayList<String> friends = currentUser.getFriends();
        posts = database1.loadPosts();
        posts.sort((e1, e2) -> e2.getTimeStamp().compareTo(e1.getTimeStamp()));
        for (int i = 0; i < posts.size(); i++) {
            for (int j = 0; j < friends.size(); j++) {
                if (posts.get(i).getContentPublisher().equals(friends.get(j))) {
                    caption = posts.get(i).getContent().getCaption();
                    postCaptions.add(caption);
                }
            }
        }
        String[] emptyData = {};
        postList.setListData(emptyData);
        String[] data = new String[postCaptions.size()];
        data = postCaptions.toArray(data);
        postList.setListData(data);
    }

    public void loadGroups() {
        groups = groupDatabase.loadGroups();
        String[] emptyData = {};
        jList2.setListData(emptyData);
        ArrayList<String> groupNames = userGroups.returnGroupNamesByUserId(currentUser.getUserId());
        String[] data = new String[groups.size()];
        data = groupNames.toArray(data);
        jList2.setListData(data);
    }

    private JPanel friendPanel(String friend) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel usernameLabel = new JLabel(userDatabase.getUser(friend, users).getUserName());
        usernameLabel.setPreferredSize(new Dimension(150, 30)); // Adjust dimensions as needed
        panel.add(usernameLabel);
        JLabel useridLabel = new JLabel(friend);
        usernameLabel.setPreferredSize(new Dimension(150, 30)); // Adjust dimensions as needed
        panel.add(useridLabel);

        // Button to view the friend's profile
        JButton viewChatButton = new JButton("View Chat");
        //Here add view Profile functionality
        viewChatButton.addActionListener(e -> {
            loadChats(friend);
        });
        panel.add(viewChatButton);
        return panel;
    }

    public void loadChats(String friend) {
        friends.dispose();
        introPanel.removeAll();
        chatPanel.removeAll();
        chat.setVisible(true);
         chat.revalidate();
        chat.repaint();
        chatPane.revalidate();
        chatPane.repaint();
        chatPanel.setLayout(new BoxLayout(chatPanel, BoxLayout.Y_AXIS));
        
        introPanel.revalidate();
        introPanel.repaint();
        introPanel.setLayout(new BoxLayout(introPanel, BoxLayout.X_AXIS));
        JLabel userNameLabel = new JLabel(userDatabase.getUser(friend, users).getUserName());
            userNameLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            ImageIcon icon = new ImageIcon(userDatabase.getUser(friend, users).getUserPhoto());
        Image image = icon.getImage();
        Image scaledImage1 = image.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon circularIcon = new ImageIcon(UserIcon.makeImageCircular(scaledImage1));
        JLabel imageLabel1 = new JLabel(circularIcon);
        
         JButton back = new JButton("Back");
        FontIcon backIcon = FontIcon.of(FontAwesomeSolid.ARROW_LEFT, 20, Color.WHITE);
            back.setIcon(backIcon);
            introPanel.add(back);
            introPanel.add(Box.createHorizontalStrut(20));
           introPanel.add(imageLabel1);
           introPanel.add(Box.createHorizontalStrut(20));
        introPanel.add(userNameLabel);
        introPanel.add(Box.createHorizontalStrut(280));
        

            
            FontIcon refreshIcon = FontIcon.of(FontAwesomeSolid.SYNC_ALT, 20, Color.WHITE);
            JButton refreshButton = new JButton("");
            refreshButton.setIcon(refreshIcon);
            introPanel.add(refreshButton);
        Chat chatting = new Chatting(currentUser.getUserId(), friend);
        currentChat = chatting;
        if (chatting.getMessages().isEmpty()) {
            
            JLabel messageLabel = new JLabel("<html><body style='width: 500px;'>" + "Start Chatting!" + "</body></html>");
            messageLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
            chatPanel.add(messageLabel);
        } else {
            for (Message i : chatting.getMessages()) {
                JPanel entryPanel = chat(i,friend);
                chatPanel.add(entryPanel);
                chatPanel.add(Box.createVerticalStrut(20));
            }
        }
        back.addActionListener(e -> {
            friends.setVisible(true);
            this.dispose();
        });
        refreshButton.addActionListener(e -> {
            loadChats(friend);
        });
        chatPanel.revalidate();
        chatPanel.repaint();
    }

    public JPanel chat(Message m,String friend) {
        JPanel panel = new JPanel();
         // Simplify alignment
    panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    
        JLabel messageLabel = new JLabel(m.getMessage());
        messageLabel.setOpaque(true);
        messageLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        if (m.getSender().equals(currentUser.getUserId())) {
            panel.setLayout(new FlowLayout(FlowLayout.RIGHT,0,0));
            messageLabel.setBackground(new Color(220, 248, 198));
             
        } else {
            panel.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
            messageLabel.setBackground(new Color(230, 230, 230));
            ImageIcon icon = new ImageIcon(userDatabase.getUser(friend, users).getUserPhoto());
            System.out.println(userDatabase.getUser(friend, users).getUserPhoto());
        Image image = icon.getImage();
        Image scaledImage1 = image.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon circularIcon = new ImageIcon(UserIcon.makeImageCircular(scaledImage1));
        JLabel imageLabel1 = new JLabel(circularIcon);
        Box centerBox = Box.createHorizontalBox();
        centerBox.add(imageLabel1);
        centerBox.add(Box.createHorizontalStrut(20));
        centerBox.add(messageLabel);
        panel.add(centerBox);
        }
        panel.add(messageLabel);
        panel.add(Box.createVerticalStrut(30));
        return panel;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Chat;
    private javax.swing.JList<String> RequestList;
    private javax.swing.JDialog chat;
    private javax.swing.JScrollPane chatPane;
    private javax.swing.JPanel chatPanel;
    private javax.swing.JPanel friendPanel;
    private javax.swing.JDialog friends;
    private javax.swing.JPanel introPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton18;
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
    private javax.swing.JDialog jDialog4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JButton likeButton;
    private javax.swing.JButton notifications;
    private javax.swing.JDialog postInteract;
    private javax.swing.JList<String> postList;
    private javax.swing.JButton send;
    private javax.swing.JTextField textMsg;
    // End of variables declaration//GEN-END:variables
}
