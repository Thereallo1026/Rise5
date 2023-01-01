package dev.rise.ui.clickgui.impl.tecnio.elements.buttons;

import dev.rise.Rise;
import dev.rise.font.CustomFont;
import dev.rise.setting.impl.BooleanSetting;
import dev.rise.ui.clickgui.impl.tecnio.elements.buttontype.Button;
import dev.rise.util.render.RenderUtil;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public final class BooleanButton extends Button {

    private BooleanSetting setting;
    private Color color;

    public BooleanButton(final float x, final float y, final float width, final float height, final BooleanSetting set, final Color col) {
        super(x, y, width, height);
        setting = set;
        color = col;
    }

    @Override
    public void drawPanel(final int mouseX, final int mouseY) {
        final Color color = new Color(Rise.CLIENT_THEME_COLOR);
        final float settingsOffset = 2;
        RenderUtil.rect(this.getX(), this.getY(), this.getWidth(), this.getHeight(), new Color(0xff181A17));

        if (setting.isEnabled())
            RenderUtil.rect(this.getX() + 1 + settingsOffset, this.getY(), this.getWidth() - 3 - settingsOffset * 2, this.getHeight(), color);

        CustomFont.drawString(setting.name, this.getX() + 1 + settingsOffset, this.getY() + this.getHeight() / 2 - CustomFont.getHeight() / 2.0F, 0xffffffff);
    }

    @Override
    public void mouseAction(final int mouseX, final int mouseY, final boolean click, final int button) {
        if (isHovered(mouseX, mouseY) && click) {
            setting.setEnabled(!setting.isEnabled());
        }
    }
}
