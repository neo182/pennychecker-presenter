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
package com.pennychecker.wicketexample.event;

import com.pennychecker.eventbus.Event;
import com.pennychecker.wicketexample.mvp.model.WicketUser;

/**
 * @author Steffen Kaempke
 */
public final class EditUserEvent extends Event<EditUserEventHandler>{

	public final static Type<EditUserEventHandler> TYPE = new Type<EditUserEventHandler>();
	public final WicketUser user;
	
	
	
	public EditUserEvent(WicketUser user) {
		this.user = user;
	}

	@Override
	public com.pennychecker.eventbus.Event.Type<EditUserEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(EditUserEventHandler handler) {
		handler.onEditUserEvent(this);
	}

	public WicketUser getUser() {
		return user;
	}
	
	

}
