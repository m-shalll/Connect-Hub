/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Frontend;
import Backend.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author AbdElrahman
 */
public class Friends extends javax.swing.JDialog {
    public ArrayList<User> users=LogInPannel.users;
   
   public User targetUser=LogInPannel.logIn ;
   
    public Friends(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
           
        
       
        //generate friend requests
        loadList1();
        //generate friends list
        loadList2();
        //generate suggestions
        loadList3();
    }
    public void loadList1(){
         ArrayList<String> names = new ArrayList<>();
    
    // Get the friend requests map for the target user
    Map<String, String> friendReq = targetUser.getFriendReq();
    
    // Iterate over the map to check for "Pending" requests
System.out.println(friendReq.entrySet());
    for (Map.Entry<String, String> entry : friendReq.entrySet()) {
        if ("pending".equals(entry.getValue())) {
            names.add(entry.getKey()); 
            //System.out.println("899"+names);
        }
    }
    
    // Set the list data for your JList
    jList2.setListData(names.toArray(new String[0]));
}
    public void loadList2(){
    ArrayList<String> names = new ArrayList<>();
    //generate all friends of specified user
    for(String i: targetUser.getFriends()){
    names.add(i);
    }
        System.out.println(names);
    //adds the arraylist created to jlist by converting to array
    jList1.setListData(names.toArray(new String[0]));
    }
    
    public void loadList3(){
   ArrayList<String> names =LogInPannel.f.suggestedFriends(targetUser, users);
        System.out.println(names);
   jList3.setListData(names.toArray(new String[0]));
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        Add = new javax.swing.JButton();
        Decline = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        Block = new javax.swing.JButton();
        Remove = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        Request = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Friend Requests");

        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jList1);

        Add.setText("Add");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        Decline.setText("Decline");
        Decline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeclineActionPerformed(evt);
            }
        });

        jLabel2.setText("Friends List");

        jList2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(jList2);

        Block.setText("Block");
        Block.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BlockActionPerformed(evt);
            }
        });

        Remove.setText("Remove");
        Remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveActionPerformed(evt);
            }
        });

        jList3.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(jList3);

        jLabel3.setText("Suggestions");

        Request.setText("Send friend request");
        Request.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RequestActionPerformed(evt);
            }
        });

        jButton2.setText("Refresh");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Add, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Decline, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Block, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Remove, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(128, 128, 128))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(Request))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(Add)
                        .addGap(96, 96, 96)
                        .addComponent(Decline))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(Block)
                        .addGap(49, 49, 49)
                        .addComponent(Remove))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Request)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
String s=jList2.getSelectedValue();
        System.out.println(s);


if(s==null)
 JOptionPane.showMessageDialog(this, "Must choose User","Error",JOptionPane.ERROR_MESSAGE);
else{

    
       try {
           
           
           User r = LogInPannel.manager.getUser(s,users);
           try {
               LogInPannel.f.acceptFriendRequest(targetUser,r);
           } catch (IOException ex) {
               Logger.getLogger(Friends.class.getName()).log(Level.SEVERE, null, ex);
           }
           
JOptionPane.showMessageDialog(this, "Friend Added", "Information", JOptionPane.INFORMATION_MESSAGE);
           
       } catch (IOException ex) {
        Logger.getLogger(Friends.class.getName()).log(Level.SEVERE, null, ex);
    }
       loadList1();
       loadList2();
       try {
            AccountManagement.saveUsers(users);
            // TODO add your handling code here:
        } catch (IOException ex) {
            Logger.getLogger(Friends.class.getName()).log(Level.SEVERE, null, ex);
        }
 
}


        // TODO add your handling code here:
    }//GEN-LAST:event_AddActionPerformed

    private void DeclineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeclineActionPerformed
String s=jList2.getSelectedValue();
        System.out.println(s);


if(s==null)
 JOptionPane.showMessageDialog(this, "Must choose User","Error",JOptionPane.ERROR_MESSAGE);
else{

    
       try {
           
           
           User r = LogInPannel.manager.getUser(s,users);
           try {
               LogInPannel.f.declineFriendRequest(targetUser, r);
           } catch (IOException ex) {
               Logger.getLogger(Friends.class.getName()).log(Level.SEVERE, null, ex);
           }
           
JOptionPane.showMessageDialog(this, "Friend Request Declined", "Information", JOptionPane.INFORMATION_MESSAGE);
           
       } catch (IOException ex) {
        Logger.getLogger(Friends.class.getName()).log(Level.SEVERE, null, ex);
    }
        loadList1();
        try {
            AccountManagement.saveUsers(users);
            // TODO add your handling code here:
        } catch (IOException ex) {
            Logger.getLogger(Friends.class.getName()).log(Level.SEVERE, null, ex);
        }

}
        // TODO add your handling code here:
    }//GEN-LAST:event_DeclineActionPerformed

    private void BlockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BlockActionPerformed
        String s=jList1.getSelectedValue();
        System.out.println(s);


if(s==null)
 JOptionPane.showMessageDialog(this, "Must choose User","Error",JOptionPane.ERROR_MESSAGE);
else{

    
       User r;
            try {
                r = LogInPannel.manager.getUser(s,users);
                  try {
        LogInPannel.f.blockUser(targetUser, r);
    } catch (IOException ex) {
        Logger.getLogger(Friends.class.getName()).log(Level.SEVERE, null, ex);
    }

    
            } catch (IOException ex) {
                Logger.getLogger(Friends.class.getName()).log(Level.SEVERE, null, ex);
            }
     
JOptionPane.showMessageDialog(this, "Blocked User", "Information", JOptionPane.INFORMATION_MESSAGE);
 loadList2();
 try {
            AccountManagement.saveUsers(users);
            // TODO add your handling code here:
        } catch (IOException ex) {
            Logger.getLogger(Friends.class.getName()).log(Level.SEVERE, null, ex);
        }
}
// TODO add your handling code here:
    }//GEN-LAST:event_BlockActionPerformed

    private void RemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveActionPerformed
       String s=jList1.getSelectedValue();
        System.out.println(s);


if(s==null)
 JOptionPane.showMessageDialog(this, "Must choose User","Error",JOptionPane.ERROR_MESSAGE);
else{

    
       try {
           
           
           User r = LogInPannel.manager.getUser(s,users);
           System.out.println("990"+r);
           try {
              LogInPannel.f.removeFriend(targetUser, r);
           } catch (IOException ex) {
               Logger.getLogger(Friends.class.getName()).log(Level.SEVERE, null, ex);
           }
           
JOptionPane.showMessageDialog(this, "Removed User", "Information", JOptionPane.INFORMATION_MESSAGE);
           
       } catch (IOException ex) {
        Logger.getLogger(Friends.class.getName()).log(Level.SEVERE, null, ex);
    }
       loadList2();
       try {
            AccountManagement.saveUsers(users);
            // TODO add your handling code here:
        } catch (IOException ex) {
            Logger.getLogger(Friends.class.getName()).log(Level.SEVERE, null, ex);
        }
 
}        
// TODO add your handling code here:
    }//GEN-LAST:event_RemoveActionPerformed

    private void RequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RequestActionPerformed
              String s=jList3.getSelectedValue();
        System.out.println(s);


if(s==null)
 JOptionPane.showMessageDialog(this, "Must choose User","Error",JOptionPane.ERROR_MESSAGE);
else{

    
       try {
           
           
           User r = LogInPannel.manager.getUser(s,LogInPannel.users);
           try {
               LogInPannel.f.sendFriendRequest(targetUser, r);
           } catch (IOException ex) {
               Logger.getLogger(Friends.class.getName()).log(Level.SEVERE, null, ex);
           }
           
           
JOptionPane.showMessageDialog(this, "Friend Request Sent", "Information", JOptionPane.INFORMATION_MESSAGE);
            
       } catch (IOException ex) {
        Logger.getLogger(Friends.class.getName()).log(Level.SEVERE, null, ex);
    }
 loadList3();
 try {
            AccountManagement.saveUsers(users);
            // TODO add your handling code here:
        } catch (IOException ex) {
            Logger.getLogger(Friends.class.getName()).log(Level.SEVERE, null, ex);
        }
}
        // TODO add your handling code here:
    }//GEN-LAST:event_RequestActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            users=LogInPannel.manager.loadUsers();
        } catch (IOException ex) {
            Logger.getLogger(Friends.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            targetUser=LogInPannel.manager.getUser(LogInPannel.userName, users);
        } catch (IOException ex) {
            Logger.getLogger(Friends.class.getName()).log(Level.SEVERE, null, ex);
        }
        loadList1();
        loadList2();
        loadList3();
       
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            AccountManagement.saveUsers(users);
            // TODO add your handling code here:
        } catch (IOException ex) {
            Logger.getLogger(Friends.class.getName()).log(Level.SEVERE, null, ex);
        }
        FeedWindow x = new FeedWindow(targetUser);
        x.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed


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
            java.util.logging.Logger.getLogger(Friends.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Friends.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Friends.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Friends.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Friends dialog = new Friends(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JButton Block;
    private javax.swing.JButton Decline;
    private javax.swing.JButton Remove;
    private javax.swing.JButton Request;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JList<String> jList3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
