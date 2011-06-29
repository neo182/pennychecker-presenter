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
package com.pennychecker.jfx.example.mvp.presenter;

import com.google.inject.Inject;
import com.pennychecker.eventbus.EventBus;
import com.pennychecker.jfx.example.event.EditUserEvent;
import com.pennychecker.jfx.example.event.UserChangedEvent;
import com.pennychecker.jfx.example.event.UserChangedEventHandler;
import com.pennychecker.jfx.example.mvp.model.User;
import com.pennychecker.jfx.example.repository.UserRepository;
import com.pennychecker.presenter.event.PresenterRevealedEvent;
import com.pennychecker.presenter.javafx.FxDisplay;
import com.pennychecker.presenter.javafx.FxPresenter;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Steffen Kämpke
 */
public final class AllUserPresenter extends FxPresenter<AllUserPresenter.Display> {

    private final List<User> users = new ArrayList<User>();
    private User selectedUser;
    private final UserRepository userRepository;

    /**
     * 
     * @param display
     * @param eventBus
     * @param userRepository 
     */
    @Inject
    public AllUserPresenter(Display display, EventBus eventBus, UserRepository userRepository) {
        super(display, eventBus);
        assert null != userRepository;
        this.userRepository = userRepository;
        bind();
        fetchUsers();
    }

    @Override
    protected void onBind() {

        display.getUserList().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            public void handle(MouseEvent event) {
                int index = display.getSelectedUserIndex();
                if (index < 0) {
                    return;
                }
                selectedUser = users.get(index);
                display.setSelectedUser(selectedUser);
            }
        });

        display.getUserList().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            public void handle(MouseEvent event) {
                if (event.getClickCount() == 2) {
                    int index = display.getSelectedUserIndex();
                    if (index < 0) {
                        return;
                    }
                    final User selectedUser = users.get(index);
                    display.setSelectedUser(selectedUser);

                    eventBus.fireEvent(new EditUserEvent(selectedUser));
                }
            }
        });

        registerHandler(eventBus.addHandler(UserChangedEvent.TYPE, new UserChangedEventHandler() {

            public void onUserChangedEvent(UserChangedEvent event) {

                User user = event.getUser();

                if (null == user) {
                    firePresenterRevealedEvent();
                    return;
                }

                if (!users.contains(user)) {
                    users.add(user);
                }

                selectedUser = user;
                display.setSelectedUser(selectedUser);
                display.setUsers(users);
                display.setSelection(users.indexOf(user));
                firePresenterRevealedEvent();
            }
        }));

        display.getAddUserButton().addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                eventBus.fireEvent(new EditUserEvent(null));
            }
        });

        display.getEditUserButton().addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                if (null == selectedUser) {
                    display.setWarning("Please select a user.");
                    return;
                }

                eventBus.fireEvent(new EditUserEvent(selectedUser));
            }
        });

        display.getRemoveUserButton().addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                if (null == selectedUser) {
                    display.setWarning("Select a user.");
                    return;
                }
                users.remove(selectedUser);
                selectedUser = null;
                display.clearSelections();
                display.setUsers(users);
                display.setSelectedUser(selectedUser);
            }
        });
    }

    @Override
    protected void onUnbind() {
    }

    public void refreshDisplay() {
    }

    private void fetchUsers() {
        users.clear();
        final List<User> userList;
        try {
            userList = userRepository.finaAll();
        } catch (Exception ex) {
            display.setError("Could not fetch users.");
            return;
        }

        display.setUsers(userList);
        display.clearSelections();
    }

    public interface Display extends FxDisplay {

        Node getUserList();

        Node getAddUserButton();

        Node getEditUserButton();

        Node getRemoveUserButton();

        public int getSelectedUserIndex();

        public void setSelectedUser(User selectedUser);

        public void setUsers(List<User> users);

        public void clearSelections();

        public void setSelection(int index);

        public void setWarning(String string);

        public void setError(String string);
    }

    public void firePresenterRevealedEvent() {
        eventBus.fireEvent(new PresenterRevealedEvent(AllUserPresenter.this));
    }
}
