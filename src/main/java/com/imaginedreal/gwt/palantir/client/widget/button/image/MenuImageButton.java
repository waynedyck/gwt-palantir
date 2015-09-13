package com.imaginedreal.gwt.palantir.client.widget.button.image;

import com.imaginedreal.gwt.palantir.client.widget.image.LocalImageHolder;
import com.googlecode.mgwt.ui.client.widget.button.ImageButton;

public class MenuImageButton extends ImageButton {

	public MenuImageButton() {
		super(LocalImageHolder.get().menu());
	}

}
