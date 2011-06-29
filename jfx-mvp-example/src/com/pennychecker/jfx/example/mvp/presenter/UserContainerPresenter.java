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
import com.pennychecker.presenter.javafx.FxContainerDisplay;
import com.pennychecker.presenter.javafx.FxContainerPresenter;

/**
 *
 * @author Steffen Kämpke
 */
public class UserContainerPresenter extends FxContainerPresenter<UserContainerPresenter.Display> {

    /**
     * 
     * @param display
     * @param eventBus
     * @param editUserPresenter
     * @param allUserPresenter 
     */
    @Inject
    public UserContainerPresenter(Display display, EventBus eventBus, EditUserPresenter editUserPresenter, AllUserPresenter allUserPresenter) {
        super(display, eventBus, editUserPresenter, allUserPresenter);

        assert null != editUserPresenter;
        assert null != allUserPresenter;

        display.addParent(allUserPresenter.getDisplay().asParent());
        display.addParent(editUserPresenter.getDisplay().asParent());

        showPresenter(allUserPresenter);
        bind();
    }

    public void refreshDisplay() {
    }

    public interface Display extends FxContainerDisplay {
    }
}
