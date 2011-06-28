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
package com.pennychecker.example;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.pennychecker.example.mvp.presenter.UserContainerPresenter;
import com.pennychecker.example.guice.MvpModule;

/**
 *
 * @author Steffen Kämpke mailto:steffen.kaempke@pennychecker.de
 */
public class SwingMvpExample extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;

    /** Creates new form MvpDispatchExampleMain */
    public SwingMvpExample() {
        initComponents();
        this.setTitle("Model View Presenter - Steffen Kaempke");
        final Injector injector = Guice.createInjector(new MvpModule());
        final UserContainerPresenter userContainerPresenter = injector.getInstance(UserContainerPresenter.class);
        this.add(userContainerPresenter.getDisplay().asComponent());

        pack();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new SwingMvpExample().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
