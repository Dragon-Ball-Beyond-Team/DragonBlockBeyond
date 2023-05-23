package io.firetamer81.dragonblockbeyond.core.firelib.gui_stuff.testcomponents;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.SharedConstants;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.util.Mth;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class TestTextField extends TestAdvancedScreenComponent {
    protected final boolean canLoseFocus;
    final char colorCodePlaceholder;
    private final ArrayList<String> suggestions;
    private final String[] colorCodeSuggestions;
    protected String text;
    protected int maxStringLength;
    protected int cursorCounter;
    protected boolean enableBackgroundDrawing;
    protected boolean isFocused;
    protected int lineScrollOffset;
    protected int cursorPosition;
    protected int selectionEnd;
    protected int enabledColor;
    protected int disabledColor;
    protected Predicate<String> validator;
    private Consumer<String> guiResponder;
    private BiFunction<String, Integer, String> textFormatter;
    private boolean acceptsColors;
    private Runnable callback;
    private boolean isShiftDown;
    private boolean showSuggestions;
    private int selectedSuggestion;
    private String label;

    public TestTextField(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.canLoseFocus = true;
        this.colorCodePlaceholder = 888;
        this.suggestions = new ArrayList();
        this.colorCodeSuggestions = new String[]{"§11", "§22", "§33", "§44", "§55", "§66", "§77", "§88", "§99", "§AA", "§BB", "§CC", "§DD", "§EE", "§FF", "§LL", "§MM", "§NN", "§OO", "K§kK"};
        this.text = "";
        this.maxStringLength = 100;
        this.enableBackgroundDrawing = true;
        this.enabledColor = 14737632;
        this.disabledColor = 7368816;
        this.validator = (s) -> true;
        this.textFormatter = (p_195610_0_, p_195610_1_) -> p_195610_0_;
        this.acceptsColors = false;
        this.showSuggestions = true;
        this.selectedSuggestion = 0;
        this.label = "";
    }

    public TestTextField(int x, int y, int width) {
        this(x, y, width, 20);
    }

    //<editor-fold desc="Rendering Methods">
    public void render(PoseStack poseStack, int mouseX, int mouseY, float partial) {
        //Setup Variables
        int currentColor = this.isEnabled() ? this.enabledColor : this.disabledColor;
        int j = this.cursorPosition - this.lineScrollOffset;
        int k = this.selectionEnd - this.lineScrollOffset;
        String string = this.renderer.plainSubstrByWidth(this.text.substring(this.lineScrollOffset), this.getAdjustedWidth());
        boolean flag = j >= 0 && j <= string.length();
        boolean flag1 = this.isFocused() && this.cursorCounter / 6 % 2 == 0 && flag;
        int textXPos = this.getEnableBackgroundDrawing() ? this.getX() + 4 : this.getX();
        int textYPos = this.getEnableBackgroundDrawing() ? this.getY() + (this.height - 8) / 2 : this.getY();

        //Render Input Field Background
        if (this.getEnableBackgroundDrawing()) {
            fill(poseStack,
                    this.getX() - 1,
                    this.getY() - 1,
                    this.getX() + this.width + 1,
                    this.getY() + this.height + 1,
                    -6250336
            );

            fill(poseStack,
                    this.getX(),
                    this.getY(),
                    this.getX() + this.width,
                    this.getY() + this.height,
                    -16777216
            );
        }

        //Render Text Field Title/Label
        if (!this.label.isEmpty()) {
            this.renderer.draw(poseStack, this.label,
                    (float)this.getX(),
                    (float)(this.getY() - 8),
                    currentColor
            );
        }

        //Draw Text Within Input Field
        int j1 = textXPos;

        if (k > string.length()) {
            k = string.length();
        }

        if (!string.isEmpty()) {
            String s1 = flag ? string.substring(0, j) : string;
            j1 = this.renderer.drawShadow(poseStack, this.textFormatter.apply(s1, this.lineScrollOffset), (float)textXPos, (float)textYPos, currentColor);
        }

        boolean flag2 = this.cursorPosition < this.text.length() || this.text.length() >= this.getMaxStringLength();
        int k1 = j1;
        if (!flag) {
            k1 = j > 0 ? textXPos + this.width : textXPos;
        } else if (flag2) {
            k1 = j1 - 1;
            --j1;
        }

        if (!string.isEmpty() && flag && j < string.length()) {
            this.renderer.drawShadow(poseStack, this.textFormatter.apply(string.substring(j), this.cursorPosition), (float)j1, (float)textYPos, currentColor);
        }

        if (!flag2 && !this.getCurrentSuggestion().isEmpty()) {
            this.renderer.drawShadow(poseStack, this.getCurrentSuggestion(), (float)(k1 - 1), (float)textYPos, -8355712);
        }

        if (flag1) {
            if (flag2) {
                Screen.fill(poseStack, k1, textYPos - 1, k1 + 1, textYPos + 1 + 9, -3092272);
            } else {
                this.renderer.drawShadow(poseStack, "_", (float)k1, (float)textYPos, currentColor);
            }
        }

        if (k != j) {
            int l1 = textXPos + this.renderer.width(string.substring(0, k));
            this.drawSelectionBox(k1, textYPos - 1, l1 - 1, textYPos + 1 + 9);
        }
    }

    private void drawSelectionBox(int startX, int startY, int endX, int endY) {
        int j;
        if (startX < endX) {
            j = startX;
            startX = endX;
            endX = j;
        }

        if (startY < endY) {
            j = startY;
            startY = endY;
            endY = j;
        }

        if (endX > this.getX() + this.width) {
            endX = this.getX() + this.width;
        }

        if (startX > this.getX() + this.width) {
            startX = this.getX() + this.width;
        }

        Tesselator tessellator = Tesselator.getInstance();
        BufferBuilder bufferbuilder = tessellator.getBuilder();
        RenderSystem.clearColor(0.0F, 0.0F, 255.0F, 255.0F);
        RenderSystem.disableTexture();
        RenderSystem.enableColorLogicOp();
        RenderSystem.logicOp(GlStateManager.LogicOp.OR_REVERSE);
        bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION);
        bufferbuilder.vertex((double)startX, (double)endY, 0.0).endVertex();
        bufferbuilder.vertex((double)endX, (double)endY, 0.0).endVertex();
        bufferbuilder.vertex((double)endX, (double)startY, 0.0).endVertex();
        bufferbuilder.vertex((double)startX, (double)startY, 0.0).endVertex();
        tessellator.end();
        RenderSystem.disableColorLogicOp();
        RenderSystem.enableTexture();
    }
    //</editor-fold>

    public void writeText(String textToWrite) {
        String s = "";
        if (this.acceptsColors) {
            textToWrite = textToWrite.replace('§', '\u0378');
        }

        String s1 = SharedConstants.filterText(textToWrite);
        if (this.acceptsColors) {
            s1 = s1.replace('\u0378', '§');
        }

        int i = Math.min(this.cursorPosition, this.selectionEnd);
        int j = Math.max(this.cursorPosition, this.selectionEnd);
        int k = this.maxStringLength - this.text.length() - (i - j);
        if (!this.text.isEmpty()) {
            s = s + this.text.substring(0, i);
        }

        int l;
        if (k < s1.length()) {
            s = s + s1.substring(0, k);
            l = k;
        } else {
            s = s + s1;
            l = s1.length();
        }

        if (!this.text.isEmpty() && j < this.text.length()) {
            s = s + this.text.substring(j);
        }

        if (this.validator.test(s)) {
            this.text = s;
            this.clampCursorPosition(i + l);
            this.setSelectionPos(this.cursorPosition);
            this.onTextChanged(this.text);
        }

    }

    public boolean changeFocus(boolean changeFocusBool) {
        return this.visible && this.isEnabled() && super.changeFocus(changeFocusBool);
    }

    public void setText(String textIn) {
        if (this.validator.test(textIn)) {
            if (textIn.length() > this.maxStringLength) {
                this.text = textIn.substring(0, this.maxStringLength);
            } else {
                this.text = textIn;
            }

            this.setCursorPositionEnd();
            this.setSelectionPos(this.cursorPosition);
            this.onTextChanged(textIn);
        }

    }

    public String getSelectedText() {
        int i = Math.min(this.cursorPosition, this.selectionEnd);
        int j = Math.max(this.cursorPosition, this.selectionEnd);
        return this.text.substring(i, j);
    }

    public void setSelectionPos(int position) {
        int i = this.text.length();
        this.selectionEnd = Mth.clamp(position, 0, i);
        if (this.renderer != null) {
            if (this.lineScrollOffset > i) {
                this.lineScrollOffset = i;
            }

            int j = this.getAdjustedWidth();
            String s = this.renderer.plainSubstrByWidth(this.text.substring(this.lineScrollOffset), j);
            int k = s.length() + this.lineScrollOffset;
            if (this.selectionEnd == this.lineScrollOffset) {
                this.lineScrollOffset -= this.renderer.plainSubstrByWidth(this.text, j, true).length();
            }

            if (this.selectionEnd > k) {
                this.lineScrollOffset += this.selectionEnd - k;
            } else if (this.selectionEnd <= this.lineScrollOffset) {
                this.lineScrollOffset -= this.lineScrollOffset - this.selectionEnd;
            }

            this.lineScrollOffset = Mth.clamp(this.lineScrollOffset, 0, i);
        }

    }

    //<editor-fold desc="General Get Methods">
    private boolean getEnableBackgroundDrawing() { return this.enableBackgroundDrawing; }

    public int getAdjustedWidth() {
        return this.getEnableBackgroundDrawing() ? this.width - 8 : this.width;
    }

    private int getMaxStringLength() { return this.maxStringLength; }

    public String getText() { return this.text; }
    //</editor-fold>

    //<editor-fold desc="General Set Methods">
    public void setEnableBackgroundDrawing(boolean enableBackgroundDrawingIn) {
        this.enableBackgroundDrawing = enableBackgroundDrawingIn;
    }

    public void setMaxStringLength(int maxStringLength) {
        this.maxStringLength = maxStringLength;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public final void setReturnAction(Runnable r) { this.callback = r; }

    public void setDisabledTextColour(int color) { this.disabledColor = color; }

    public void setTextColor(int color) { this.enabledColor = color; }

    public void setAcceptsColors(boolean acceptsColors) {
        this.acceptsColors = acceptsColors;
    }

    public void setResponder(Consumer<String> responderIn) {
        this.guiResponder = responderIn;
    }

    public void setTextFormatter(BiFunction<String, Integer, String> textFormatterIn) {
        this.textFormatter = textFormatterIn;
    }

    public void setValidator(Predicate<String> validatorIn) {
        this.validator = validatorIn;
    }
    //</editor-fold>

    //<editor-fold desc="Cursor Position Methods">
    public void moveCursorBy(int num) {
        this.setCursorPosition(this.cursorPosition + num);
    }

    public void clampCursorPosition(int pos) {
        this.cursorPosition = Mth.clamp(pos, 0, this.text.length());
    }

    public void setCursorPositionZero() {
        this.setCursorPosition(0);
    }

    public void setCursorPositionEnd() {
        this.setCursorPosition(this.text.length());
    }

    public int getCursorPosition() {
        return this.cursorPosition;
    }

    public void setCursorPosition(int pos) {
        this.clampCursorPosition(pos);
        if (!this.isShiftDown) {
            this.setSelectionPos(this.cursorPosition);
        }

        this.onTextChanged(this.text);
    }
    //</editor-fold>

    //<editor-fold desc="Input Methods">
    public void mouseClick(double mouseX, double mouseY, int mouseButton) {
        if (this.isVisible()) {
            boolean isHovered = mouseX >= (double)this.getX() && mouseX < (double)(this.getX() + this.width) && mouseY >= (double)this.getY() && mouseY < (double)(this.getY() + this.height);
            Objects.requireNonNull(this);
            super.setFocused(isHovered);
            if (this.isFocused() && isHovered && mouseButton == 0) {
                int i = Mth.floor(mouseX) - this.getX();
                if (this.enableBackgroundDrawing) {
                    i -= 4;
                }

                String s = this.renderer.plainSubstrByWidth(this.text.substring(this.lineScrollOffset), this.getAdjustedWidth());
                this.setCursorPosition(this.renderer.plainSubstrByWidth(s, i).length() + this.lineScrollOffset);
            }
        }

    }

    public void mouseRelease(double mouseX, double mouseY, int state) {}

    public boolean keyPressed(int keyCode, int p_keyPressed_2_, int p_keyPressed_3_) {
        if (!this.canWrite()) {
            return false;
        } else {
            this.isShiftDown = Screen.hasShiftDown();
            if (Screen.isSelectAll(keyCode)) {
                this.setCursorPositionEnd();
                this.setSelectionPos(0);
                return true;
            } else if (Screen.isCopy(keyCode)) {
                Minecraft.getInstance().keyboardHandler.setClipboard(this.getSelectedText());
                return true;
            } else if (Screen.isPaste(keyCode)) {
                if (this.isEnabled()) {
                    this.writeText(Minecraft.getInstance().keyboardHandler.getClipboard());
                }

                return true;
            } else if (Screen.isCut(keyCode)) {
                Minecraft.getInstance().keyboardHandler.setClipboard(this.getSelectedText());
                if (this.isEnabled()) {
                    this.writeText("");
                }

                return true;
            } else {
                switch (keyCode) {
                    case 257:
                    case 335:
                        this.onReturn();
                        return true;
                    case 259:
                        if (this.isEnabled()) {
                            this.isShiftDown = false;
                            this.delete(-1);
                            this.isShiftDown = Screen.hasShiftDown();
                        }

                        return true;
                    case 260:
                    case 266:
                    case 267:
                    default:
                        return false;
                    case 261:
                        if (this.isEnabled()) {
                            this.isShiftDown = false;
                            this.delete(1);
                            this.isShiftDown = Screen.hasShiftDown();
                        }

                        return true;
                    case 262:
                        if (Screen.hasControlDown()) {
                            this.setCursorPosition(this.getNthWordFromCursor(1));
                        } else {
                            this.moveCursorBy(1);
                        }

                        return true;
                    case 263:
                        if (Screen.hasControlDown()) {
                            this.setCursorPosition(this.getNthWordFromCursor(-1));
                        } else {
                            this.moveCursorBy(-1);
                        }

                        return true;
                    case 264:
                        --this.selectedSuggestion;
                        return false;
                    case 265:
                        ++this.selectedSuggestion;
                        return false;
                    case 268:
                        this.setCursorPositionZero();
                        return true;
                    case 269:
                        this.setCursorPositionEnd();
                        return true;
                }
            }
        }
    }

    public boolean charTyped(char character, int keyCode) {
        if (!this.canWrite()) {
            return false;
        } else {
            if (this.acceptsColors && character == 167) {
                character = 888;
            }

            if (SharedConstants.isAllowedChatCharacter(character)) {
                if (this.isEnabled()) {
                    if (this.acceptsColors && character == 888) {
                        character = 167;
                    }

                    this.writeText(Character.toString(character));
                }

                return true;
            } else {
                return false;
            }
        }
    }
    //</editor-fold>

    //<editor-fold desc="Text Suggestion Methods">
    public void addSuggestion(String suggestion) {
        if (!this.suggestions.contains(suggestion)) {
            this.suggestions.add(suggestion);
        }
    }

    public void addSuggestions(String... suggestions) {
        String[] var2 = suggestions;
        int var3 = suggestions.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            String s = var2[var4];
            if (!this.suggestions.contains(s)) {
                this.suggestions.add(s);
            }
        }

    }

    public void removeSuggestion(String suggestion) {
        this.suggestions.remove(suggestion);
    }

    public void enableSuggestions() {
        this.showSuggestions = true;
    }

    public void disableSuggestions() {
        this.showSuggestions = false;
    }

    public boolean isShowingSuggestions() {
        return this.showSuggestions;
    }

    public ArrayList<String> getSuggestions() {
        return this.suggestions;
    }

    public String getCurrentSuggestion() {
        if (this.acceptsColors && this.text.endsWith("§")) {
            if (this.selectedSuggestion < 0) {
                this.selectedSuggestion = this.colorCodeSuggestions.length - 1;
            }

            if (this.selectedSuggestion >= this.colorCodeSuggestions.length) {
                this.selectedSuggestion = 0;
            }

            return this.colorCodeSuggestions[this.selectedSuggestion];
        } else if (!this.suggestions.isEmpty()) {
            ArrayList<String> fittingSuggestions = new ArrayList();
            Iterator var2 = this.suggestions.iterator();

            while(var2.hasNext()) {
                String s = (String)var2.next();
                if (s.startsWith(this.text)) {
                    fittingSuggestions.add(s);
                }
            }

            if (this.selectedSuggestion < 0) {
                this.selectedSuggestion = fittingSuggestions.size();
            }

            if (fittingSuggestions.size() < this.selectedSuggestion) {
                this.selectedSuggestion = 0;
            }

            if (fittingSuggestions.isEmpty()) {
                return "";
            } else {
                return (String)fittingSuggestions.get(this.selectedSuggestion);
            }
        } else {
            return "";
        }
    }
    //</editor-fold>

    //<editor-fold desc="Delete Text Methods">
    private void delete(int p_212950_1_) {
        if (Screen.hasControlDown()) {
            this.deleteWords(p_212950_1_);
        } else {
            this.deleteFromCursor(p_212950_1_);
        }

    }

    public void deleteWords(int num) {
        if (!this.text.isEmpty()) {
            if (this.selectionEnd != this.cursorPosition) {
                this.writeText("");
            } else {
                this.deleteFromCursor(this.getNthWordFromCursor(num) - this.cursorPosition);
            }
        }

    }

    public void deleteFromCursor(int num) {
        if (!this.text.isEmpty()) {
            if (this.selectionEnd != this.cursorPosition) {
                this.writeText("");
            } else {
                boolean flag = num < 0;
                int i = flag ? this.cursorPosition + num : this.cursorPosition;
                int j = flag ? this.cursorPosition : this.cursorPosition + num;
                String s = "";
                if (i >= 0) {
                    s = this.text.substring(0, i);
                }

                if (j < this.text.length()) {
                    s = s + this.text.substring(j);
                }

                if (this.validator.test(s)) {
                    this.text = s;
                    if (flag) {
                        this.moveCursorBy(num);
                    }

                    this.onTextChanged(this.text);
                }
            }
        }

    }
    //</editor-fold>

    //<editor-fold desc="'getNthWordFrom' Methods">
    public int getNthWordFromCursor(int numWords) {
        return this.getNthWordFromPos(numWords, this.getCursorPosition());
    }

    private int getNthWordFromPos(int n, int pos) {
        return this.getNthWordFromPosWS(n, pos, true);
    }

    private int getNthWordFromPosWS(int n, int pos, boolean skipWs) {
        int i = pos;
        boolean flag = n < 0;
        int j = Math.abs(n);

        for(int k = 0; k < j; ++k) {
            if (!flag) {
                int l = this.text.length();
                i = this.text.indexOf(32, i);
                if (i == -1) {
                    i = l;
                } else {
                    while(skipWs && i < l && this.text.charAt(i) == ' ') {
                        ++i;
                    }
                }
            } else {
                while(skipWs && i > 0 && this.text.charAt(i - 1) == ' ') {
                    --i;
                }

                while(i > 0 && this.text.charAt(i - 1) != ' ') {
                    --i;
                }
            }
        }

        return i;
    }
    //</editor-fold>

    //<editor-fold desc="Component Behaviour Methods">
    private void onTextChanged(String newText) {
        if (this.guiResponder != null) {
            this.guiResponder.accept(newText);
        }
    }

    private void onReturn() {
        if (this.callback != null) {
            this.callback.run();
        }
    }

    private boolean canWrite() {
        return this.isVisible() && this.isFocused() && this.isEnabled();
    }
    //</editor-fold>
}
