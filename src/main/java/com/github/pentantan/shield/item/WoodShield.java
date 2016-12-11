package com.github.pentantan.shield.item;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemBanner;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SuppressWarnings("deprecation")
public class WoodShield {

	public class ItemWoodShield extends Item {
		//private int maxStackSize;

		public ItemWoodShield() {
			//this.maxStackSize = 1;
			setCreativeTab(CreativeTabs.COMBAT);
			setMaxDamage(336);
			addPropertyOverride(new ResourceLocation("blocking"), new IItemPropertyGetter() {
				@Override
				@SideOnly(Side.CLIENT)
				public float apply(final ItemStack stack, @Nullable final World worldIn, @Nullable final EntityLivingBase entityIn) {
					return entityIn!=null&&entityIn.isHandActive()&&entityIn.getActiveItemStack()==stack ? 1.0F : 0.0F;
				}
			});
		}

		private void addPropertyOverride(final ResourceLocation resourceLocation, final IItemPropertyGetter iItemPropertyGetter) {
			// TODO 自動生成されたメソッド・スタブ

		}

		private void setCreativeTab(final CreativeTabs combat) {
			// TODO 自動生成されたメソッド・スタブ

		}

		private void setMaxDamage(final int i) {
			// TODO 自動生成されたメソッド・スタブ

		}

		/**
		 * Called when a Block is right-clicked with this Item
		 */

		@Override
		public EnumActionResult onItemUse(final ItemStack stack, final EntityPlayer playerIn, final World worldIn, final BlockPos pos, final EnumHand hand, final EnumFacing facing, final float hitX, final float hitY, final float hitZ) {
			return super.onItemUse(stack, playerIn, worldIn, pos, hand, facing, hitX, hitY, hitZ);
		}

		public String getItemStackDisplayName(final ItemStack stack1) {
			if (stack1.getSubCompound("BlockEntityTag", false)!=null) {
				String stack = "item.woodshield.";
				final EnumDyeColor enumdyecolor = ItemBanner.getBaseColor(stack1);
				stack = stack+enumdyecolor.getUnlocalizedName()+".name";
				return I18n.translateToLocal(stack);
			} else
				return I18n.translateToLocal("item.woodshield.name");
		}
	}

	/**
	 * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
	 */
	@SideOnly(Side.CLIENT)
	public void getSubItems(final Block itemIn, final CreativeTabs tab, final List<ItemStack> subItems) {
		final ItemStack itemstack = new ItemStack(itemIn, 1, 0);
		subItems.add(itemstack);
	}

	/**
	 * gets the CreativeTab this item is displayed on
	 */
	@SideOnly(Side.CLIENT)
	public CreativeTabs getCreativeTab() {
		return CreativeTabs.COMBAT;
	}

	/**
	 * returns the action that specifies what animation to play when the items is being used
	 */
	public EnumAction getItemUseAction(final ItemStack stack) {
		return EnumAction.BLOCK;
	}

	/**
	 * How long it takes to use or consume an item
	 */
	public int getMaxItemUseDuration(final ItemStack stack) {
		return 72000;
	}

	public ActionResult<ItemStack> onItemRightClick(final ItemStack itemStackIn, final World worldIn, final EntityPlayer playerIn, final EnumHand hand) {
		playerIn.setActiveHand(hand);
		return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
	}

	/**
	 * Return whether this item is repairable in an anvil.
	 */
	public boolean getIsRepairable(final ItemStack toRepair, final ItemStack repair) {
		if (repair.getItem()==Item.getItemFromBlock(Blocks.PLANKS))
			return true;
		return true;

	}
}