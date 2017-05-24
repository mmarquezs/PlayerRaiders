package com.gendeathrow.pmobs.common.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

import com.gendeathrow.pmobs.common.BruteSerumHandler;

public class BruteSerum  extends Item
{
	public BruteSerum()
	{
		super();
		this.setCreativeTab(CreativeTabs.REDSTONE);
        this.setMaxStackSize(4);
	}
	
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
	{

        if (playerIn == null || !playerIn.capabilities.isCreativeMode)
        {
            --itemStackIn.stackSize;
        }
        
 
        if (!worldIn.isRemote && playerIn != null)
        {
            Potion potion = Potion.REGISTRY.getObject(BruteSerumHandler.BRUTESERUMID);
     	

        	if(!playerIn.isPotionActive(potion))
        	{
        		PotionEffect serum = new PotionEffect(potion, 4800);
        	
            	playerIn.addPotionEffect(serum);

                if (playerIn.getHealth() < playerIn.getMaxHealth())
                {
                	playerIn.setHealth(playerIn.getMaxHealth());
                }
                
                worldIn.playSound(null, playerIn.getPosition(), com.gendeathrow.pmobs.common.SoundEvents.SERUM_ANGER, SoundCategory.PLAYERS, 2.0F, playerIn.getRNG().nextFloat() * 0.4F + 0.8F);
        	}
         }
        
        
		if (worldIn.isRemote && playerIn != null)
		{
			for (int i = 0; i < 15; ++i)
			{
	               worldIn.spawnParticle(EnumParticleTypes.VILLAGER_ANGRY, playerIn.posX + (playerIn.getRNG().nextDouble() - 1D) * (double)playerIn.width, playerIn.posY + playerIn.getRNG().nextDouble() * (double)playerIn.height - 0.25D, playerIn.posZ + (playerIn.getRNG().nextDouble() - 1D) * (double)playerIn.width, (playerIn.getRNG().nextDouble() - 1D) * 2.0D, -playerIn.getRNG().nextDouble(), (playerIn.getRNG().nextDouble() - 1D) * 2.0D, new int[0]);
			}
		}
        
	        return new ActionResult(EnumActionResult.PASS, itemStackIn);
	}
	
}