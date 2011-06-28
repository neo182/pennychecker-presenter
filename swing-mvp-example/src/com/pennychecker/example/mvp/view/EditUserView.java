/**
 * Copyright [2011] Steffen Kämpke
 * mailto: sk@pennychecker.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.pennychecker.example.mvp.view;

import com.pennychecker.example.mvp.model.User;
import com.pennychecker.example.mvp.presenter.EditUserPresenter;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

/**
 *
 * @author Steffen Kämpke
 */
public class EditUserView extends javax.swing.JPanel implements EditUserPresenter.Display{
    private static final long serialVersionUID = 1L;

    /** Creates new form EditUserView */
    public EditUserView() {
        initComponents();
        this.setName("editUserView");
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldFirstname = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldLastname = new javax.swing.JTextField();
        jButtonSave = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();

        jTextFieldFirstname.setText("jTextField1");
        jTextFieldFirstname.setName("jTextFieldFirstname"); // NOI18N

        jLabel1.setText("Firstname");
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText("Lastname");
        jLabel2.setName("jLabel2"); // NOI18N

        jTextFieldLastname.setText("jTextField2");
        jTextFieldLastname.setName("jTextFieldLastname"); // NOI18N

        jButtonSave.setText("Save");
        jButtonSave.setName("jButtonSave"); // NOI18N

        jButtonCancel.setText("Cancel");
        jButtonCancel.setName("jButtonCancel"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSave))
                    .addComponent(jTextFieldFirstname, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldLastname, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldLastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSave)
                    .addComponent(jButtonCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextFieldFirstname;
    private javax.swing.JTextField jTextFieldLastname;
    // End of variables declaration//GEN-END:variables

    public JButton getSaveButton() {
        return jButtonSave;
    }

    public JButton getCloseButton() {
        return jButtonCancel;
    }

    public String getFirstname() {
        return jTextFieldFirstname.getText();
    }

    public String getLastName() {
        return jTextFieldLastname.getText();
    }

    public void setErrorMessage(String string) {
        JOptionPane.showMessageDialog(this, string, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public void setWarningMessage(String string) {
        JOptionPane.showMessageDialog(this, string, "Warning", JOptionPane.WARNING_MESSAGE);
    }

    public void clearForm() {
        jTextFieldFirstname.setText("");
        jTextFieldLastname.setText("");
    }

    public void setUser(User user) {
        jTextFieldFirstname.setText(user.getFirstname());
        jTextFieldLastname.setText(user.getLastname());
    }

    public JComponent asComponent() {
        return this;
    }
}
