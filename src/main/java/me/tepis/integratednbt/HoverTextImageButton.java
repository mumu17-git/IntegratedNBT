package me.tepis.integratednbt;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.network.chat.Component;

import java.util.List;
import java.util.stream.Collectors;

public class HoverTextImageButton extends ImageButton {
    private Screen gui;

    private List<Component> hoverText;


    public HoverTextImageButton(
        TexturePart textureNormal,
        TexturePart textureHover,
        int x,
        int y,
        Button.OnPress onPress
    ) {
        super(textureNormal, textureHover, x, y, onPress);
    }

    public HoverTextImageButton(Screen gui, int x, int y, Button.OnPress onPress) {
        super(x, y, onPress);
        this.gui = gui;
    }

    public void setHoverText(List<Component> hoverText) {
        this.hoverText = hoverText;
    }

    public void setHoverTextRaw(List<String> hoverText) {
        this.hoverText = hoverText.stream()
            .map(s -> Component.literal(s))
            .collect(Collectors.toList());
    }

    /**
     * Draw hover text if is hovered
     */
    public void drawHover(GuiGraphics matrixStack, int mouseX, int mouseY) {
        if (this.isHovered) {
            matrixStack.renderTooltip(
                Minecraft.getInstance().font,
                FontHelper.wrap(this.hoverText, 200),
                mouseX,
                mouseY
            );
        }
    }
}
