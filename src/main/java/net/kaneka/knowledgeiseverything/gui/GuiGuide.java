package net.kaneka.knowledgeiseverything.gui;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import net.kaneka.knowledgeiseverything.capabilities.CapabilityHandler;
import net.kaneka.knowledgeiseverything.capabilities.KnowledgeStorage;
import net.kaneka.knowledgeiseverything.capabilities.KnowledgesProvider;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GuiGuide extends GuiScreen {
	
public static final ResourceLocation BACKGROUND = new ResourceLocation("knowledgeiseverything:textures/gui/guide_background.png");
private final int bookImageWidth = 176;
private final int bookImageHeight = 166;
private int currPage = 0;
private static final int bookTotalPages = 1;
private static ResourceLocation[] picture = new ResourceLocation[bookTotalPages];
private static String[] stringPageText = new String[bookTotalPages];
private static String[] stringHeaderText = new String[bookTotalPages];
private GuiButton buttonDone;
private NextPageButton buttonNextPage;
private NextPageButton buttonPreviousPage;
private EntityPlayer player; 
private float lerningknowledge, enderknowledge, magicknowledge, natureknowledge, techknowledge;  
private int lerningknowledgelevel, enderknowledgelevel, magicknowledgelevel, natureknowledgelevel, techknowledgelevel;  

public GuiGuide(EntityPlayer player)
{
	this.player = player; 
	
	this.lerningknowledge = player.getCapability(KnowledgesProvider.Knowledge_CAP, null).getKnowledge("LerningKnowledge");
	this.lerningknowledgelevel = player.getCapability(KnowledgesProvider.Knowledge_CAP, null).getLevel("LerningKnowledge");
	this.enderknowledge = player.getCapability(KnowledgesProvider.Knowledge_CAP, null).getKnowledge("EnderKnowledge");
	this.enderknowledgelevel = player.getCapability(KnowledgesProvider.Knowledge_CAP, null).getLevel("EnderKnowledge");
	
}


@Override
public void initGui() 
{
    buttonList.clear();
    Keyboard.enableRepeatEvents(true);

    buttonDone = new GuiButton(0, width / 2 - 50, 4 + bookImageHeight -20, 98, 20, I18n.format("gui.done", new Object[0]));
	
    buttonList.add(buttonDone);
    int offsetFromScreenLeft = (width - bookImageWidth) / 2;
    buttonList.add(buttonNextPage = new NextPageButton(1, offsetFromScreenLeft + 360, 220, true));
    buttonList.add(buttonPreviousPage = new NextPageButton(2, offsetFromScreenLeft + 17, 220, false));

}

@Override
public void updateScreen() 
{
	//buttonDone.visible = (currPage == bookTotalPages - 1);
    //buttonNextPage.visible = (currPage < bookTotalPages - 1);
   // buttonPreviousPage.visible = currPage > 0;
}


@Override
public void drawScreen(int parWidth, int parHeight, float p_73863_3_)
{
    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    
   
    int offsetFromScreenLeft = (width - bookImageWidth) / 2;
    int offsetFromScreenTop = (height - bookImageHeight ) / 2;
    if(currPage == 0)
    {
    mc.getTextureManager().bindTexture(BACKGROUND);
    this.drawTexturedModalRect(offsetFromScreenLeft, offsetFromScreenTop, 0, 0, 176, 166);
    int height = calculateHeights(this.lerningknowledge, this.lerningknowledgelevel, this.player);
    drawTexturedModalRect(offsetFromScreenLeft + 60, offsetFromScreenTop + 100 - height, 177, 78 - height, 14 , height);
    height = calculateHeights(this.enderknowledge, this.enderknowledgelevel, this.player);
    drawModalRectWithCustomSizedTexture(offsetFromScreenLeft + 123, offsetFromScreenTop + 100 - height, 403, 78 - height, 12 , height, 500, 400);
    }
    
    
    
    /* this.mdrawTexturedModalRect(offsetFromScreenLeft, 2, 0, 0, 400, 250);
    int widthOfString;
    int halfscreen = width /2;
    mc.getTextureManager().bindTexture(picture[currPage]);
    drawModalRectWithCustomSizedTexture(halfscreen + 45 , 80, 0, 0, 100, 100, 100, 100);
    
    String stringPageIndicator = I18n.format("book.pageIndicator", new Object[] {Integer.valueOf(currPage + 1), bookTotalPages});

    widthOfString = fontRendererObj.getStringWidth(stringPageIndicator);
    fontRendererObj.drawString(stringPageIndicator, offsetFromScreenLeft - widthOfString + bookImageWidth - 44, 18, 0);
    fontRendererObj.drawSplitString(stringHeaderText[currPage], offsetFromScreenLeft + 25, 24, 160, 255);
    fontRendererObj.drawSplitString(stringPageText[currPage], offsetFromScreenLeft + 25, 46, 160, 0);
    */

    super.drawScreen(parWidth, parHeight, p_73863_3_);
}


@Override
protected void mouseClickMove(int parMouseX, int parMouseY, int parLastButtonClicked, long parTimeSinceMouseClick) 
{
	
}

@Override
protected void actionPerformed(GuiButton parButton) 
{
	if (parButton == buttonDone)
	{
		mc.displayGuiScreen((GuiScreen)null);
	}
    else if (parButton == buttonNextPage)
    {
        if (currPage < bookTotalPages)
        {
            ++currPage;
        }
        if(currPage == bookTotalPages)
        {
        	currPage = 0;
        }
    }
    else if (parButton == buttonPreviousPage)
    {
        
        if(currPage == 0)
        {
        	currPage = bookTotalPages;
        }
        if (currPage > 0)
        {
            --currPage;
        }
    }
}


@Override
public void onGuiClosed() 
{
	
}


@Override
public boolean doesGuiPauseGame()
{
    return false;
}



@SideOnly(Side.CLIENT)
static class NextPageButton extends GuiButton
{
    private final boolean isNextButton;

    public NextPageButton(int parButtonId, int parPosX, int parPosY, boolean parIsNextButton)
    {
        super(parButtonId, parPosX, parPosY, 70, 13, "");
        isNextButton = parIsNextButton;
    }

    /**
     * Draws this button to the screen.
     */
    @Override
	public void drawButton(Minecraft mc, int parX, int parY)
    {
        if (visible)
        {
        	 
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            mc.getTextureManager().bindTexture(BACKGROUND);
            int textureX = 15;
            int textureY = 214;

           
            if (!isNextButton)
            {
                textureX -= 15;
            }

            drawTexturedModalRect(xPosition, yPosition, textureX, textureY, 70, 13);
        	}
    	}
	}

	private int calculateHeights(float knowledge, int knowledgelevel, EntityPlayer player)
	{
		float levelknowledge;
		float levelrange;
		if (knowledgelevel > 0) {
			levelknowledge = player.getCapability(
					KnowledgesProvider.Knowledge_CAP, null).getLevelKnowledge(
					knowledgelevel);
			levelrange = player.getCapability(KnowledgesProvider.Knowledge_CAP,
					null).getLevelKnowledge(knowledgelevel + 1)
					- levelknowledge;
		}
		else
		{
			levelknowledge = 0;
			levelrange = player.getCapability(KnowledgesProvider.Knowledge_CAP,null).getLevelKnowledge(knowledgelevel + 1)- levelknowledge;
		}
		float actualllevelknowledge = knowledge-levelknowledge; 
		
		float heights = (actualllevelknowledge/levelrange)*78; 
		return (int) heights; 
	}

}

